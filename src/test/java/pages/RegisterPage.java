package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
    public WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    public WebElement createAccount;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    public WebElement nameBox;

    @FindBy(id = "continue")
    public WebElement verifyCountinue;

    @FindBy(xpath = "//*[@id=\"cvf-input-code\"]")
    public WebElement verifyCodeBox;



    @FindBy(xpath = "//*[@id=\"x_verificationMsg\"]/p[2]")
    public WebElement verifyCode;


    @FindBy(xpath = "//*[@id=\"cvf-submit-otp-button\"]/span/input")
    public WebElement createButton;


}
