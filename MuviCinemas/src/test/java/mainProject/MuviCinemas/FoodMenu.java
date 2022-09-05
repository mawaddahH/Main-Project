package mainProject.MuviCinemas;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class FoodMenu extends BaseConnection {
	
	/**
	 * Test download Food Menu
	 * @throws MalformedURLException 
	 */
	@Test(retryAnalyzer = RetryingFailedTestCases.class,groups = { "Food Menu" },description=" Verify if the guest/user can download and open the food menu as a PDF file")
	public void TC_13() throws InterruptedException, MalformedURLException {

		// create Test Report
		ExtentTestManager.startTest("TC_13"," Verify if the guest/user can download and open the food menu as a PDF file",deviceName_,"Food Menu");
		Thread.sleep(40000);

		// Navigate to "My account"
		driver.findElement(AppiumBy.id("com.muvi:id/ivHome")).click();
		System.out.println("Finshed: Navigate \"My account\" ");
		Thread.sleep(3000);

		// Navigate to "Food Menu"
		driver.findElement(AppiumBy.id("com.muvi:id/tvFnB")).click();
		System.out.println("Finshed: Navigate to \"Food Menu\"");
		Thread.sleep(60000);

		// Click on "Boutique Menu"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'Boutique Menu')]")).click();
		System.out.println("Finshed: Click on \"Boutique Menu\"");
		Thread.sleep(25000);

		// get all contexts
		Set<String> contexts = driver.getContextHandles();

		for (String context : contexts) {
			System.out.println("getContextHandles =" + context);
		}

		// get current context
		String context1 = driver.getContext();
		System.out.println("Finshed: the current context is = " + context1);
		Thread.sleep(5000);

		driver.findElement(AppiumBy.xpath("//*[contains(@text,'Cancel')]")).click();
		Thread.sleep(5000);

		driver.findElement(AppiumBy.xpath("//*[contains(@text,'BoutiqueMenu.pdf')]")).click();
		Thread.sleep(5000);

		// Click on "Adobe Acrobat"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'Adobe Acrobat')]")).click();
		System.out.println("Finshed: Click on \"Adobe Acrobat\"");
		Thread.sleep(5000);

		// get all contexts
		Set<String> contexts1 = driver.getContextHandles();

		for (String context : contexts1) {
			System.out.println("getContextHandles =" + context);
		}

		// get current context
		String context2 = driver.getContext();
		System.out.println("Finshed: the current context is = " + context2);
		Thread.sleep(5000);
		
		
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

		
		// back to another native app
		Activity newActivity =
				new Activity("com.muvi", "com.muvi.ui.splash.SplashScreen")
				.setAppWaitPackage("com.muvi")
				.setAppWaitActivity("com.muvi.ui.splash.SplashScreen")
				.setStopApp(false);
		driver.startActivity(newActivity);
		
		
		// back to "My account" Page
		Navigation navigate = driver.navigate();
		navigate.back();
		System.out.println("Finshed: back to \"My account\" Page");
		Thread.sleep(3000);

		// back to "My account" Page
		navigate.back();
		System.out.println("Finshed: back to \"My account\" Page");
		Thread.sleep(3000);

		// Click on "Movie"
		driver.findElement(AppiumBy.accessibilityId("Movies")).click();
		System.out.println("Finshed: Click on \"Movies\"");
		Thread.sleep(3000);

	}
}
