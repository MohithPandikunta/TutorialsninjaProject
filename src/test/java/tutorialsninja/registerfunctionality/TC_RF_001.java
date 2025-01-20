package tutorialsninja.registerfunctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
	@Test

	public void VerifyRegisteringWithMandatoryField() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Pandi");
		driver.findElement(By.id("input-lastname")).sendKeys("Mohit");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("M0987");
		driver.findElement(By.id("input-confirm")).sendKeys("M0987");	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(), expectedHeading);
	
		String actualproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualproperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualproperDetailsFour = "contact us."; 
		
		String expectedProperDetail = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedProperDetail.contains(actualproperDetailsOne));
		Assert.assertTrue(expectedProperDetail.contains(actualproperDetailsTwo));
		Assert.assertTrue(expectedProperDetail.contains(actualproperDetailsThree));
		Assert.assertTrue(expectedProperDetail.contains(actualproperDetailsFour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	
	public static String generateNewEmail() {
	return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	}
}
