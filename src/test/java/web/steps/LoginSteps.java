package web.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {


    WebDriver driver;
    LoginPage loginPage;

    @Given("I open Demoblaze homepage")
    public void open_homepage() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.openHomePage();
    }

    @When("I click Login menu")
    public void click_login_menu() {
        loginPage.openLoginModal();
    }

    @When("I input username and password")
    public void input_credential() {
        loginPage.enterUsername("test");
        loginPage.enterPassword("test");
    }

    @When("I click Login button")
    public void click_button() {
        loginPage.clickLogin();
    }

    @Then("I should see welcome message")
    public void verify_login() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(loginPage.getWelcomeMessage().contains("test"));
        driver.quit();
    }


}
