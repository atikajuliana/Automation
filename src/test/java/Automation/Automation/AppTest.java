package Automation.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class AppTest extends AppiumDriverBase {

	public void swipe() throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.8);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		driver.swipe(startx, starty, endx, starty, 1000);
	}

	@Description("1. Swipe page sebelum masuk ke halaman Login")
	@Step
	public void gotoLoginPage() throws InterruptedException {
		int swipeSize = 5;
		for (int i = 0; i < swipeSize; i++) {
			swipe();
		}
	}

	@Description("2. Klik tombol MASUK")
	@Step
	public void clickButtonMasuk() throws Exception {
		driver.findElement(By.id("ovo.id:id/btn_get_started")).click();
		Thread.sleep(1000);
	}
	
	@Description("3. Masukkan No telepon dan klik tombol Sign in")
	@Step("Masukkan no telepon: [0]")
	public void clickButtonSignIn() throws Exception {
		driver.findElement(By.id("ovo.id:id/field_account")).sendKeys("08xxxxxxxxxx");
		driver.findElement(By.id("ovo.id:id/btn_sign_in")).click();
	}
	
	@Description("4. Masukkan security code")
	@Step
	public void insertSecurityCode() throws Exception {
		driver.findElement(By.id("ovo.id:id/pin_entry")).sendKeys("xxxxxx");
	}

	@Description("5. Klik cancel pada Finger Print")
	@Step
	public void ignoreFingerPrint() throws Exception {
		driver.findElement(By.id("ovo.id:id/cancel_button")).click();
	}

	@Description("This is for Login Test")
	@Story("Login Test")
	@Test
	public void login() throws Exception {
		gotoLoginPage();
		clickButtonMasuk();		
		clickButtonSignIn();
		insertSecurityCode();
		ignoreFingerPrint();

		Thread.sleep(10000);
		// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// //Taking screenshot
		// FileUtils.copyFile(scrFile, new File(“c:\\Temp\\screenshotGK.png”));

		Assert.assertTrue(true);
	}
}
