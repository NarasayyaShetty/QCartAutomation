package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Practice {
	@Test
	public void setUp() {
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		WebDriver driver=new FirefoxDriver(options);
	}

}
