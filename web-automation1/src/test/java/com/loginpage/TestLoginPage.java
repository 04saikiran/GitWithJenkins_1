package com.loginpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLoginPage {

	public WebDriver driver;
	public String verificationError = "";
	public String url = "";

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\PracticeSelenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/";
		// Test commit //
	}

	@Test
	public void loginPage() {
		try {
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("trainer.saikiran@gmail.com");
			driver.findElement(By.id("enterimg")).click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			verificationError = e.getMessage();
			System.out.println(verificationError);
		}
	}

	@AfterMethod
	public void tierDown() {
		driver.quit();
		String catchError = "";
		if (!catchError.equals(verificationError))
			Assert.fail();
	}
}
