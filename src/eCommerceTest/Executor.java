package eCommerceTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Executor extends Base{
	
	public static AndroidDriver<AndroidElement> driver = null;

		public static void main(String[] args) throws Exception {

			driver = setup();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Step1_PageObject step1 = new Step1_PageObject(driver);
			step1.fillform();
			
			Step2_PageObject step2 = new Step2_PageObject(driver);
			step2.addProductToCart("Air Jordan 4 Retro");
			step2.addProductToCart("Converse All Star");
			step2.checkOutCart();
			
			Step3_PageObject step3 = new Step3_PageObject(driver);
			System.out.println("Total price of all products: " + step3.getSumAmountofAllProducts());
			System.out.println("Total purchase amount: " + step3.getTotalPurchaseAmount());
			
			step3.checkDiscountEmails();
//			step3.pressOnTerms();
//			step3.closeTermsPopUp();
			step3.clickOnVisitWebsite();
			
			Thread.sleep(7000);
			
			Step4_WebView_PageObject step4 = new Step4_WebView_PageObject(driver);
			switchToWebViewContext("WEBVIEW");
			step4.search("AnandhaPrakash Mani");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			switchToWebViewContext("NATIVE");
			
			step1.fillform();
			
			
		}
		
		public static void switchToWebViewContext(String requiredConetext) {
			Set<String> contexts = driver.getContextHandles();
			for (String context : contexts) 
			{ 
			    System.out.println("Context: " + context);
			    if(context.contains(requiredConetext)) {
			    	driver.context(context);
			    	break;
			    }
			}		
		}

}
