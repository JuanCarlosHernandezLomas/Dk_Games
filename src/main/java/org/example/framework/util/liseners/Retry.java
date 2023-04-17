package org.example.framework.util.liseners;

import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.example.framework.util.extentreports.ExtentTestManager.getTest;


public class Retry implements IRetryAnalyzer {
    private byte count = 0;
    private static byte maxTry= 1 ;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if(count<maxTry){
                count++;
                iTestResult.setStatus(iTestResult.FAILURE);
                extendReportsFailOperation(iTestResult);
            }
        }
        return false;
    }

    private void extendReportsFailOperation(ITestResult iTestResult) {
        getTest().log(Status.FAIL,"Test Failed ");
        //add screenshot
    }
}
