package appiumtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import PageObject.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities extends BaseClass {
	
	AndroidDriver<AndroidElement> driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	
	
	public void Login() throws InterruptedException, IOException
	{
		

		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties Prop= new Properties();
		
		Prop.load(Fis);
		
		String Email = (String) Prop.get("Email");
		String Password = (String) Prop.get("Password");
		//To click on Sign in
		LoginPage Login = new LoginPage(driver);
		Login.AlreadySignIn.click();
		//Enter Email Address
		
		
		Login.EmailAddress.sendKeys(Email);
		
		//Click on Continue
		
		Login.Continue.click();
		
		
		//Enter Password
		
		Login.Password.sendKeys(Password);
		
		
		//Click On Signin button
		
		Login.SignIn.click();
		
	}
	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
}
