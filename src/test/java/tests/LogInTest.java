package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LogInTest {

    LoginPage loginPage;


    @Test
    public void testLogIn() {
        loginPage = new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"), "Title does NOT contains 'Amazon'!");

        loginPage.sigInButton.click();

        loginPage.mailBox.sendKeys("validMail");
        loginPage.continueButton.submit();

        ReusableMethods.wait(3);

        loginPage.passwordBox.sendKeys("validPassword");
        ReusableMethods.wait(2);
        loginPage.logInButton.submit();

        Assert.assertTrue(loginPage.accountName.isDisplayed(), "Account name is NOT display!");

        ReusableMethods.webElementSS(loginPage.accountName);

        Driver.closeDriver();
    }

}

