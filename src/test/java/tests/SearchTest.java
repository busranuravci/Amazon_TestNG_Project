package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class SearchTest {

    SearchPage searchPage;


    @Test
    public void testSearchProduct() {

        searchPage=new SearchPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        searchPage.searchBox.sendKeys("airpods", Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().getTitle().contains("airpods"), "Title does NOT contains 'airpods' !");

        ReusableMethods.wait(3);
        Driver.getDriver().navigate().back();

        searchPage.searchBox.sendKeys("apple watch");
        searchPage.searchIcon.click();

        ReusableMethods.wait(3);
        Assert.assertFalse(Driver.getDriver().getTitle().contains("airpods"), "Title does NOT contains 'apple watch' !");

        searchPage.appleWatch.click();

        ReusableMethods.allPageSS();

        Driver.closeDriver();
    }


    @Test
    public void testCategoriesClick() {

        searchPage=new SearchPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        searchPage.categoriesDD.click();

        Select select = new Select(searchPage.categoriesDD);
        select.selectByIndex(5);

        ReusableMethods.wait(3);

        List<WebElement> categoryList = select.getOptions();
        System.out.println("Selected category is: " + categoryList.get(5).getText());


        Driver.quitDriver();
    }


    @Test
    public void testDeliveryLocation() {

        searchPage = new SearchPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        searchPage.deliveryLocation.click();

        ReusableMethods.wait(2);

        Assert.assertEquals(searchPage.deliveryCountriesDD.getText(), "Ship outside the US");

        ReusableMethods.wait(2);

        searchPage.deliveryCountriesDD.click();

        Select select1= new Select(searchPage.deliveryCountriesDD);
        select1.selectByVisibleText("United Kingdom");

        List<WebElement> categoryList = select1.getOptions();
        System.out.println("Selected country is: " + categoryList.get(6).getText());

        ReusableMethods.wait(5);

        searchPage.locationDoneButton.click();

        ReusableMethods.wait(2);
        Assert.assertTrue(searchPage.locationScreen.getText().contains("United Kingdom"));

        ReusableMethods.webElementSS(searchPage.locationScreen);

        Driver.closeDriver();
    }


    @Test
    public void testLanguageOptions() {

        searchPage = new SearchPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        ReusableMethods.JSscrollEnd();
    ReusableMethods.wait(3);
         ReusableMethods.JSscrollHome();
    ReusableMethods.wait(2);
        ReusableMethods.hoverOverActions(searchPage.languageOption);

        Assert.assertTrue(searchPage.defaultLanguageEng.getText().contains("English"));

        Driver.closeDriver();
    }


    @Test
    public void testMoneyType() {

        searchPage = new SearchPage();
        Driver.getDriver().get("https://amazon.com");

        ReusableMethods.JSscrollEnd();
        Assert.assertFalse(searchPage.moneyType.getText().contains("TRY- Turkish Lira"));

     ReusableMethods.wait(3);

        searchPage.moneyType.click();
     ReusableMethods.wait(3);

        searchPage.moneyDD.click();
       ReusableMethods.wait(2);
          searchPage.pound.click();
       ReusableMethods.wait(5);

       ReusableMethods.JSscroll(searchPage.cancelButton);
       ReusableMethods.wait(2);

       Assert.assertTrue(searchPage.cancelButton.isDisplayed()," Cancel Button is NOT Displayed");

         ReusableMethods.wait(2);
          searchPage.saveChangeButton.click();


        Driver.quitDriver();
    }


    @Test
    public void testCoupon() {

        searchPage = new SearchPage();
        Driver.getDriver().get("https://amazon.com");

        searchPage.alert.click();
        searchPage.todaysDeal.click();
     ReusableMethods.wait(3);
        searchPage.couponsButton.click();

        ReusableMethods.allPageSS();


        Driver.closeDriver();

    }
}

