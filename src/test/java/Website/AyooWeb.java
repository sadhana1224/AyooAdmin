package Website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AyooWeb {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/book-appointment");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[2]//a)[1]")));
		element.click();
		//driver.findElement(By.xpath("(//li[2]//a)[1]")).click();
		driver.findElement(By.xpath("//div[@class='main-logo']")).click();
		//driver.findElement(By.xpath("(//button[contains(text(),'Physical Health')])[2]")).click();
	//	driver.findElement(By.xpath("(//p[contains(text(),'Physician')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Find a Doctor')])[1]")).click();
Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,500)");














		/*
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/div[1]")).click();
		driver.findElement(By.id("Virtual")).click();
		Thread.sleep(15);
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[4]/div[1]")).click();

		//Date
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[10]/button[1]/img[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'5')]")).click();

		///driver.findElement(By.xpath("//button[text()='All']")).click();
		Thread.sleep(25);

		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Psychiatry')]")));

		 driver.findElement(By.xpath("//button[@value='60']")).click();

		 driver.findElement(By.xpath("//button[text()='11:00 AM']")).click();
		 Thread.sleep(5);
		 //promo code
		// driver.findElement(By.id("applyPromoCode")).sendKeys("PROMO1001");
		 driver.findElement(By.id("confirmAppointment")).click();
		 driver.findElement(By.xpath("//body/form[@id='TransactionForm']/div[1]/div[3]/div[2]/div[3]/div[4]/div[1]/ul[1]/li[3]/div[1]/span[2]")).click();


		 Select sel=new Select(driver.findElement(By.id("netBankingBank")));
		 sel.selectByIndex(1);

		 */
		//Thread.sleep(5);
		//driver.quit();
	}
}
