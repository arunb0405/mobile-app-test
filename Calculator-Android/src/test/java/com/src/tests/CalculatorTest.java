package com.src.tests;

import com.google.common.collect.ImmutableMap;
import com.src.pages.CalculatorPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current Dir :" +currentDirectory);
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "pixel 6a");
        capabilities.setCapability("udid", "emulator-5554");
//        capabilities.setCapability("udid", "26101JEGR03574");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("newCommandTimeout", 5000);
        capabilities.setCapability("app",currentDirectory +"\\com.google.android.calculator_Android-6.0.apk");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testCal()  {
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/digit_2")));
        calculatorPage.add();
        //WebElement results = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        //Check the calculated value on the edit box
        assert calculatorPage.resultText.getText().equals("6") : "Actual value is : " + calculatorPage.resultText.getText() + " did not match with expected value: 6";

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) calculatorPage.resultText).getId(),"duration",3000)
        );
    }

    @AfterClass
    public void teardown() {
        //close the app
        driver.quit();
    }
}