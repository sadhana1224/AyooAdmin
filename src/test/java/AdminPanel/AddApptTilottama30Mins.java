package AdminPanel; //Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddApptTilottama30Mins {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.id("dashboard-add-appointment")).click();

		driver.findElement(By.xpath("//select[@name='cartype']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='Mental Health']")).click();

		driver.findElement(By.xpath("//select[@name='apttype']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='Virtual']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("apptslot")));
		dateInput.click();
		WebElement dateToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'18')]")));
		dateToSelect.click();
		Select spl=new Select(driver.findElement(By.xpath("//select[@id='specialization']")));
		spl.selectByIndex(0);

		//select doctor
		WebElement doctorDropdown = driver.findElement(By.xpath("//div[@id='doctor']"));
		doctorDropdown.click();
		Thread.sleep(2000);

		WebElement doctorOption = driver.findElement(By.xpath("//div[contains(text(),'Tilottama Khandelwal')]"));
		doctorOption.click();

//Time slot- 50 mins
		WebElement timeslotDropdown = driver.findElement(By.xpath("//select[@id='timeslot']"));
		Select timeslot = new Select(timeslotDropdown);
		timeslot.selectByVisibleText("08:30 PM");
		Thread.sleep(2000);

//60 mins slot
		/*	driver.findElement(By.xpath("//div//input[@id='60-slot']")).click();*/
		//Search patient

		WebElement patient = driver.findElement(By.xpath("//div[@id='patients']//div"));
		patient.click();
		Thread.sleep(3000);
		WebElement patientname=driver.findElement(By.xpath("//input[@id='patientsListInput']"));
		patientname.sendKeys("Sadhana V");
		Thread.sleep(2000);
		WebElement dropdownOption = driver.findElement(By.xpath("//div[contains(text(),'Sadhana V')]"));
		dropdownOption.click();
		driver.findElement(By.xpath("//select//option[@value='Self']")).click();


		//	WebElement payment=driver.findElement(By.id("payment"));
		//	payment.clear();
		//	payment.sendKeys("0");
		//promocode
		driver.findElement(By.id("applyPromoCode")).sendKeys("Ayoo200");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("book-appointment-submit")).click();

	}

}








