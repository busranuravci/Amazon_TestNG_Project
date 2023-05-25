package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CartTest {
    CartPage cartPage;


    @Test
    public void testShopping() {
        SearchPage searchPage = new SearchPage();

        cartPage = new CartPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        searchPage.searchBox.sendKeys("air fryer", Keys.ENTER);

        Assert.assertTrue(cartPage.productPrice.isDisplayed());

        ReusableMethods.wait(3);
        cartPage.firstAirFry.click();

        ReusableMethods.wait(2);
        ReusableMethods.webElementSS(cartPage.productSS);

        Assert.assertTrue(cartPage.buyButton.isDisplayed());
        cartPage.addCartButton.click();
  ReusableMethods.wait(2);

        ReusableMethods.webElementSS(cartPage.cartScreen);
        Assert.assertTrue(cartPage.cartScreen.isDisplayed());
        System.out.println("This product price is:  " + cartPage.priceText.getText());

        ReusableMethods.wait(2);
        cartPage.checkoutButton.click();
        ReusableMethods.wait(2);

        cartPage.address.click();
        cartPage.nameBox.sendKeys("Mary Jane",Keys.TAB,
                                            ConfigReader.getProperty("phone"),Keys.TAB,
                               ConfigReader.getProperty("address1"),Keys.TAB,
                            ConfigReader.getProperty("address2"),Keys.TAB, "SF");
   ReusableMethods.wait(2);
        Select sc = new Select(cartPage.stateDD);
        sc.selectByIndex(5);

        cartPage.zipCode.sendKeys("35201");
        cartPage.useAddress.click();

    ReusableMethods.wait(2);
        cartPage.addDebitCard.click();

        cartPage.cardBox.sendKeys("credit_card",Keys.TAB,"nameCard");
    ReusableMethods.wait(2);

        ReusableMethods.ddmIndex(cartPage.expDay,6);
        ReusableMethods.ddmIndex(cartPage.expYear,8);

        cartPage.payButton.submit();

        Assert.assertTrue(cartPage.successfulText.getText().contains("Your order has been received!"));


        Driver.closeDriver();
    }

}
