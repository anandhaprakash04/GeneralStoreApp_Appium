package eCommerceTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Step4_WebView_PageObject {
	
	public AndroidDriver<AndroidElement> driver = null;
	public WebDriverWait wait = null;

		
	Step4_WebView_PageObject (AndroidDriver<AndroidElement> driver) throws Exception {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, 20);
	}
	


	public void search(String text) throws Exception {
		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
//		WebElement googleSearch = driver.findElement(By.name("btnK"));
//		googleSearch.click();
	}
	
}
