/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

/**
 * Rigorous Test :-)
 */
public class CreateAnAccountFunction extends BaseConnection {

	/**
	 * Test Sign-in Word
	 * 
	 * @throws MalformedURLException
	 */
	@Parameters({ "deviceName_" })
	@Test(enabled=false,retryAnalyzer = RetryingFailedTestCases.class,
	priority = 1, groups = {"Create Account" },
	description = "Verify if the system displays the word sign-in / sign-out in the application rather than log-in /log-out")
	public void TC_05(String deviceName_) throws InterruptedException, MalformedURLException {
		// Get driver
//		this.driver =getdriver(deviceName_,platform_,port_);
		ExtentTestManager.startTest("TC_05",
				"Verify if the system displays the word sign-in / sign-out in the application rather than log-in /log-out",
				deviceName_, "Create Account");
		Thread.sleep(4000);

		// Navigate "My account"
		driver.findElement(AppiumBy.id("com.muvi:id/ivHome")).click();
		System.out.println("Finshed: Navigate \"My account\" ");
		Thread.sleep(3000);

		// click on "Sign-in"
		String text1 = driver.findElement(AppiumBy.id("com.muvi:id/tvSignin")).getText();
		driver.findElement(AppiumBy.id("com.muvi:id/tvSignin")).click();
		System.out.println("Finshed: click on \"Sign-in\" ");
		Thread.sleep(3000);

		// check "Sign in"
		if (driver.findElement(AppiumBy.id("com.muvi:id/btLogin")).isDisplayed()) {
			String text2 = driver.findElement(AppiumBy.id("com.muvi:id/btLogin")).getText();
			Assert.assertEquals(text2, text1);
			System.out.println("Finshed: Assert.assertEquals(text1, text2)");
			Thread.sleep(3000);
		}
	}

	/**
	 * Test Error Message "The user already exists"
	 */
	@Parameters({ "deviceName_" })
	@Test(enabled=false,retryAnalyzer = RetryingFailedTestCases.class, priority = 2, groups = {
			"Create Account" }, description = "Verify if the system displays an error message when the user enters an existing email in the sign-up form")
	public void TC_02(String deviceName_) throws InterruptedException {
		ExtentTestManager.startTest("TC_02",
				"Verify if the system displays an error message when the user enters an existing email in the sign-up form",
				deviceName_, "Create Account");
		Thread.sleep(4000);

		// back to "Movies" Page
		Navigation navigate = driver.navigate();
		navigate.back();
		Thread.sleep(3000);

		// click on "Sign-up"
		driver.findElement(AppiumBy.id("com.muvi:id/tvSignup")).click();
		System.out.println("Finshed: click on \"Sign-up\" ");
		Thread.sleep(3000);

		// Send Key to "First Name"
		driver.findElement(AppiumBy.id("com.muvi:id/tvFirstname")).sendKeys("Mawaddah");
		System.out.println("Finshed: Send Key to \"First Name\"");
		Thread.sleep(3000);

		// Send Key to "Last Name"
		driver.findElement(AppiumBy.id("com.muvi:id/tvLastname")).sendKeys("UltraPower");
		System.out.println("Finshed: Send Key to \"Last Name\"");
		Thread.sleep(3000);

		// Send Key to "Email"
		driver.findElement(AppiumBy.id("com.muvi:id/tvEmail")).sendKeys("ultrapower.team5@gmail.com");
		System.out.println("Finshed: Send Key to \"Email\"");
		Thread.sleep(3000);

		// Send Key to "Mobile Number"
		driver.findElement(AppiumBy.id("com.muvi:id/etMobileNo")).sendKeys("533891847");
		System.out.println("Finshed: Send Key to \"Mobile Number\"");
		Thread.sleep(3000);

		// Click "Date of Birth"
		driver.findElement(AppiumBy.id("com.muvi:id/tvDateSignUp")).click();
		System.out.println("Finshed: Click \"Date of Birth\"");
		Thread.sleep(3000);

		// Click "year"
		driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
		System.out.println("Finshed: Click \"year\"");
		Thread.sleep(3000);

		// Select "year"
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'1998')]")).click();
		System.out.println("Finshed: Select \"year\"");
		Thread.sleep(3000);

		// Select "Month"
		WebElement previousMonth = driver.findElement(AppiumBy.accessibilityId("Previous month"));
		previousMonth.click();
		Thread.sleep(3000);

		previousMonth.click();
		Thread.sleep(3000);

		previousMonth.click();
		Thread.sleep(3000);

		previousMonth.click();
		Thread.sleep(3000);

		previousMonth.click();
		Thread.sleep(3000);

		System.out.println("Finshed: Select \"Month\"");
		Thread.sleep(3000);

		// Select "Day"
		driver.findElement(AppiumBy.accessibilityId("09 April 1998")).click();
		System.out.println("Finshed: Select \"Day\"");
		Thread.sleep(3000);

		// Click "OK"
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		System.out.println("Finshed: Click \"OK\"");
		Thread.sleep(3000);

		// Select "Female"
		driver.findElement(AppiumBy.id("com.muvi:id/rbFemale")).click();
		System.out.println("Finshed: Select \"Female\"");
		Thread.sleep(3000);

		// Send Key to "Password"
		driver.findElement(AppiumBy.id("com.muvi:id/tvPassword")).sendKeys("##UltraPOWER5");
		System.out.println("Finshed: Send Key to \"Password\"");
		Thread.sleep(3000);

		// Select "Agree"
		driver.findElement(AppiumBy.id("com.muvi:id/checkNotificationSignup")).click();
		System.out.println("Finshed: Select \"Agree\"");
		Thread.sleep(3000);

		// Click "Sign up"
		driver.findElement(AppiumBy.id("com.muvi:id/btSign")).click();
		System.out.println("Finshed: Click \"Sign up\"");
		Thread.sleep(5000);

		if (driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).isDisplayed()) {
			String text = driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).getText();
			Assert.assertEquals("The user already exists. Please try to login or register a new account.", text);
			System.out.println("Finshed: The text message displayied = " + text);
			// Click "OK"
			driver.findElement(AppiumBy.id("com.muvi:id/btn_ok")).click();
			System.out.println("Finshed: Click \"OK\"");
			Thread.sleep(3000);

		}
		
		// back to "Sign-in form" Page
		navigate.back();
		Thread.sleep(3000);

	}

	/**
	 * Test sign-in with invalid data
	 */
	@Parameters({ "deviceName_" })
	@Test(dataProvider = "Authentication", dataProviderClass = DataProviderData.class, retryAnalyzer = RetryingFailedTestCases.class, priority = 3, groups = {
			"Create Account" }, description = "Verify if the user can not sign in with invalid data.")
	public void TC_03( String email, String password) throws InterruptedException {

		Thread.sleep(4000);

//		// back to "Movies" Page
//		Navigation navigate = driver.navigate();
//		navigate.back();
//		Thread.sleep(3000);
//
//		navigate.back();
//		Thread.sleep(3000);

		// Navigate "My account"
		driver.findElement(AppiumBy.id("com.muvi:id/ivHome")).click();
		System.out.println("Finshed: Navigate \"My account\" ");
		Thread.sleep(3000);

		// click on "Sign-in"
		driver.findElement(AppiumBy.id("com.muvi:id/tvSignin")).click();
		System.out.println("Finshed: click on \"Sign-in\" ");
		Thread.sleep(3000);

		// Send Key to "Email"
		driver.findElement(AppiumBy.id("com.muvi:id/tvUsername")).sendKeys(email);
		System.out.println("Finshed: Send Key to \"Email\" is " + email);
		Thread.sleep(3000);

		// Send Key to "Password"
		driver.findElement(AppiumBy.id("com.muvi:id/tvPassword")).sendKeys(password);
		System.out.println("Finshed: Send Key to \"Password\" is " + password);
		Thread.sleep(3000);

		// Click on "Login"
		driver.findElement(AppiumBy.id("com.muvi:id/btLogin")).click();
		System.out.println("Finshed: Click on \"Login\"");
		Thread.sleep(3000);

		if (driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).isDisplayed()) {
			String text = driver.findElement(AppiumBy.id("com.muvi:id/tv_desp")).getText();
			if(text.equals("User does not exist")) {
			Assert.assertEquals("User does not exist", text);
			System.out.println("Finshed: The text message displayied = " + text);
			ExtentTestManager.startTest("TC_03", "Verify if the user can sign in with invalid data.", deviceName_,
					"Create Account").createNode("email = "+email+" & password = "+password,"Display message = "+text);
			Thread.sleep(3000);

			}
			else {
				Assert.assertEquals("The credentials used do not match. Please try again.", text);
				System.out.println("Finshed: The text message displayied = " + text);
				ExtentTestManager.startTest("TC_03", "Verify if the user can sign in with invalid data.", deviceName_,
						"Create Account").createNode("email = "+email+" & password = "+password,"Display message = "+text);
				Thread.sleep(3000);

			}
			// Click "OK"
			driver.findElement(AppiumBy.id("com.muvi:id/btn_ok")).click();
			System.out.println("Finshed: Click \"OK\"");
			Thread.sleep(3000);
		}

	}

	/**
	 * Test sign-in with valid data
	 */
	@Parameters({ "deviceName_" })
	@Test(enabled=false,retryAnalyzer = RetryingFailedTestCases.class, priority = 4, groups = {
			"Create Account" }, description = "Verify if the user can sign in with valid data")
	public void TC_04(String deviceName_) throws InterruptedException {
		ExtentTestManager.startTest("TC_04", "Verify if the user can sign in with valid data", deviceName_,
				"Create Account");
		Thread.sleep(4000);
		
		// Navigate "My account"
		driver.findElement(AppiumBy.id("com.muvi:id/ivHome")).click();
		System.out.println("Finshed: Navigate \"My account\" ");
		Thread.sleep(3000);

		// click on "Sign-in"
		driver.findElement(AppiumBy.id("com.muvi:id/tvSignin")).click();
		System.out.println("Finshed: click on \"Sign-in\" ");
		Thread.sleep(3000);

		// Send Key to "Email"
		WebElement email = driver.findElement(AppiumBy.id("com.muvi:id/tvUsername"));
		email.clear();
		email.sendKeys("ultrapower.team5@gmail.com");
		System.out.println("Finshed: Send Key to \"Email\"");
		Thread.sleep(3000);

		// Send Key to "Password"
		WebElement password = driver.findElement(AppiumBy.id("com.muvi:id/tvPassword"));
		password.clear();
		password.sendKeys("##UltraPOWER5");
		System.out.println("Finshed: Send Key to \"Password\"");
		Thread.sleep(3000);

		// Click on "Login"
		driver.findElement(AppiumBy.id("com.muvi:id/btLogin")).click();
		System.out.println("Finshed: Click on \"Login\"");
		Thread.sleep(3000);

		// Click on "Skip Now"
		driver.findElement(AppiumBy.id("com.muvi:id/btnSkipNow")).click();
		System.out.println("Finshed: Click on \"Skip Now\"");
		Thread.sleep(3000);

	}

}
