package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.LoginPage;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStepDefs extends TestBase {
    LoginPage loginPage = new LoginPage();


    @When("User enters invalid username {string}")
    public void user_enters_invalid_username(String username) {
        loginPage.usernameInput.sendKeys(username);

    }
    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) {
     loginPage.passwordInput.sendKeys(password);
    }
    @Then("User should not be able to login")
    public void user_should_not_be_able_to_login() {
       loginPage.loginButton.click();
       Driver.quitDriver();
    }


    // second scenario

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.usernameInput.sendKeys(username);


    }
    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
     loginPage.passwordInput.sendKeys(password);
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
       loginPage.loginButton.click();

//        Driver.quitDriver();
    }



}
