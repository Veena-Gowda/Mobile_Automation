package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchItemPage {

	public SearchItemPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	

	@AndroidFindBy(xpath="//*[@text='What are you looking for?']")
	public WebElement SearchNewItem;
	
	@AndroidFindBy(xpath="//*[@text='Search']")
	public WebElement Search;
	
	@AndroidFindBy(xpath="//*[@text='Sony 65 inches Smart Sony 65\" X7000G 4K Smart TV (2019)']")
	public WebElement SelectItem;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement ClickEOnlement;
	

	
	

}
