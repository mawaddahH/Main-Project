/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import static java.util.Arrays.asList;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseConnection {
	public AndroidDriver driver;
	public  DesiredCapabilities desiredCapabilities;
	public  URL remoteUrl;
	public  String deviceName_;
	public  String platform_;
	public  String port_;
	
	@Parameters({ "deviceName_","platform_", "port_"})
	@BeforeMethod
	public void setUp(String deviceName_, String platform_, String port_,Method method) throws Exception {
		if(method.getName().equals("TC_02")) {
			System.out.println("Finshed: DO NOT NEED TO RUN BEFOREMETHOD");
		}
		else {
		this.deviceName_ =deviceName_;
		this.platform_=platform_;
		this.port_=port_;

		// Setting up desire caps using DesireCapabilities class
		// Create an object for Desired Capabilities
		desiredCapabilities = new DesiredCapabilities();

		// Set capabilities
		desiredCapabilities.setCapability("appium:app",
				"C:\\Users\\lo0ol\\Downloads\\muvi Cinemas-com.muvi-3.1.8-3109.apk");
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceName_);	
		desiredCapabilities.setCapability("appium:platformVersion", platform_);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appium:skipDeviceInitialization", true);

		 
		
		// Java package of the Android app you want to run
		desiredCapabilities.setCapability("appium:appPackage", "com.muvi");
		// Activity name for the Android activity you want to launch from your package
		desiredCapabilities.setCapability("appium:appActivity", "com.muvi.ui.splash.SplashScreen");
		Thread.sleep(2000);

		System.out.println("Finshed: desiredCapabilities for "+ deviceName_);

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		remoteUrl = new URL("http://127.0.0.1:"+port_+"/wd/hub");//
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		System.out.println("Finshed: driver for "+ deviceName_);

		setDriver(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		Thread.sleep(20000);

		
		//--------------
		if(driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).isDisplayed()) {
			driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
			System.out.println("Finshed: Allow only while using the app 1");
			Thread.sleep(2000);
		}
		else {
			System.out.println("Finshed: NOT FOUND Allow only while using the app");

		}


		// click on "English" text
		driver.findElement(AppiumBy.id("com.muvi:id/rdoEnglish")).click();
		System.out.println("Finshed: English");
		Thread.sleep(2000);

		// click on "Riyadh - الرياض"
		driver.findElement(AppiumBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[8]"))
				.click();
		System.out.println("Finshed: Riyadh - الرياض");
		Thread.sleep(2000);

		// click on "Continue" text
		driver.findElement(AppiumBy.id("com.muvi:id/btnCont")).click();
		System.out.println("Finshed: Continue");
		Thread.sleep(50000);

		// click on "TIP close_icon" text
		driver.findElement(AppiumBy.id("com.muvi:id/close_icon")).click();
		System.out.println("Finshed: TIP close_icon");
		Thread.sleep(4000);

		// click on "Allow only while using the app" text
		driver.findElement(AppiumBy.id("com.muvi:id/close_icon")).click();
		System.out.println("Finshed: TIP close_icon");
		Thread.sleep(4000);
	}
	}

	@AfterSuite
	public void close() throws MalformedURLException, InterruptedException {

		driver.quit();
		System.out.println("Finshed: quit driver");

	}

	public void horizonalScroll(int centerY, double startX, double endX) {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}

	public void horizonalScroll() {

		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int centerY = (int) (height / 2);
		double startX = (int) (width * 0.9);
		double endX = (int) (width * 0.1);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}



	public void verticalScroll() {

		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int centerX = (int) (width / 2);
		double startY = (int) (height * 0.6);
		double endY = (int) (height * 0.1);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int) endY));
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}

	public  AndroidDriver getDriver() {
		return driver;
	}

	public  void setDriver(AndroidDriver driver) {
		this.driver = driver;
	}

	public void attemptPinchToZoomOut() {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

		Dimension size = driver.manage().window().getSize();
		Point source = new Point(size.getWidth(), size.getHeight());

		Sequence pinchAndZoom1 = new Sequence(finger, 0);
		pinchAndZoom1
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x / 4,
						(int) (source.y / 2.2)))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(110)))
				.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
						source.x / 3, (int) (source.y / 1.5)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		Sequence pinchAndZoom2 = new Sequence(finger2, 0);
		pinchAndZoom2
				.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
						source.x * 4 / 5, (int) (source.y / 2.2)))
				.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(100)))
				.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
						source.x / 3, (int) (source.y / 1.5)))
				.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		((AppiumDriver) driver).perform(asList(pinchAndZoom1, pinchAndZoom2));
	}
	
	public void verticalScroll(int centerX, double startY, double endY) {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int) endY));
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}
	

	public void attemptPinchToZoomIn() {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

		Dimension size = driver.manage().window().getSize();
		Point source = new Point(size.getWidth(), size.getHeight());

		Sequence pinchAndZoom1 = new Sequence(finger, 0);
		pinchAndZoom1
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x / 2,
						source.y / 2))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(110)))
				.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
						source.x / 3, source.y / 3))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		Sequence pinchAndZoom2 = new Sequence(finger2, 0);
		pinchAndZoom2
				.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x / 2,
						source.y / 2))
				.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
						source.x * 3 / 4, source.y * 3 / 4))
				.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		((AppiumDriver) driver).perform(asList(pinchAndZoom1, pinchAndZoom2));
	}

}

