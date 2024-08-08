package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.GoogleSearchPage;
import com.ucodeacademy.utility.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class SearchDTStepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("User search for")
    public void user_search_for(DataTable dataTable) {

        List<String> searchWords = dataTable.asList(String.class);

        for (String eachWord : searchWords){
            //googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(eachWord + Keys.ENTER);
            // verify title contains the searched word (eachWord)
            //Assert.assertTrue("Failed!",Driver.getDriver().getTitle().contains(eachWord));
        }


    }


}
