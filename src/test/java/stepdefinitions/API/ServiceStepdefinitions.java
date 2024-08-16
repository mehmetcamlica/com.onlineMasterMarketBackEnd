package stepdefinitions.API;

import com.google.gson.Gson;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.hu.Ha;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;
import pojos.AddServicepojo;

import pojos.PojoServicee;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ServiceStepdefinitions {



    JSONObject requestBody;
    HashMap<String, Object> reqBody;

    PojoServicee pojoServicee;

    Response response;

    JsonPath jsonPath;

    String exceptionMesaj;

    AddServicepojo addServicepojo;

    @Given("The api user sets {string} path parameters DAMRA.")
    public void thee_api_user_sets_path_parameters(String pathParam) {
        API_Methods.pathParam(pathParam);

    }

    @Given("The api user sends a GET request and saves the returned response DAMRA.")
    public void thee_api_user_sends_a_get_request_and_saves_the_returned_response() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .when()
                .get(API_Methods.fullPath);

        response.prettyPrint();



    }

    @Given("The api user verifies that the status code is {int} DAMRA.")
    public void thee_api_user_verifies_that_the_status_code_is(int statusCode) {


        response.then().assertThat().statusCode(statusCode);
    }

    @Given("The api user verifies that the {string} information in the response body is {string} DAMRA.")
    public void thee_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {

        response.then().assertThat().body(key, equalTo(value));


    }


    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including {string}, {string}, {string}, {string}, {string} DAMRA.")
    public void thee_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including(int dataIndex, String service_id,
                                                                                                                             String service_title,
                                                                                                                             String service_location,
                                                                                                                             String finalAmount,
                                                                                                                             String currency_code) {

        jsonPath = response.jsonPath();

        Assert.assertEquals(service_id, jsonPath.getString("data["+dataIndex+"].service_id"));

          }




    @Given("The api user sends a GET request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized DAMRA.")
    public void thee_api_user_sends_a_get_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

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

    @Given("The api user verifies that the data in the response body includes {int}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} DAMRA.")
    public void the_api_user_verifies_that_the_data_in_the_response_body_includes_damra(int id, String service_id, String service_title, String service_amount, String category_name, String service_latitude, String service_longitude, String about, String ratings, String rating_count, String views, String currency) {
        //jsonPath = response.jsonPath();
    }


    @Given("The api user prepares a post request containing {int}, {int}, {int}, {string}, {string}, {string}, {int}, {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_blog_endpoint(int shop_id, int staff_id, int duration, String service_title, String category, String subcategory, int service_amount, String about) {



       // addServicepojo = new AddServicepojo(shop_id, staff_id, duration, service_title, category, subcategory, service_amount, about);

         requestBody=new JSONObject();

        requestBody.put("shop_id",shop_id);
        requestBody.put("staff_id",staff_id);
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);
        requestBody.put("service_amount",service_amount);
        requestBody.put("about",about);



    }

    @Given("The api user sends a POST request and saves the returned response DAMRA.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response() {


      API_Methods.sendRequest("POST",requestBody.toString());


    }

    @Given("The api user prepares a post request containing {int}, {int}, {int}, {string}, {string}, {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_post_request_containing_information_to_send_to_the_api_add_service_endpoint(Integer shop_id, Integer staff_id, Integer duration, String category, String subcategory, String service_title) {

        requestBody=new JSONObject();

        requestBody.put("shop_id",shop_id);
        requestBody.put("staff_id",staff_id);
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);



    }


    @Given("The api user prepares a POST request that contains no data DAMRA.")
    public void the_api_user_prepares_a_post_request_that_contains_no_data() {

        addServicepojo = new AddServicepojo();


    }

    //PATCH

    @Given("The api user prepares a patch request containing {int}, {int}, {int}, {string}, {string}, {string}, {int}, {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_api_add_service_endpoint_damra(int shop_id, int staff_id, int duration, String service_title, String category, String subcategory, int service_amount, String about) {

        requestBody=new JSONObject();

        requestBody.put("shop_id",shop_id);
        requestBody.put("staff_id",staff_id);
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);
        requestBody.put("service_amount",service_amount);
        requestBody.put("about",about);



    }

    @Given("The api user prepares a patch request containing {int} {int}, {int}, {int}, {string}, {string}, {string}, {int}, {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_api_add_service_endpoint_damra(Integer int1, Integer shop_id, Integer staff_id, Integer duration, String service_title, String category, String subcategory, Integer service_amount, String about) {

        requestBody=new JSONObject();

        requestBody.put("shop_id",shop_id);
        requestBody.put("staff_id",staff_id);
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);
        requestBody.put("service_amount",service_amount);
        requestBody.put("about",about);

        System.out.println(requestBody.toString());


    }


    @Given("The api user sends a {string} request and saves the returned response DAMRA.")
    public void the_api_user_sends_a_request_and_saves_the_returned_response(String httpMethod) {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .patch(API_Methods.fullPath);

        response.prettyPrint();

    }


    @Given("The api user verifies that the updated_service_id information in the response body {string} is the same as the id path parameter DAMRA.")
    public void the_api_user_verifies_that_the_updated_service_id_information_in_the_response_body_is_the_same_as_the_id_path_parameter_damra(String id) {

           jsonPath= response.jsonPath();

           String valueID = String.valueOf(API_Methods.id);

           Assert.assertEquals(valueID,jsonPath.getString(id));


    }


    @Given("The api user prepares a patch request containing {int}, {int}, {string}, {string}, {string}, {int}, {string} information to send to the api addService endpoint DAMRA.")
      public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_api_add_service_endpoint_damra(Integer id,Integer duration, String service_title, String category, String subcategory, int service_amount, String about ) {


        requestBody=new JSONObject();
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);
        requestBody.put("service_amount",service_amount);
        requestBody.put("about",about);
    }

    @Given("The api user prepares a patch request containing   {int}, {int}, {int}, {string}, {string}, {string}, {int}, {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_api_add_service_endpoint_damra(Integer shop_id, Integer staff_id, Integer duration, String service_title, String category, String subcategory, Integer service_amount, String about) {
        requestBody=new JSONObject();
        requestBody.put("shop_id",shop_id);
        requestBody.put("staff_id",staff_id);
        requestBody.put("duration",duration);
        requestBody.put("service_title",service_title);
        requestBody.put("category",category);
        requestBody.put("subcategory",subcategory);
        requestBody.put("service_amount",service_amount);
        requestBody.put("about",about);

    }
    @Given("The api user sends a {string} request and saves the returned response Damra.")
    public void the_api_user_sends_a_request_and_saves_the_returned_response_damra(String string) {

    }
    @Given("The api user sends a {string} request and saves the returned response damraa.")
    public void the_api_user_sends_a_request_and_saves_the_returned_response_damraa(String string) {

try {
    response = given()
            .spec(HooksAPI.spec)
            .header("token", "asda1j23j123")
            .header("Accept", "application/json")
            .contentType(ContentType.JSON)
            .when()
            .body(requestBody.toString())
            .patch(API_Methods.fullPath);



       }catch (Exception e){

        exceptionMesaj=e.getMessage();
       }

Assert.assertEquals("status code: 401, reason phrase: Unauthorized",exceptionMesaj);

    }

    @Given("The api user prepares a patch request containing {string} information to send to the api addService endpoint DAMRA.")
    public void the_api_user_prepares_a_patch_request_containing_information_to_send_to_the_api_add_service_endpoint_damra(String shop_id) {

        requestBody=new JSONObject();
        requestBody.put("shop_id",shop_id);

        System.out.println(requestBody.toString());

    }

    @Given("The api user Verify that the updated_service_id in the response body returned  from the  endpoint is the same as the id path parameter in the {int} endpoint DAMRA.")
    public void the_api_user_verify_that_the_updated_service_id_in_the_response_body_returned_from_the_endpoint_is_the_same_as_the_id_path_parameter_in_the_endpoint_damra(int shop_id) {



        jsonPath = response.jsonPath();

        Assert.assertEquals(shop_id, jsonPath.getString("data.shop_id"));
    }

    @Given("The api user service_title information {string} verification.")
    public void the_api_user_service_title_information_verification(String service) {
      response.then().assertThat().body("data.service_overview.service_title", Matchers.equalTo(service));
    }


}