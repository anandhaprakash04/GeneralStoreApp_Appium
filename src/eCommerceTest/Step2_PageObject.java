package eCommerceTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Step2_PageObject {
	
	public AndroidDriver<AndroidElement> driver = null;
		
	Step2_PageObject (AndroidDriver<AndroidElement> driver) throws Exception {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void addProductToCart(String productName) throws Exception {

		driver
        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
        + "new UiSelector().text(\""+ productName + "\"));"); 
		
		List<AndroidElement> productNames = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		List<AndroidElement> addToCarts = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
				
		for(int i=0; i< productNames.size();i++) {
			
			if(productNames.get(i).getText().equalsIgnoreCase(productName)) {
				addToCarts.get(i).click();
				break;
			}
		}
		
	}
	
	public void checkOutCart ( ) {
		AndroidElement checkoutCart = driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
		checkoutCart.click();
	}
}
