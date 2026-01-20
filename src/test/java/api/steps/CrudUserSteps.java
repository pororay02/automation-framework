package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class CrudUserSteps {


    private Response response;
    private String userId;

    private final String baseUrl = "https://dummyapi.io/data/v1";
    private final String appId = "dummy-app-id";

    @Given("I have valid new user data")
    public void i_have_valid_new_user_data() {
        // nothing to do here
    }

    @When("I send POST request to create the user")
    public void create_user() {
        String payload = """
        {
          "firstName": "Ray",
          "lastName": "Han",
          "email": "rayhan.test%s@gmail.com"
        }
    """.formatted(System.currentTimeMillis());

        response = given()
                .header("app-id", appId)
                .header("Content-Type", "application/json")
                .body(payload)
                .post(baseUrl + "/user/create");

        if (response.statusCode() == 200) {
            userId = response.jsonPath().getString("id");
        }
    }

    @Given("I have an existing dummy user id")
    public void get_existing_user_id() {
        assertNotNull(userId, "User ID must exist before update");
    }

    @When("I send PUT request to update the user")
    public void update_user() {
        String payload = """
        {
          "firstName": "Updated"
        }
    """;

        response = given()
                .header("app-id", appId)
                .header("Content-Type", "application/json")
                .body(payload)
                .put(baseUrl + "/user/" + userId);
    }

    @Given("I have dummy user id to delete")
    public void user_id_for_delete() {
        assertNotNull(userId, "User ID must exist before delete");
    }

    @When("I send DELETE request to delete the user")
    public void delete_user() {
        response = given()
                .header("app-id", appId)
                .delete(baseUrl + "/user/" + userId);
    }

    @Then("the response status should be {int}")
    public void assert_status(Integer code) {
        assertEquals(code, response.statusCode());
    }

    @Then("the response status should be 200 or 204")
    public void assert_status_delete() {
        int code = response.statusCode();
        assertTrue(code == 200 || code == 204);
    }

    @Then("the response should contain created user id")
    public void validate_created_user() {
        assertNotNull(userId);
    }

    @Then("the response should reflect updated data")
    public void validate_update() {
        assertEquals("Updated", response.jsonPath().getString("firstName"));
    }


}
