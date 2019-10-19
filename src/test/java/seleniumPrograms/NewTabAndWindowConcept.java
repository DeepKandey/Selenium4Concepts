package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabAndWindowConcept {

	public static void main(String[] args) {
		// Setting driver property
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true"); // To suppress the Chrome logs on console before
																		// before launch

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		WebElement googleSearchTxt = driver.findElement(By.name("q"));
		googleSearchTxt.sendKeys("Hello World");

		// Fetching parent Tab/Window id
		String parent = driver.getWindowHandle();
		System.out.println("Parent tab: " + parent);

		// switching to new Tab/Window
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

		// Fetching child Tab/Window Id
		String child = driver.getWindowHandle();
		System.out.println("child tab: " + child);

		newTab.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.0.0-alpha-3");
		newTab.close();

 		driver.switchTo().window(parent);
		googleSearchTxt.clear();
		googleSearchTxt.sendKeys("hey I am using Selenium4");
		
		driver.close();

	}

}
