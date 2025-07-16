package Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseClass{
	
	@Test
	public void testCase01() {
		
		//Click on privacy policy and switch to privacy policy window and verify url and text
		WebElement privacyPolicy=driver.findElement(By.partialLinkText("Privacy policy"));
		privacyPolicy.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Set<String> set=driver.getWindowHandles();
		List<String> list=new ArrayList<>(set);
		System.out.println(list.size());
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		driver.switchTo().window(list.get(1));
		wait.until(ExpectedConditions.urlContains("privacy-policy"));
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current url is"+currentUrl);
		Assert.assertTrue(currentUrl.contains("/privacy-policy") ,"Privacy policy URL not matched");
		WebElement privacyText=wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
		System.out.println(privacyText.getText());
		Assert.assertEquals(privacyText.getText(),"Privacy Policy", "Text is not matched");
		
		
		
	}

}
