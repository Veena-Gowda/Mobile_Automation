

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver<AndroidElement> Capabilities(String apkFile) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<AndroidElement> driver;
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		cap.setCapability("takesScreenshot", true);
		
		File app = new File("/MobileAutomation/src/test/java/");
	 	File appdir = new File(app,apkFile);
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 5T");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.UDID, "1ce52ad7");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.1");
		cap.setCapability(MobileCapabilityType.APP, appdir);
		//cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\shrey\\Downloads\\Veena_docs\\eclipse-workspace\\appiumtest\\src\\test\\java\\Amazon_shopping.apk");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		}
		
	
	

	}


