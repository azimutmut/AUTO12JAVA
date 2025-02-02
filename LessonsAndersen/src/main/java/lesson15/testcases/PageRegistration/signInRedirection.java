package lesson15.testcases.PageRegistration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class signInRedirection {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/registration");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Sing in']")).click();
    }
}

