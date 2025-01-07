package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddDoctor {
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='pro-inner-item']//span[contains(text(),'Add Doctor ')])")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Test Doctor");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Doctor");
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("1995-05-22");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sakejon562@matmayer.com");
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9785463240");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sadhu@12345");
        Select gender=new Select(driver.findElement(By.xpath("//select[@id='gender']")));
        gender.selectByIndex(1);
        //20 mins
       WebElement tmins= driver.findElement(By.xpath("//input[@id='virtual_consulting_fees_20_mins']"));
       tmins.clear();
       tmins.sendKeys("0");
        //30 mins
        WebElement tmins1= driver.findElement(By.xpath("//input[@id='virtual_consulting_fees_30_mins']"));
        tmins1.clear();
        tmins1.sendKeys("1500");
        //60 mins
        WebElement tmins2=driver.findElement(By.xpath("//input[@id='virtual_consulting_fees_60_mins']"));
        tmins2.clear();
        tmins2.sendKeys("0");

        driver.findElement(By.xpath("//input[@id='profilename']")).sendKeys("Sadhana Testt");

        //Doctor Type
        Select doctype=new Select(driver.findElement(By.xpath("//select[@id='doctortype']")));
        doctype.selectByIndex(2);

        //Care Type
        Select caretype=new Select(driver.findElement(By.xpath("(//select[@class='form-control'])[3]")));
        caretype.selectByIndex(1);
        Thread.sleep(3000);

        //Specialization
        Select spl=new Select(driver.findElement(By.xpath("//select[@id='specialization']")));
        spl.selectByIndex(3);

        //languages
        driver.findElement(By.xpath("//input[@id='languages']")).sendKeys("English, Hindi, Tamil");
        driver.findElement(By.xpath("//input[@id='graduation']")).sendKeys("MBBS");
        driver.findElement(By.xpath("//input[@id='masters']")).sendKeys("MD (Psychiatry)");

        //20 mins
        WebElement cmins= driver.findElement(By.xpath("//input[@id='clinic_consulting_fees_20_mins']"));
        cmins.clear();
        cmins.sendKeys("0");
        //30 mins
        WebElement cmins1= driver.findElement(By.xpath("//input[@id='clinic_consulting_fees_30_mins']"));
        cmins1.clear();
        cmins1.sendKeys("1500");
        //60 mins
        WebElement cmins2=driver.findElement(By.xpath("//input[@id='clinic_consulting_fees_60_mins']"));
        cmins2.clear();
        cmins2.sendKeys("0");

        driver.findElement(By.xpath("//input[@id='additional_qualification']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='fellowship']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='residency']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='experience']")).sendKeys("5yrs");
//Practice Area
        WebElement dropdown = driver.findElement(By.id("react-select-2-input"));
        dropdown.click();
// First Practice Area
        dropdown.sendKeys("Psychiatry");
        dropdown.sendKeys(Keys.ENTER);
// Second Practice Area
        dropdown.sendKeys("Depression");
        dropdown.sendKeys(Keys.ENTER);
// Third Practice Area
        dropdown.sendKeys("Child Therapy");
        dropdown.sendKeys(Keys.ENTER);

        //Awards
        driver.findElement(By.xpath("//input[@id='awards']")).sendKeys("Best Therapist");
        driver.findElement(By.xpath("//input[@id='homeaddress']")).sendKeys("Agara,Bangalore");

        //Bio
        driver.findElement(By.xpath("//textarea[@id='bio']")).sendKeys("Her therapeutic practice is grounded in evidence-based methodologies with her work drawing from Cognitive Behavioral Therapy (CBT), Dialectical Behaviour Therapy (DBT), Acceptance and Commitment Therapy (ACT), and Behavior Therapy. This integrative approach allows her to deeply understand her clients' struggles and effectively guide them in managing their emotions and behaviors.");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

// Validate the message text
        String expectedMessage = "Doctor added success!";
        String actualMessage = successMessage.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Success message is validated: " + actualMessage);
        } else {
            System.out.println("Validation failed. Expected: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
}
