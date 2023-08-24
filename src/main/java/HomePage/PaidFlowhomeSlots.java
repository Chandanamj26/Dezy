package HomePage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaidFlowhomeSlots {
	public static void main(String[] args) throws IOException, InterruptedException, CsvException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		String[] urls = {
				"https://dezy.com/in/unified-booking/ext?utm_lead_type=aligner",
				"https://dezy.com/in/unified-booking/ext?utm_lead_type=implant"
		};
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,80);
		List<String[]> allData = new ArrayList<>();
		CSVWriter writer = new CSVWriter(new FileWriter("PaidFlow\\PaidFlowHomebookingSlots.csv"));
		String[] daystext = new String[7];
		for (int i = 0; i < urls.length; i++) {
			String url =  urls[i];
			driver.get(url);
			String testType = null;
			if (i == 0) {
				testType = "Paid-Aligner";
			} else  {
				testType = "Paid-Implant";
			} 
			if(i==0) {
				WebElement Number = driver.findElement(By.xpath("//div[@data-test='unifiedBookingInputPhone']/div/div/div[2]/input"));
				Number.sendKeys("8105401169");
			}
			WebElement button = driver.findElement(By.xpath("//div[@data-test='input-phone-continue']/button/span/span"));
			js.executeScript("arguments[0].click();", button);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-test='unifiedBookingSelectCity']"))));

			String csvFilePath = "PaidFlow\\location.csv";
			List<Map<String, String>> data = readDataFromCSV(csvFilePath);
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
				WebElement Chooseone = driver.findElement(By.xpath("(//div[@data-test='concern-card'])[5]"));
				js.executeScript("arguments[0].click();", Chooseone);
				WebElement home = driver.findElement(By.xpath("//div[@data-test='paid-home-booking']"));
				js.executeScript("arguments[0].click();", home);

				DateFormat dateFormat = new SimpleDateFormat("dd MMMM");
				Date date = new Date();
				String c2= dateFormat.format(date);
				System.out.println(c2);
				 int maxAttempts = 1;
				   for (int attempt = 1; attempt <= maxAttempts; attempt++) {
					WebElement address = driver.findElement(By.xpath("//input[@data-test='enter-location']"));
					address.sendKeys(addressText);
					try {
						WebElement addressclick = driver.findElement(By.xpath("//*[@id=\"pageContent\"]/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/p[2]/span[2]"));
						wait.until(ExpectedConditions.elementToBeClickable(addressclick));
						addressclick.click();
					} catch (Exception e) {
						try {
							By nextElementLocator = By.xpath("//*[@id=\"pageContent\"]/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/p[2]/span[1]");
							WebElement nextElement = driver.findElement(nextElementLocator);
							Actions actions = new Actions(driver);
							actions.moveToElement(nextElement).click().perform();
						} catch (Exception ex) {
							driver.navigate().refresh();
						}
					}
				}
				WebElement buildingName = driver.findElement(By.xpath("//input[@data-test='data-test-building']"));
				buildingName.sendKeys(buildingNameText);
				WebElement pincode = driver.findElement(By.xpath("//input[@data-test='data-test-pincode']"));
				pincode.sendKeys(pincodeText);
				WebElement landmark = driver.findElement(By.xpath("//input[@data-test='data-test-landmark']"));
				landmark.sendKeys(landmarkText);
				WebElement save = driver.findElement(By.xpath("//button[@data-test='save-address-button']/child::span/child::span"));
				save.click();
				WebElement[] days = new WebElement[7];
				if(i==0) {
					for (int j4 = 0; j4<7; j4++) {
						int daysIndex = j4;
						String daysXPath = String.format("//button[@data-test='day-btn-%d}']/child::p[1]", daysIndex);
						days[j4] = driver.findElement(By.xpath(daysXPath));
						wait.until(ExpectedConditions.visibilityOf(days[j4]));
						daystext[j4] = days[j4].getText();
						System.out.println(daystext[j4]);
					}
					if (row.equals(data.get(0))) {
						String[] header1 = {"Address","City","Testtype",c2, daystext[1],daystext[2],daystext[3],daystext[4],daystext[5],daystext[6]};
						writer.writeNext(header1);
					}
				}
				WebElement[] slots = new WebElement[7];
				String[] slotstext = new String[7];
				for (int j5 = 0; j5 < 7; j5++) {
					int slotIndex = j5;
				    String slotsXPath = String.format("//button[contains(., 'Slots') and @data-test='day-btn-%d}']/child::p[2]", slotIndex);
				//	String slotsXPath = String.format("//button[@data-test='day-btn-%d}']/child::p[2]", slotIndex);
				    slots[j5] = driver.findElement(By.xpath(slotsXPath));
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(slotsXPath))));
					slots[j5] = driver.findElement(By.xpath(slotsXPath));
					slotstext[j5] = slots[j5].getText();
					System.out.println(slotstext[j5]);
				}
				String[] area41={addressText,cityText,testType,slotstext[0], slotstext[1],slotstext[2],slotstext[3],slotstext[4],slotstext[5],slotstext[6]};
				writer.writeNext(area41);
				writer.flush();
				int numberOfBackNavigations = 4; 
				for (int i1 = 0; i1 < numberOfBackNavigations; i1++) {
				    driver.navigate().back();
				}
			}
		}
		writer.writeAll(allData);
		writer.flush();
		writer.close();
		driver.quit();
	}
	public static List<Map<String, String>> readDataFromCSV(String csvFilePath) throws IOException, CsvException {
		List<Map<String, String>> data;
		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
			List<String[]> rows = reader.readAll();
			String[] headers = rows.get(0);
			data = new ArrayList<>();
			for (int i = 1; i < rows.size(); i++) {
				String[] values = rows.get(i);
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < headers.length; j++) {
					rowData.put(headers[j], values[j]);
				}
				data.add(rowData);
			}
		}
		return data;
	}
}
