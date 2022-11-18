import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubTestNG {

	public WebDriver driver1;

	public String email = "batoolalshareef@gmail.com";
	public String password = "Bs23051982**";

	@BeforeTest

	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://github.com/login");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys(email);
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
	}

	@Test(priority = 1)
	public void test_The_Title() {
		String actualTitleName = driver1.getTitle();
		String expectedTitleName = "GitHub";
//		System.out.println("The Title of WebSeite is: " + actualTitleName);
		Assert.assertEquals(actualTitleName, expectedTitleName);
	}

//	@Test(priority = 2)
//	public void test_The_Profile_Name() throws InterruptedException {
//		String actualProfileName = "batoolshareef";
//		Thread.sleep(1000);
//		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
//		Thread.sleep(1000);
//
//		String expextedProfileName = driver1
//				.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a/strong"))
//				.getText();
////	System.out.println(expextedProfileName);
//
//		Assert.assertEquals(actualProfileName, expextedProfileName);
//	}

//	@Test(priority = 3)
//
//	public void test_Create_New_Repostory() throws InterruptedException {
//		driver1.navigate().refresh();
//		Thread.sleep(3000);
//		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
//		Thread.sleep(3000);
//		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/a[2]")).click();
//		Thread.sleep(3000);
//		driver1.findElement(By.xpath("//*[@id=\"user-profile-frame\"]/div/div[1]/div/div/a")).click();
//		Thread.sleep(3000);
//		driver1.findElement(By.xpath("//*[@id=\"repository_name\"]")).sendKeys("GitHubTesNG");
//		Thread.sleep(3000);
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver1;
//		js.executeScript("window.scrollBy(0,450)");
//		driver1.findElement(By.xpath("//*[@id=\"new_repository\"]/div[5]/button")).click();
//		Thread.sleep(3000);
//		driver1.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[1]/div[1]/div[1]/h3/a")).click();
//		Thread.sleep(3000);
//				
//	}

	@Test(priority = 4)
	public void test_Repostory_Existance() throws InterruptedException {
		driver1.navigate().refresh();
		Thread.sleep(3000);
		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
		Thread.sleep(3000);
		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/a[2]")).click();
		Thread.sleep(3000);

		String actualRepostory =driver1.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[1]/div[1]/div[1]/h3/a")).getText();
//System.out.println(actualRepostory);
		String expextedRepostory = "GitHubTesNG";
		
		Assert.assertEquals(actualRepostory, expextedRepostory);
		}

	
	
//	@Test(priority = 5)
//	public void test_The_Log_Out() throws InterruptedException {
//		driver1.navigate().refresh();
//
//		Thread.sleep(3000);
//		String actualUrl = driver1.getCurrentUrl();
//		String expectedUrl = "https://github.com/";
//		Thread.sleep(1000);
//		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
//		Thread.sleep(1000);
//		driver1.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button")).click();
//
//		System.out.println("The actual url after logout is: " + actualUrl);
//
//		Assert.assertEquals(actualUrl, expectedUrl);
//	}

}