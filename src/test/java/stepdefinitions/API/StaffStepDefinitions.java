package stepdefinitions.API;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
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

import java.util.List;
import java.util.Map;

public class StaffStepDefinitions {

	Response response;
	RequestSpecification spec;
	String token;
	String fullPath;

	JSONObject expectedDataJSObject;

	JsonPath responseJsonPath;

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

	@Given("The api user close the api connection.Selcuk")
	public void the_api_user_close_the_api_connection_selcuk() {
		response = null;
		spec = null;
		fullPath = null;
		token = null;
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
}
