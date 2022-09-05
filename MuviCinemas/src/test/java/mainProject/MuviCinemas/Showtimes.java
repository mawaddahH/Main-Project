/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Showtimes extends BaseConnection {
	/**
	 * Test displays a "user details mandatory" message
	 * @throws MalformedURLException 
	 */
	@Test(retryAnalyzer = RetryingFailedTestCases.class,groups = { "Showtimes" },description="Verify if the system displays a \"user details mandatory\" message when the user did not fill in all the required information for guest.")
	public void TC_11() throws InterruptedException, MalformedURLException {
		// create Test Report
		ExtentTestManager.startTest("TC_11","Verify if the system displays a \"user details mandatory\" message when the user did not fill in all the required information for guest.",deviceName_,"Showtimes");
		Thread.sleep(4000);

		// click on "Showtimes"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'Showtimes')]")).click();
		System.out.println("Finshed: Showtimes");
		Thread.sleep(10000);

		// click on "Date"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'05')]")).click();
		System.out.println("Finshed: click on \"Date\"");
		Thread.sleep(10000);

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

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-5");
		Thread.sleep(5000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-6");
		Thread.sleep(5000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-7");
		Thread.sleep(5000);

		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-8");
		Thread.sleep(5000);

		// choose movie time
		if (driver.findElement(AppiumBy.xpath("//*[contains(@text,'Orphan: First Kill')]")).isDisplayed()) {
			// click on "Time"
			driver.findElement(AppiumBy.xpath("//*[contains(@text,'12:20 AM')]")).click();
			System.out.println("Finshed: click on \"Date\"");
			Thread.sleep(5000);
		} else {
			// click on any "Time"
			driver.findElement(AppiumBy.id("com.muvi:id/tv_show_time")).click();
			System.out.println("Finshed: click on \"Date\"");
			Thread.sleep(5000);
		}

		// click on "Agree"
		driver.findElement(AppiumBy.id("com.muvi:id/btnAgree")).click();
		System.out.println("Finshed: click on \"Agree\"");
		Thread.sleep(15000);

		// click on "Skip"
		driver.findElement(AppiumBy.id("com.muvi:id/btnSkipOffers")).click();
		System.out.println("Finshed: click on \"Skip\"");
		Thread.sleep(5000);

		// click on "close pop-up" windows
		driver.findElement(AppiumBy.id("com.muvi:id/close_icon")).click();
		System.out.println("Finshed: click on \"Next\"");
		Thread.sleep(5000);

		// Select seat
		driver.findElement(AppiumBy.xpath(
				"//android.widget.RelativeLayout[@content-desc=\"Zoom tip\"]/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.RelativeLayout/android.widget.TableLayout/android.widget.LinearLayout[1]/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.LinearLayout/android.widget.ImageView[4]"))
				.click();
		System.out.println("Finshed: Select seat 1");
		Thread.sleep(3000);

		/// Zoom out
		attemptPinchToZoomOut();
		Thread.sleep(5000);

		// select another seat 
		driver.findElement(AppiumBy.xpath(
				"//android.widget.RelativeLayout[@content-desc=\"Zoom tip\"]/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.RelativeLayout/android.widget.TableLayout/android.widget.LinearLayout[1]/android.widget.TableLayout/android.widget.TableRow[3]/android.widget.LinearLayout/android.widget.ImageView[4]"))
				.click();
		System.out.println("Finshed: Select seat 2");
		Thread.sleep(3000);

		// click on "close pop-up" windows
		driver.findElement(AppiumBy.id("com.muvi:id/close_icon")).click();
		System.out.println("Finshed: click on \"close pop-up\" windows");
		Thread.sleep(5000);

		// select another seat 
		driver.findElement(AppiumBy.xpath(
				"//android.widget.RelativeLayout[@content-desc=\"Zoom tip\"]/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.RelativeLayout/android.widget.TableLayout/android.widget.LinearLayout[1]/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.LinearLayout/android.widget.ImageView[9]"))
				.click();
		System.out.println("Finshed: Select seat 3");
		Thread.sleep(3000);

		// select another seat 
		driver.findElement(AppiumBy.xpath(
				"//android.widget.RelativeLayout[@content-desc=\"Zoom tip\"]/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.RelativeLayout/android.widget.TableLayout/android.widget.LinearLayout[1]/android.widget.TableLayout/android.widget.TableRow[5]/android.widget.LinearLayout/android.widget.ImageView[2]"))
				.click();
		System.out.println("Finshed: Select seat 4");
		Thread.sleep(3000);

		// click on "Cart Arrow"
		driver.findElement(AppiumBy.accessibilityId("Cart Arrow")).click();
		System.out.println("Finshed: click on \"Cart Arrow\"");
		Thread.sleep(6000);

		// click on "close"
		driver.findElement(AppiumBy.id("com.muvi:id/ivCloseTicketsSummary")).click();
		System.out.println("Finshed: click on \"close\"");
		Thread.sleep(6000);

		// click on "Next"
		driver.findElement(AppiumBy.id("com.muvi:id/tvContinue")).click();
		System.out.println("Finshed: click on \"Next\"");
		Thread.sleep(10000);

		// click on "Guest"
		driver.findElement(AppiumBy.id("com.muvi:id/tvGuest")).click();
		System.out.println("Finshed: click on \"Guest\"");
		Thread.sleep(10000);

		// click on "Arrow"
		driver.findElement(AppiumBy.id("com.muvi:id/ivArrow")).click();
		System.out.println("Finshed: click on \"Arrow\"");
		Thread.sleep(5000);

		// scroll vertical
		height = driver.manage().window().getSize().getHeight();
		width = driver.manage().window().getSize().getWidth();
		centerX = (int) (width / 2);
		startY = (int) (height * 0.6);
		endY = (int) (height * 0.1);
		verticalScroll(centerX, startY, endY);
		System.out.println("Finshed: verticalScroll-1");
		Thread.sleep(5000);

		// send Key on "First Name"
		driver.findElement(AppiumBy.id("com.muvi:id/tvFirstname")).sendKeys("Mawaddah");
		System.out.println("Finshed: send Key on \"First Name\"");
		Thread.sleep(3000);

		// send Key on "Last Name"
		driver.findElement(AppiumBy.id("com.muvi:id/tvLastname")).sendKeys("UltraPower");
		System.out.println("Finshed: send Key on \"Last Name\"");
		Thread.sleep(3000);

		// send Key on "Email"
		driver.findElement(AppiumBy.id("com.muvi:id/tvEmail")).sendKeys("ultrapower.team5@gmail.com");
		System.out.println("Finshed: send Key on \"Email\"");
		Thread.sleep(3000);

		// send Key on "payment_type"
		driver.findElement(AppiumBy.id("com.muvi:id/llv_payment_type")).click();
		System.out.println("Finshed: send Key on \"payment_type\"");
		Thread.sleep(3000);

		// Click on "Pay"
		driver.findElement(AppiumBy.id("com.muvi:id/btnPay")).click();
		System.out.println("Finshed: Click on \"Pay\"");
		Thread.sleep(3000);
		
		// compare error message
		if(driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).isDisplayed()) {
			String text = driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).getText();
			Assert.assertEquals("User details mandatory", text);
			System.out.println("Finshed: the text error is = "+ text);
			Thread.sleep(3000);

			// Click on "OK"
			driver.findElement(AppiumBy.id("com.muvi:id/btn_ok")).click();
			System.out.println("Finshed: Click on \"OK\"");
			Thread.sleep(3000);	
		}

		// back
		Navigation navigate = driver.navigate();
		navigate.back();
		System.out.println("Finshed: back");
		Thread.sleep(3000);

		// back 
		navigate.back();
		System.out.println("Finshed: back");
		Thread.sleep(3000);

		// Click on "OK"
		driver.findElement(AppiumBy.id("com.muvi:id/btn_ok")).click();
		System.out.println("Finshed: Click on \"OK\"");
		Thread.sleep(10000);

		// Click on "Movie"
		driver.findElement(AppiumBy.accessibilityId("Movies")).click();
		System.out.println("Finshed: Click on \"Movies\"");
		Thread.sleep(3000);

	}
}
