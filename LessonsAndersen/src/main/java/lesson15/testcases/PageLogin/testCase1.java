package lesson15.testcases.PageLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("S.Iaffwnfeffdsorv@gmail.com");
//        driver.findElement(By.id("login-email")).sendKeys("sample@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("string123");
        Thread.sleep(1000);

        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);

//        driver.findElement(By.id("login-password")).sendKeys("Sample@123");
//        driver.findElement(By.xpath("//button[text()='Sing   in']")).click();
//        time.sleep(2000);

    }
}