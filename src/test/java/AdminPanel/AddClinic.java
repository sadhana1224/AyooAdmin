package AdminPanel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddClinic {
	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("sadhana@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("sadhana@ayoo");
		driver.findElement(By.id("loginbtn")).click();
		
		driver.findElement(By.xpath("(//span[@class=\"pro-icon\"]/ancestor::div[@class='pro-inner-item'])[7]")).click();
		driver.findElement(By.xpath("(//span[@class=\"pro-item-content\"]/ancestor::li[@class='pro-menu-item'])[13]")).click();
		driver.findElement(By.id("name")).sendKeys("Ayoo care  bbClinic");
		driver.findElement(By.id("address")).sendKeys("Hennur Karnataka");
		driver.findElement(By.id("mobile")).sendKeys("2233554466");
		driver.findElement(By.id("lat")).sendKeys("12.916775");
		driver.findElement(By.id("lon")).sendKeys("77.624188");
		
		Select sel1=new Select(driver.findElement(By.id("city")));
		sel1.selectByIndex(3);
		driver.findElement(By.id("starttime")).sendKeys("11.00AM");
		driver.findElement(By.id("endtime")).sendKeys("7.00PM");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	}

}
