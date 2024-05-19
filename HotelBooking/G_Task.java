package com.HotelBooking;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class G_Task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		//Login
				driver.get("https://www.omrbranch.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("email")).sendKeys("venkateshsel99@gmail.com");
				driver.findElement(By.id("pass")).sendKeys("Selva@kamali1");
				driver.findElement(By.xpath("//button[@value='login']")).click();
				
				//Print Welcome UserName
				WebElement gt = driver.findElement(By.xpath("//a[@data-testid='username']"));
				String tt = gt.getText();
				System.out.println(tt);
				
				//Print Explore Hotel
				WebElement gettext = driver.findElement(By.xpath("//h5[text()='Explore Hotels']"));
				String text = gettext.getText();
				System.out.println(text);
				
				//Search Hotel
				WebElement State = driver.findElement(By.xpath("//select[@id='state']"));
				Select selectState=new Select(State);
				selectState.selectByValue("Tamil Nadu");
				driver.findElement(By.xpath("//span[text()='Select City *']")).click();
				WebElement Madurai = driver.findElement(By.xpath("//li[text()='Madurai']"));
				Madurai.click();
				driver.findElement(By.xpath("//textarea[@type='search']")).click();
				driver.findElement(By.xpath("//li[text()='Standard']")).click();
				driver.findElement(By.xpath("//textarea[@type='search']")).click();
				driver.findElement(By.xpath("//li[text()='Deluxe']")).click();
				driver.findElement(By.xpath("//textarea[@type='search']")).click();
				driver.findElement(By.xpath("//li[text()='Suite']")).click();
				driver.findElement(By.xpath("//textarea[@type='search']")).click();
				driver.findElement(By.xpath("//li[text()='Luxury']")).click();
				driver.findElement(By.xpath("//textarea[@type='search']")).click();
				driver.findElement(By.xpath("//li[text()='Studio']")).click();
				driver.findElement(By.xpath("//input[@name='check_in']")).click();
				driver.findElement(By.xpath("//a[text()='19']")).click();
				driver.findElement(By.xpath("//input[@name='check_out']")).click();
				driver.findElement(By.xpath("//a[text()='22']")).click();
				WebElement rooms = driver.findElement(By.xpath("//select[@id='no_rooms']"));
				Select selectrooms=new Select(rooms);
				selectrooms.selectByValue("3");
				WebElement Adult = driver.findElement(By.xpath("//select[@id='no_adults']"));
				Select SelectAdult=new Select(Adult);
				SelectAdult.selectByValue("3");
				driver.findElement(By.xpath("//input[@id='no_child']")).sendKeys("2");
				
				//Frame
				driver.switchTo().frame("hotelsearch_iframe");
				WebElement search = driver.findElement(By.xpath("//button[@class='btn filter_btn']"));
				search.click();

				
				driver.findElement(By.xpath("//label[@for='value_nasc']")).click();
				
				
				
				List<WebElement> hotelName = driver.findElements(By.xpath("//div[@class='col-md-5 hotel-suites']//h5"));
				List<String> dev = new ArrayList<>();
				for (WebElement name : hotelName) {
					String text1 = name.getText();
					dev.add(text1);
				}
				System.out.println(dev);
				List<String> qa = new ArrayList<>();
				qa.addAll(dev);
				Collections.sort(qa);
				System.out.println(qa);
				boolean equals = qa.equals(dev);
				if (equals) {
					System.out.println("Ascending order is correct");
				} else {
					System.out.println("Ascending order is not correct");
				}
			}

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}
