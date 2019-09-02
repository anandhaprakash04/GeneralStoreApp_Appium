package eCommerceTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/*
 * Test case#1 : 
 * Fill the form 
 * Move to the next page
 * 
 */

public class Step1_PageObject {
	
	public AndroidDriver<AndroidElement> driver = null;
		
	Step1_PageObject (AndroidDriver<AndroidElement> driver) throws Exception {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	public void fillform() throws Exception {
				
		AndroidElement yourNameElement = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		AndroidElement femaleGenderElement = driver.findElement(By.xpath("//*[@text='Male']"));
		AndroidElement countryDropdown = driver.findElement(By.id("android:id/text1"));
		
		yourNameElement.sendKeys("Anandhaprakash Mani");
		driver.hideKeyboard();
		femaleGenderElement.click();
		countryDropdown.click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");

		AndroidElement indiaDropdown =  driver.findElement(By.xpath("//*[@text='Argentina']"));
		indiaDropdown.click();
		
		AndroidElement letsGoBtn = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		letsGoBtn.click();
	
	}
	
	public void getToastMessage() throws Exception {
		
		AndroidElement femaleGenderElement = driver.findElement(By.xpath("//*[@text='Female']"));
		AndroidElement countryDropdown = driver.findElement(By.id("android:id/text1"));
		
		femaleGenderElement.click();
		countryDropdown.click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))");

		AndroidElement indiaDropdown =  driver.findElement(By.xpath("//*[@text='Austria']"));
		indiaDropdown.click();
		
		AndroidElement letsGoBtn = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		letsGoBtn.click();
		
		AndroidElement toastErrormessage = driver.findElementByXPath("//android.widget.Toast[1]");
		String actualErrorMessage = toastErrormessage.getAttribute("name");
		System.out.println("Actual Error message: " + actualErrorMessage);
	
	}


}
