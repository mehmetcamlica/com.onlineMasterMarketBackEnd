package utilities.API_Utilities;

import hooks.HooksAPI;
import utilities.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class Authentication {
    public static String generateToken() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url", "api")).build();

        spec.pathParams("pp1", "api", "pp2", "getToken");

        JSONObject reqBody  = new JSONObject();
        reqBody.put("email", ConfigReader.getProperty("providerEmail", "api"));
        reqBody.put("password", ConfigReader.getProperty("providerPassword", "api"));

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");

        JsonPath repJP = response.jsonPath();

        String token = repJP.getString("data.token");

        return token;
    }
}
