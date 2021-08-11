package com.sdet1718.util;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerIMP implements ITestListener {

	private ExtentReports report;
	private ExtentTest test;
	public void onFinish(ITestContext arg0) {					
		report.flush();

	}		


	public void onStart(ITestContext arg0) {
		//C:\Users\Nitheesha\Desktop\User1\SDET17-18
		File file=new File("./ExtentReport.html");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(file);
		htmlReport.config().setDocumentTitle("Application V1.0");
		htmlReport.config().setReportName("Test Execution");
		htmlReport.config().setTheme(Theme.DARK);
		//add all the configuration to extent report
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("App url", "http://appUrl.com");
		report.setSystemInfo("Reporter Name", "Nithesh H S");
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					


	}		


	public void onTestFailure(ITestResult result) {					

		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		String screenshotPath=WebDriverUtility.takeScreenShot(Baseclass.staticDriver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath);
	}		


	public void onTestSkipped(ITestResult result) {					
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());

	}		


	public void onTestStart(ITestResult result) {					
		 test=report.createTest(result.getMethod().getMethodName());

	}		


	public void onTestSuccess(ITestResult result) {					

		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}	
}
