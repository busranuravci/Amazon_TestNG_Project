package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
    public WebElement firstAirFry;


    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]")
    public WebElement productPrice;


    @FindBy(xpath = "//*[@id=\"dp-container\"]")
    public  WebElement productSS;


    @FindBy(id = "add-to-cart-button")
    public  WebElement addCartButton;


    @FindBy(id = "buy-now-button")
    public  WebElement buyButton;


    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]")
    public WebElement cartScreen;


     @FindBy(xpath = "//*[@id=\"gutterCartViewForm\"]/div/div/div[1]")
     public WebElement priceText;


    @FindBy(xpath = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
    public  WebElement checkoutButton;


    @FindBy(xpath = "//*[@id=\"add-new-address-popover-link\"]")
    public WebElement address;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
    public WebElement nameBox;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")
    public WebElement stateDD;


    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    public WebElement zipCode;


    @FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
    public WebElement useAddress;


    @FindBy(id = "pp-A5a7eE-77")
    public WebElement addDebitCard;


    @FindBy(id = "pp-2Fr89n-16")
    public WebElement cardBox;

    @FindBy(xpath = "//*[@id=\"pp-2Fr89n-22\"]/span/span")
    public WebElement expDay;


    @FindBy(xpath = "//*[@id=\"pp-2Fr89n-23\"]/span/span")
    public WebElement expYear;


    @FindBy(xpath = "//*[@id=\"pp-A5a7eE-91-announce\"]")
    public WebElement payButton;

    @FindBy(xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[3]")
    public WebElement successfulText;



}






















