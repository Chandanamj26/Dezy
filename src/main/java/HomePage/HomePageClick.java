package HomePage;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;
public class HomePageClick{
	public static void main(String[] args) throws IOException, InterruptedException, CsvException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dezy.com/in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,60);


		WebElement headerbutton = driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"));
		js.executeScript("arguments[0].click();", headerbutton);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();

		WebElement button = driver.findElement(By.xpath("//button[@data-test='home-page-book-cta']/span/span"));
		js.executeScript("arguments[0].click();", button);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();

		WebElement button2 = driver.findElement(By.xpath("//button[@data-test='homeFooterConsultNow']/span/span[1]"));
		js.executeScript("arguments[0].click();", button2);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();


		WebElement aligners = driver.findElement(By.xpath("(//p[@data-test='Aligners'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(aligners)); 
		js.executeScript("arguments[0].click();", aligners);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));   
		WebElement alignersbutton = driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"));
		js.executeScript("arguments[0].click();", alignersbutton);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement Braces = driver.findElement(By.xpath("(//p[@data-test='Braces'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Braces)); 
		js.executeScript("arguments[0].click();", Braces);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));   
		WebElement Bracesbutton = driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"));
		js.executeScript("arguments[0].click();", Bracesbutton);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement Veneers=driver.findElement(By.xpath("(//p[@data-test='Veneers'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Veneers));
		js.executeScript("arguments[0].click();", Veneers);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-test='title']"))));
		WebElement button3 = driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-test='title']"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement TeethWhitening=driver.findElement(By.xpath("(//p[@data-test='Teeth Whitening'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(TeethWhitening));
		js.executeScript("arguments[0].click();", TeethWhitening);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));
		WebElement button4 = driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button4);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement DentalJewellery=driver.findElement(By.xpath("(//p[@data-test='Dental Jewellery'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(DentalJewellery));
		js.executeScript("arguments[0].click();", DentalJewellery);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));
		WebElement button5 = driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement arrow=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[6]"));
		arrow.click();
		WebElement Implants=driver.findElement(By.xpath("(//p[@data-test='Implants'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Implants)); 
		js.executeScript("arguments[0].click();", Implants);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));
		WebElement button6 = driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"));
		js.executeScript("arguments[0].click();", button6);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book a free assessment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement ele=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[6]"));
		Actions action=new Actions(driver);
		action.doubleClick(ele).perform();
		WebElement Rootcanal=driver.findElement(By.xpath("//p[@data-test='Rootcanal']"));
		wait.until(ExpectedConditions.elementToBeClickable(Rootcanal));
		js.executeScript("arguments[0].click();", Rootcanal);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));
		WebElement button7 = driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button7);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement ele1=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[7]"));
		ele1.click();
		WebElement CompleteDentures=driver.findElement(By.xpath("(//p[@data-test='Complete Dentures'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CompleteDentures));
		js.executeScript("arguments[0].click();", CompleteDentures);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]")))); 
		WebElement button8 = driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button8);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement ele2=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[9]"));
		ele2.click();
		WebElement Bridges=driver.findElement(By.xpath("(//p[@data-test='Bridges'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Bridges));
		js.executeScript("arguments[0].click();", Bridges);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]")))); 
		WebElement button9= driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button9);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement dot7=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[7]"));
		dot7.click();
		WebElement dentalbonding=driver.findElement(By.xpath("(//p[@data-test='Dental Bonding'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(dentalbonding));
		js.executeScript("arguments[0].click();", dentalbonding);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]")))); 
		WebElement button91= driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button91);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement dot8=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[9]"));
		dot8.click();	 
		WebElement ToothExtraction=driver.findElement(By.xpath("(//p[@data-test='Tooth Extraction'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(ToothExtraction));
		js.executeScript("arguments[0].click();", ToothExtraction);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));     
		WebElement button11= driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button11);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement dot9=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[9]"));
		dot9.click();
		WebElement TeethCleaning=driver.findElement(By.xpath("//p[@data-test='Teeth Cleaning']"));
		wait.until(ExpectedConditions.elementToBeClickable(TeethCleaning));
		js.executeScript("arguments[0].click();", TeethCleaning);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));     
		WebElement button12= driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button12);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='header-book-cta']/span/span"))));
		driver.navigate().refresh();

		WebElement dot10=driver.findElement(By.xpath("(//div[@data-test='HowItWorksDot'])[9]"));
		dot10.click();
		WebElement Scaling=driver.findElement(By.xpath("//p[@data-test='Scaling & Root Planing']"));
		wait.until(ExpectedConditions.elementToBeClickable(Scaling));
		js.executeScript("arguments[0].click();", Scaling);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));     
		WebElement button13= driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"));
		js.executeScript("arguments[0].click();", button13);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@data-test='unifiedBookingInputPhoneGifSection']"))));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Book an appointment'])[1]"))));   
		driver.navigate().back();
		System.out.println("done");

	}

}




