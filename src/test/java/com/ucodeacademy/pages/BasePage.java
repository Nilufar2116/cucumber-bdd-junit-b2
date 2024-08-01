package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends Wait {

    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void clickOn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
}
