package com.ucodeacademy.step_definitions;

import com.ucodeacademy.utility.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//    @Before (order = 1)
//    public void beforeEachScenario(Scenario scenario){
//        System.out.println("I run before each scenario 1");
////        System.out.println(scenario.getName());
////        System.out.println(scenario.getId());
////        System.out.println(scenario.getLine());
////        System.out.println(scenario.getStatus());
//
//
//    }

//    @Before(order = 2)
//    public void beforeEachScenario2(Scenario scenario){
//        System.out.println("I run before each scenario 2");
//    }

//    @After
//    public void afterEachScenario(Scenario scenario){
//        System.out.println("I run after each Scenario 1");
////        System.out.println(scenario.getName());
////        System.out.println(scenario.getId());
////        System.out.println(scenario.getLine());
////        System.out.println(scenario.getStatus());
//
//    }

//    @After(order = 2)
//    public void afterEachScenario2(Scenario scenario){
//        System.out.println("I run after each Scenario 2");
//    }
//
//    // run Before specific Scenario or Scenarios with matching tag
//    @Before(value = "@xyz")
//    public void beforeSpecificScenario(Scenario scenario){
//        System.out.println("I run before the scenario that has @xyz");
//    }
//    // run After specific Scenario or Scenarios with matching tag
//
//    @After(value = "@xyz")
//    public void afterSpecificScenario(Scenario scenario){
//
//        System.out.println("I run after the scenario that has @xyz");
//
//    }



//    @BeforeStep
//    public void beforeStep(Scenario scenario){
//        System.out.println("I run before each step in scenario");
//    }
//
//    @AfterStep
//    public void afterEachStep(Scenario scenario){
//        System.out.println("I run after each step in scenario");
//        //System.out.println(scenario.getSourceTagNames());
//    }

    // bellow we'll use @After to take a screenshot if a scenario/step fails
    @After
    public void screenshotOfFailedScenario(Scenario scenario){
        if (scenario.isFailed()){
            // Cast driver to TakeScreenshot to take screenshot and it in byte [] screenshot
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    // bellow we'll use @AfterStep to take a screenshot of each step
    @AfterStep
    public void takeScreenshot(Scenario scenario){
        byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png",scenario.getName());
    }



}
