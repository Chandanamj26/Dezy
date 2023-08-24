package HomePage;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaiFlowClinicSlots {
	public static void main(String[] args) throws InterruptedException, IOException {
		String[] urls = {
				"https://dezy.com/in/unified-booking/ext?utm_lead_type=aligner",
				"https://dezy.com/in/unified-booking/ext?utm_lead_type=implant",
				"https://dezy.com/in/unified-booking/ext?utm_lead_type=clinic"
		};
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,800); 
		CSVWriter writer= new CSVWriter(new FileWriter("PaidFlow\\PaidFlowClinicSlots.csv"));
		boolean isFirstRow = true;
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM"); 
		Date date = new Date();
		String c2= dateFormat.format(date);
		System.out.println(c2);
		for (int i = 0; i < urls.length; i++) {
			String url =  urls[i];
			driver.get(url);
			String testType = null;
			if (i == 0) {
				testType = "Paid-Aligner";
			} else if (i == 1) {
				testType = "Paid-Implant";
			} else if (i == 2) {
				testType = "Paid-Clinic";
			}
			if(i==0) {
				WebElement Number = driver.findElement(By.xpath("//div[@data-test='unifiedBookingInputPhone']/div/div/div[2]/input"));
				Number.sendKeys("8105401169");
			}
			WebElement button = driver.findElement(By.xpath("//div[@data-test='input-phone-continue']/button/span/span"));
			js.executeScript("arguments[0].click();", button);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h5[text()='Pick a city for your dental consultation?']"))));

			List<WebElement> location = driver.findElements(By.xpath("//div[@data-test='select-city']/descendant::p"));
			WebElement locationref;
			for(int i1=0;i1<location.size();i1++) {
				List<WebElement> location1 = driver.findElements(By.xpath("//div[@data-test='select-city']/descendant::p"));
				locationref=location1.get(i1);
				js.executeScript("arguments[0].scrollIntoView(true);", locationref);
				wait.until(ExpectedConditions.visibilityOf(locationref));
				String locationText = locationref.getText();
				System.out.println(locationref.getText());
				js.executeScript("arguments[0].click();", locationref);
				if(i==0||i==1) {
					WebElement Chooseone1 = driver.findElement(By.xpath("(//div[@data-test='concern-card'])[5]"));
					js.executeScript("arguments[0].click();", Chooseone1);
					WebElement clinic1 = driver.findElement(By.xpath("//div[@data-test='paid-clinic-booking']"));
					js.executeScript("arguments[0].click();", clinic1);
				}
				List<WebElement> Area = driver.findElements(By.xpath("//div[@data-test='city-select']/child::div/child::p"));
				WebElement Arearef;
				for(int j=0;j<Area.size();j++) {
					List<WebElement> Area1 = driver.findElements(By.xpath("//div[@data-test='city-select']/child::div/child::p"));
					wait.until(ExpectedConditions.visibilityOf(Area1.get(j)));
					Arearef=Area1.get(j);
					wait.until(ExpectedConditions.visibilityOf(Arearef));
					String areaText = Arearef.getText();
					System.out.println(Arearef.getText());
					js.executeScript("arguments[0].click();", Arearef);
					WebElement clinicname = driver.findElement(By.xpath("//h4[@data-test='clinic-name']"));
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[@data-test='clinic-name']"))));
					String Clinicname=clinicname.getText();
					System.out.println(Clinicname);
					if (j == 0 && isFirstRow) {
						WebElement[] days = new WebElement[5];
						String[] daystext = new String[5];
						for (int j4 = 0; j4 < 5; j4++) {
							int daysIndex = j4 + 2;
							String daysXPath = String.format("//button[@data-test='day-btn-%d}']/child::p[1]", daysIndex);
							days[j4] = driver.findElement(By.xpath(daysXPath));
							wait.until(ExpectedConditions.visibilityOf(days[j4]));
							daystext[j4] = days[j4].getText();
							System.out.println(daystext[j4]);
						}
						String[] header1 = {"Location", "Area", "clinic", "Testtype", c2, "Tom", daystext[0], daystext[1], daystext[2], daystext[3], daystext[4]};
						writer.writeNext(header1);
						isFirstRow = false;
					}
					Thread.sleep(15000);
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
					String[] area41={locationText,areaText,Clinicname,testType,slotstext[0], slotstext[1],slotstext[2],slotstext[3],slotstext[4],slotstext[5],slotstext[6]};
					writer.writeNext(area41);
					writer.flush();
				}
				if (i == 0||i==1) {
					navigateBackAndAwait(driver, wait, "//div[@data-test='paid-clinic-booking']");
					navigateBackAndAwait(driver, wait, "(//div[@data-test='concern-card'])[5]");
					navigateBackAndAwait(driver, wait, "//div[@data-test='select-city']/descendant::p");
				}else {
					navigateBackAndAwait(driver, wait, "//div[@data-test='select-city']/descendant::p");
				}
			}	
		}
		driver.close();
	}
	public static void navigateBackAndAwait(WebDriver driver, WebDriverWait wait, String xpath) {
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
}
