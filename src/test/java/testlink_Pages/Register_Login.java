package testlink_Pages;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink_PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Hashantha on 10/18/2017.
 */
public class Register_Login extends Browser_SetUp {

    //Login Page Elements
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy (id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;

    //Register Page Elements
    @FindBy(id = "EmailAddress")
    WebElement RegisterEmail;
    @FindBy(id = "FirstName")
    WebElement RegisterFirstname;
    @FindBy(id = "surname")
    WebElement RegisterSurname;
    @FindBy (id = "show-pwd")
    WebElement ShowPassword;
    @FindBy(id = "Password")
    WebElement RegisterPassword;
    @FindBy(id = "registersubmit")
    WebElement RegisterButton;


    //UserPreference form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[1]/label[2]")
    WebElement hostTab;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[2]/button")
    WebElement proceed;


    public Register_Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver , this);
    }


    //Login page data passing
    public  void loginData(String randomEmail, String pwd){
        email_address.sendKeys(randomEmail);
        password.sendKeys(pwd);
        login_button.click();
    }


    //Register page data passing
    public void registerData(String randomEmail, String randomName, String pwd) {
        RegisterEmail.sendKeys(randomEmail);
        RegisterFirstname.sendKeys(randomName);
        RegisterSurname.sendKeys(randomName);
        RegisterPassword.sendKeys(pwd);
        ShowPassword.click();
        RegisterButton.click();
    }


    //UserPreference Select
    public void selectUserPreference(){
        hostTab.click();
        proceed.click();
    }

    public void updateTestLinkResult(String testCase, String notes, String result) throws TestLinkAPIException
    {
        TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,SERVER_URL);
        testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, notes, result);
    }

}
