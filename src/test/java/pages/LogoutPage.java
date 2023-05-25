package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath ="//*[@id=\"nav-link-accountList\"]" )
    public WebElement accountBox;


    @FindBy(xpath = "//*[@id=\"nav-item-signout\"]/span")
    public WebElement signOut;


}
