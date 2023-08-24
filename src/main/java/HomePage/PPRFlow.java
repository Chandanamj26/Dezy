package HomePage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class PPRFlow {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream");
		WebDriver driver=WebDriverManager.chromedriver().capabilities(options).create();
		// System.setProperty("webdriver.chrome.driver",
		   //      "C:\\Users\\itsup\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev.dezy.com/in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,40);
		Login log=new Login(driver,wait);
		log.Login();
	
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);

		List<WebElement> pprissuecard = driver.findElements(By.xpath("//div[@data-test='ppr-issue-card']/div"));
		WebElement pprissuecardref;
		for (int i = 0; i < pprissuecard.size(); i++) {
			List<WebElement> pprissuecard1 = driver.findElements(By.xpath("//div[@data-test='ppr-issue-card']/div"));
			pprissuecardref = pprissuecard1.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-test='ppr-issue-card']/div")));
			String pprissuecardText = pprissuecardref.getText();
			System.out.println(pprissuecardText);
			js.executeScript("arguments[0].click();", pprissuecardref);

			WebElement Button = driver.findElement(By.xpath("//button[@data-test='find-right-treatment']/span/span"));
			js.executeScript("arguments[0].click();", Button);
			WebElement Continue = driver.findElement(By.xpath("(//div[@data-test='input-phone-continue']/descendant::span)[2]"));
			js.executeScript("arguments[0].click();", Continue);
			WebElement Bangalore = driver.findElement(By.xpath("(//div[@data-test='select-city']/descendant::p)[1]"));
			js.executeScript("arguments[0].click();", Bangalore);
			WebElement  Name= driver.findElement(By.xpath("//div[@data-test='ppr-input-name']/descendant::input"));
			Name.sendKeys("test");
			WebElement ContinueName = driver.findElement(By.xpath("(//div[@data-test='input-phone-continue']/descendant::span)[2]"));
			js.executeScript("arguments[0].click();", ContinueName);
			if(i==0) {
				clickElement(driver, "(//div[@data-test='ppr-issue-card']/descendant::p)[1]", wait);
			}
			if(i==1) {
				clickElement(driver, "(//div[@data-test='question-container']/descendant::h5)[1]", wait);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Is there a cavity or black discoloration on the aching tooth?']"))));
				clickElement(driver, "(//div[@data-test='question-container']/descendant::h5)[1]", wait);
				clickElement(driver, "(//div[@data-test='question-container']/descendant::img)[1]", wait);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Does the pain shoot up if you drink or eat anything hot or cold?']"))));
				clickElement(driver, "(//div[@data-test='question-container']/descendant::h5)[1]", wait);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='If you chew from the involved tooth does it increase the pain?']"))));
				clickElement(driver, "(//div[@data-test='question-container']/descendant::h5)[1]", wait);
			}
			if(i==2) {
				clickElement(driver, "//h5[text()='Single Tooth']", wait);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Do you think your gums are receding?']"))));
				clickElement(driver, "//h5[text()='Yes']", wait);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Can you feel or see a ditch on the tooth surface']"))));
				clickElement(driver, "//h5[text()='Yes']", wait);
			}
			if(i==3) {
				clickElement(driver, "//div[@data-test='ppr-issue-card']/p[1]", wait);
                clickElement(driver, "//h5[text()='16 to 45 years']", wait);
			}
			WebElement pprContinue = driver.findElement(By.xpath("(//button[@data-test='next-step']/descendant::span)[2]"));
			js.executeScript("arguments[0].click();", pprContinue);

			WebElement Front = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='question-container']/descendant::img[5]")));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
			fileInput.sendKeys("C:\\Users\\itsup\\Pictures\\Screenshots\\Photo.png");
			clickElement(driver, "//span[text()='Save']", wait);

			WebElement Upper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='question-container']/descendant::img[5]")));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Upper);
			WebElement fileInput1 = driver.findElement(By.xpath("//input[@type='file']"));
			fileInput1.sendKeys("C:\\Users\\itsup\\Pictures\\Screenshots\\Photo.png");
			WebElement save1 = driver.findElement(By.xpath("//span[text()='Save']"));
			js.executeScript("arguments[0].click();", save1);

			WebElement Lower = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='question-container']/descendant::img[5]")));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Lower);
			WebElement fileInput2 = driver.findElement(By.xpath("//input[@type='file']"));
			fileInput2.sendKeys("C:\\Users\\itsup\\Pictures\\Screenshots\\Photo.png");
			WebElement save2 = driver.findElement(By.xpath("//span[text()='Save']"));
			js.executeScript("arguments[0].click();", save2);

			WebElement pprfullreport = driver.findElement(By.xpath("//div[text()='See your full report']"));
			js.executeScript("arguments[0].click();", pprfullreport);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h6[contains(text(),'Thank you')]"))));

			WebElement bookyourfreescan = driver.findElement(By.xpath("//button[@data-test='data-test-book-scan']/span/span"));
			js.executeScript("arguments[0].click();", bookyourfreescan);
			try {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='clinic-title']"))));
				driver.navigate().back();
			} catch (Exception e) {
				driver.navigate().refresh();
				bookyourfreescan = driver.findElement(By.xpath("//button[@data-test='data-test-book-scan']/span/span"));
				js.executeScript("arguments[0].click();", bookyourfreescan);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='clinic-title']"))));
				driver.navigate().back();
			}
			WebElement  Findclinics= driver.findElement(By.xpath("//button[@data-test='find-clinics']"));
			js.executeScript("arguments[0].click();", Findclinics);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='clinic-title']"))));
			driver.navigate().back();

			WebElement  dezy= driver.findElement(By.xpath("//div[@data-test='desktopNav']/descendant::img[1]"));
			js.executeScript("arguments[0].click();", dezy);
		}
		driver.quit();
	}
	public static void clickElement(WebDriver driver, String xpath, WebDriverWait wait) {
		WebElement element =  wait.until( ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
}


