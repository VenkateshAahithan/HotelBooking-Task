package com.HotelBooking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_Task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		//Login
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("venkateshsel99@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Selva@kamali1");
		driver.findElement(By.xpath("//button[@value='login']")).click();
		
		//Frame
				driver.switchTo().frame("hotelsearch_iframe");
				WebElement search = driver.findElement(By.xpath("//button[@class='btn filter_btn']"));
				search.click();
				driver.switchTo().parentFrame();

		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-state']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-city']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-check_in']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-check_out']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-no_rooms']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='invalid-no_adults']")).getText());
		
}}
