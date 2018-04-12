package Automation.Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverBase {
	protected static AndroidDriver driver;
	protected WebDriverWait wait;
	protected static Dimension size;
		
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException  {
		final File classpathRoot = new File(System.getProperty("user.dir"));
	    final File appDir = new File(classpathRoot, "src/test/java/Automation/Automation");
	    final File app = new File(appDir, "ovo.apk");
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "");
	    caps.setCapability("platformName", "ANDROID");
	    caps.setCapability("platformVersion", "7.1.1");
	    caps.setCapability("deviceName", "ZY322DZ6ZZ");
	    //caps.setCapability("app", app.getAbsolutePath());
	    //caps.setCapability("noReset","true");
	    //caps.setCapability("fullReset","false");
	    caps.setCapability("appPackage", "ovo.id");
	    caps.setCapability("appActivity", "ovo.id.loyalty.activity.LandingActivity");
	    caps.setCapability("autoGrantPermissions", true);
	 
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	}
	
	@AfterMethod
	public void afterMethdod() {
		driver.quit();		
	}		
}
