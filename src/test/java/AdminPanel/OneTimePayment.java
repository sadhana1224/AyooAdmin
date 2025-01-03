package AdminPanel;//Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneTimePayment{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Payments')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'One Time payments')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement patient = driver.findElement(By.xpath("//div[@id='patients']"));
		patient.click();
		wait.until(ExpectedConditions.elementToBeClickable(patient));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Sadhana V';", patient);
		WebElement patientSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Sadhana V')]")));
		patientSuggestion.click();
	
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("1");
		driver.findElement(By.xpath("//button[contains(text(),'Send Link')]")).click();
		
		Thread.sleep(10);
		driver.quit();
	}

}
