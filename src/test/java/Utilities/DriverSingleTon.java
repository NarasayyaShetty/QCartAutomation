package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverSingleTon {
	private static WebDriver driver=null;
	
	private DriverSingleTon() {}
	
	public static WebDriver driverInIt(String browserName) {
		if(driver==null) {
			switch(browserName) {
			case "chrome" :
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--incognito");
				option.addArguments("--start-maximized");
			//	option.addArguments("--headless");
				driver=new ChromeDriver(option);
				break;
			case "fireFox":
				
				
				
				FirefoxOptions option1=new FirefoxOptions();
			//	option1.addArguments("-private");
			//	option1.addArguments("--headless");
				driver=new FirefoxDriver(option1);
				break;
			default:
				throw new RuntimeException("Please enter proper browser Name");
			}
			
		}
		//driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}

}
