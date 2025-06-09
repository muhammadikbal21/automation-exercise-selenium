package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.ContactUsPage;
import utils.WaitUtils;

public class ContactUsSteps {

    private ContactUsPage contactUsPage;
    private WebDriver driver = Hooks.driver;

    public ContactUsSteps() {
        this.contactUsPage = new ContactUsPage(driver);
    }

    @And("click contact us menu")
    public void clickContactUsMenu() {
        WebElement contactMenuElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getContactUsMenu());
        contactMenuElement.click();

        String expectedUrl = "https://www.automationexercise.com/contact_us";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement titleContactElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getGetInTouchTitle());
        String expectedTitleContact = "GET IN TOUCH";
        String actualTitleContact = titleContactElement.getText();
        Assert.assertEquals(actualTitleContact, expectedTitleContact);
    }

    @And("input name at contact us form")
    public void inputNameAtContactUsForm() {
        WebElement nameContactElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getInputName());
        String actualNameContactInput = "Muhammad Ikbal";
        nameContactElement.sendKeys(actualNameContactInput);

        // ini berfungsi untuk mengambil nilai dari field email agar dapat diperiksa
        String expectedNameContactInput = nameContactElement.getAttribute("value");
        Assert.assertEquals("Name Contact input mismatch", expectedNameContactInput, actualNameContactInput);
    }

    @And("input email at contact us form")
    public void inputEmailAtContactUsForm() {
        WebElement emailContactElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getInputEmail());
        String actualEmailContactInput = "ikbal@gmail.com";
        emailContactElement.sendKeys(actualEmailContactInput);

        // ini berfungsi untuk mengambil nilai dari field email agar dapat diperiksa
        String expectedEmailContactInput = emailContactElement.getAttribute("value");
        Assert.assertEquals("Email Contact input mismatch", expectedEmailContactInput, actualEmailContactInput);
    }

    @And("input subject at contact us form")
    public void inputSubjectAtContactUsForm() {
        WebElement subjectContactElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getInputSubject());
        String actualSubjectContactInput = "Ini Subject";
        subjectContactElement.sendKeys(actualSubjectContactInput);

        // ini berfungsi untuk mengambil nilai dari field email agar dapat diperiksa
        String expectedSubjectContactInput = subjectContactElement.getAttribute("value");
        Assert.assertEquals("Subject Contact input mismatch", expectedSubjectContactInput, actualSubjectContactInput);
    }

    @And("input message at contact us form")
    public void inputMessageAtContactUsForm() {
        WebElement messageContactElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getInputMessage());
        String actualMessageContactInput = "Ini Message";
        messageContactElement.sendKeys(actualMessageContactInput);

        // ini berfungsi untuk mengambil nilai dari field email agar dapat diperiksa
        String expectedMessageContactInput = messageContactElement.getAttribute("value");
        Assert.assertEquals("Message Contact input mismatch", expectedMessageContactInput, actualMessageContactInput);
    }

    @And("browse file at contact us form")
    public void browseFileAtContactUsForm() {
        WebElement browseFileElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getBrowseFile());
        // path di macbook
        String filePath = "/Users/muhammadikbal/Documents/Ikbal/Project/Selenium/AutomationExercise/src/test/resources/testfiles/nezuko.jpeg";
        browseFileElement.sendKeys(filePath);

        String uploadedFileValue = browseFileElement.getAttribute("value");
        Assert.assertTrue("Uploaded file path should contain file name",
                uploadedFileValue.contains("nezuko.jpeg"));
    }

    @When("click submit button")
    public void clickSubmitButton() {
        WebElement submitButtonElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getSubmitButton());
        // ini berfungsi sebagai scrolling agar button langsung diarahkan pada tempatnya dan tidak tertutupi iklan/ads pada web nya
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButtonElement);
        submitButtonElement.click();

        Alert alert = driver.switchTo().alert();
        String confirmAlert = alert.getText();
        String expectedConfirmAlert = "Press OK to proceed!";
        Assert.assertEquals(expectedConfirmAlert, confirmAlert);
        alert.accept();
    }

    @Then("user see wording success submit form")
    public void userSeeWordingSuccessSubmitForm() {
        WebElement successWordingElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getSuccessWording());
        String expectedSuccessWording = "Success! Your details have been submitted successfully.";
        String actualSuccessWording = successWordingElement.getText();

        Assert.assertEquals(expectedSuccessWording, actualSuccessWording);
    }

    @When("click home button")
    public void clickHomeButton() {
        WebElement homeButtonElement = WaitUtils.waitForElementToBeVisible(contactUsPage.getHomeButton());
        homeButtonElement.click();

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
