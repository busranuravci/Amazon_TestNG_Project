package tests;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegisterTest {

    RegisterPage registerPage;


    @Test (priority = 0)
    public void testRegister() {

        registerPage= new RegisterPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"), "Title does NOT contains 'Amazon'!");

        registerPage.accountButton.click();
        registerPage.createAccount.click();

        registerPage.nameBox.sendKeys("Mary Jane", Keys.TAB,ConfigReader.getProperty("validMail"),Keys.TAB,
                                                      ConfigReader.getProperty("validPassword"),Keys.TAB,ConfigReader.getProperty("validPassword"));
        ReusableMethods.wait(3);
        registerPage.verifyCountinue.submit();

    }

    @Test(priority = 1)
    public void testVerify() {
        registerPage=new RegisterPage();
        Driver.getDriver().get(ConfigReader.getProperty("verifyLink"));

        String emailVerifyText = registerPage.verifyCode.getText();

        registerPage.verifyCodeBox.sendKeys(emailVerifyText);

        registerPage.createButton.submit();


        Driver.closeDriver();
    }

}
