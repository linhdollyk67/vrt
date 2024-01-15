package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    static String platformName = "Android";
    static String deviceName = "vivo Y21s";
    static String platformVersion = "12";
    static String udid = "3412447670002B7";
    int timeoutExWait = 30;
    int timeoutImWait = 5;
//    public static WebDriverWait waitApp;
    public static AppiumDriver<MobileElement> driver;
//    private static AndroidDriver<WebElement> driver;
    public static VisualRegressionTracker vrt;
    public BaseTest(AppiumDriver driver){
        this.driver = driver;
//        waitApp = new WebDriverWait(driver, timeoutExWait);
    }
    public BaseTest(){

    }
}
