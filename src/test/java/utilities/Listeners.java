package utilities;

import org.testng.*;


public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {


    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Start : " + context.getName());  //--> testin ismini veriyor
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish :  " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On Test Start:  " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess  " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure   " + result.getName());
        ReusableMethods.allPageSS();   //
    }




    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
