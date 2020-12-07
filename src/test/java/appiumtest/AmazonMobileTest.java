package appiumtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddToCartPage;
import PageObject.BuyingOptionPage;
import PageObject.LoginPage;
import PageObject.ProceedToCheckoutPage;
import PageObject.SearchItemPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AmazonMobileTest extends BaseClass {
	
	@Test
	public void FirstTestCase() throws InterruptedException, IOException {
		
		
		//Given apk file is not eBay, its amazon shopping apk so the script created using Amazon Shopping apk file.
		// Start the Appium Server
		startServer();
		
		AndroidDriver<AndroidElement> driver =  Capabilities("AmazonApkFile");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			System.out.println("Application Started");
			
			LoginPage Login = new LoginPage(driver);
			SearchItemPage SearchItem = new SearchItemPage(driver);
			BuyingOptionPage BuyOptions =new BuyingOptionPage(driver);
			AddToCartPage AddToCart = new AddToCartPage(driver);
			ProceedToCheckoutPage ProceedToCheckOut = new ProceedToCheckoutPage(driver);
			
			//To import data from external resource
			FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
			Properties Prop= new Properties();
			
			Prop.load(Fis);
			
			
			String Email = (String) Prop.get("Email");
			String Password = (String) Prop.get("Password");
			
			//String url = (String) Prop.get("Email");			
			//To click on Sign in
			
			Login.AlreadySignIn.click();
			
			
			Thread.sleep(3000);
			
			
			//Enter Email Address
			
			
			Login.EmailAddress.sendKeys(Email);
			
			
			Thread.sleep(3000);
			//Click on Continue
			
			Login.Continue.click();
			Thread.sleep(3000);
			
			//Enter Password
			
			Login.Password.sendKeys(Password);
			Thread.sleep(3000);
			
			//Click On Signin button
			
			Login.SignIn.click();
			
			Thread.sleep(3000);
			//Search for 65-Inch TV
			
			SearchItem.SearchNewItem.click();
			
			
			SearchItem.Search.sendKeys("65 Inch TV");
			//driver.findElement(By.xpath("//*[@resource-id = 'com.amazon.mShop.android.shopping:id/rs_search_src_text']")).sendKeys(Keys.ENTER);
			
			Thread.sleep(5000);
			//Click on 65 inch TV
			SearchItem.ClickEOnlement.click();
			
						
			String Actual_description = SearchItem.SelectItem.getText();
			
			SearchItem.SelectItem.click();
						
			Thread.sleep(3000);
			//Click on All buy options
			
			BuyOptions.BuyAllOptions.click();
			
			Thread.sleep(3000);
			//Click on Add to Cart
			String Actual_Price = AddToCart.Price.getText();
			
			AddToCart.AddToCart.get(0).click();
			
			//Click on Cart Icon
			
			AddToCart.ClickBasket.click();
			
			
			//Add Assertion here to verify price & description
			
			Thread.sleep(3000);
						
			String Expected_Description = ProceedToCheckOut.Description.getText();
			
					
			String Expected_Price = ProceedToCheckOut.Price.getText();
			
			Assert.assertEquals(Actual_description, Expected_Description);
			
			Assert.assertEquals(Actual_Price, Expected_Price);
			
			//Click on Proceed to Checkout
			
			ProceedToCheckOut.ProceedToCheckout.click();
	}



	
}
