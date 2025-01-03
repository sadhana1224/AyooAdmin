package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AllPatientsFilters {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();
        //Filter By Patient name
        driver.findElement(By.xpath("(//span[contains(text(),'Patients')])[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'All Patients ')]")).click();
        WebElement patientName = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        patientName.sendKeys("Aathu");

        //Clear Filter
        Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'Clear Filter')]")).click();

        //Filter By PhoneNumber
        driver.findElement(By.xpath("//option[@value='mobile']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter Mobile']")).sendKeys("9688741481");
        //Clear Filter
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Clear Filter')]")).click();
        Thread.sleep(3000);

        //Filter By Email
        driver.findElement(By.xpath("//option[@value='Email']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("sadhana@ayoo.care");

        //Clear Filter
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Clear Filter')]")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
