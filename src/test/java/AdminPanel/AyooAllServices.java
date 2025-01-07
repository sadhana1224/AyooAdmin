package AdminPanel;//workinng

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AyooAllServices {
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
        driver.findElement(By.xpath("//span[contains(text(),'All Services ')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//img[@alt='add']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div//input)[1]")).sendKeys("Test");
        //Service Type
        WebElement serviceType = driver.findElement(By.xpath("(//div[@class=' css-14el2xx-placeholder'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(serviceType).click().sendKeys("Allergy Testing").sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Modality
        WebElement Modality = driver.findElement(By.xpath("//div[contains(text(),'Select Modality')]"));
        Thread.sleep(2000);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(Modality).click().sendKeys("ECG").sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Tags
        WebElement Tags = driver.findElement(By.xpath("//div[contains(text(),'Select Tags')]"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(Tags).click().sendKeys("Full Body").sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Add
        driver.findElement(By.xpath("//button[@class='confirm']")).click();


    }
}
