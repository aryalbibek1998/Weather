package weather;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class Weather {

    public static WebDriver webDriver = new ChromeDriver();

    static Temp temp = new Temp(webDriver);

    public static void main(String[] args) throws InterruptedException {
        Temp.nepTemp();
    }}










