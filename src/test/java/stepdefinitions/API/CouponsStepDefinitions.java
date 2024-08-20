package stepdefinitions.API;

<<<<<<< HEAD
public class CouponsStepDefinitions {
=======
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.Authentication;
import utilities.API_Utilities.TestData;
import utilities.ConfigReader;

import java.util.HashMap;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class CouponsStepDefinitions {

    String requestBody;

    TestData testData = new TestData();

    Response response;

    HashMap<String, Object> mapRequestBody;

    int createdCouponId;

    JsonPath responseJsonPath;


    @Given("The api user sets {string} path parameters, esra.")
    public void the_api_user_sets_path_parameters_esra(String pathParam) {

        // Bir api testi yaparken atmamiz gereken 4 adim var :

        // 1- endpoint ve varsa eger request body olusturmaliyiz.
        // Burada bir get sorgusu var bunun icin request gonderirken bir body göndermemize gerek yok.

        // Hooks da butun scenario lardan önce calisan methodlarla token alma ve endpoint olusurmak icin gerekli ayarlamalar zaten yapilmis.

        // API_Methods.addedId methodu eger bir delete veya patch islemi varsa öncelikle yeni bir id olusturma üzerine olusturulmus.
        // Yani benim scenariom icinde delete ve patch geciyorsa önce yeni bir data olusturulacak ve ben sorgularimi bu data üzerinde
        // gerceklestirecegim.

        // Fakat http method bunlara dahil degilse örnegin buradaki gibi bir get sorgusu varsa
        // bizim direkt pathParam methodu yardimiyla endpointimizi olusturmamiz gerekiyor.

        if (API_Methods.addedId == 0) {
            API_Methods.pathParam(pathParam); // Eger delete veya patch sorgusu degilse burasi calisacak
        } else {
            API_Methods.pathParam(pathParam + "/" + API_Methods.addedId);
            // Eger delete veya patch sorgusu ise once yeni bir kayit ekleyecegi icin burasi calisacak

        }

        // Bu methodla birlikte 1. adimimiz olan token alma ve endpoint olusturma islemini gerceklestirdik.

    }

    @Given("The api user sends a {string} request and saves the returned response, esra.")
    public void the_api_user_sends_a_request_and_saves_the_returned_response_esra(String httpMethod) {

        // Yukaridaki methodla token almis ve endpointimizi olusturmustuk.

        // 2- Request gonderip, donen response u kaydetmemiz gerekiyor.

        // API_Methods ta request gondermek icin olusturulmus method bana get request ve donen response u kaydetme imkani taniyor.

        if (requestBody == null || requestBody.isEmpty()) {
            API_Methods.sendRequest(httpMethod, null);
        } else {
            API_Methods.sendRequest(httpMethod, requestBody);
        }
    }

    @Given("The api user verifies that the status code is {int}, esra.")
    public void the_api_user_verifies_that_the_status_code_is_esra(int statusCode) {

        // Yukaridaki methodla request gonderdik ve donen response u kaydettik.

        // 3- Eger testi yapmamiz icin gerekiyorsa expected data hazirlamamiz gerekiyor
        // US de benden boyle bir test yapmam istenmemis, dolayisiyla  bu adimi atlayabilirim.

        // 4- Assertion

        // Request i gonderdim ve response u kaydettim, artik testimi yapabilirim.
        // Stepte belirtmis oldugum expected status code ile request sonucunda donen status code un ayni olup
        // olmadigini test etmem gerekiyor.

        // Bunun icin API_Methods da Matchers classiyla hazirlanmis olan testi iceren methodu kullanabilirim.

        //response.prettyPrint();
        API_Methods.statusCodeAssert(statusCode);

    }

    @Given("The api user verifies that the {string} information in the response body is {string}, esra.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is_esra(String key, String expectedValue) {

        // Burada donen response body deki bilgilerin expected bilgi ile ayni olup olmadigini test etmemiz gerekiyor.
        // Yani elimdeki response un key ve value larinin expected body deki key ve value lar ile ayni olmasi gerekiyor.

        // Bunun icin API_Methods da olusturulan methodu kullaniyoruz.

        API_Methods.assertBody(key, expectedValue);

    }

    @Given("The api user sends a {string} request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized, esra.")
    public void the_api_user_sends_a_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized_esra(String httpMethod, String statusCode) {

        // Eger bir request body gondermiyorsak, ve ornegin gecersiz tokenla sisteme giris yapma gibi bir durumda exception firlatilmasi
        // ihtimaline karsilik try catch olusturmamiz ve exceptionla bize donen mesaji kullanmamiz gerekiyor.
        // exception dan donen mesajla testimizi gerceklestiriyoruz.

        String response = (requestBody == null) ? API_Methods.tryCatchRequest(httpMethod, null) : API_Methods.tryCatchRequest(httpMethod, requestBody);
        assertEquals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api"), response);

    }

    @Given("The api user sets {string} request body with {int}, {string}, {int}, {string}, {int}, {int}, {string}, esra")
    public void the_api_user_sets_request_body_with_esra(String httpMethod, int service_id, String coupon_name, int percentage, String start_date, int valid_days, int user_limit, String description) {

        if (!(coupon_name.equals("PROer345"))) {
            coupon_name = "CPN" + System.currentTimeMillis();
        }
        mapRequestBody = testData.couponRequestBody(service_id, coupon_name, percentage, start_date, valid_days, user_limit, description);
        // Bana maple olusturulmus bir request body dondurecek
        // System.out.println(mapRequestBody);
        response = API_Methods.sendRequest(httpMethod, mapRequestBody); // bana post request sonucu bir response dondurecek.

    }

    @Given("The api user sets {string} request body with {int}, {string}, {int}, {string}, {int}, {string}, esra")
    public void the_api_user_sets_request_body_with_esra(String httpMethod, int service_id, String coupon_name, int percentage, String start_date, int valid_days, String description) {
        // user_limit eksik bir sekilde request body olusturacagiz.

        mapRequestBody = new HashMap<>();

        mapRequestBody.put("service_id", service_id);
        mapRequestBody.put("coupon_name", coupon_name);
        mapRequestBody.put("percentage", percentage);
        mapRequestBody.put("start_date", start_date);
        mapRequestBody.put("valid_days", valid_days);
        // mapRequestBody.put("user_limit", user_limit);
        mapRequestBody.put("description", description);

        response = API_Methods.sendRequest(httpMethod, mapRequestBody); // bana gondermis oldugum post sonucu bir response dondurecek.

    }

    @Given("The api user sends a {string} request with valid authorization information but no data and saves the returned response, esra.")
    public void the_api_user_sends_a_request_with_valid_authorization_information_but_no_data_and_saves_the_returned_response_esra(String httpMethod) {

        mapRequestBody = new HashMap<>(); // Burada map objemizi olusturduk.
        // Su anda objemizin icinde data yok
        // Bizden istenen bos bir request body gonderdigimizde sistemin nasil bir tepki verdigini test etmek
        // Bu yuzden map i bos bir sekilde gonderecegiz.
        response = API_Methods.sendRequest(httpMethod, mapRequestBody);
        response.prettyPrint();

    }

    @Given("Bu id bilgisi ile get sorgusu yapilacak.")
    public void bu_id_bilgisi_ile_get_sorgusu_yapilacak() {

        // Yukarida post request ile yeni bir coupon ekledik.
        // Ekledigimiz bu coupon daki response bilgisi üzerinden data.added_coupon_id nin karsisindaki id yi alacagiz ve kaydedecegiz.

        // Bu bilgilerin gercekten kaydedilip kaydedilmedigini dogrulamak icin bu yukarida elde ettigimiz
        // id bilgisi ile bir get sorgusu yapacagiz.

        // responseJsonPath = response.jsonPath();
        // idValue = responseJsonPath.getInt("data.added_coupon_id");
        // System.out.println("id degeri ; "+idValue);
//

        // Kod ===>> API_Methods.verification("api", "coupon-details", "data.added_coupon_id", "data.id", idValue);

        // bu methodda once response jsonPath e cevirilyor.
        // daha sonra "data.added_coupon_id" üzerinden id bilgisi kaydediliyor.
        // sonra id nin String mi yoksa int mi oldugu kontrol ediliyor ve her iki durumda da int e cevriliyor

        // daha sonra pp1 olarak api
        //            pp2 olarak coupon-details
        //            pp3 olarak id value su endpoint olarak kaydediliyor.

        // bu endpoint hazirlandiktan sonra bir get request gonderiliyor ve donen response kaydediliyor.

        // donen response daki data.id nin karsisinda yer alan deger ile bizim ekledigimiz id nin ayni olup olmadigi test ediliyor.


    }

    @Given("The api user verifies that the {string} information in the returned response body is the same as the id path parameter written in the endpoint, esra.")
    public void the_api_user_verifies_that_the_information_in_the_returned_response_body_is_the_same_as_the_id_path_parameter_written_in_the_endpoint_esra(String responseId) {

        // Burada response body de bize donen keyler uzerinden islem yapiyoruz.
        // Yani response body deki key üzerinden donen id degerini elde etmeye calisiyoruz.
        // Istedigimiz key in degerini feature da gonderiyoruz ve karsisinda bulunan id degerini elde ediyoruz.
        // Response dan elde ettigimiz id degeri ile path parametresinde bulunan sorgusunu yaptigimiz id degerinin
        // birbiriyle ayni olup olmadigini test ediyoruz.
        // Path parametresinde id degerini en basta pathParams methodunu kullanirken zaten almis oluyoruz
        API_Methods.assertPathParam(responseId);

    }

    @Given("The api user deletes created coupon, esra.")
    public void the_api_user_deletes_created_coupon_esra() {

        // post islemi sonucunda eklemis oldugumuz coupon u silmemiz gerekiyor.

        responseJsonPath = response.jsonPath();
        createdCouponId = responseJsonPath.getInt("data.added_coupon_id"); // ekledigimiz coupon un id si üzerinden delete sorgusu yapacagiz.


        if (createdCouponId != 0) {

            spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url", "api")).build();
            spec.pathParams("pp1", "api", "pp2", "deleteCoupon", "pp3", createdCouponId);

            String createdCouponIdString = createdCouponId + "";

            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .header("token", Authentication.generateToken())
                    .when()
                    .delete("/{pp1}/{pp2}/{pp3}");

            response.then()
                    .assertThat()
                    .body("data.deleted_coupon_id", equalTo(createdCouponIdString)); // dogrulama icin

        }


    }


>>>>>>> main
}
