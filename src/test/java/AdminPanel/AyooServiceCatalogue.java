package AdminPanel;//pending - error in 36th line

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AyooServiceCatalogue {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Facilities')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'AYOO Clinics ')]")).click();
        Thread.sleep(2000);

        //click on the clinic
        driver.findElement(By.xpath("(//tr//a)[1]")).click();

        //Service Catalogue
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        driver.findElement(By.xpath("(//div//img[@alt='add'])[2]")).click();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dropdownInput = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownInput);
        js.executeScript("arguments[0].click();", dropdownInput);

// Continue with sending keys
        dropdownInput.sendKeys("SID-BX-0001");
        dropdownInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //lab service id
        driver.findElement(By.xpath("(//div//input)[12]")).sendKeys("Ayoo1");
        //price
        driver.findElement(By.xpath("(//input[@type='number'])[3]")).sendKeys("1500");
        //discount
        driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys("10");

        //home collection available if yes - put 7 in code, if no- 8
        driver.findElement(By.xpath("(//select//option)[8]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

    }
}
