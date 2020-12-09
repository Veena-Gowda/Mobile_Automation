package appiumtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.AddToCartPage;
import PageObject.BuyingOptionPage;

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
		
			
			
			SearchItemPage SearchItem = new SearchItemPage(driver);
			BuyingOptionPage BuyOptions =new BuyingOptionPage(driver);
			AddToCartPage AddToCart = new AddToCartPage(driver);
			ProceedToCheckoutPage ProceedToCheckOut = new ProceedToCheckoutPage(driver);
			Utilities utility=new Utilities(driver);
			
			//Import data from external resource(globalpropeties file)
			FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
			Properties Prop= new Properties();
			
			Prop.load(Fis);
			
			//To click on Sign in
		
			//Login Functionality derived in Utilities
			utility.Login();
			
			String searchforitem = (String) Prop.get("SearchItem");
			
			//Search for 65-Inch TV
			
			SearchItem.SearchNewItem.click();
			
			
			SearchItem.Search.sendKeys(searchforitem);
			//driver.findElement(By.xpath("//*[@resource-id = 'com.amazon.mShop.android.shopping:id/rs_search_src_text']")).sendKeys(Keys.ENTER);
			
			
			//Timeout Exception handling
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				//Click on 65 inch TV
				
				SearchItem.ClickEOnlement.click();
			} catch (TimeoutException e) {
				System.out.println("WebDriver couldn’t locate the frame");
				}
					
			String Actual_description = SearchItem.SelectItem.getText();
			
			SearchItem.SelectItem.click();
						

			//Click on All buy options
			
			//Exception Handling if the element is not found
			try {
				BuyOptions.BuyAllOptions.click();
				}
			catch (NoSuchElementException e)
			{
				System.out.println("WebDriver couldn’t locate the element");
				}
			
			
			//Click on Add to Cart
			String Actual_Price = AddToCart.Price.getText();
			
			AddToCart.AddToCart.get(0).click();
			
			//Click on Cart Icon
			
			AddToCart.ClickBasket.click();
			
			
			//Add Assertion here to verify price & description
					
			String Expected_Description = ProceedToCheckOut.Description.getText();
			
					
			String Expected_Price = ProceedToCheckOut.Price.getText();
			
			Assert.assertEquals(Actual_description, Expected_Description);
			
			Assert.assertEquals(Actual_Price, Expected_Price);
			
			//Click on Proceed to Checkout
			
			ProceedToCheckOut.ProceedToCheckout.click();
			service.stop();
	}

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	// to kill all nodes
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	
	
}
