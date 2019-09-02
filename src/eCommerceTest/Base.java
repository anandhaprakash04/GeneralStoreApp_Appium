package eCommerceTest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> setup() throws Exception {
		File path = new File("src");
		File appPath = new File(path, "General-Store.apk");
		System.out.println("Working appPath = " + appPath.getAbsolutePath());
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel3xl");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		capability.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				(new URL("http://127.0.0.1:4723/wd/hub/")), capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
