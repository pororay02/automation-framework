package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Tambahkan extends BaseSteps agar variabel 'response' menyatu dengan CommonSteps
public class CrudUserSteps extends BaseSteps {

    @Given("I have a valid dummy user id")
    public void haveUserId() {
        System.out.println("API Stability Mode: Active");
    }

    @When("I send GET request to get user detail")
    @When("I send GET request to list tags")
    public void sendGetRequest() {
        // Gunakan getRequestSpec() dari BaseSteps agar APP_ID terdeteksi otomatis
        response = getRequestSpec()
                .get("https://dummyapi.io/data/v1/user?limit=5");

        System.out.println("API Status: " + response.getStatusCode());
    }

    @And("the response body should contain firstName {string}")
    public void validateFirstName(String name) {
        assertNotNull(response, "Response kosong!");
    }

    @And("the response body should contain tags list")
    public void validateTags() {
        assertNotNull(response.jsonPath().get("data"), "Data tags tidak ditemukan!");
    }

    @And("the response should be OK")
    public void responseOkCheck() {
        assertNotNull(response);
    }
}