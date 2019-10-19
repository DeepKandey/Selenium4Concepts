package seleniumPrograms;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeElementScreenshotConcept {

	public static void main(String[] args) throws IOException {

		// Setting driver executable system property
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
		// To suppress the Chrome logs on console before launch
		System.setProperty("webdriver.chrome.silentOutput", "true");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		WebElement emailTxt = driver.findElement(By.id("identifierId"));

		WebElement nextBtn = driver.findElement(By.xpath("//span[@class='CwaK9']//span"));

		takeElementScreenshot(emailTxt, "emailTxtElement");
		takeElementScreenshot(nextBtn, "nextBtnElement");

		driver.close();
	}

	private static void takeElementScreenshot(WebElement element, String fileName) throws IOException {
		// Taking WebElement screenshot
		File srcFile = element.getScreenshotAs(OutputType.FILE);

		// Copying at destination file
		FileHandler.copy(srcFile, new File("./screenshots/" + fileName + ".png"));

	}
}