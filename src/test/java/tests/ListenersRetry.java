package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class ListenersRetry {


    @Test (retryAnalyzer =utilities.ListenersRetry.class)
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }


}
