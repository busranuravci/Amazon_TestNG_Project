package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage  {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;


    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
    public WebElement appleWatch;

    @FindBy(id = "searchDropdownBox")
    public WebElement categoriesDD;


    @FindBy(xpath = "//*[@id=\"nav-global-location-popover-link\"]")
    public WebElement deliveryLocation;
    @FindBy(xpath = "//*[@id=\"GLUXCountryListDropdown\"]/span/span")
    public WebElement deliveryCountriesDD;
    @FindBy(xpath = "//*[@id=\"a-popover-1\"]/div/div[2]/span/span/span/button")
    public WebElement locationDoneButton;

    @FindBy(id = "glow-ingress-line2")
    public WebElement locationScreen;

    @FindBy(xpath = "//*[@id=\"icp-nav-flyout\"]")
    public WebElement languageOption;

    @FindBy(xpath = "//*[@id=\"icp-touch-link-language\"]/span[1]")
    public WebElement defaultLanguageEng;


    @FindBy(xpath = "//*[@id=\"icp-touch-link-cop\"]/span[2]")
    public WebElement moneyType;

    @FindBy(xpath = "//*[@id=\"icp-currency-dropdown-selected-item-prompt\"]/span/span")
    public WebElement moneyDD;

    @FindBy(xpath = "//*[@id=\"icp-save-button\"]/span/input")
    public WebElement saveChangeButton;
    @FindBy(xpath = "//*[@id=\"icp-cancel-button\"]/span/a")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"icp-currency-dropdown_22\"]")
    public WebElement pound;



    @FindBy(xpath = "//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")
    public WebElement alert;

    @FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[1]")
    public  WebElement todaysDeal;
    @FindBy(xpath = "//*[@id=\"nav-subnav\"]/a[2]/span")
    public WebElement couponsButton;



}
