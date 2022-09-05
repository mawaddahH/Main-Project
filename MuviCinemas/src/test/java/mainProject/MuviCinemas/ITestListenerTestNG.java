/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class ITestListenerTestNG extends BaseConnection implements ITestListener {
	
	ExtentReports extent = ExtentReportNG.ExtentReportsGenerator();
	String deviceName_;
	
	public void onStart(ITestContext context) {
		System.out.println("-------------------------");
		System.out.println("onStart method "+context.getName()+" \n");
		deviceName_ = context.getCurrentXmlTest().getParameter("deviceName_");
		System.out.println("onStart method deviceName_ = context.getCurrentXmlTest().getParameter(\"deviceName_\"); == "+deviceName_+" \n");

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method "+context.getName());
		System.out.println("------------------------- \n");
		// flush the report
		extent.flush();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestStart(ITestResult result) {
		System.out.println("-------");
		System.out.println("New Test Started " + result.getName()+"\n");
		
//		result.getTestContext().getCurrentXmlTest().getParameter("deviceName_");
//		if(result.getMethod().getDataProviderMethod()==null) {
//		ExtentTestManager.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription(), deviceName_,
//				result.getAttribute("groups").toString());
//		}
//		else {
//			ExtentTestManager.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription()+" with DataProvider = "+result.getMethod().getDataProviderMethod().getMethod().getParameters().toString(), deviceName_,
//					result.getAttribute("groups").toString());
//		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method " + result.getName()+"\n");
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");

//		 //Get driver from BaseTest and assign to local webdriver variable.
//        Object testClass = result.getInstance();
//        AndroidDriver driver = ((BaseConnection) testClass).getDriver();
//        //Take base64Screenshot screenshot for extent reports
//        String base64Screenshot =
//            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
//        //ExtentReports log and screenshot operations for failed tests.
//        ExtentTestManager.getTest().log(Status.PASS, "Test Passed",
//        ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method " + result.getName()+"\n");
		 //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = result.getInstance();
        AndroidDriver driver = ((BaseConnection) testClass).getDriver();
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable().getMessage(),
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method " + result.getName()+"\n");
		// add the result to the report
		Object testClass = result.getInstance();
        AndroidDriver driver = ((BaseConnection) testClass).getDriver();
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(Status.SKIP, result.getThrowable().getMessage(),
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage Method " + result.getName()+"\n");
	}
}
