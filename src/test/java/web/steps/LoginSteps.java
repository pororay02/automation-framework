package web.steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pages.LoginPage; // Panggil Page yang kita buat tadi
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open Demoblaze homepage")
    public void openHome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        loginPage = new LoginPage(driver); // Inisialisasi Page
    }

    @When("I click Login menu")
    public void clickMenu() {
        loginPage.clickLoginMenu();
    }

    @And("I input username and password")
    public void inputUser() {
        loginPage.inputCredentials("jayjay_user", "password123");
    }

    @And("I click Login button")
    public void submit() {
        loginPage.clickSubmit();
    }

    @Then("I should see welcome message")
    public void verify() {
        String msg = loginPage.getWelcomeMessage();
        assertTrue(msg.contains("Welcome"));
        driver.quit();
    }
}