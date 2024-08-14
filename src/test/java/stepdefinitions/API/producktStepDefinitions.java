package stepdefinitions.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class producktStepDefinitions {

    private String baseUrl;
    private String token;

    @Before
    public void setUp() {
        // API'nin temel URL'sini ve geçerli bir token'ı ayarlayın
        baseUrl = "https://your-api-base-url.com"; // Burada gerçek API base URL'inizi kullanın
        token = "valid_auth_token"; // Buraya geçerli bir token ekleyin
    }

    @Test
    public void testGetMyProductsWithValidAuth() {
        // API Test: /api/myProducts endpoint
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/myProducts?shop_id=123");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Products Listed Successfully"));
    }

    @Test
    public void testGetProductsWithValidAuth() {
        // API Test: /api/Products endpoint
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/Products?shop_id=123");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product Details"));
    }

    @Test
    public void testGetMyProductsWithInvalidAuth() {
        // API Test: /api/myProducts endpoint with invalid auth
        Response response = RestAssured.given()
                .header("Authorization", "Bearer invalid_auth_token")
                .when()
                .get(baseUrl + "/api/myProducts?shop_id=123");

        assertEquals(401, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Invalid token or token missing"));
    }

    @Test
    public void testGetMyProductsWithNoShopId() {
        // API Test: /api/myProducts endpoint without shop_id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/myProducts");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("shop_id is required."));
    }

    @Test
    public void testGetMyProductsWithInvalidShopId() {
        // API Test: /api/myProducts endpoint with invalid shop_id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/myProducts?shop_id=999");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("No shop this id or No product this shop."));
    }

    @Test
    public void testGetProductDetailsWithValidId() {
        // API Test: /api/product-details/{id} endpoint with valid id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/product-details/123");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product Details"));
    }

    @Test
    public void testGetProductDetailsWithNoId() {
        // API Test: /api/product-details endpoint without id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/product-details");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Id missing"));
    }

    @Test
    public void testGetProductDetailsWithInvalidId() {
        // API Test: /api/product-details/{id} endpoint with invalid id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/product-details/999");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("No Details found"));
    }

    @Test
    public void testAddProductWithValidData() {
        // API Test: /api/addProduct endpoint with valid data
        String requestBody = "{\"name\":\"New Product\",\"price\":100}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/api/addProduct");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product Added successfully"));
    }

    @Test
    public void testAddProductWithMissingData() {
        // API Test: /api/addProduct endpoint with missing data
        String requestBody = "{\"name\":\"\"}";  // Eksik veri

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/api/addProduct");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Required data is missing"));
    }

    @Test
    public void testEditProductWithValidData() {
        // API Test: /api/editProduct/{id} endpoint with valid data
        String requestBody = "{\"name\":\"Updated Product\",\"price\":150}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(baseUrl + "/api/editProduct/123");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product Updated successfully"));
    }

    @Test
    public void testEditProductWithNoData() {
        // API Test: /api/editProduct/{id} endpoint with no data
        String requestBody = "{}";  // Veri eksik

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(baseUrl + "/api/editProduct/123");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("No data for update"));
    }

    @Test
    public void testEditProductWithInvalidId() {
        // API Test: /api/editProduct/{id} endpoint with invalid id
        String requestBody = "{\"name\":\"Updated Product\",\"price\":150}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(baseUrl + "/api/editProduct/999");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product not found"));
    }

    @Test
    public void testEditProductWithInvalidAuth() {
        // API Test: /api/editProduct/{id} endpoint with invalid auth
        String requestBody = "{\"name\":\"Updated Product\",\"price\":150}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer invalid_auth_token")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(baseUrl + "/api/editProduct/123");

        assertEquals(401, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Invalid token or token missing"));
    }

    @Test
    public void testDeleteProductWithValidId() {
        // API Test: /api/deleteProduct/{id} endpoint with valid id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(baseUrl + "/api/deleteProduct/123");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product deleted successfully"));
    }

    @Test
    public void testDeleteProductWithInvalidId() {
        // API Test: /api/deleteProduct/{id} endpoint with invalid id
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(baseUrl + "/api/deleteProduct/999");

        assertEquals(203, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Product not found. Invalid ID."));
    }

    @Test
    public void testDeleteProductWithInvalidAuth() {
        // API Test: /api/deleteProduct/{id} endpoint with invalid


    }
}
