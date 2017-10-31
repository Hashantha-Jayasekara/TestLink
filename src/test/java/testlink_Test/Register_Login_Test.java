package testlink_Test;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import testlink_PageFactory.Browser_SetUp;
import testlink_Pages.Register_Login;

/**
 * Created by Hashantha on 3/30/2017.
 */

public class Register_Login_Test {

    Browser_SetUp objBrowser;
    Register_Login objRegisterLogin;

    String randomName = RandomStringUtils.randomAlphabetic(10);
    String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@test.com";


    String result;
    String notes = null;

    @BeforeTest()
    public void SetUp() throws Exception{
        this.objBrowser = new Browser_SetUp();
        this.objBrowser.setUp();
    }

    @BeforeMethod()
    public void beforeMethods(){

        objRegisterLogin = new Register_Login(this.objBrowser.driver);

    }


    @Test(priority = 1)
    public void registerUser()throws Exception{
        String pwd = "1qaz2wsx@";

        try{

            objBrowser.driver.get(objBrowser.site + "user/register");
            objRegisterLogin.registerData(randomEmail,randomName, pwd);
            System.out.println("User Registration Success!");
            System.out.println("Updating Test Results");
            objBrowser.sleep();
            result = TestLinkAPIResults.TEST_PASSED;
            notes = "Executed successfully";

        }catch (Exception e) {
            result = TestLinkAPIResults.TEST_FAILED;
            notes = "Execution failed";



    }
        finally {
            objRegisterLogin.updateTestLinkResult("001-1", notes, result);
        }


}

    @Test(priority = 2)
    public void loginUser()throws Exception{
        String pwd = "1qaz2wsx@";

        try {
            objBrowser.driver.get(objBrowser.site + "user/logout");
            objBrowser.sleep();
            objBrowser.driver.get(objBrowser.site + "user/login");
            objRegisterLogin.loginData(randomEmail,pwd);
            System.out.println("User login Success!");
            System.out.println("Updating Test Results");
            objBrowser.sleep();
            result = TestLinkAPIResults.TEST_PASSED;
            notes = "Executed successfully";


        }catch (Exception e){
            result = TestLinkAPIResults.TEST_FAILED;
            notes = "Execution failed";
        }

        finally {
            objRegisterLogin.updateTestLinkResult("001-2", notes, result);
        }


    }

    @Test(priority = 3)
    public void userPreference()throws Exception{

        try {

            objRegisterLogin.selectUserPreference();
            System.out.println("User Preference Selected");
            System.out.println("Updating Test Results");
            objBrowser.sleep();
            result = TestLinkAPIResults.TEST_PASSED;
            notes = "Executed successfully";


        }catch (Exception e){
            result = TestLinkAPIResults.TEST_FAILED;
            notes = "Execution failed";
        }

        finally {
            objRegisterLogin.updateTestLinkResult("001-3", notes, result);
        }

    }

    
}
