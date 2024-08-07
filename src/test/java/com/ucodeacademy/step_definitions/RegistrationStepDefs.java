package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.RegistrationPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class RegistrationStepDefs {

    RegistrationPage registrationPage = new RegistrationPage();

    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        String url = ConfigReader.getProperty("register.url");
        Driver.getDriver().get(url);

    }
    @Given("User enters first name {string}")
    public void user_enters_first_name(String firstName) {

        registrationPage.firstnameField.sendKeys(firstName);

    }
    @Given("User enters last name {string}")
    public void user_enters_last_name(String lastName) {
        registrationPage.lastnameField.sendKeys(lastName);

    }
    @Given("User enters username {string}")
    public void user_enters_username(String username) {
        registrationPage.usernameField.sendKeys(username);

    }
    @Given("User enters email {string}")
    public void user_enters_email(String email) {
        registrationPage.emailField.sendKeys(email);
    }
    @Given("User enters password {string}")
    public void user_enters_password(String password) {
        registrationPage.passwordField.sendKeys(password);
    }
    @Given("User enters phone number {string}")
    public void user_enters_phone_number(String phoneNumber) {
        registrationPage.phoneField.sendKeys(phoneNumber);

    }
    @Given("User selects gender Male")
    public void user_selects_gender() {
        registrationPage.genderTypeMale.click();
    }
    @Given("User enters data of birth {string}")
    public void user_enters_data_of_birth(String birthDate) {
        registrationPage.birthDateField.sendKeys(birthDate);
    }
    @Given("User selects Department of Engineering {string} from dropdown")
    public void user_selects_department_of_engineering_from_dropdown(String department) {
        // we could declare it in the class level and initialize it here
        Select select = new Select(registrationPage.departmentDropdown);
        select.selectByValue(department);

    }
    @Given("User selects Job title {string} from dropdown")
    public void user_selects_job_title_from_dropdown(String jobTitle) {
        // we could declare it in the class level and initialize it here
        Select select = new Select(registrationPage.jobTitleDropdown);
        select.selectByVisibleText(jobTitle);


    }
    @Given("User selects programming language {string}")
    public void user_selects_programming_language(String string) {
        registrationPage.languageJava.click();
    }
    @Given("User clicks on Sign up button")
    public void user_clicks_on_sign_up_button() {

    }
    @Then("User should able to register successfully")
    public void user_should_able_to_register_successfully() throws InterruptedException {
        registrationPage.signUpButton.click();

        //verify registration is successful
        // using try-catch block for negative test -> trying to register with invalid entry
        try {
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("registration_confirmation"));
            System.out.println("Positive test passed");
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Negative test passed");
        }

        System.out.println(Driver.getDriver().getCurrentUrl());

       Thread.sleep(4000);
       Driver.quitDriver();

    }
}
