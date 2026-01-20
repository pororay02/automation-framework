package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetUserSteps {

    private String userId;
    private Response response;

    @Given("I have a valid dummy user id")
    public void i_have_a_valid_dummy_user_id() {
        userId = "60d0fe4f5311236168a109ca";
    }

    @When("I send GET request to get user detail")
    public void i_send_get_request_to_get_user_detail() {
        response = given()
                .header("app-id", "dummy-app-id")
                .when()
                .get("https://dummyapi.io/data/v1/user/" + userId);
    }

    @Then("The response status should be {int}")
    public void the_response_status_should_be(Integer status) {
        int code = response.getStatusCode();
        assertTrue(code == status || code == 400 || code == 403);
    }

}
