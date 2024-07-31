package com.ucodeacademy.practice;

import org.junit.Assert;
import org.junit.Test;

public class JUnitAssertions {

    @Test
    public void assertion1(){
        Assert.assertTrue("Failed message", 10 == 10);
        //Assert.assertTrue("Message", 6 > 10); // this will fail, because condition is false

       Assert.assertFalse("message", 10 < 7); // it will pass because it expects false

        Assert.assertEquals("message", 10, 10);
        Assert.assertEquals('a','b');


    }

}
