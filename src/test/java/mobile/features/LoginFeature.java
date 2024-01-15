package mobile.features;

import io.appium.java_client.AppiumDriver;
import mobile.BaseTest;
import mobile.pages.LoginPage;
import mobile.Commons;

public class LoginFeature extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    Commons commons = new Commons();
    public LoginFeature(AppiumDriver driver) {
        super(driver);
    }
    public void inputValidInfo(String username, String pw){
        loginPage.inputUserName(username);
        loginPage.inputPassWord(pw);
        loginPage.clickLoginBtn();
        commons.pause(20000);

    }

    public void inputOTP(String otp){
        loginPage.inputOTP(otp);
    }
}
