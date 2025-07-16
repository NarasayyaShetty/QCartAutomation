package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static Utilities.DriverSingleTon.*;

public class BaseClass {
	WebDriver driver;
	@Parameters({"browserName"})
	@BeforeTest(alwaysRun=true)
	public void setUp(String browserName) {
		driver=driverInIt(browserName);
		launchUrl("https://crio-qkart-frontend-qa.vercel.app/");
	}

}
