package org.fa.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Forgeahead-Shital on 9/15/2017.
 */
public class GuiControl {
    private WebElement webElement;
    private List<WebElement>webElementList;
    private static WebDriver webDriver;
    private String locatorType;
    private String locatorValue;

    public GuiControl(String locator){
        locatorType=locator.split("_TBD_")[0];
        locatorValue=locator.split("_TBD_")[1];
    }

    public static void setWebDriver(String browserName){
        switch (browserName.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver",getDriverPath(browserName));
                webDriver=new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver",getDriverPath(browserName));
                webDriver=new FirefoxDriver();
                break;
        }
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static String getDriverPath(String browserName){
        String driverPath=null;
        String osName=System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")){
            driverPath="src/main/resources/drivers/windows/"+browserName+"driver.exe";
        }
        if (osName.contains("linux")){
            driverPath="src/main/resources/drivers/linux/"+browserName+"driver";
        }
        if (osName.contains("mac")){
            driverPath="src/main/resources/drivers/mac/"+browserName+"driver";
        }
        return driverPath;
    }

    public WebElement getGuiControl(){
        return getGuiControl(locatorType,locatorValue);
    }

    public WebElement getGuiControl(String locatorType,String locatorValue){
        switch (locatorType.toUpperCase()){
            case "ID" :
                webElement = webDriver.findElement(By.id(locatorValue));
                break;
            case "XPATH" :
                webElement = webDriver.findElement(By.xpath(locatorValue));
                break;
        }
        return webElement;
    }

    public void click(){
        getGuiControl().click();
    }

    public void sendKyes(String keys){
        getGuiControl().sendKeys(keys);
    }

    public void setText(String text){
        getGuiControl().clear();
        getGuiControl().sendKeys(text);
    }
}
