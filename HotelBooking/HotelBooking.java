package com.HotelBooking;
                                                      //SELENIUM USING MAVEN BUILD MANAGEMENT TOOL
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBooking {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		//Login
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("venkateshsel99@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Selva@kamali1");
		driver.findElement(By.xpath("//button[@value='login']")).click();
		
		// Print Welcome UserName
		WebElement gt = driver.findElement(By.xpath("//a[@data-testid='username']"));
		String tt = gt.getText();
		System.out.println(tt);
		
		//print Explore Hotel
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
       //DropDown
		String[] options = {"Standard", "Deluxe", "Suite", "Luxury", "Studio"};
		WebElement dropdown = driver.findElement(By.xpath("//textarea[@type='search']"));
		for (String option : options) {
		dropdown.click();
		WebElement optionElement = driver.findElement(By.xpath("//li[text()='" + option + "']"));
		optionElement.click();
		}
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
		WebElement selecthotel = driver.findElement(By.xpath("//h5[text()='Select Hotel']"));
		String text2 = selecthotel.getText();
		System.out.println(text2);
		
		//Print Hotel Name
		WebElement selecthotel1 = driver.findElement(By.xpath("//h5[text()='Le Royal Meridien Studio']"));
		String text3 = selecthotel1.getText();
		System.out.println(text3);
		
		//Print Hotel Price
		WebElement selecthotel2 = driver.findElement(By.xpath("(//strong[@class='total-prize'])[1]"));
		String text4 = selecthotel2.getText();
		System.out.println(text4);
		driver.findElement(By.xpath("(//a[text()='Continue'])[1]")).click();
		//Alert
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='own']")).click();
		
		//Book Hotel
		WebElement saluation = driver.findElement(By.xpath("//select[@id='user_title']"));
		Select mr =new Select(saluation);
		mr.selectByValue("Mr");
		driver.findElement(By.id("first_name")).sendKeys("venkatesh");
		driver.findElement(By.id("last_name")).sendKeys("selvaraj");
		driver.findElement(By.id("user_phone")).sendKeys("7598348238");
		driver.findElement(By.id("user_email")).sendKeys("venkateshel99@gmail.com");
		driver.findElement(By.id("gst")).click();
		driver.findElement(By.id("gst_registration")).sendKeys("9043592058");
		driver.findElement(By.id("company_name")).sendKeys("Greens Tech OMR Branch");
		driver.findElement(By.id("company_address")).sendKeys("Thoraipakkam");
		driver.findElement(By.xpath("//button[@id='step1next']")).click();
		driver.findElement(By.xpath("//input[@id='bed']")).click();
		WebElement msg = driver.findElement(By.xpath("//textarea[@id='other_request']"));
		msg.sendKeys("i need rental car");
		driver.findElement(By.xpath("//button[@id='step2next']")).click();
		driver.findElement(By.xpath("//div[@class='credit-card pm']")).click();
		WebElement type = driver.findElement(By.xpath("//select[@id='payment_type']"));
		Select cardtype=new Select(type);
		cardtype.selectByValue("debit_card");
		WebElement card = driver.findElement(By.xpath("//select[@id='card_type']"));
		Select selectcard=new Select(card);
		selectcard.selectByValue("visa");
		driver.findElement(By.xpath("//input[@id='card_no']")).sendKeys("5555555555552222");
		driver.findElement(By.xpath("//input[@id='card_name']")).sendKeys("venkatesh");
		WebElement month = driver.findElement(By.xpath("//select[@id='card_month']"));
		Select selectmonth=new Select(month);
		selectmonth.selectByValue("06");
		driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("543");	
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();	
		
		//Print Booking
		WebElement bookorder = driver.findElement(By.xpath("//h2[@name='booking-code']"));
		String text6 = bookorder.getText();
		System.out.println(text6);
		driver.findElement(By.xpath("//button[text()='My Booking']")).click();
		
		//Print OrderId,HotelName,Price
		WebElement booking = driver.findElement(By.xpath("(//div[@class='col-md-5'])[1]"));
		String text5 = booking.getText();
		System.out.println(text5);	
		WebElement hotelname = driver.findElement(By.xpath("//h5[text()='Le Royal Meridien Studio']"));
		String text7 = hotelname.getText();
		System.out.println(text7);	
		WebElement bookingprice = driver.findElement(By.xpath("//strong[@class='total-prize']"));
		String text8= bookingprice.getText();
		System.out.println(text8);
		
		//Modify the CheckIn Date And CheckOut Date
		driver.findElement(By.xpath("//button[@class='edit btn filter_btn']")).click();
		driver.findElement(By.xpath("//input[@name='check_in']")).click();
		driver.findElement(By.xpath("//a[text()='16']")).click();
		driver.findElement(By.xpath("//input[@name='check_out']")).click();
		driver.findElement(By.xpath("//a[text()='24']")).click();
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Cancel Booking
		driver.findElement(By.xpath("//a[text()='Cancel']")).click();
		//Alert
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[text()='Cancelled']")).click();	
		WebElement cancel = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String text9 = cancel.getText();
		System.out.println(text9);
		
	}
	}
