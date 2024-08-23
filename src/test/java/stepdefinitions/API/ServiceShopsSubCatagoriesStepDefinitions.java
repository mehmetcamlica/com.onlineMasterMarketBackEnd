package stepdefinitions.API;

import com.beust.ah.A;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static utilities.API_Utilities.API_Methods.fullPath;

public class ServiceShopsSubCatagoriesStepDefinitions {

    Response response;

    JsonPath jsonPath;
    String exceptionMesaj;

    HashMap<String, Object> reqBody;

    JSONObject body;
    String deletedSubcategoryId;

    String returnedCategory;

    @Given("The API user creates the {string} post parameter, beyza")
    public void the_apı_user_creates_the_post_parameter_beyza(String pathParam) {

        API_Methods.pathParam(pathParam);
    }
    @Given("The API user sends a POST body and stores the returned response, beyza")
    public void the_apı_user_sends_a_post_body_and_stores_the_returned_response_beyza() {

        JSONObject postBody = new JSONObject();
        postBody.put("category", 1);
        System.out.println(postBody.toString());

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(fullPath);
        response.prettyPrint();


    }
    @Given("The API user verifies that the status code is {int} , beyza")
    public void the_apı_user_verifies_that_the_status_code_is_beyza(Integer code) {
        response.then()
                .assertThat()
                .statusCode(code);

    }
    @Given("The API user verifies that the {string} in the response body is {string} , beyza")
    public void the_apı_user_verifies_that_the_in_the_response_body_is_beyza(String key, String value) {
        response.then()
                .assertThat()
                .body(key, equalTo(value));


    }

    @Given("The API user verifies the {string} and {string} in the response body.")
    public void the_apı_user_verifies_the_and_in_the_response_body(String value1, String value2) {


        response.then()
                .assertThat()
                .body("data.subcategory_list[0].subcategory_name",equalTo(value1))
                .body("data.subcategory_list[0].subcategory_image",equalTo(value2));

    }



    @Given("The API user creates the {string} path parameter , beyza")
    public void the_apı_user_creates_the_path_parameter_beyza(String pathPar) {

        API_Methods.pathParam(pathPar);


    }
    @Given("The API user sends a POST body with no record, beyza")
    public void the_apı_user_sends_a_post_body_with_no_record_beyza() {
        JSONObject postBody = new JSONObject();
        postBody.put("category", 125);
        System.out.println(postBody.toString());

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(fullPath);
        response.prettyPrint();



    }
    @Given("The API user sends a POST body with no data, beyza")
    public void the_apı_user_sends_a_post_body_with_no_data_beyza() {

        JSONObject postbady = new JSONObject();

        response= given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(postbady.toString())
                .when()
                .post(fullPath);

        response.prettyPrint();


    }

    @Given("The API user sends a POST body containing valid data \\(category) with invalid \\(invalid API key) authorization information to the endpoint. beyza")
    public void the_apı_user_sends_a_post_body_containing_valid_data_category_with_invalid_invalid_apı_key_authorization_information_to_the_endpoint_beyza() {



        JSONObject postBody = new JSONObject();
        postBody.put("category", 1);
        System.out.println(postBody.toString());

        response = given()
                .spec(HooksAPI.spec)

                .header("token", "kdfsdkfskdf")
                .header("Accept","application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(API_Methods.fullPath);

        response.prettyPrint();



}


    @Given("The api user sends a GET request and saves the returned response , beyza")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response_beyza() {





        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);
        response.prettyPrint();





    }

    @Given("The api user sets {string} path parameters, beyza")
    public void the_api_user_sets_path_parameters_beyza(String pathParam) {

        if (API_Methods.addedId == 0) {
            API_Methods.pathParam(pathParam); // Eger delete veya patch sorgusu degilse burasi calisacak
        } else {
            API_Methods.pathParam(pathParam + "/" + API_Methods.addedId);
            // Eger delete veya patch sorgusu ise once yeni bir kayit ekleyecegi icin burasi calisacak

        }


    }
    @Given("The API user sends a Get body with no record, beyza")
    public void the_apı_user_sends_a_get_body_with_no_record_beyza() {

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .get(API_Methods.fullPath);
        response.prettyPrint();





    }
    @Given("The api user verifies that the {string} information in the response body is {string} , beyza")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_beyza(String key, String value) {

JsonPath mapjasn = response.jsonPath();

Assert.assertEquals(value,mapjasn.getString(key));






    }
    @Given("The api user sends a {string} request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized , beyza")
    public void the_api_user_sends_a_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_beyza(String httpMethod) {

        String mesaj = null;

        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", "brjfdkjl")
                    .header("Accept","application/json")
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {
           mesaj= e.getMessage();
        }
        System.out.println("mesaj : "+ mesaj);

        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage","api"),mesaj);

    }

    @Given("The API user sends a addPOST body with no record, beyza")
    public void the_apı_user_sends_a_add_post_body_with_no_record_beyza() {
        JSONObject postBody = new JSONObject();
        postBody.put("category", 1);
        postBody.put("subcategory_name","New Sub Category");
        System.out.println(postBody.toString());

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(fullPath);
        response.prettyPrint();






    }

    @Given("The API user sends a POST body with missing data \\(subcategory_name)with valid authorization information , beyza")
    public void the_apı_user_sends_a_post_body_with_missing_data_subcategory_name_with_valid_authorization_information_beyza() {
      ///////////////////////////////////////////////

        JSONObject postBody = new JSONObject();

        postBody.put("subcategory_name","New Sub Category");
        System.out.println(postBody.toString());

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(fullPath);
        response.prettyPrint();





    }

    @Given("The API user sends a addPOST body with no data, beyza")
    public void the_apı_user_sends_a_add_post_body_with_no_data_beyza() {

        JSONObject postbady = new JSONObject();

        response= given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(postbady.toString())
                .when()
                .post(fullPath);

        response.prettyPrint();



    }

    @Given("The api user sends a PATCH request and saves the returned response , beyza")
    public void the_api_user_sends_a_patch_request_and_saves_the_returned_response_beyza() {

        JSONObject patchBody = new JSONObject();
        patchBody.put("category", 1);
        patchBody.put("subcategory_name","New Sub Category Updated");

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .body(patchBody.toString())
                .when()
                .patch(API_Methods.fullPath);
        response.prettyPrint();




    }
    @Given("The api user subcatagory name {string} Verification, beyza")
    public void the_api_user_subcatagory_name_verification_beyza(String value) {

response.then().assertThat().body("data.subcategory.subcategory.subcategory_name",Matchers.equalTo(value));

    }


    @Given("The API user sends a PATCH body with no data, beyza")
    public void the_apı_user_sends_a_patch_body_with_no_data_beyza() {

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .patch(API_Methods.fullPath);
        response.prettyPrint();

    }

    @Given("The API user sends a PATCH body with no id, beyza")
    public void the_apı_user_sends_a_patch_body_with_no_id_beyza() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .patch(API_Methods.fullPath);
        response.prettyPrint();




    }
    @Given("The API user sends a PATCH body with no  correct data \\(category, subcategory_name) with valid authorization information , beyza")
    public void the_apı_user_sends_a_patch_body_with_no_correct_data_category_subcategory_name_with_valid_authorization_information_beyza() {
        JSONObject patchBody = new JSONObject();
        patchBody.put("category", 1);
        patchBody.put("subcategory_name","New Sub Category Updated");
        String geçersizID = "26565";

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .body(patchBody.toString())
                .when()
                .patch(fullPath,geçersizID);
        response.prettyPrint();




    }

    @Given("The api userr sends a {string} request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized , beyza")
    public void the_api_userr_sends_a_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_beyza(String string, String string2) {
        String mesaj = null;

        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", "brjfdkjl")
                    .header("Accept","application/json")
                    .when()
                    .patch(fullPath);
        } catch (Exception e) {
            mesaj= e.getMessage();
        }
        System.out.println("mesaj : "+ mesaj);

        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage","api"),mesaj);



    }



    @Given("the api user ends a patch request with valid data and saves the pdated subcategory_id, beyza")
    public void the_api_user_ends_a_patch_request_with_valid_data_and_saves_the_pdated_subcategory_id_beyza() {

        JSONObject patchBody = new JSONObject();
        patchBody.put("category", 1);
        patchBody.put("subcategory_name", "New Sub Category Updated");

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .body(patchBody.toString())
                .when()
                .patch(fullPath);
        response.prettyPrint();
        JsonPath jsonpath = response.jsonPath();
        int keyys = Integer.parseInt(jsonpath.getString("data.updated_subcategory_id"));
        Assert.assertEquals(API_Methods.id,keyys);




    }
    @Given("The api user sends a DELETE request and saves the returned response , beyza")
    public void the_api_user_sends_a_delete_request_and_saves_the_returned_response_beyza() {
////////// çalışmadı
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();


    }
    @Given("The API user sends a DELETE body with no data, beyza")
    public void the_apı_user_sends_a_delete_body_with_no_data_beyza() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();



    }

    @Given("The API user sends a DELETE body with no id, beyza")
    public void the_apı_user_sends_a_delete_body_with_no_id_beyza() {
        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();
    }


    @Given("The api user sends a {string} request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized , beyzaaa")
    public void the_api_user_sends_a_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_beyzaaa(String string, String string2) {
        String mesaj = null;

        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .header("token", "brjfdkjl65")
                    .header("Accept","application/json")
                    .when()
                    .delete(fullPath);
        } catch (Exception e) {
            mesaj= e.getMessage();
        }
        System.out.println("mesaj : "+ mesaj);

        Assert.assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage","api"),mesaj);

    }
    @Given("API user sends a DELETE request for that specific saves the returned response")
    public void apı_user_sends_a_delete_request_for_that_specific_saves_the_returned_response() {

        response = given()
                .spec(HooksAPI.spec)
                .header("token", Authentication.generateToken())
                .header("Accept","application/json")
                .when()
                .delete(fullPath);

        response.prettyPrint();

        deletedSubcategoryId = response.jsonPath().getString("data.deleted_subcategory_id");
    }
    @Given("The API user verifies that the deleted_subcategory_id in the response matches the sent ID")
    public void the_apı_user_verifies_that_the_deleted_subcategory_id_in_the_response_matches_the_sent_ıd() {

 JsonPath jasnpath = response.jsonPath();
 int value = Integer.parseInt(jasnpath.getString("data.deleted_subcategory_id"));

        Assert.assertEquals(API_Methods.id,value);
    }

    @Given("The API user sends a addPOST body containing valid data \\(category) with invalid \\(invalid API key) authorization information to the endpoint. beyza")
    public void the_apı_user_sends_a_add_post_body_containing_valid_data_category_with_invalid_invalid_apı_key_authorization_information_to_the_endpoint_beyza() {
        JSONObject postBody = new JSONObject();
        postBody.put("category", 1);
        postBody.put("subcategory_name","New Sub Category");
        System.out.println(postBody.toString());


        response = given()
                .spec(HooksAPI.spec)

                .header("token", "kdfsdkfskdf")
                .header("Accept","application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(postBody.toString())
                .post(API_Methods.fullPath);

        response.prettyPrint();





    }

    @Given("The api user subcatagary id {string} Verification, beyza")
    public void the_api_user_subcatagary_id_verification_beyza(String valueid) {

        response.then().assertThat().body("data.subcategory.subcategory.subcategory_id",Matchers.equalTo(valueid));

    }
    @Given("The api user response mesagge {string} Verification, beyza")
    public void the_api_user_response_mesagge_verification_beyza(String value) {
     response.then().assertThat().body("response.response_message",equalTo(value));
    }

}


































