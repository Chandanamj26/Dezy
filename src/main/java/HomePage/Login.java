package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;

	
	 WebDriverWait wait;
	public Login(WebDriver driver, WebDriverWait wait)
	{
	super();
	this.driver=driver;
	this.wait=wait;
	PageFactory.initElements(driver, this);
	//PageFactory.initElements(FieldDecorator(driver), this);
	}
	public void Login() throws InterruptedException {
		
       WebElement loginbutton = driver.findElement(By.xpath("//div[@data-test='login']"));
       loginbutton.click();
       Thread.sleep(4000);

       String myWindowHandle = driver.getWindowHandle();
       driver.switchTo().window(myWindowHandle);
       WebElement Number = driver.findElement(By.xpath("//input[@type='number']"));
       Number.sendKeys("8105401169");
       Thread.sleep(1000);
       WebElement proceed= driver.findElement(By.xpath("//span[text()='Proceed']"));
       proceed.click();
       Thread.sleep(8000); 
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='accountDetails']/div/p"))));    
      Thread.sleep(8000);  
	}
}
