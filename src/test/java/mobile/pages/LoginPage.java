package mobile.pages;

import io.appium.java_client.AppiumDriver;
import mobile.BaseTest;
import mobile.Commons;

public class LoginPage extends BaseTest {
    Commons commons = new Commons();
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public String username= "//*[@resource-id='ph.com.bdo.pay.tst:id/authenticationJourney_usernameScreen_usernameField']";

    public String password ="//*[@resource-id='ph.com.bdo.pay.tst:id/authenticationJourney_usernameScreen_passwordField']";

    public String loginBtn  = "//*[@resource-id='ph.com.bdo.pay.tst:id/authenticationJourney_usernameScreen_loginButton']";
    public void inputUserName(String data){
        commons.pause(3000);
        commons.clickElement(username);
        commons.sendKey(username, data);

    }

    public void inputPassWord(String data){
        commons.pause(3000);
        commons.clickElement(password);
        commons.sendKey(password, data);

    }
    public void clickLoginBtn() {
        commons.pause(3000);
        commons.clickElement(loginBtn);

    }

    public void inputOTP(String OTP){
        commons.pause(7000);
        driver.getKeyboard().sendKeys(OTP);
    }
}
