/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Stories extends BaseConnection {


	/**
	 * Test displays rules of entry message
	 * 
	 * @throws MalformedURLException
	 */
	@Test(retryAnalyzer = RetryingFailedTestCases.class,groups = {
			"Stories" }, description = "Verify if the system displays rules of entry message when the user wants to book a movie from the stories.")
	public void TC_07() throws InterruptedException, MalformedURLException {
		// create Test Report
//		ExtentTestManager.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription(),deviceName_,result.getMethod().getGroups().toString());
		ExtentTestManager.startTest("TC_07",
				"Verify if the system displays rules of entry message when the user wants to book a movie from the stories.",
				deviceName_, "Stories");
		Thread.sleep(4000);

		// scroll horizontal by coordinate
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int centerY = (int) (height / 1.7);
		double startX = (int) (width * 0.9);
		double endX = (int) (width * 0.1);

		System.out.println("Finshed: height = " + height);
		System.out.println("Finshed: width = " + width);
		System.out.println("Finshed: centerY = " + centerY);
		System.out.println("Finshed: startX = " + startX);
		System.out.println("Finshed: endX = " + endX);

		horizonalScroll(centerY, startX, endX);
		Thread.sleep(3000);

		// click on story
		WebElement image = driver.findElement(AppiumBy.xpath("//*[contains(@text,'Bullet Train')]"));
		image.click();
		System.out.println("Finshed: click on story");
		Thread.sleep(15000);

		// click on "book now"
		driver.findElement(AppiumBy.id("com.muvi:id/btn_promotion")).click();
		System.out.println("Finshed: click on \"book now\"");
		Thread.sleep(3000);

		// scroll vertical
		height = driver.manage().window().getSize().getHeight();
		width = driver.manage().window().getSize().getWidth();
		int centerX = (int) (width / 2);
		double startY = (int) (height * 0.6);
		double endY = (int) (height * 0.1);
		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-1");
		Thread.sleep(3000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-2");
		Thread.sleep(3000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-3");
		Thread.sleep(3000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-4");
		Thread.sleep(3000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-5");
		Thread.sleep(3000);

		// select time
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'01:20 AM')]")).click();
		System.out.println("Finshed: select time");
		Thread.sleep(3000);

		// click on "Cancel"
		driver.findElement(AppiumBy.id("com.muvi:id/btnCancel")).click();
		System.out.println("Finshed: click on \"Cancel\"");
		Thread.sleep(3000);

		// back to "My account" Page
		Navigation navigate = driver.navigate();
		navigate.back();
		System.out.println("Finshed: back to \"My account\" Page");
		Thread.sleep(3000);

		// Click on "Movie"
		driver.findElement(AppiumBy.accessibilityId("Movies")).click();
		System.out.println("Finshed: Click on \"Movies\"");
		Thread.sleep(3000);

	}
}
