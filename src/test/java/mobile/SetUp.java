package Mobile;

import io.appium.java_client.android.AndroidDriver;
import io.visual_regression_tracker.sdk_java.IgnoreAreas;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

public class TestApp {
    static String platformName = "Android";
    static String deviceName = "vivo Y21s";
    static String platformVersion = "12";
    static String udid = "3412447670002B7";
    private static AndroidDriver<WebElement> driver;
    private static VisualRegressionTracker vrt;
    @BeforeClass
    public static void setUp() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("newCommandTimeout", 90000);
        String appPath = System.getProperty("user.dir") + "\\src\\test\\resources\\BDOPay.apk";
        System.out.println(appPath);
        capabilities.setCapability("app", appPath);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        VisualRegressionTrackerConfig vrtConfig = VisualRegressionTrackerConfig.builder()
                .apiUrl("http://localhost:4200")
                .apiKey("DEFAULTUSERAPIKEYTOBECHANGED")
                .project("Default project")
                .branchName("master")
                .enableSoftAssert(true)
                .build();
        vrt = new VisualRegressionTracker(vrtConfig);
        vrt.start();
    }

@Test
    public void checkApp() throws InterruptedException, IOException {
        Thread.sleep(10000);
        //CLick Allow
        vrt.track(
                "Login Page",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), TestRunOptions.builder().device(deviceName).os("Android 12")
                        .customTags("BDOPay").viewport("3360 x 2012").diffTollerancePercent(0.0f)
                        .ignoreAreas(Collections.singletonList(IgnoreAreas.builder()
                                .x(10L).y(10L).width(100L).height(200L).build())).build());
    }

    @AfterClass
    public static void tearDown() throws IOException, InterruptedException {
        driver.closeApp();
        vrt.stop();
    }
}