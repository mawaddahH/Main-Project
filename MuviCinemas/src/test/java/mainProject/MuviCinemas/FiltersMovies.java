/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FiltersMovies extends BaseConnection {
	
	/**
	 * Test select more than one option
	 * @throws MalformedURLException 
	 */
	@Test(retryAnalyzer = RetryingFailedTestCases.class,groups = { "Filters Movies" },description="Verify if the user can select more than one option in the experience types.")
	public void TC_09() throws InterruptedException, MalformedURLException {
		
		ExtentTestManager.startTest("TC_09","Verify if the user can select more than one option in the experience types.",deviceName_,"Filters Movies");

		System.out.println("Finshed: driver is "+ driver);

		//Get driver
		// back to another native app
		Thread.sleep(4000);
		
		// click on "FILTERS"
		driver.findElement(AppiumBy.id("com.muvi:id/tvFilter")).click();
		Thread.sleep(3000);

		// select option "Standard"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'Standard')]")).click();
		System.out.println("Finshed: select option \"Standard\"");
		Thread.sleep(3000);

		// select option "screen X"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'screen X')]")).click();
		System.out.println("Finshed: select option \"screen X\"");
		Thread.sleep(3000);
		
		// select option "muvi JUNIOR"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'muvi JUNIOR')]")).click();
		System.out.println("Finshed: select option \"muvi JUNIOR\"");
		Thread.sleep(3000);
		
		// Click on "APPLY"
		driver.findElement(AppiumBy.id("com.muvi:id/btn_filter_apply")).click();
		System.out.println("Finshed: Click on \"APPLY\"");
		Thread.sleep(3000);
		
		// scroll vertical
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int centerX = (int) (width / 2);
		double startY = (int) (height * 0.6);
		double endY = (int) (height * 0.1);
		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-1");
		Thread.sleep(5000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-2");
		Thread.sleep(5000);
		
		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-3");
		Thread.sleep(5000);
		
		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-4");
		Thread.sleep(5000);
		
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
