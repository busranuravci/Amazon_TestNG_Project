package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;



    public static void wait (int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }


    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }


    public static void ddmVisibleText(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }


    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }


    public static void ddmValue(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByValue(option);
    }


    public static void switchToWindow(int num) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(num));
    }


    public static void window(int num) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[num].toString());
    }

    public static void visibleWait(WebElement element, int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    public static WebElement visibleWait(By locator, int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        wait.until(ExpectedConditions.alertIsPresent());

    }


    public static void allPageSS() {
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "Test_ScreenShoots/" + "screenshot" + date + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void webElementSS(WebElement element) {
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "Test_ScreenShoots" + date + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public static void JSclick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }



    public static void JSscroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void JSscrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


    public static void JSscrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    public static void JSsendKeys(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }


    public static void hoverOverActions(WebElement element) {
        Actions actions = new Actions(Driver.driver);
        new Actions(Driver.driver).moveToElement(element).perform();
    }




    //ExtentReport
    public static void extentReport() {
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "TestOutput/reports/extentReport_" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);


        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Busra");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Report");
    }




}