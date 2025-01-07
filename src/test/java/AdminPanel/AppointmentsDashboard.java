package AdminPanel;//working

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AppointmentsDashboard {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();

        driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[1]")).click();
        //Dashboard
        driver.findElement(By.xpath("//span[contains(text(),'Dashboard ')]")).click();

        Select Range=new Select(driver.findElement(By.xpath("//select[@class='AppointmentDashboard_Pre_select']")));
        //we can change the range
        Range.selectByIndex(0);

        //if we need Custom range - use these below lines - custom -0- otherwise comment below 8 lines
        WebElement fromDateField = driver.findElement(By.xpath("//input[@class='AppointmentDashboard_FromDate']"));
        fromDateField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fromDateField.sendKeys(Keys.DELETE);
        fromDateField.sendKeys("04/12/2024");

        WebElement toDateField = driver.findElement(By.xpath("//input[@class='AppointmentDashboard_ToDate']"));
        toDateField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        toDateField.sendKeys(Keys.DELETE);
        toDateField.sendKeys("07/01/2025");

        WebElement SelectADoctor = driver.findElement(By.xpath("//div[@class=' css-1s2u09g-control']"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(SelectADoctor).click().sendKeys("Aditi").sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);


    }
    }
