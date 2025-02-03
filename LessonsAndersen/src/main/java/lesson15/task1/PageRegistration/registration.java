package lesson15.task1.PageRegistration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class registration {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/registration");
        Thread.sleep(1000);
        driver.findElement(By.name("firstName")).sendKeys("Aza");
        driver.findElement(By.name("lastName")).sendKeys("Mat");
        driver.findElement(By.name("dateOfBirth")).sendKeys("01/01/2000");

        Thread.sleep(2000);
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("aza@meat.com");
        driver.findElement(By.name("password")).sendKeys("qwerty123");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("qwerty123");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.quit();

    }
}