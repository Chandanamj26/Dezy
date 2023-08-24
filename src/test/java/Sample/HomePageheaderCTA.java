package Sample;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HomePageheaderCTA {
	public static void main(String[] args) throws IOException, InterruptedException, CsvException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dezy.com/in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,60);

		/*
        WebElement help = driver.findElement(By.xpath("//p[@data-test='desktopHelpMenu']"));
        help.click();
        Thread.sleep(2000);

        WebElement WhatsApp=driver.findElement(By.xpath("(//div[@data-test='Chat on WhatsApp'])[2]"));
        WhatsApp.click();

        Set w = driver.getWindowHandles();
        // window handles iterate
        Iterator t = w.iterator();
        String ch = (String) t.next();
        String pw = (String) t.next();
        // switching child window
        driver.switchTo().window(pw);
        System.out.println("Child window title "+ driver.getTitle());
        // close the child browser window
        driver.close();
  	 	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='whyDezyButton']/p"))));     

        driver.navigate().refresh();
		 */
		WebElement whydezy=driver.findElement(By.xpath("//div[@data-test='whyDezyButton']/p"));
		whydezy.click();
		WebElement dezydiff=driver.findElement(By.xpath("//h6[.='The Dezy Difference']"));
		dezydiff.click();
		driver.navigate().refresh();

		WebElement whydezy1=driver.findElement(By.xpath("//div[@data-test='whyDezyButton']/p"));
		whydezy1.click();	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-test='title']"))));     
		driver.navigate().refresh();

		WebElement whydezy3=driver.findElement(By.xpath("//div[@data-test='whyDezyButton']/p"));
		whydezy3.click();	
		WebElement ExpertDentists=driver.findElement(By.xpath("//h6[.='Our Expert Dentists']"));
		ExpertDentists.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-test='header']"))));  

		WebElement Findaclinic=driver.findElement(By.xpath("//p[text()='Find a clinic']"));
		Findaclinic.click();	
		driver.navigate().back();

		driver.navigate().refresh();
		WebElement Treatments=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments.click();	


		WebElement Aligner=driver.findElement(By.xpath("//h6[@data-test='Aligner']"));
		Aligner.click();	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement Treatments2=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments2.click(); 
		WebElement Braces=driver.findElement(By.xpath("//h6[@data-test='Braces']"));
		Braces.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement Treatments3=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments3.click(); 
		WebElement Veneers=driver.findElement(By.xpath("//h6[@data-test='Dental Veneers']"));
		Veneers.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement Treatments4=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments4.click(); 
		WebElement TeethWhitening=driver.findElement(By.xpath("//h6[@data-test='Teeth Whitening']"));
		TeethWhitening.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='relative z-40 px-6 md:px-[6.5rem]']/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh(); 
		WebElement Treatment5=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatment5.click();
		WebElement DentalJewellery=driver.findElement(By.xpath("//h6[@data-test='Dental Jewellery']"));
		DentalJewellery.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='flex gap-6']/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh(); 
		WebElement Treatments6=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments6.click();
		WebElement Implants=driver.findElement(By.xpath("(//h6[@data-test='Implants'])[1]"));
		Implants.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh(); 
		WebElement Treatments7=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments7.click();
		WebElement Rootcanal=driver.findElement(By.xpath("//h6[@data-test='Root Canal']"));
		Rootcanal.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement Treatments8=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments8.click();
		WebElement CompleteDentures=driver.findElement(By.xpath("//h6[@data-test='Complete Dentures']"));
		CompleteDentures.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='relative z-40 px-6 md:px-[6.5rem]']/div/h1")))); 
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement Treatments9=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		Treatments9.click();
		WebElement Bridges=driver.findElement(By.xpath("//h6[@data-test='Bridges']"));
		Bridges.click(); 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='flex gap-6']/div/h1")))); 
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement T1=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		T1.click();
		WebElement dentalbonding=driver.findElement(By.xpath("//h6[@data-test='Dental Bonding']"));
		dentalbonding.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='relative z-40 px-6 md:px-[6.5rem]']/div/h1")))); 
		driver.navigate().back();  
		driver.navigate().refresh();
		WebElement T2=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		T2.click();	 
		WebElement ToothExtraction=driver.findElement(By.xpath("//h6[@data-test='Tooth Extraction']"));
		ToothExtraction.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='flex gap-6']/div/h1"))));     
		driver.navigate().back();
		driver.navigate().refresh();
		WebElement dot9=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		dot9.click();
		WebElement TeethCleaning=driver.findElement(By.xpath("//h6[@data-test='Teeth Whitening']"));
		TeethCleaning.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='relative z-40 px-6 md:px-[6.5rem]']/div/h1"))));     
		driver.navigate().back();  
		driver.navigate().refresh();
		WebElement dot10=driver.findElement(By.xpath("//div[@data-test='treatmentButton']/p"));
		dot10.click();
		WebElement Scaling=driver.findElement(By.xpath("//h6[@data-test='Scaling & Root Planing']"));
		Scaling.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='px-4 mx-auto md:px-24']/div/div/h1"))));     
		driver.navigate().back();  

		System.out.println("done");

	}
}

