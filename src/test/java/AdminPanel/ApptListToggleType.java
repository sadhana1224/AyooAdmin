package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ApptListToggleType {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[1]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[3]")).click();

        Select sel = new Select(driver.findElement(By.xpath("//select[@data-testid='filter-selector']")));
        //filter by-Patient name
        sel.selectByIndex(2);
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Sadhana");

        WebElement filter = driver.findElement(By.xpath("((//div[@class='booking-status-container'])//select)[1]"));
        filter.click();
        Select sel1 = new Select(filter);
        sel1.selectByIndex(7);
        Thread.sleep(3000);

        //check close button is working or not--in Pop up
        driver.findElement(By.xpath("//div//img[@alt='closeIcon']")).click();
        Thread.sleep(2000);
        WebElement filter1 = driver.findElement(By.xpath("((//div[@class='booking-status-container'])//select)[1]"));
        filter1.click();
        Select sel2 = new Select(filter);
        sel2.selectByIndex(7);
        Thread.sleep(3000);

        //check cancel is working or nor---- pop up
        driver.findElement(By.xpath("//div[@class='action-btns']//button[contains(text(),'Cancel')]")).click();
        WebElement filter2= driver.findElement(By.xpath("((//div[@class='booking-status-container'])//select)[1]"));
        filter2.click();
        Select sel3= new Select(filter);
        sel3.selectByIndex(7);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='confirm']")).click();

    }
}
