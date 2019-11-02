package seleniumPrograms;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorConcept {

	public static void main(String[] args) {
		// Setting driver executable system property
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?gws_rd=ssl");
		
		

		// List of Elements using Relative Locator
		List<WebElement> languageList = driver.findElements(withTagName("a").above(By.className("Q8LRLc")).below(By.name("btnK")));

		for (WebElement language : languageList) {
			System.out.println("Language tanslation: " + language.getText());
		}

		// Entering text in search box
		driver.findElement(By.name("q")).sendKeys("Relative locator concept in Selenium 4");
		// Click on Google Search using Relative locator
		driver.findElement(withTagName("input").below(By.name("q")).toRightOf(By.name("btnI"))).click();

		driver.quit();
	}
}