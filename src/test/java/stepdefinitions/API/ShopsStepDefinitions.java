package stepdefinitions.API;


import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ShopsStepDefinitions {
    Response response;
    JsonPath jsonPath;

    String expectionmesaj;

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
    public void the_api_user_verifies_that_the_status_code_is_toprak(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }

    @Given("The api user verifies that the {string} information in the response body is {string} TOPRAK.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_toprak(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
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
        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage","api"),expectionmesaj);

    }
}
