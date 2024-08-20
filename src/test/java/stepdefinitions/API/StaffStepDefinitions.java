package stepdefinitions.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.API_Utilities.APIReader;
import utilities.API_Utilities.Authentication;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StaffStepDefinitions {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	Response response;
	RequestSpecification spec;
	String token;
	String fullPath;
	JSONObject expectedDataJSObject;
	JsonPath responseJsonPath;
	int addedId;

	int deletedId;

	@Given("The api user close the api connection.Selcuk")
	public void the_api_user_close_the_api_connection_selcuk() {
		response = null;
		spec = null;
		fullPath = null;
		token = null;
		responseJsonPath = null;
		addedId = 0;
		deletedId = 0;
	}

	@Given("The api user sets up spec for base url and valid token.Selcuk")
	public void the_api_user_sets_up_spec_for_base_url_and_valid_token() {
		token = Authentication.generateToken();

		spec = new RequestSpecBuilder()
				.setBaseUri(APIReader.getApiProperties("base_url"))
				.addHeader("Accept", "application/json")
				.addHeader("Token", token)
				.build();
	}

	@Given("The api user sets up spec for base url and invalid token.Selcuk")
	public void the_api_user_sets_up_spec_for_base_url_and_invalidvalid_token() {
		token = APIReader.getApiProperties("invalidApiKey");
		spec = new RequestSpecBuilder()
				.setBaseUri(APIReader.getApiProperties("base_url"))
				.addHeader("Accept", "application/json")
				.addHeader("Token", token)
				.build();
	}

	@Given("The api user sets {string} path parameters.Selcuk")
	public void the_api_user_sets_path_parameters_selcuk(String rawPaths) {
		String[] paths = rawPaths.split("/");
		StringBuilder tempPath = new StringBuilder("{");
		for (int i = 0; i < paths.length; i++) {
			String key = "get" + i;
			spec.pathParam(key, paths[i].trim());
			tempPath.append(key + "}/{");
		}
		tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
		tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
		fullPath = tempPath.toString();
	}

	@Given("The api user sends a get request and saves the returned response.Selcuk")
	public void the_api_user_sends_a_request_and_saves_the_returned_response_selcuk() {
			response = RestAssured.given()
					.spec(spec)
					.contentType(ContentType.JSON)
					.when()
					.get(fullPath);
	}

	@Given("The api user verifies that the status code is {int}.Selcuk")
	public void the_api_user_verifies_that_the_status_code_is_selcuk(int statusCode) {
		response
				.then()
				.assertThat()
				.statusCode(statusCode);
	}

	@Given("The api user verifies that the {string} information in the response body is {string}.Selcuk")
	public void the_api_user_verifies_that_the_information_in_the_response_body_is_selcuk(String path, String expectedResponse) {
		response.then().body(path, Matchers.equalTo(expectedResponse));
	}

	@Given("The api user verifies that the data in the response body index[{int}] includes {int}, {int}, {string}, {string}, {string}, {string}.Selcuk")
	public void the_api_user_verifies_that_the_data_in_the_response_body_index_includes_selcuk(int dataIndex,
																							   int id,
																							   int providerId,
																							   String firstName,
																							   String contactNo,
																							   String email,
																							   String status) {
		responseJsonPath = response.jsonPath();
		response.then().log().all();
		Assert.assertEquals(id, responseJsonPath.getInt("data.staff_list[" + dataIndex + "].id"));
		Assert.assertEquals(providerId, responseJsonPath.getInt("data.staff_list[" + dataIndex + "].provider_id"));
		Assert.assertEquals(firstName, responseJsonPath.getString("data.staff_list[" + dataIndex + "].first_name"));
		Assert.assertEquals(contactNo, responseJsonPath.getString("data.staff_list[" + dataIndex + "].contact_no"));
		Assert.assertEquals(email, responseJsonPath.getString("data.staff_list[" + dataIndex + "]email"));
		Assert.assertEquals(status, responseJsonPath.getString("data.staff_list[" + dataIndex + "].status"));

	}

	@Given("The api user sends a get request, and verifies that the status code is {int} and message is {string}.Selcuk")
	public void the_api_user_sends_a_get_request_saves_the_returned_response_and_verifies(int expectedStatusCode,
																						  String expectedMessage) {
		String exceptionMessage = null;
		try {
			response = RestAssured.given()
					.spec(spec)
					.contentType(ContentType.JSON)
					.when()
					.get(fullPath);
			Assert.fail("Should have throw the exception!");
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
		}
		int actualStatusCode = Integer.parseInt(exceptionMessage.replaceAll("\\D++", ""));
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
		Assert.assertEquals(exceptionMessage, APIReader.getApiProperties(expectedMessage));
	}

	@Given("The api user verifies that the data in the response body includes {int}, {int}, {string}, {string}, {string},{string}, {string},{string} {string}.Selcuk")
	public void the_api_user_verifies_that_the_data_in_the_response_body_includes_selcuk(int id,
																						 int providerId,
																						 String firstName,
																						 String lastName,
																						 String countryCode,
																						 String contactNo,
																						 String email,
																						 String gender,
																						 String status) {
		System.out.println("huhu:" + lastName);
	}

	@DataTableType(replaceWithEmptyString = "[blank]")
	public String stringType(String cell) {
		return (cell);
	}

	@Given("The api user verifies that data in the respond body")
	public void the_api_user_verifies_that_data_in_the_respond_body(DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		responseJsonPath = response.jsonPath();

		if (dataMap == null)
			Assert.fail("Something happened along the way!");
		int i = 0;
		for (Map<String, String> each : dataMap) {
			Assert.assertEquals(Integer.parseInt(each.get("id")), responseJsonPath.getInt("data[" + i + "].id"));
			Assert.assertEquals(Integer.parseInt(each.get("provider_id")), responseJsonPath.getInt("data[" + i + "].provider_id"));
			Assert.assertEquals(each.get("first_name"), responseJsonPath.getString("data[" + i + "].first_name"));
			Assert.assertEquals(each.get("last_name"), responseJsonPath.getString("data[" + i + "].last_name"));
			Assert.assertEquals(each.get("country_code"), responseJsonPath.getString("data[" + i + "].country_code"));
			Assert.assertEquals(each.get("contact_no"), responseJsonPath.getString("data[" + i + "].contact_no"));
			Assert.assertEquals(each.get("email"), responseJsonPath.getString("data[" + i + "].email"));
			Assert.assertEquals(each.get("gender"), responseJsonPath.getString("data[" + i + "].gender"));
			Assert.assertEquals(each.get("status"), responseJsonPath.getString("data[" + i + "].status"));
			i++;
		}
	}

	@ParameterType("[^\"]*")
	public List<String> post(String requestBodyForPost)
	{
		return (Arrays.asList(requestBodyForPost.split(",")));
	}


	@Given("The api user sends a post request with {post} .Selcuk")
	public void the_api_user_sends_a_post_request_with_mac_edmont_mrtin_gmail_com_male_about_martin_selcuk(List<String> post) {
		System.out.println(post);
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when()
				.body("")
				.post(fullPath);
	}

	@DocStringType
	public JsonNode json(String docString) throws JsonProcessingException {
		return (objectMapper.readTree(docString));
	}

	@Given("The api user sends a post request with the body.Selcuk")
	public void the_api_user_sends_a_post_request_with_the_body(JsonNode jsonNode) {
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when()
				.body(jsonNode.toString())
				.post(fullPath);
		addedId = response.jsonPath().getInt("data.added_staff_id");
		System.out.println(addedId);
	}

	@Given("The api user deletes the post request.Selcuk")
	public void the_api_user_deletes_the_post_request_selcuk() {
		the_api_user_sets_path_parameters_selcuk("api/deleteStaff/" + addedId);
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when().log().all()
				.delete(fullPath);

		response.then().log().all();
	}

	@Given("The api user send post request from {string} file.Selcuk")
	public void the_api_user_send_request_from_file_selcuk(String fileName) {
		JSONObject requestBoydJSObject = getJsonObjectFromFile(fileName);
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when()
				.body(requestBoydJSObject.toString())
				.post(fullPath);
	}

	@Given("The api user send patch request from {string} file.Selcuk")
	public void the_api_user_send_patch_request_from_file_selcuk(String fileName) {
		JSONObject requestBoydJSObject = getJsonObjectFromFile(fileName);
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when()
				.body(requestBoydJSObject.toString())
				.patch(fullPath);

	}

	@Given("The api user verifies {string} in response matches the id path parameter in PATCH id {int}.Selcuk")
	public void the_api_user_verifies_in_response_matches_the_id_path_parameter_in_patch_id_selcuk(String responsePath, int expectedId) {
		int actualResponseId = response.jsonPath().getInt(responsePath);

		Assert.assertEquals(expectedId, actualResponseId);
	}

	@Given("The api user send delete request for that spesific {int}.Selcuk")
	public void the_api_user_send_delete_request_for_that_spesific_selcuk(int idToDelete) {
		response = RestAssured
				.given()
				.spec(spec)
				.contentType(ContentType.JSON)
				.when()
				.delete(fullPath);
		deletedId = idToDelete;
	}

	public JSONObject getJsonObjectFromFile(String fileName) {
		File file = new File("data/dataAPI/" + fileName);
		JSONObject jsonObject = null;
		try {
			String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			jsonObject = new JSONObject(content);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return (jsonObject);
	}
}
