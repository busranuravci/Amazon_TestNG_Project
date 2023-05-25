package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LogOutTest {
    LoginPage loginPage;


    LogoutPage logoutPage;

    @Test(priority = 1)
    public void testLogOut() {

        logoutPage = new LogoutPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"), "Title does NOT contains 'Amazon'!");

        ReusableMethods.hoverOverActions(logoutPage.accountBox);

        ReusableMethods.wait(3);

        logoutPage.signOut.click();

        Driver.closeDriver();

    }



    @Test(priority = 0)
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


    }

}
