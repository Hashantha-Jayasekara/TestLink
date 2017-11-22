package testlink_PageFactory;

/**
 * Created by Hashantha on 10/18/2017.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class Browser_SetUp {

    public static String DEV_KEY = "ae6d708dd85e99015f89a8612c6a010a";
    public static String SERVER_URL = "http://localhost/testlink/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    public static String PROJECT_NAME = "flipMyroom";
    public static String PLAN_NAME = "Phase04";
    public static String BUILD_NAME = "Phase04_Regression";
    public WebDriver driver;
    public String site = "https://www.flip.net/";

    public void setUp() throws Exception {

        driver = new FirefoxDriver();
    }


    public void sleep()  {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
    }


}
