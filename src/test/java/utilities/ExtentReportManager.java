package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;    // UI of the report
	public ExtentReports extent;    //populate common info on the report
	public ExtentTest test;     // creating test case entries in the report and update status of the test methods
	String reportName;
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		reportName = "Test-Report-" + timeStamp + ".html";
 
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);// specify location of the report
		sparkReporter.config().setDocumentTitle(" Interest Rate Finding Report"); // Title of report
		sparkReporter.config().setReportName("EMI Calculator Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);  // setting dark theme 
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
 
		extent.setSystemInfo("Application", "EMICalculator");
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Browser name","Chrome,Edge");
		extent.setSystemInfo("User Name", "Saptarshi Roy");  //System.getProperty("user.name")
		extent.setSystemInfo("Environemnt", "QAE");
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
 

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
 
	}
	public void onTestSuccess(ITestResult result) {
		//test = extent.createTest(result.getTestClass().getName()); //package+testclassname
		//result.getMethod().getMethodName() =  .getName()
		//result.getTestClass().getName()+"."+ result.getName() - package+testclass+methodname
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, result.getName() + " got successfully executed");
 
		String imgPath = new ScreenShotClass(driver).screenShot(result.getName());  // initiating screenshot class
		//  taking screen capture upon test execution 
		test.addScreenCaptureFromPath(imgPath);
	}
	public void onTestFailure(ITestResult result)
	{
 
		//test = extent.createTest(result.getTestClass().getName());
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		String imgPath = new ScreenShotClass(driver).screenShot(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}
	public void onTestSkipped(ITestResult result) {
 
		//test = extent.createTest(result.getTestClass().getName());
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
 
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
		// storing the path of extent reports 
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
		File extentReport = new File(pathOfExtentReport);
		try {
			// automatic opening of extent report upon completeion of test automation in default browser in local machine
			Desktop.getDesktop().browse(extentReport.toURI());
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}