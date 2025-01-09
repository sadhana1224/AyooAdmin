package AdminPanel;//working- need time for date

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PatientPersonalProfileEdit {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Patients')])[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'All Patients ')]")).click();
        WebElement patientName=driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        patientName.sendKeys("Aaru");
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Aaru Sathya')]")).click();
        Thread.sleep(2000);
        //personal profile Edit
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='root']/div[2]/div[3]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")).click();
//        /
        Thread.sleep(2000);
                //div//img[@alt='Edit'])[1]ead.sleep(2000);
        //Firstname
        driver.findElement(By.xpath("(//div//input)[1]")).sendKeys("a");
        //last name
        driver.findElement(By.xpath("(//div//input)[2]")).sendKeys("H");
        //Dob
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        js.executeScript("arguments[0].setAttribute('value', '2001-11-16');", dateField);
        Thread.sleep(3000);

        //phone number
        WebElement inputField = driver.findElement(By.xpath("(//div//input)[4]"));
        inputField.click();
        inputField.sendKeys(Keys.BACK_SPACE); // Deletes one digit
// Add new text to update the field
        inputField.sendKeys("5");

        //Gender
        Select gender= new Select(driver.findElement(By.xpath("(//div//select)[2]")));
        gender.selectByVisibleText("Female");

        //Email
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));

        email.clear();
        //norix81291@nozamas.com
        email.sendKeys("geyida5404@gosarlar.com");
//address
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("254,cornerstreet");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Kartnataka");
        driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("560062");
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
        //Maritial Status
        Select maritialstatus=new Select(driver.findElement(By.xpath("//select[@name='maritalstatus']")));
        maritialstatus.selectByIndex(0);
        //Languages
        driver.findElement(By.xpath("//input[@name='lang1']")).sendKeys("English");
        driver.findElement(By.xpath("//input[@name='lang2']")).sendKeys("Tamil");

        driver.findElement(By.xpath("//div//button[contains(text(),'save')]")).click();

        Thread.sleep(2000);

        //Personal Doctor Details
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Aditi");
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("aditi@gmail.com");
        Select ph=new Select(driver.findElement(By.xpath("//select[@name='countrycode']")));
        ph.selectByIndex(1);
        driver.findElement(By.xpath("//input[@name='Mobile']")).sendKeys("5050505050");
        driver.findElement(By.xpath("//button[contains(text(),'save')]")).click();
    }
}
