package lesson15.task4_and_5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.driver.consts.URL;
public class authorisationAndUploadingPhoto {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL.LOGIN.getUrl());
        driver.findElement(By.name("email")).sendKeys("S.Iaffwnfeffdsorv@gmail.com");
        driver.findElement(By.name("password")).sendKeys("string123");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("C:/Users/Username/Desktop/photo1.jpg");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img[alt='Close']")).click();
        Thread.sleep(1000);

        driver.quit();
    }
}
