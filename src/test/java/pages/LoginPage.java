package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//*[@id=\"nav-signin-tooltip\"]/a/span")
    public WebElement sigInButton;


    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public WebElement mailBox;


    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    public WebElement accountName;



}
