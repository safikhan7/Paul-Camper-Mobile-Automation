package paul_Camper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Paul_Camper_Automation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		dc.setCapability(CapabilityType.PLATFORM_NAME, "Android");

		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

		dc.setCapability("chromeOptions",ImmutableMap.of("w3c",false));


		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,dc);
		Thread.sleep(5000);

		driver.get(" https://paulcamper.com/rent-camper/");

		driver.findElement(By.xpath("//button[@id = 'onetrust-reject-all-handler' and text()='Only necessary']")).click();
		
		WebElement rentCamperLabel = driver.findElement(By.xpath("//h1[@class='searchRowMobileLabelText']"));

		String rentCamperText = rentCamperLabel.getText();

		String expectedRentLabelText = "Rent a campervan near you:";

		Assert.assertEquals(rentCamperText,expectedRentLabelText,"This is expected page to open");
		
		driver.quit();
		

	}

}

