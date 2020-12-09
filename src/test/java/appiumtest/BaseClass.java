package appiumtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObject.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	public static AppiumDriverLocalService service;
	
	public void startServer()
	{
		
		service = AppiumDriverLocalService.buildDefaultService();
		
		service.start();
				
	}

	public AndroidDriver<AndroidElement> Capabilities(String apkFile) throws InterruptedException, IOException {
		
		
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties Prop= new Properties();
		
		Prop.load(Fis);
		
		Prop.get(apkFile);
		
		AndroidDriver<AndroidElement> driver;
				
		DesiredCapabilities cap = new DesiredCapabilities();
				
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		cap.setCapability("takesScreenshot", true);
		
		File app = new File("src");
	 	File appdir = new File(app,(String) Prop.get(apkFile));
	 	
	 	String DeviceName = (String) Prop.get("DEVICE_NAME");
	 	
	 	String AutomationName = (String) Prop.get("AUTOMATION_NAME");
	 	
	 	String Udid = (String) Prop.get("UDID");
	 	
	 	String PlatformName = (String) Prop.get("PLATFORM_NAME");
	 	
	 	String PlatformVersion = (String) Prop.get("PLATFORM_VERSION");
	 	
	 	String url = (String) Prop.get("URL");
	 	
	 	
		//Set device capabilities
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName);
		cap.setCapability(MobileCapabilityType.UDID, Udid );
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PlatformVersion);
		cap.setCapability(MobileCapabilityType.APP, appdir.getAbsolutePath());
		
		
		driver = new AndroidDriver<AndroidElement>(new URL(url),cap);
		return driver;
		
	
		
		
		}
		
	
	

	}


