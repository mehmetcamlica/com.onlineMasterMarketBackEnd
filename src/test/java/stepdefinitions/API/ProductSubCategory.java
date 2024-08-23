package stepdefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;

import static utilities.API_Utilities.API_Methods.response;

public class ProductSubCategory {

    @Given("Get request is sent to api pro_subcategories endpoint with valid authorizationn")
    public void getRequestIsSentToApiPro_subcategoriesEndpointWithValidAuthorization() {
        String url = "https://qa.onlinemastermarket.com/";

        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer your-valid-token");

        response = RestAssured.get(url);

    }

    @Then("the status code should be {int}, Melike")
    public void theStatusCodeShouldBe(int expectedStatusCode) {

        //response.then().statusCode(200);
        //Assert.assertEquals("Product Subcategories Listed Successfully", response.jsonPath().getString("response_message"));
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());
    }

    @And("the response message should be {string}, Melike")
    public void theResponseMessageShouldBe(String expectedMessage) {

        String responseBody = response.getBody().asString();
        //String success_message = response.getBody().as
        Assert.assertEquals(expectedMessage, responseBody);
        System.out.println(responseBody+"RESPONSE:"+response);
    }

}
