package seleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.security.Security;
import org.testng.annotations.Test;


public class HandleSSLCertificate {
	private WebDriver driver;

	@Test
	public void loadInsecureWebsite() throws InterruptedException {

		// Launch Browser
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress the Chrome logs on console
																		// before launch

		driver = new ChromeDriver();

		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		// Set certificate
		devTools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com/");

		Thread.sleep(5000);
		// close browser
		driver.quit();
	}// End of method loadInsecureWebsite
} // End of class HandleSSLCertficate