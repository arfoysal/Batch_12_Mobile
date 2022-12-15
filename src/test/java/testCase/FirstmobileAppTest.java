package testCase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstmobileAppTest {

	@Test
	public void appTest() throws MalformedURLException, InterruptedException {
		File f = new File("src");
		File fs =  new File(f,"General-Store.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:udid", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appium:appPackage", "com.androidsample.generalstore");
		cap.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1'][3]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhaka");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
		
		driver.quit();
		
		

	}

}
