package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	public WebElement AlreadySignIn;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement EmailAddress;
	
	@AndroidFindBy(xpath="//*[@text='Continue']")
	public WebElement Continue;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement Password;
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement SignIn;
	
	
	

}
