package com.konakart.Helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 * Extent Report:To generate HTML report on the user-specified path.
 * This will generate screenshot for pass,fail and skip case.
 * 
 * @author indira.saravanan
 *
 */

public class ExtentReport extends TestBase {

	ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;

	public void startReport() {
		htmlReporter = new ExtentHtmlReporter("Extent.html");
		htmlReporter.config().setDocumentTitle("Automation Report-Atmecs.com");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	// This will generate HTML report
	public void tearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE FAILED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE SKIPPED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE PASSED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	// This will generate screenshot
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshot/" + screenshotName + ".png";
		File Destination = new File(destination);
		FileUtils.copyFile(source, Destination);
		return destination;
	}
}
