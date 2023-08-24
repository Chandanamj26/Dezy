package HomePage;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;


import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganicFlowHomeSlots {
	public static void main(String[] args) throws IOException, InterruptedException, CsvException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://dezy.com/in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,100);
		Login log=new Login(driver,wait);
		log.Login();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='desktopNav']"))));

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);
		boolean isFirstRow = true;
		CSVWriter writer = new CSVWriter(new FileWriter("OrganicFlow/organicflowHomeslots.csv"));
		String[] daystext = new String[7];

		String csvFilePath = "PaidFlow\\location.csv";
		List<Map<String, String>> data = PaidFlowhomeSlots.readDataFromCSV(csvFilePath);
		boolean isFirstCategory = true;
		String[] categoryXPaths = {
				"//div[@data-test='concern-category-card']/descendant::h6[2]", 
				"//div[@data-test='concern-category-card']/descendant::h6[3]"  
		};
		WebElement headerbutton = driver.findElement(By.xpath("//button[@data-test='header-book-cta']/descendant::span[2]"));
		js.executeScript("arguments[0].click();", headerbutton);
		WebElement Continue = driver.findElement(By.xpath("(//div[@data-test='input-phone-continue']/descendant::span)[2]"));
		js.executeScript("arguments[0].click();", Continue);
		for (int i = 0; i < categoryXPaths.length; i++) {
			String categoryXPath =  categoryXPaths[i];
			for (Map<String, String> row : data) {
				String addressText = row.get("Address");
				String buildingNameText = row.get("Building Name");
				String pincodeText = row.get("Pincode");
				String landmarkText = row.get("Landmark");
				String cityText = row.get("City");

				WebElement Firstlocation = driver.findElement(By.xpath("//div[@data-test='select-city']/descendant::p[contains(text(), '" + cityText + "')]"));
				js.executeScript("arguments[0].scrollIntoView(true);", Firstlocation);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='select-city']/descendant::p[contains(text(), '" + cityText + "')]"))));
		
				js.executeScript("arguments[0].click();", Firstlocation);
				WebElement categoryElement = driver.findElement(By.xpath(categoryXPath));
				String categoryText = categoryElement.getText();
				System.out.println(categoryText);
				js.executeScript("arguments[0].click();", categoryElement);
				WebElement Treatment = driver.findElement(By.xpath("//*[@id=\"pageContent\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/p[1]"));
				wait.until(ExpectedConditions.visibilityOf(Treatment));
				String TreatmentText = Treatment.getText();
				System.out.println(TreatmentText);
				js.executeScript("arguments[0].click();", Treatment);
				WebElement home = driver.findElement(By.xpath("//div[@data-test='organic-home-booking']/descendant::p[1]"));
				assert home.isDisplayed() : "Clinic element is not visible";
				js.executeScript("arguments[0].click();", home);

				WebElement address = driver.findElement(By.xpath("//input[@data-test='enter-location']"));
				address.sendKeys(addressText);
				try {
					WebElement addressclick = driver.findElement(By.xpath("//*[@id=\"pageContent\"]/div/div[2]/div[3]/div[1]/div/div[1]/div/div/div[2]/p[2]/span[2]"));
					wait.until(ExpectedConditions.elementToBeClickable(addressclick));
					addressclick.click();
				} catch (Exception e) {
					By nextElementLocator = By.xpath("//*[@id=\"pageContent\"]/div/div[2]/div[3]/div[1]/div/div[1]/div/div/div[2]/p[2]/span[1]");
					WebElement nextElement = driver.findElement(nextElementLocator);
					Actions actions = new Actions(driver);
					actions.moveToElement(nextElement).click().perform();
				}
				WebElement buildingName = driver.findElement(By.xpath("//input[@data-test='data-test-building']"));
				js.executeScript("arguments[0].scrollIntoView(true);", buildingName);
				buildingName.sendKeys(buildingNameText);
				WebElement pincode = driver.findElement(By.xpath("//input[@data-test='data-test-pincode']"));
				js.executeScript("arguments[0].scrollIntoView(true);", pincode);
				pincode.sendKeys(pincodeText);
				WebElement landmark = driver.findElement(By.xpath("//input[@data-test='data-test-landmark']"));
				landmark.sendKeys(landmarkText);
				WebElement save = driver.findElement(By.xpath("//button[@data-test='save-address-button']/child::span/child::span"));
				save.click();
				WebElement[] days = new WebElement[7];
				if (isFirstCategory) {
					for (int j4 = 0; j4<7; j4++) {
						int daysIndex = j4;
						String daysXPath = String.format("//button[@data-test='day-btn-%d}']/child::p[1]", daysIndex);
						days[j4] = driver.findElement(By.xpath(daysXPath));
						wait.until(ExpectedConditions.visibilityOf(days[j4]));
						daystext[j4] = days[j4].getText();
						System.out.println(daystext[j4]);
					}
					if (isFirstCategory && isFirstRow)  {
						String[] header1 = {"Address","City","Treatment",currentDate, daystext[1],daystext[2],daystext[3],daystext[4],daystext[5],daystext[6]};
						writer.writeNext(header1);
						isFirstRow = false;
					}
				}
		
				WebElement[] slots = new WebElement[7];
				String[] slotstext = new String[7];
				for (int j5 = 0; j5 < 7; j5++) {
					int slotIndex = j5;
				    String slotsXPath = String.format("//button[contains(., 'Slots') and @data-test='day-btn-%d}']/child::p[2]", slotIndex);
					//String slotsXPath = String.format("//button[@data-test='day-btn-%d}']/child::p[2]", slotIndex);
					slots[j5] = driver.findElement(By.xpath(slotsXPath));
					slotstext[j5] = slots[j5].getText();
					System.out.println(slotstext[j5]);
				}
				String[] area41={addressText,cityText,TreatmentText,slotstext[0], slotstext[1],slotstext[2],slotstext[3],slotstext[4],slotstext[5],slotstext[6]};
				writer.writeNext(area41);
				writer.flush();
				int numberOfBackNavigations = 5; // Change this value to the number of times you want to navigate back
				for (int i1 = 0; i1 <numberOfBackNavigations; i1++) {
					driver.navigate().back();
				//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='unifiedBookingHeaderButton']"))));
	
				}
			}
		}
		driver.quit();
	}
}
