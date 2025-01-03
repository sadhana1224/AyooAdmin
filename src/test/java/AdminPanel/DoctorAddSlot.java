package AdminPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DoctorAddSlot {
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
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Anam Feroze");
        driver.findElement(By.xpath("//h3[@class='box-title m-b-0']")).click();
        //Schedule
        driver.findElement(By.xpath("//a//span[contains(text(),'Schedule')]")).click();
        //Edit Slot
        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[1]")).click();

        // First Date Field (From Date)
        List<WebElement> dateFields = driver.findElements(By.cssSelector("input.DoctorSlotsManagement-FromDate_input"));
        WebElement dateField = dateFields.get(0); // First input field
        dateField.click();
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL) // Select All
                .sendKeys(Keys.BACK_SPACE) // Delete
                .perform();
        Thread.sleep(2000);
        dateField.sendKeys("01/03/2025"); // mm-dd-yyyy

// Second Date Field (To Date)
        WebElement dateField1 = dateFields.get(1); // Second input field
        dateField1.click();
        Thread.sleep(4000);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL) // Select All
                .sendKeys(Keys.BACK_SPACE) // Delete
                .perform();
        Thread.sleep(2000);
        dateField1.sendKeys("01/03/2026");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[1]")).click();
        //Add slots
        //if we need to delete the slots use below lines- monday to saturday- if we no need comment those lines(mon to sat)
        //Mon- In-c/vc
        driver.findElement(By.xpath("(//tr//td//span[text()='In-C/VC']/following-sibling::img[@alt='Delete'])[1]")).click();
        //Mon-Vc
        driver.findElement(By.xpath("(//tr//td//span[text()='VC']/following-sibling::img[@alt='Delete'])[1]")).click();

    }
}