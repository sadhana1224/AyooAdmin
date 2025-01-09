package AdminPanel;  //Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PromoCode {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");
		driver.findElement(By.id("loginbtn")).click();


		driver.findElement(By.xpath("(//span[contains(text(),'Promo Code')])[1]")).click();
		//All promocode
		driver.findElement(By.xpath("(//span[contains(text(),'All Promo Codes')])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().back();

		//Create Promo code
		driver.findElement(By.xpath("(//span[contains(text(),'Promo Code')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Create Promo Code')])[1]")).click();
		driver.findElement(By.xpath("//label[text()='Promotion Code'][1]/following-sibling::input")).sendKeys("SAD400");
		driver.findElement(By.xpath("//label[text()='Promotion Name'][1]/following-sibling::input")).sendKeys("Discount");
		driver.findElement(By.xpath("//label[text()='Promotion Description'][1]//following-sibling::input")).sendKeys("Testing");
		driver.findElement(By.xpath("//label[text()='Discount Type']//following-sibling::select")).click();
		Select sel=new Select(driver.findElement(By.xpath("//label[text()='Discount Type']//following-sibling::select")));
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//label[text()='Discount Of']//following-sibling::input")).sendKeys("100");
		driver.findElement(By.xpath("//label[text()='Max use(per user)']//following-sibling::input")).sendKeys("10");
		driver.findElement(By.xpath("//label[text()='Valid From']//following-sibling::input")).sendKeys("19-22-2024");
		driver.findElement(By.xpath("//label[text()='Valid Until']//following-sibling::input")).sendKeys("06-22-2025");

		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
