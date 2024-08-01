package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage extends BasePage {

    public AddRemovePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "button[onclick='addElement()']")
    public WebElement addButton;

    @FindBy(css = "button[onclick='deleteElement()']")
    public WebElement deleteButton;


}
