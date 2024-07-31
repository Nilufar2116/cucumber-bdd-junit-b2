package com.ucodeacademy.practice;

import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Wait;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void test1(){

        String url = ConfigReader.getProperty("url");
        Driver.getDriver().get(url);
        Wait.waitForGivenTime(3);

        Driver.quitDriver();
    }
}
