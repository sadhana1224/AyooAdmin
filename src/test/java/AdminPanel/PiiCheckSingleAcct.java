package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PiiCheckSingleAcct {
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

        driver.findElement(By.id("loginbtn")).click();

        //Dashboard-- Add User
        driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
        driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys("Aadhdn");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("v");
        driver.findElement(By.xpath("//input[@placeholder='DD-MM-YYYY']")).sendKeys("01/01/2000");
        Select sel=new Select(driver.findElement(By.name("gender")));
        sel.selectByIndex(1);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jixovo1532@bflcafe.com");
        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("3404048666");
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Hsr");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Karnataka");
        driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("566054");
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");


        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        Thread.sleep(3000);
        //Select sel1=new Select(driver.findElement(By.xpath("//select[@id='maritalstatus']")));
        //sel1.selectByIndex(1);

        //check Pop up is closed or not
        driver.findElement(By.xpath("//div[@class='customProfileExistModal_closeIcon']")).click();
        Thread.sleep(3000);
        //Pii Pop Up
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='ProfileExistModal_Link']")).click();
        Thread.sleep(5000);
        //resend reg link- for unreg user- check otherwise comment the below line
      //  driver.findElement(By.xpath("//div[@class='ResetPassButton']")).click();

        //reset pwd link- for registered user
        driver.findElement(By.xpath("//div[@class='ResetPassButton']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ResetPassword-container_ButtonsYes']")).click();




    }
}
