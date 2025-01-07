package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AllDoctorsEditDelete {
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();

        driver.findElement(By.xpath("(//div[@class='pro-inner-item']//span[contains(text(),'Doctors')])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='pro-inner-item']//span[contains(text(),'Doctors')])[2]")).click();
        //we can change the Doctor name here
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Sadhana Testt");

        driver.findElement(By.xpath("//a//i[@class='fa fa-edit p-r-10']")).click();
        WebElement editprofile=driver.findElement(By.xpath("//input[@id='firstname']"));
        editprofile.clear();
        editprofile.sendKeys("Test doctorr");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

    }
}
