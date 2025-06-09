package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By contactUsMenu = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By getInTouchTitle = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    By inputName = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    By inputEmail = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    By inputSubject = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    By inputMessage = By.xpath("//*[@id=\"message\"]");
    By browseFile = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    By submitButton = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
    By successWording = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    By homeButton = By.xpath("//*[@id=\"form-section\"]/a");

    public By getContactUsMenu() {
        return contactUsMenu;
    }

    public By getGetInTouchTitle() {
        return getInTouchTitle;
    }

    public By getInputName() {
        return inputName;
    }

    public By getInputEmail() {
        return inputEmail;
    }

    public By getInputSubject() {
        return inputSubject;
    }

    public By getInputMessage() {
        return inputMessage;
    }

    public By getBrowseFile() {
        return browseFile;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public By getSuccessWording() {
        return successWording;
    }

    public By getHomeButton() {
        return homeButton;
    }
}
