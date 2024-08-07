package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstnameField;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastnameField;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneField;

    @FindBy(xpath = "//input[@ value ='male']")
    public WebElement genderTypeMale;

    @FindBy(xpath = "//input[@name='birthday']")
    public WebElement birthDateField;

    @FindBy(xpath = "//select[@name='department']")
    public WebElement departmentDropdown;

    @FindBy(xpath = "//select[@name='job_title']")
    public WebElement jobTitleDropdown;

    @FindBy(xpath = "//input[@value='java']")
    public WebElement languageJava;

    @FindBy(xpath = "//button[@id='id_register']")
    public WebElement signUpButton;


}
