package test_steps;

import io.cucumber.java.After;
import utils.test_logger;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login;

import java.io.IOException;

import org.junit.Assert;

public class LoginTest {
    WebDriver driver;
    login login;
    test_logger logger = new test_logger();

    @Given("user is on the login page")
    public void openLoginPage() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bugbash.syook.com/");
        logger.log("Launched the browser with specified url");
        login = new login(driver);
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) throws IOException, InterruptedException {
        login.enterUsername(username);
        login.enterPassword(password);
        logger.log("Entered Login Credentials: "+username+" and "+password);
    }

    @And("clicks the login button")
    public void clickLogin() {
        login.clickLogin();
    }
    @Then("login result {string}")
    public void loginResult(String result) throws IOException, InterruptedException {
        String msg = login.getMessage();

        if (result.equalsIgnoreCase("successful")) 
        {
            Assert.assertEquals("Login successful!", msg);
            logger.log("Successfully logged in");
        } 
        else if (result.equalsIgnoreCase("failed")) 
        {
            Assert.assertEquals("Invalid email or password. Try: admin@shophub.com / admin123", msg);
            logger.log("Login failed with invalid credentials");
        }
    }
    @After
    public void browserquit() {
    	driver.quit();
    }
}
