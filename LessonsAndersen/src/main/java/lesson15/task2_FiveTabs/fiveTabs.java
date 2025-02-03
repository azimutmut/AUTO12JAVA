package lesson15.task2_FiveTabs;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WindowType;
    import org.openqa.selenium.chrome.ChromeDriver;
    import utils.driver.consts.URL;

public class fiveTabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL.AUTO.getUrl());
        String link1 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL.W3.getUrl());
        String link2 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL.ZOO.getUrl());
        String link3 = driver.getWindowHandle();
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL.LAB.getUrl());
        String link4 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL.SPEED.getUrl());
        String link5 = driver.getWindowHandle();

        String[] links = new String[5];
        links[0] = link1;
        links[1] = link2;
        links[2] = link3;
        links[3] = link4;
        links[4] = link5;
        Thread.sleep(1000);

        for (String link : links) {
            driver.switchTo().window(link);
            String title = driver.getTitle();
            System.out.println(title);
            System.out.println(driver.getCurrentUrl());
            System.out.println(" ");
            Thread.sleep(1000);

            String titleZoo = title.substring(0,3);
            String zoo = "Zoo";
            if(titleZoo.equals(zoo)){
                driver.close();
            }
        }
        Thread.sleep(1000);
        driver.quit();
    }
}

