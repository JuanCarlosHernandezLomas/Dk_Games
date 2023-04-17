package org.example.framework.util.liseners;

import com.aventstack.extentreports.Status;

import org.example.framework.base.DriverFactory;
import org.example.framework.util.extentreports.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.example.framework.util.extentreports.ExtentTestManager.getTest;
import static org.example.framework.util.logs.Log.info;


public class TestListener extends DriverFactory implements ITestListener {
    private static  String getTestMethodName(ITestResult iTestResult){
        return  iTestResult.getMethod().getConstructorOrMethod().getName();

    }
    @Override
    public void  onStart(ITestContext iTestContext){
        info("Starting method" +iTestContext.getName());
        iTestContext.setAttribute("WebDriver", getInstance().getDriver());
    }

    @Override
    public  void onFinish(ITestContext iTestContext){
        info("Finishing method " +iTestContext.getName());
        info("XXXXXXXXXXXXXXX   -E--N--D    XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestFailure(ITestResult iTestResult){
        info(getTestMethodName(iTestResult)+ "test is failed.");
        getTest().log(Status.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        info(getTestMethodName(iTestResult)+ "test is skipped.");
        getTest().log(Status.SKIP,"Test skipped");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult){
        info(getTestMethodName(iTestResult)+ "test is succed.");
        getTest().log(Status.PASS,"Test Passed");
    }
    @Override
    public void  onTestStart (ITestResult iTestResult){
        info("****************************************************************");
        info(getTestMethodName(iTestResult) + "Test is starting");
        info("****************************************************************");
    }
    @Override
    public  void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){
        info("Test failed but it is in defined success ratio " +getTestMethodName(iTestResult));

    }
}
