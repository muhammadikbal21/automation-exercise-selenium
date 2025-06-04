package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LogoutPage;
import utils.WaitUtils;

public class LogoutSteps {

    private LogoutPage logoutPage;
    private WebDriver driver = Hooks.driver;

    public LogoutSteps() {
        this.logoutPage = new LogoutPage(driver);
    }

    @When("user click logout button")
    public void userClickLogoutButton() {
        WebElement logoutButtonElement = WaitUtils.waitForElementToBeVisible(logoutPage.getLogoutButton());

        logoutButtonElement.click();
    }

    @Then("user is navigated to login page")
    public void userIsNavigatedToLoginPage() {
        WaitUtils.waitForTitle("Automation Exercise - Signup / Login");

        String expectedUrl = "https://www.automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
