package stepdefinitions.API;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.API_Utilities.APIReader;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;

import static io.restassured.RestAssured.given;

public class ProductCategoriesStepDefinitions {

    Response response;
    JsonPath jsonPath;
    String exceptionMessage;
    JSONObject requestBody;

    @Given("The api user sets {string} path parameters,bilal.")
    public void the_api_user_sets_path_parameters_bilal(String pathParam) {

        API_Methods.pathParam(pathParam);

    }
    @Given("The api user sends a {string} request and saves the returned response,bilal.")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response_bilal(String method) {

        response = given()
                    .spec(HooksAPI.spec)
                    .header("token", Authentication.generateToken())
                    .header("Accept","application/json")
                    .when()
                    .get(API_Methods.fullPath);
        response.prettyPrint();

    }
    @Given("The api user verifies that the status code is {int},bilal.")
    public void the_api_user_verifies_that_the_status_code_is_bilal(int code) {
        response.then().assertThat().statusCode(code);
    }
    @Given("The api user verifies that the {string} information in the response body is {string},bilal.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_bilal(String key, String value) {
      response.then().assertThat().body(key, Matchers.equalTo(value));
    }
    @Given("The api user verifies that the information in the response body includes {string}, {string}, {string}, {string}, {string}, {string},{string},{string},bilal.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_includes_bilal(String id, String category_name, String slug, String category_image, String thumb_image, String status, String updated_on, String created_on) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getString("data[0].id"));
        Assert.assertTrue(jsonPath.getString("data[0].category_name").contains(category_name));
        Assert.assertEquals(slug, jsonPath.getString("data[0].slug"));
        category_image = null;
        Assert.assertEquals(category_image, jsonPath.get("data[0].category_image"));
        Assert.assertEquals(thumb_image, jsonPath.getString("data[0].thumb_image"));
        Assert.assertEquals(status, jsonPath.getString("data[0].status"));
        Assert.assertEquals(updated_on, jsonPath.getString("data[0].updated_on"));
        Assert.assertEquals(created_on, jsonPath.getString("data[0].created_on"));

    }
    @Given("The api user sends a {string} request with invalid authorization information {string} and saves the returned response,bilal.")
    public void the_api_user_sends_a_request_with_invalid_authorization_information_and_saves_the_returned_response_bilal(String method, String invalidAPIKey) {

        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept","application/json")
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }

        System.out.println("Mesaj : " + exceptionMessage);

    }

    @Given("The api user verifies that the status code is {string} with the reason phrase Unauthorized,bilal.")
    public void the_api_user_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_bilal(String code) {

        Assert.assertEquals(APIReader.getApiProperties("unauthorizedExceptionMessage"),exceptionMessage);
    }
    @Given("The api user prepares a post request containing {string} information to send to the {string} endpoint,bilal.")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_product_category_endpoint_bilal(String category_name, String apiProductCategory) {

      requestBody = new JSONObject();
      requestBody.put("category_name", category_name);

    }
    @Given("The api user sends a POST request and saves the returned response,bilal.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response_bilal() {

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
    @Given("The api user sends a POST request with invalid authorization information {string} and correct data {string} and saves the returned response,bilal.")
    public void the_api_user_sends_a_post_request_with_invalid_authorization_information_and_correct_data_and_saves_the_returned_response_bilal(String invalidAPIKey, String category_name) {


            response = given()
                    .spec(HooksAPI.spec)
                    .contentType(ContentType.JSON)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept","application/json")
                    .when()
                    .body(requestBody.toString())
                    .post(API_Methods.fullPath);

            response.prettyPrint();
    }
    @Given("The api user prepares a patch request containing {string} information to send to the {string} endpoint,bilal.")
    public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_endpoint_bilal(String category_name, String apiProductCategory) {

        requestBody = new JSONObject();
        requestBody.put("category_name", category_name);
    }
    @Given("The api user sends a PATCH request and saves the returned response,bilal.")
    public void the_api_user_sends_a_patch_request_and_saves_the_returned_response_bilal() {

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .body(requestBody.toString())
                .patch(API_Methods.fullPath);

        response.prettyPrint();
    }
    @Given("The api user prepares a PATCH request that contains no data,bilal.")
    public void the_api_user_prepares_a_patch_request_that_contains_no_data_bilal() {

        requestBody = new JSONObject();
    }

    @Given("The api user sends a PATCH request with invalid authorization information {string} and correct data {string} and saves the returned response,bilal.")
    public void the_api_user_sends_a_patch_request_with_invalid_authorization_information_and_correct_data_and_saves_the_returned_response_bilal(String invalidAPIKey, String category_name) {
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .contentType(ContentType.JSON)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept","application/json")
                    .when()
                    .body(requestBody.toString())
                    .patch(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }

        System.out.println("Mesaj : " + exceptionMessage);
    }

    @Given("The api user verifies that the updated_product_category_id in the response body is {int},bilal.")
    public void the_api_user_verifies_that_the_updated_product_category_id_in_the_response_body_is_bilal(int id) {
        jsonPath = response.jsonPath();
        String id_ = String.valueOf(API_Methods.id);
        Assert.assertEquals(id_, jsonPath.getString("data.updated_product_category_id"));
    }
    @Given("The api user sends a DELETE request and saves the returned response,bilal.")
    public void the_api_user_sends_a_delete_request_and_saves_the_returned_response_bilal() {

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();
    }
    @Given("The api user sends a DELETE request with invalid authorization information {string} and saves the returned response,bilal.")
    public void the_api_user_sends_a_delete_request_with_invalid_authorization_information_and_saves_the_returned_response_bilal(String invalidAPIKey) {
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", APIReader.getApiProperties("invalidApiKey"))
                    .header("Accept","application/json")
                    .when()
                    .delete(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }

        System.out.println("Mesaj : " + exceptionMessage);
    }
    @Given("The api user verifies that the deleted_product_category_id in the response body is {int},bilal.")
    public void the_api_user_verifies_that_the_deleted_product_category_id_in_the_response_body_is_bilal(int id) {
        jsonPath = response.jsonPath();
        String id_ = String.valueOf(API_Methods.id);
        Assert.assertEquals(id_, jsonPath.getString("data.deleted_product_category_id"));
    }


}
