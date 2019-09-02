package eCommerceTest;

import static java.time.Duration.ofSeconds;

import java.util.List;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Step3_PageObject {
	
	public AndroidDriver<AndroidElement> driver = null;
	public WebDriverWait wait = null;
	public TouchAction touch = null;
		
	Step3_PageObject (AndroidDriver<AndroidElement> driver) throws Exception {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, 10);
		this.touch = new TouchAction(driver);
	}

	public double getSumAmountofAllProducts() throws Exception {

//		Thread.sleep(2000);
		AndroidElement totalPurchaseLabel = driver.findElement(By.xpath("//*[@text='Total Purchase Amount:  ']"));
		wait.until(ExpectedConditions.visibilityOf(totalPurchaseLabel));
		
		List<AndroidElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		double sum =0;
		for(int i=0; i< prices.size();i++) {
			sum = sum + Double.parseDouble(prices.get(i).getText().replaceAll("[^\\d.]", ""));
		}
		return sum;
	}
	
	public double getTotalPurchaseAmount() throws Exception {

		AndroidElement purchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		return Double.parseDouble(purchaseAmount.getText().replaceAll("[^\\d.]", ""));
		
	}
	
	public void checkDiscountEmails() {
		MobileElement chkEmail = driver.findElement(By.className("android.widget.CheckBox"));
		touch.tap(tapOptions().withElement(element(chkEmail))).perform();
	}
	
	public void pressOnTerms() {
		MobileElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		touch.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
	}
	
	public void closeTermsPopUp() {
		MobileElement closePopup = driver.findElement(By.id("android:id/button1"));
		touch.tap(tapOptions().withElement(element(closePopup))).perform();		
	}
	
	public void clickOnVisitWebsite() {
		
		MobileElement visitWebSite = driver.findElementById("com.androidsample.generalstore:id/btnProceed");
		touch.tap(tapOptions().withElement(element(visitWebSite))).perform();
		
	}
}
