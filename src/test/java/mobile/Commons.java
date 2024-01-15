package mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Commons extends SetUp{
    public void pause(int time) {
        try {
            if (time >= 1000) {
                for (int i = 0; i < time / 1000; i++) {
                    if (time > 1000) {
                        System.out.println("Sleep " + (i + 1) + "s");
                    }
                    Thread.sleep(1000);
                }
            } else {
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    public void waitElement(String xpathExpression) {
//        waitApp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
//    }
    public void clickElement(String xpathExpression) {
//        waitElement(xpathExpression);
        driver.findElement(By.xpath(xpathExpression)).click();
    }
    public void clickIdElement(String idExpression) {
//        waitElement(idExpression);
        driver.findElement(By.id(idExpression)).click();
    }
    public void sendKey(String xpathExpression, String keyWord){
//        waitElement(xpathExpression);
        driver.findElement(By.xpath(xpathExpression)).sendKeys(keyWord);
    }
}
