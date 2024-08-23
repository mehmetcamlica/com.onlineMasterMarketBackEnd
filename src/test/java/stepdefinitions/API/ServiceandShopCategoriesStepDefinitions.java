package stepdefinitions.API;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.API_Utilities.APIReader;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ServiceandShopCategoriesStepDefinitions {
    Response response;
    RequestSpecification spec;
    JsonPath responseJsonPath;
    String exceptionMessage;
    JSONObject requestBody;
    JsonPath jsonPath;

    @Given("The api user sets {string} path parameters Gokcen.")
    public void the_api_user_sets_path_parameters_gokcen(String pathParam) {
        API_Methods.pathParam(pathParam);
        System.out.println(API_Methods.fullPath);

    }

    @Given("The api user sends a GET request and saves the returned response Gokcen.")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response_gokcen() {
        try {
            response = given().spec(HooksAPI.spec).header("token", Authentication.generateToken())
                    .header("Accept", "application/json")
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        response.prettyPrint();

    }

    @Given("The api user verifies that the status code is {int} Gokcen.")
    public void the_api_user_verifies_that_the_status_code_is_gokcen(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }

    @Given("The api user verifies that the {string} information in the response body is {string} Gokcen.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_gokcen(String path, String expectedResponse) {
        response.then().body(path, equalTo(expectedResponse));
    }

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including {string}, {string}, {string}, {string}, {string} ,{string},{string},{string} Gokcen.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including_gokcen(Integer dataIndex, String category_name, String category_slug,
                                                                                                                                   String category_type, String gender_type, String category_image, String thumb_image, String category_mobile_icon, String status) {
        responseJsonPath = response.jsonPath();
        Assert.assertEquals(category_name, responseJsonPath.getString("data.category_list[" + dataIndex + "].category_name"));
        Assert.assertEquals(category_slug, responseJsonPath.getString("data.category_list[" + dataIndex + "].category_slug"));
        Assert.assertEquals(gender_type, responseJsonPath.getString("data.category_list[" + dataIndex + "].gender_type"));
        Assert.assertEquals(category_type, responseJsonPath.getString("data.category_list[" + dataIndex + "].category_type"));
        Assert.assertEquals(category_image, responseJsonPath.getString("data.category_list[" + dataIndex + "].category_image"));
        Assert.assertEquals(thumb_image, responseJsonPath.getString("data.category_list[" + dataIndex + "].thumb_image"));
        Assert.assertEquals(category_mobile_icon, responseJsonPath.getString("data.category_list[" + dataIndex + "].category_mobile_icon"));
        Assert.assertEquals(status, responseJsonPath.getString("data.category_list[" + dataIndex + "].status"));


    }


    @Given("The api user verifies the information in the response body for the entry with the specified {string}, including {string}, {string}, {string}, {string}, {string} ,{string},{string},{string} Gokcen.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_including_gokcen(Object id, String category_name, String category_slug, String gender_type, String category_type, String category_image, String thumb_image, String category_mobile_icon, String status) {
        responseJsonPath = response.jsonPath();
        Assert.assertEquals(category_name, responseJsonPath.getString("data.category_list[" + id + "].category_name"));
        Assert.assertEquals(category_slug, responseJsonPath.getString("data.category_list[" + id + "].category_slug"));
        Assert.assertEquals(gender_type, responseJsonPath.getString("data.category_list[" + id + "].gender_type"));
        Assert.assertEquals(category_type, responseJsonPath.getString("data.category_list[" + id + "].category_type"));
        Assert.assertEquals(category_image, responseJsonPath.getString("data.category_list[" + id + "].category_image"));
        Assert.assertEquals(thumb_image, responseJsonPath.getString("data.category_list[" + id + "].thumb_image"));
        Assert.assertEquals(category_mobile_icon, responseJsonPath.getString("data.category_list[" + id + "].category_mobile_icon"));
        Assert.assertEquals(category_image, responseJsonPath.getString("data.category_list[" + id + "].category_image"));
        Assert.assertEquals(status, responseJsonPath.getString("data.category_list[" + id + "].status"));
    }

    @Given("The api user sends a GET request with invalid authorization, saves the returned response Gokcen.")
    public void the_api_user_sends_a_get_request_with_invalid_authorization_saves_the_returned_response_gokcen() {
        try {
            response = given().spec(HooksAPI.spec).header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept", "application/json")
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {

            exceptionMessage = e.getMessage();
        }
        System.out.println("Mesaj : " + exceptionMessage);
    }

    @Given("The api user verifies that the status code is {int} with the reason phrase {string} Gokcen.")
    public void the_api_user_verifies_that_the_status_code_is_with_the_reason_phrase_gokcen(Integer statusCode, String message) {
        // response.then().assertThat().statusCode(statusCode);
        message = exceptionMessage;
        System.out.println(message);
        Assert.assertEquals(APIReader.getApiProperties("unauthorizedExceptionMessage"), message);
    }

    @Given("The api user sends a POST request with {string}  and saves the returned response Gokcen.")
    public void the_api_user_sends_a_post_request_with_and_saves_the_returned_response_gokcen(String categoryName) {
        requestBody = new JSONObject();
        requestBody.put("category_name", categoryName);
        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .body(requestBody.toString())
                .post(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user sends a POST request with invalid api key {string}  and saves the returned response Gokcen.")
    public void the_api_user_sends_a_post_request_with_invalid_api_key_and_saves_the_returned_response_gokcen(String categoryName) {
        requestBody = new JSONObject();
        requestBody.put("category_name", categoryName);
        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .header("token", APIReader.getApiProperties("invalidApiKey"))
                .header("Accept", "application/json")
                .when()
                .body(requestBody.toString())
                .post(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user verifies the information in the response body for the entry with the specified {string}.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified(String id) {
        responseJsonPath = response.jsonPath();
        Assert.assertEquals(id, responseJsonPath.getString("data.added_category_id"));
    }

    @Given("The api user sends a PATCH request with {string}  and saves the returned response Gokcen.")
    public void the_api_user_sends_a_patch_request_with_and_saves_the_returned_response_gokcen(String categoryName) {
        requestBody = new JSONObject();
        requestBody.put("category_name", categoryName);
        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .body(requestBody.toString())
                .patch(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user sends a PATCH request with no data and saves the returned response Gokcen.")
    public void the_api_user_sends_a_patch_request_with_no_data_and_saves_the_returned_response_gokcen() {
        requestBody = new JSONObject();
        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .body(requestBody.toString())
                .patch(API_Methods.fullPath);

    }

    @Given("The api user sends a PATCH request with an invalid api key, {string}  and saves the returned response Gokcen.")
    public void the_api_user_sends_a_patch_request_with_an_invalid_api_key_and_saves_the_returned_response_gokcen(String categoryName) {
        requestBody = new JSONObject();
        requestBody.put("category_name", categoryName);
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .contentType(ContentType.JSON)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept", "application/json")
                    .when()
                    .body(requestBody.toString())
                    .patch(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }

        System.out.println("Mesaj : " + exceptionMessage);
    }

    @Given("The api user verifies that the updated_category_id in the response body is {int} Gokcen.")
    public void the_api_user_verifies_that_the_updated_category_id_in_the_response_body_is_gokcen(Integer int1) {
        jsonPath = response.jsonPath();
        String idString = String.valueOf(API_Methods.id);
        Assert.assertEquals(idString, jsonPath.getString("data.updated_category_id"));
    }

    @Given("The api user sends a DELETE request and saves the returned response Gokcen.")
    public void the_api_user_sends_a_delete_request_and_saves_the_returned_response_gokcen() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user sends a DELETE request with an invalid api key and saves the returned response Gokcen.")
    public void the_api_user_sends_a_delete_request_with_an_invalid_api_key_and_saves_the_returned_response_gokcen() {
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept", "application/json")
                    .when()
                    .delete(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Mesaj : " + exceptionMessage);

    }

    @Given("The api user verifies that the deleted_category_id in the response body is {int} Gokcen.")
    public void the_api_user_verifies_that_the_deleted_category_id_in_the_response_body_is_gokcen(Integer int1) {
        jsonPath = response.jsonPath();
        String id_ = String.valueOf(API_Methods.id);
        Assert.assertEquals(id_, jsonPath.getString("data.deleted_category_id"));
    }
}

