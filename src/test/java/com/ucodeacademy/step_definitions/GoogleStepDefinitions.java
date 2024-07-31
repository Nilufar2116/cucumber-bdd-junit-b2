package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.GoogleSearchPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage searchPage = new GoogleSearchPage();


    @Given("User is on the google home page")
    public void user_is_on_the_google_home_page() {
        String url = ConfigReader.getProperty("googleUrl");

        Driver.getDriver().get(url);


    }
    @Given("User searches for {string}")
    public void user_searches_for(String word) {
        searchPage.searchBox.sendKeys(word+ Keys.ENTER);

    }
    @Then("User should see {string} in the tile")
    public void user_should_see_in_the_tile(String word) {

        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Failed", title.contains(word));

        Driver.quitDriver();



    }

}
