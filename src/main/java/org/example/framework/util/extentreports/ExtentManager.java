package org.example.framework.util.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtendReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./results/extent-report.html");
        reporter.config().setReportName("Test Execution Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Plataforma","DK games");
        extentReports.setSystemInfo("Author", "Juan Carlos Hernández Lomas");
        return  extentReports;
    }
}
