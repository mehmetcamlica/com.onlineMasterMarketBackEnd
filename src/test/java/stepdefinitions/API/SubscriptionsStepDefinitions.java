package stepdefinitions.API;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.API_Utilities.API_Methods;

import static org.junit.Assert.assertEquals;
public class SubscriptionsStepDefinitions {
    Response response;

    @Given("the user sets the valid API endpoint {string}")
    public void the_user_sets_the_valid_api_endpoint(String endpoint) {
        API_Methods.pathParam(endpoint);
    }

    @Given("the user sets the invalid API endpoint {string}")
    public void the_user_sets_the_invalid_api_endpoint(String endpoint) {
        API_Methods.pathParam(endpoint);
    }

    @When("the user sends a GET request to the subscriptions endpoint")
    public void the_user_sends_a_get_request_to_the_subscriptions_endpoint() {
        response = API_Methods.sendRequest("GET", null);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("response.response_message");
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("the subscription details should be verified as valid")
    public void the_subscription_details_should_be_verified_as_valid() {
        // Detayların doğrulaması burada yapılmalı
    }

    @Then("the response should contain valid subscription information")
    public void the_response_should_contain_valid_subscription_information() {
        // Detayların doğrulaması burada yapılmalı
    }
}
