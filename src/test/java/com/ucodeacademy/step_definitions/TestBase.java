package com.ucodeacademy.step_definitions;

import com.ucodeacademy.utility.Driver;
import org.junit.After;
import org.junit.Assert;

public class TestBase {

   // @After // this works with @Test and it runs after each @Test
    // since we are not Using @Test, this will not work
    public void tearDown2(){
        Driver.quitDriver();
    }

    public void assertTextContain(String actual, String expected){
        Assert.assertTrue("Failed!", actual.contains(expected));
    }

}
