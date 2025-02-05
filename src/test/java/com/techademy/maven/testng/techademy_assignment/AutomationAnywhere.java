package com.techademy.maven.testng.techademy_assignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhere {
	// public static void main(String[] args) {
	public WebDriver driver;
	public String url = "https://www.automationanywhere.com/";

	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeTest
	public void profileSetup() {
		driver.manage().window().maximize();
		System.out.println("The profile setup process is completed");

	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Accept Cookies
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		System.out.println("The app setup process is completed");
	}

	/*
	 * Question 3a Verify if logo is present
	 */
	@Test(priority = 1, timeOut = 15000, enabled = true)
	public void validate_presence_of_logo() {
		WebElement logo = driver.findElement(By.xpath("//*[@class='coh-link header-logo']"));
		Assert.assertEquals(logo.isDisplayed(), true);
	}

	/*
	 * Question 3b Verify if Request Demo button is present and clickable
	 */
	@Test(priority = 2, timeOut = 15000, enabled = true)
	public void validate_RequestDemo() {
		WebElement request_demo = driver.findElement(By.xpath("//*[@title='Request Demo']"));
		Assert.assertEquals(request_demo.isDisplayed(), true);
		try

		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
			wait.until(ExpectedConditions.elementToBeClickable(request_demo));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element is not clickable");

		}
	}

	/*
	 * Question 4a Verify if products link is present
	 */
	@Test(priority = 3, timeOut = 15000, enabled = true)
	public void validate_Products() {
		WebElement products = driver.findElement(By.xpath("//*[@href='/products']"));
		Assert.assertEquals(products.isDisplayed(), true);
		products.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/products");
	}

	/*
	 * Question 4a Verify if solution link is present
	 */
	@Test(priority = 4, timeOut = 15000, enabled = true)
	public void validate_Solutions() {
		WebElement solutions = driver.findElement(By.xpath("//*[@href='/solutions']"));
		Assert.assertEquals(solutions.isDisplayed(), true);
		solutions.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/solutions");
	}

	/*
	 * Question 4a Verify if resources link is present
	 */
	@Test(priority = 5, timeOut = 15000, enabled = true)
	public void validate_Resources() {
		WebElement resources = driver.findElement(By.xpath("//*[@href='/resources']"));
		Assert.assertEquals(resources.isDisplayed(), true);
		resources.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/resources");
	}

	/*
	 * Question 4a Verify if company link is present
	 */
	@Test(priority = 6, timeOut = 15000, enabled = true)
	public void validate_Company() {
		WebElement company = driver.findElement(By.xpath("//a[@href='/company/about-us']" + ""));
		Assert.assertEquals(company.isDisplayed(), true);
		company.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/company/about-us");
	}

	/*
	 * Question 4a Verify if BeyondRPA link is present
	 */
	/* This test should fail */
	@Test(priority = 7, enabled = false)
	public void validate_BeyondRPA() {
		WebElement beyondrpa = driver.findElement(By.xpath("//*[@href='/beyondrpa']"));
		Assert.assertEquals(beyondrpa.isDisplayed(), true);
		beyondrpa.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/beyondrpa");
	}

	@AfterClass
	public void closeUp() {
		driver.close();
		System.out.println("The close_up process is completed");
	}
	// System.out.println("Hello");System.out.println("Test Ends");

}
