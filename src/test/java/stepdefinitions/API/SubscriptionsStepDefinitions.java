package stepdefinitions.API;
import hooks.HooksAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import pojos.AddServicepojo;
import pojos.PojoServicee;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.API_Utilities.API_Methods.*;

public class SubscriptionsStepDefinitions {
    Response response;
    JSONObject requestBody;
    HashMap<String, Object> reqBody;
    PojoServicee pojoServicee;
    JsonPath jsonPath;
    String exceptionMesaj;
    AddServicepojo addServicepojo;

    //US_051
    @Given("the user sets the valid API endpoint {string}, mehmet")
    public void the_user_sets_the_valid_api_endpoint(String endpoint) {
        pathParam(endpoint);
    }

    @Given("the user sets the invalid API endpoint {string}, mehmet")
    public void the_user_sets_the_invalid_api_endpoint(String endpoint) {
        pathParam(endpoint);
    }

    @When("the user sends a GET request to the subscriptions endpoint, mehmet")
    public void the_user_sends_a_get_request_to_the_subscriptions_endpoint() {
        response = sendRequest("GET", null);
    }

    @Then("the status code should be {int}, mehmet")
    public void the_status_code_should_be(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response message {string} should be {string}, mehmet")
    public void the_response_message_should_be(String key, String value) {
        response.then().assertThat().body(key, Matchers.equalTo(value));


    }

    @Then("the subscription details should be verified as valid, mehmet")
    public void the_subscription_details_should_be_verified_as_valid() {
        // Detayların doğrulaması burada yapılmalı
    }

    @Then("the response should contain valid subscription information, mehmet")
    public void the_response_should_contain_valid_subscription_information() {
        // Detayların doğrulaması burada yapılmalı
    }



    //US_052
    @Given("I set the subscription endpoint {string}")
    public void i_set_the_subscription_endpoint(String endpoint) {
        API_Methods.pathParam(endpoint);
    }

    @When("I send a GET request to the subscription endpoint")
    public void i_send_a_get_request_to_the_subscription_endpoint() {
       // response = given()
       //         .spec(HooksAPI.spec)
       //         .header("token", Authentication.generateToken())
       //         .header("Accept", "application/json")
       //         .when()
       //         .get(API_Methods.fullPath);
//
       // response.prettyPrint();
        sendRequest("GET", null);

    }

    @When("I send a GET request to the subscription endpoint with invalid token")
    public void i_send_a_get_request_to_the_subscription_endpoint_with_invalid_token() {
        // Authentication already set invalid token in HooksAPI
        sendRequest("GET", null);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }



    @Then("the response should contain valid subscription details")
    public void the_response_should_contain_valid_subscription_details() {
        // Here you would write code to validate the details
        assertBody("subscription_name", "Basic Plan"); // Add other assertions as needed
    }

    @Then("the response should contain the following details:")
    public void the_response_should_contain_the_following_details(DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            assertBody(row.get("key"), row.get("value"));
        });
    }
}
