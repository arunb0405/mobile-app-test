package com.src.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    private AndroidDriver driver;

    public CalculatorPage() {
    }

    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    public WebElement digit2Button;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private WebElement digit4Button;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private WebElement addButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private WebElement eqButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public WebElement resultText;

    @AndroidFindBy(id = "com.google.android.calculator:id/clr")
    private WebElement acButton;

    //@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"multiply\"]")
    @AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
    private WebElement mulButton;

    public void add() {
        digit2Button.click();
        addButton.click();
        digit4Button.click();
        eqButton.click();
    }

    public void multiply() {
        digit2Button.click();
        mulButton.click();
        digit4Button.click();
        eqButton.click();
    }

    public String getResult() {
        return resultText.getText();
    }

    public void clearScreen() {
        acButton.click();
    }

    public boolean isKeypadDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String targetResourceId = "com.google.android.calculator:id/clr";
        WebElement mobileElement = driver.findElement(By.id(targetResourceId));
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
//        ExpectedConditions.pre
        return mobileElement.isDisplayed();
    }
}
