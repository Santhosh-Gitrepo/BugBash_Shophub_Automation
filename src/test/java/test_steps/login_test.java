package test_steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login;
import org.junit.Assert;

public class login_test {
    WebDriver driver;
    login login;

    @Given("user is on the login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bugbash.syook.com/");
        login = new login(driver);
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("clicks the login button")
    public void clickLogin() {
        login.clickLogin();
    }

    @Then("login should be successful")
    public void loginSuccessful(){
        String msg = login.getMessage();
        Assert.assertEquals("Login successful!", msg);
        driver.quit();
    }

    @Then("error message should be displayed")
    public void loginFailed() {
        String msg = login.getMessage();
        Assert.assertEquals("Invalid email or password. Try: admin@shophub.com / admin123", msg);
    }
    @After
    public void browserquit() {
    	driver.quit();
    }
}
