package hooks;

import utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.API_Utilities.Authentication;

public class HooksAPI {
    public static RequestSpecification spec;

    public static boolean setupApiCompleted = false;

    @Before(order = 2)
    public void setUpScenario(Scenario scenario) {
        String token;

        // Senaryonun adına göre belirleniyor
        if (scenario.getName().contains("Invalid Token")) {
            token = ConfigReader.getProperty("invalidApiKey", "api"); // Geçersiz token al
            setupApiCompleted = true;
        } else {
            token = Authentication.generateToken(); // Provider için token oluştur
        }

        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url", "api"))
                .addHeader("Accept", "application/json")
                .addHeader("token", token)
                .build();

        setupApiCompleted = true;
    }

    @After
    public void tearDownScenarios(Scenario scenario) {
        if (scenario.isFailed()) {  // Senaryo başarısız olursa
            logFailure(scenario);
        }
    }

    private void logFailure(Scenario scenario) {
        String scenarioName = scenario.getName();
        String scenarioStatus = scenario.getStatus().name();

        // Kendi loglama method'unu kullanarak bilgileri yazdırma
        System.out.println("Senaryo Adi: " + scenarioName);
        System.out.println("Durum: " + scenarioStatus);
    }
}


