package Website;//Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/book-appointment");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[contains(text(),'Log in / Sign up')]")).click();
		driver.findElement(By.id("loginPage-signup")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Anie");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("A");
		driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys("2398647269");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("dawora2999@neixos.com");
		driver.findElement(By.xpath("(//div//input)[5]")).sendKeys("1997-05-24");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sadhu@123");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("Sadhu@123");
		WebElement gen=driver.findElement(By.xpath("//button[contains(text(),'Female')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", gen);
		Thread.sleep(1000); 
		gen.click();

		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
		//Thread.sleep(10);
		//driver.quit();
	}

}
