package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.AddRemovePage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Wait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddRemoveSteps {

    AddRemovePage addRemovePage = new AddRemovePage();


    @Given("User is on the Ucode academy add remove page")
    public void user_is_on_the_ucode_academy_add_remove_page() {
        String url = ConfigReader.getProperty("add_remove_url");
        Driver.getDriver().get(url);

    }
    @When("User clicks on Add element button")
    public void user_clicks_on_add_element_button() {
        addRemovePage.addButton.click();

        // this clickOn custom method is coming from BasePage
        // it wait for element to be clickable and click on it
        //addRemovePage.clickOn(addRemovePage.addButton);

    }
    @Then("A new button should be displayed")
    public void a_new_button_should_be_displayed() {
        // verify that the button is displayed
        //boolean displayed = addRemovePage.deleteButton.isDisplayed();
        Assert.assertTrue("Delete button is not displayed", addRemovePage.deleteButton.isDisplayed());


    }
    @Then("User click on Delete button")
    public void user_click_on_delete_button() {
        // wait for few seconds, so we can see the button before deleting it
//        Wait.waitForGivenTime(3);

        addRemovePage.deleteButton.click();

        // this clickOn custom method is coming from BasePage
        // it wait for element to be clickable and click on it
       // addRemovePage.clickOn(addRemovePage.deleteButton);

        //Wait.waitForGivenTime(2);

    }
    @Then("Delete Button should deleted")
    public void delete_button_should_deleted() {
        // since the element is not there after deleting it
        // we need to use try catch block

        try{
            Assert.assertTrue(addRemovePage.deleteButton.isDisplayed());
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Delete button is not displayed");
        }
        // fail it on purpose
       // Assert.fail();

//        Driver.quitDriver();

    }




}
