package stepdefinitions.API;
import hooks.HooksAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.AddServicepojo;
import pojos.PojoServicee;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.ConfigReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.API_Utilities.API_Methods.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.API_Utilities.RequestBuilder;

import static hooks.HooksAPI.spec;


import static org.junit.Assert.assertEquals;


public class SubscriptionsStepDefinitions {
    Response response;
    JSONObject requestBody;
    HashMap<String, Object> reqBody;
    PojoServicee pojoServicee;
    JsonPath jsonPath;
    String exceptionMesaj;
    AddServicepojo addServicepojo;
    String token;
    Object subscriptionId;

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
        //response.then().assertThat().body(key, Matchers.equalTo(value));
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


    //US_052***********************************************************************
    @Given("I set the subscription endpoint {string}")
    public void ı_set_the_subscription_endpoint(String endpoint) {
        API_Methods.pathParam(endpoint);
    }

    @When("I send a GET request to the subscription endpoint")
    public void ı_send_a_get_request_to_the_subscription_endpoint() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .get(API_Methods.fullPath);

        response.prettyPrint();
        if (response == null) {
            throw new IllegalStateException("API response is null. Please check the API request.");
        }
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }

    @Then("the response should contain valid subscription details")
    public void the_response_should_contain_valid_subscription_details() {

    }
    @Given("The api user verifies that the {string} information in the response body is {string}")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {
        API_Methods.assertBody(key, value);
    }

    @Then("the response should contain the following details:")
    public void the_response_should_contain_the_following_details(List<Map<String, String>> details) {


        if (response == null) {
            throw new IllegalStateException("Response is null. Cannot assert the response body.");
        }

        details.forEach(detail -> {
            String key = detail.get("key");
            String expectedValue = detail.get("value");
            response.then().body(key, equalTo(expectedValue));
        });

    }

    @Given("the response message {string} should be {string}")
    public void thee_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {

        response.then().assertThat().body(key, Matchers.equalTo(value));


    }

    @When("I send a GET request to the subscription endpoint with invalid token")
    public void i_send_a_get_request_to_the_subscription_endpoint_with_invalid_token() {
        // Authentication already set invalid token in HooksAPI
        sendRequest("GET", null);
    }
    @Then("the response message should bee {string}")
    public void the_response_message_should_bee(String message) {
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", Authentication.generateToken())
                    .header("Accept", "application/json")
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {
            exceptionMesaj = e.getMessage();
        }
        System.out.println("Mesaj : " + exceptionMesaj);

        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api"), exceptionMesaj);
    }


    //US_053*******************************************************************************
    @Given("The provider is authenticated with valid credentials")
    public void the_provider_is_authenticated_with_valid_credentials() {
        spec.header("token", Authentication.generateToken());

    }
    @Given("The provider prepares a post request containing {string}, {double}, {int}, {string} information to send to the api addSubscription endpoint")
    public void the_provider_prepares_a_post_request_containing_information_to_send_to_the_api_add_subscription_endpoint(String subscription_name, double fee, int duration, String fee_description) {

        requestBody=new JSONObject();

        requestBody.put("subscription_name",subscription_name);
        requestBody.put("fee",fee);
        requestBody.put("duration",duration);
        requestBody.put("fee description",fee_description);


    }
    @Given("The api user sends a POST request and saves the returned response mehmet.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response() {


        API_Methods.sendRequest("POST",requestBody.toString());


    }
    @Given("The api user prepares a post request containing {string}, {int}, {int}, {string} information to send to the api addService endpoint")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_service_endpoint(String Subscription_name, int fee, int duration, String fee_description) {

    }

    @Given("The provider is authenticated with invalid token")
    public void the_provider_is_authenticated_with_invalid_token() {
        spec.header("token", "invalid_token");
    }

    @When("The provider sends a POST request to {string} with valid data")
    public void the_provider_sends_a_post_request_to_with_valid_data(String endpoint) {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addParameterForMap("subscription_name", "Pro Plan")
                .addParameterForMap("fee", 49.99)
                .addParameterForMap("duration", 12)
                .addParameterForMap("fee_description", "Yearly subscription");

        pathParam(endpoint);
        sendRequest("POST", requestBuilder.buildUsingMap());
    }

    @When("The provider sends a POST request to {string} with missing data")
    public void the_provider_sends_a_post_request_to_with_missing_data(String endpoint) {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addParameterForMap("subscription_name", "Pro Plan")
                .addParameterForMap("fee", 49.99);

        pathParam(endpoint);
        sendRequest("POST", requestBuilder.buildUsingMap());
    }

    @When("The provider sends a POST request to {string} with no data")
    public void the_provider_sends_a_post_request_to_with_no_data(String endpoint) {
        pathParam(endpoint);
        sendRequest("POST", null);
    }

    @Then("The status code should be {int}, mehmett")
        public void the_status_code_should_bee(Integer statusCode) {
            statusCodeAssert(statusCode);
    }

    @Then("The response should {string} containn {string}")
    public void the_response_should_containn(String key, String value) {
        assertBody(key, value);
    }
    @Then("The response should {string} containnn {string}")
    public void the_response_should_containnn(String key, String value) {
        assertBody(key, value);
    }

    @Then("The created subscription should be verified via API")
    public void the_created_subscription_should_be_verified_via_api() {
        // Burada kaydın API üzerinden doğrulanmasını sağlayacağız
        assertPathParam("data.added_subscription_id");
    }



    //US_054*******************************************************************************

    @Given("the endpoint is {string}")
    public void theEndpointIs(String endpoint) {
        pathParam(endpoint);
    }

    @Given("valid authorization is provided")
    public void validAuthorizationIsProvided() {
        // Token otomatik olarak HooksAPI sınıfından sağlanıyor
    }

    @Given("invalid authorization is provided")
    public void invalidAuthorizationIsProvided() {
        // Invalid token otomatik olarak HooksAPI sınıfından sağlanıyor
    }

    @Given("the request body contains valid subscription data")
    public void theRequestBodyContainsValidSubscriptionData() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addParameterForMap("subscription_name", "Premium")
                .addParameterForMap("fee", 99.99)
                .addParameterForMap("duration", 12)
                .addParameterForMap("fee_description", "Annual Subscription");
        sendRequest("PATCH", requestBuilder.buildUsingMap());
    }

    @Given("the request body is empty")
    public void theRequestBodyIsEmpty() {
        sendRequest("PATCH", null);
    }

    @When("I send a PATCH request to the endpoint")
    public void iSendAPatchRequestToTheEndpoint() {
        // Request zaten sendRequest metodu ile gönderildi
    }

    @Then("the status code should bee {int}")
    public void theStatusCodeShouldBee(int statusCode) {
        statusCodeAssert(statusCode);
    }

    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String expectedMessage) {
        assertBody("response_message", expectedMessage);
    }

    @Then("the updated_subscription_id should match the id parameter")
    public void theUpdatedSubscriptionIdShouldMatchTheIdParameter() {
        assertPathParam("data.updated_subscription_id");
    }

    @Then("the updated subscription should be verified through the API")
    public void theUpdatedSubscriptionShouldBeVerifiedThroughTheAPI() {
        verification("api", "subscription_details", "data.updated_subscription_id", "subscription_name", "Premium");
    }
}

