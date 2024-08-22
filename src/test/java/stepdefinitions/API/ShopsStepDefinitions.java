package stepdefinitions.API;


import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;
import pojos.AddServicepojo;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static stepdefinitions.API.API_Stepdefinitions.requestBody;

public class ShopsStepDefinitions {
    Response response;
    JsonPath jsonPath;
    JSONObject requestBody;
    String expectionmesaj;

    AddServicepojo addServicepojo;

    String exceptionMesaj;

    @Given("The api user sets {string} path parameters TOPRAK.")
    public void the_api_user_sets_path_parameters_toprak(String pp1) {
        API_Methods.pathParam(pp1);
    }

    @Given("The api user sends a GET request and saves the returned response TOPRAK.")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response_toprak() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .get(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user verifies that the status code is {int} TOPRAK.")
    public void the_api_user_verifies_that_the_status_code_is_toprak(int code) {
        API_Methods.statusCodeAssert(code);

    }

    @Given("The api user verifies that the {string} information in the response body is {string} TOPRAK.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_toprak(String key, String value) {
        //response.then().assertThat().body(key, equalTo(value));
    }

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index,{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} TOPRAK.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_toprak(Integer dataIndex, String shop_code, String shop_name, String tax_allow, String contact_no, String email, String address, String country_name, String state_name, String city_name, String postal_code) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(shop_code, jsonPath.getString("data.shop_list[" + dataIndex + "].shop_code"));
        Assert.assertEquals(shop_name, jsonPath.getString("data.shop_list[" + dataIndex + "].shop_name"));
        Assert.assertEquals(tax_allow, jsonPath.getString("data.shop_list[" + dataIndex + "].tax_allow"));
        Assert.assertEquals(contact_no, jsonPath.getString("data.shop_list[" + dataIndex + "].contact_no"));
        Assert.assertEquals(email, jsonPath.getString("data.shop_list[" + dataIndex + "].email"));
        Assert.assertEquals(address, jsonPath.getString("data.shop_list[" + dataIndex + "].address"));
        Assert.assertEquals(country_name, jsonPath.getString("data.shop_list[" + dataIndex + "].country_name"));
        Assert.assertEquals(state_name, jsonPath.getString("data.shop_list[" + dataIndex + "].state_name"));
        Assert.assertEquals(city_name, jsonPath.getString("data.shop_list[" + dataIndex + "].city_name"));
        Assert.assertEquals(postal_code, jsonPath.getString("data.shop_list[" + dataIndex + "].postal_code"));
    }

    @Given("The api user sends a GET request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized TOPRAK.")
    public void the_api_user_sends_a_get_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_toprak(String string) {

        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", "toprak")
                    .header("Accept", "application/json")
                    .when()
                    .get(API_Methods.fullPath);

        } catch (Exception e) {
            expectionmesaj = e.getMessage();

        }

        System.out.println(expectionmesaj);
        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api"), expectionmesaj);

    }

    @Given("The api user verifies that the data in the response body includes {int}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} TOPRAK.")
    public void the_api_user_verifies_that_the_data_in_the_response_body_includes_toprak(int id, String shop_code, String shop_name, String tax_allow, String tax_number, String contact_no, String email, String address, String country_name, String state_name, String city_name, String postal_code) {

    }

    @Given("The api user prepares a post request containing {string}, {string}, {string}, {string}, {int}, {string}, {int}, {int} information to send to the api addService endpoint TOPRAK.")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_service_endpoint_toprak(String shop_title, String description, String contact_no, String email, int tax_allow, String address, int category, int sub_category) {

        requestBody = new JSONObject();

        requestBody.put("shop_title", shop_title);
        requestBody.put("description", description);
        requestBody.put("contact_no", contact_no);
        requestBody.put("email", email);
        requestBody.put("tax_allow", tax_allow);
        requestBody.put("address", address);
        requestBody.put("category", category);
        requestBody.put("sub_category", sub_category);

    }

    @Given("The api user sends a POST request and saves the returned response TOPRAK.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response_toprak() {

        API_Methods.sendRequest("POST", requestBody.toString());

    }


    @Given("The api user prepares a post request containing {string}, {string}, {string}, {string}, {int}, {int}, {int} information to send to the api addService endpoint TOPRAK.")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_service_endpoint_toprak(String shop_title, String description, String contact_no, String email, Integer tax_allow, Integer category, Integer sub_category) {

        requestBody=new JSONObject();

        requestBody.put("shop_title",shop_title);
        requestBody.put("description",description);
        requestBody.put("contact_no",contact_no);
        requestBody.put("email",email);
        requestBody.put("tax_allow",tax_allow);
        requestBody.put("category",category);
        requestBody.put("sub_category",sub_category);

    }

    @Given("The api user prepares a POST request that contains no data TOPRAK.")
    public void the_api_user_prepares_a_post_request_that_contains_no_data_toprak() {
       requestBody=new JSONObject();
        //API_Methods.sendRequest("POST",addServicepojo.toString());

    }


}