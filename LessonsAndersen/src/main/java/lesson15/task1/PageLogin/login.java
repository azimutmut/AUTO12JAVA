package lesson15.task1.PageLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("S.Iaffwnfeffdsorv@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("string123");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.quit();
    }
}