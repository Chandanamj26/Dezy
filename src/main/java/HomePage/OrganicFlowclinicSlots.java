package HomePage;

import java.io.FileWriter;
import java.io.IOException;
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

public class OrganicFlowclinicSlots {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("https://dezy.com/in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,600);
		Login log=new Login(driver,wait);
		log.Login();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);
		boolean isFirstRow = true;
		CSVWriter writer = new CSVWriter(new FileWriter("OrganicFlow/organicflowslots.csv"));

		WebElement headerbutton = driver.findElement(By.xpath("//button[@data-test='header-book-cta']/descendant::span[2]"));
		js.executeScript("arguments[0].click();", headerbutton);
		WebElement Continue = driver.findElement(By.xpath("(//div[@data-test='input-phone-continue']/descendant::span)[2]"));
		js.executeScript("arguments[0].click();", Continue);
		WebElement Bangalore = driver.findElement(By.xpath("(//div[@data-test='select-city']/descendant::p)[1]"));
		js.executeScript("arguments[0].click();", Bangalore);

		List<WebElement> categoryElements = driver.findElements(By.xpath("//div[@data-test='concern-category-card']/child::div/child::div/descendant::h6"));
		WebElement locationdropdownref;
		WebElement categoryRef;
		for (int i = 1; i < categoryElements.size(); i++) {
			List<WebElement> category = driver.findElements(By.xpath("//div[@data-test='concern-category-card']/child::div/child::div/descendant::h6"));
			categoryRef = category.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-test='concern-category-card']/child::div/child::div/descendant::h6")));
			String categoryText = categoryRef.getText();
			System.out.println(categoryText);
			js.executeScript("arguments[0].click();", categoryRef);

			if(i==1||i==2||i==3) {
				List<WebElement> treatmentElements = driver.findElements(By.xpath("//div[@data-test='select-treatment-card']/child::div/descendant::p[1]"));
				WebElement treatmentRef;
				for (int j1 = 0; j1 < treatmentElements.size() ; j1++) {
					List<WebElement> treatment = driver.findElements(By.xpath("//div[@data-test='select-treatment-card']/child::div/descendant::p[1]"));
					if (j1 >= treatment.size()) {
						System.out.println("Skipping unavailable element at index: " + j1);
						continue; // Skip to the next iteration
					}
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-test='select-treatment-card']/child::div/descendant::p[1]")));
					treatmentRef = treatment.get(j1);
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-test='select-treatment-card']/child::div/descendant::p[1]")));
					String treatmentText = treatmentRef.getText();
					System.out.println(treatmentText);
					js.executeScript("arguments[0].click();", treatmentRef);

					if((i==1&&j1==0)||(i==2&&j1==0)) {
						WebElement clinic = driver.findElement(By.xpath("//div[@data-test='organic-clinic-booking']/descendant::p[1]"));
						assert clinic.isDisplayed() : "Clinic element is not visible";
						js.executeScript("arguments[0].click();", clinic);
					}
					WebElement checkavailablityref;
					WebElement Banglore = driver.findElement(By.xpath("//div[@data-test='dropdown']/child::div/child::div/child::div[1]"));
					js.executeScript("arguments[0].click();", Banglore);
					List<WebElement> locationdropdown = driver.findElements(By.xpath("//div[@data-test='dropdown']/child::div/following-sibling::div/child::div"));
					for (int j2 = 0; j2 < locationdropdown.size(); j2++) {
						List<WebElement> locationdropdown1 = driver.findElements(By.xpath("//div[@data-test='dropdown']/child::div/following-sibling::div/child::div"));
						locationdropdownref = locationdropdown1.get(j2);
						String dropdownText = locationdropdownref.getText();
						System.out.println(dropdownText);
						js.executeScript("arguments[0].click();", locationdropdownref);
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h5[text()='Choose your clinic']"))));

						List<WebElement> checkAvailability = driver.findElements(By.xpath("//p[text()='Check availability']"));
						System.out.println(checkAvailability.size());		

						for (int j3 = 0; j3 < checkAvailability.size(); j3++) {
							List<WebElement> updatedCheckAvailability = driver.findElements(By.xpath("//p[text()='Check availability']"));
							if (j3 >= updatedCheckAvailability.size()) {
								System.out.println("Skipping unavailable element at index: " + j3);
								continue; // Skip to the next iteration
							}
							WebElement checkAvailabilityRef = updatedCheckAvailability.get(j3);
							try {
								wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityRef));
								js.executeScript("arguments[0].click();", checkAvailabilityRef);
							} catch (Exception e) {
								System.out.println("Element is stale, refreshing and retrying...");
								driver.navigate().refresh();
								List<WebElement> CheckAvailability = driver.findElements(By.xpath("//p[text()='Check availability']"));
								WebElement checkAvailabilityclick = CheckAvailability.get(j3);
								js.executeScript("arguments[0].click();", checkAvailabilityclick);
							}
							WebElement clinicName = driver.findElement(By.xpath("//h5[@data-test='data-test-clinicName']"));
							js.executeScript("arguments[0].scrollIntoView(true);", clinicName);
							String clinicNameText = clinicName.getText();
							System.out.println(clinicNameText);

							if(j3==0 && isFirstRow) {
								WebElement[] days = new WebElement[5];
								String[] daystext = new String[5];
								for (int j4 = 0; j4<5; j4++) {
									int daysIndex = j4+2;
									String daysXPath = String.format("(//button[@data-test='day-btn-%d}']/child::p)[3]", daysIndex);
									days[j4] = driver.findElement(By.xpath(daysXPath));
									wait.until(ExpectedConditions.visibilityOf(days[j4]));
									daystext[j4] = days[j4].getText();
									System.out.println(daystext[j4]);
								}
								String[] header1 = {"Flow", "Treatment","location","clinicName",currentDate,"Tom",daystext[0], daystext[1],daystext[2],daystext[3],daystext[4]};
								writer.writeNext(header1);
								isFirstRow = false;
							}
							WebElement[] slots = new WebElement[7];
							String[] slotstext = new String[7];
							for (int j5 = 0; j5 < 7; j5++) {//button[@data-test='day-btn-6}']/child::p)[4]
								int slotIndex = j5;
								String slotsXPath = String.format("(//button[contains(., 'Slots') and @data-test='day-btn-%d}']/child::p)[4]", slotIndex);
								//	String slotsXPath = String.format("(//button[@data-test='day-btn-%d}']/child::p)[4]", slotIndex);
								slots[j5] = driver.findElement(By.xpath(slotsXPath));
								wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(slotsXPath))));
								slotstext[j5] = slots[j5].getText();
								System.out.println(slotstext[j5]);
							}
							WebElement back = driver.findElement(By.xpath("//p[text()='Back']"));
							js.executeScript("arguments[0].click();", back);

							String[] line2 = {categoryText, treatmentText,dropdownText,clinicNameText,slotstext[0], slotstext[1],slotstext[2],slotstext[3],slotstext[4],slotstext[5],slotstext[6]};
							writer.writeNext(line2);
							writer.flush();
						}
						WebElement Banglore1 = driver.findElement(By.xpath("//div[@data-test='dropdown']/child::div/child::div/child::div[2]"));
						js.executeScript("arguments[0].click();", Banglore1);
					}
					if((i==1&&j1==0)||(i==2&&j1==0)) {
						driver.navigate().back();
						driver.navigate().back();
					}else {
						driver.navigate().back();
					}
				}	
			}
		}
	}
}
