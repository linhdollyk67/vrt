package mobile.tests;

import io.appium.java_client.AppiumDriver;
import mobile.SetUp;
import mobile.features.LoginFeature;
import org.testng.annotations.Test;

import java.io.IOException;

public class registerFlow extends SetUp {
    LoginFeature loginFeature = new LoginFeature(driver);
    @Test(priority = 0)
    public void loginToApp() throws IOException, InterruptedException {
        trackPage("Login Screen");
        loginFeature.inputValidInfo("bdopay2sit16", "Qaz123456*a");
        Thread.sleep(15000);
        trackPage("Input OTP page");
        loginFeature.inputOTP("123456");
    }
}
