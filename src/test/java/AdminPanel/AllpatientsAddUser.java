package AdminPanel; //working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AllpatientsAddUser {
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

        //Add button
        driver.findElement(By.xpath("(//a//span)[1]")).click();
        driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys("Vinbo");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("W");
        driver.findElement(By.xpath("//input[@placeholder='DD-MM-YYYY']")).sendKeys("05/25/1995");
        Select sel=new Select(driver.findElement(By.name("gender")));
        sel.selectByIndex(1);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gehgh@datingel.com");
        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("5630094885");
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Hsr");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Karnataka");
        driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("566054");
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");


        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

    }
}
