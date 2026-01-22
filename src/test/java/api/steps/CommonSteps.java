package api.steps;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonSteps {

    @Then("^the response status(?: code)? should be (\\d+)$")
    public void validateStatusCode(int code) {
        int actualStatusCode = CrudUserSteps.response.getStatusCode();

        if (actualStatusCode != code) {
            System.err.println("Gagal! Status: " + actualStatusCode);
            System.err.println("Body: " + CrudUserSteps.response.getBody().asString());
        }
        assertEquals(code, actualStatusCode, "Status code tidak sesuai!");
    }
}