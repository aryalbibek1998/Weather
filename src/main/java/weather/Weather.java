package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class weather {
    static WebDriver driver = new ChromeDriver();

    static void ForgetPassword() {
        try {

            // Navigate to the login page
            driver.get("https://weather.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println("Weather page will open");
    }}

