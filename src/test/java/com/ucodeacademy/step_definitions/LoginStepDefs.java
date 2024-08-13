package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.LoginPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs extends TestBase {
    LoginPage loginPage = new LoginPage();


    @When("User is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigReader.getProperty("login.url");
        Driver.getDriver().get(url);

    }
    @When("User enters invalid {string} in username field")
    public void user_enters_invalid_in_username_field(String username) {
        loginPage.usernameInput.sendKeys(username);

    }
    @When("User enters invalid {string} in password field")
    public void user_enters_invalid_in_password_field(String password) {
        loginPage.passwordInput.sendKeys(password);

    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        // clicking directly
        //loginPage.loginButton.click();
        // Click on login button using clickOn() from BasePage
        loginPage.clickOn(loginPage.loginButton);

    }
    @Then("User should see an {string}")
    public void user_should_see_an(String expectedError) {

        // get the text of web element directly
        //String actualError = loginPage.errorMessage.getText();

        // get the text of web element using getTextOfWebElement() from BasePage
        String actualError = loginPage.getTextOfWebElement(loginPage.errorMessage);

        // verify error message
       Assert.assertTrue("Error message doesn't match", actualError.contains(expectedError));

        // verify error using custom method
        //assertTextContain(actualError, expectedError);

//       Driver.quitDriver();

        // we can call this method directly, to quit the driver
        // we follow this way Driver.quitDriver();
        //tearDown2();


    }



}
