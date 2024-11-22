package weather;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Temp {
    static WebDriver webDriver;

    public Temp(WebDriver webDriver) {
        Temp.webDriver = webDriver;
    }

    public static void nepTemp() throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.get("https://weather.com/weather/tenday/l/81875498401fd1c269fb07dce364db25ab4ee18a60c2ce3fedf0cee8f172016c");

        List<WebElement> wtempElements = webDriver.findElements(By.className("DetailsSummary--temperature--YGmQ5"));
        List<Integer> highTemps = new ArrayList<>();
        List<Integer> lowTemps = new ArrayList<>();
        List<Double> averages = new ArrayList<>();

        for (WebElement element : wtempElements) {
            String tempText = element.getText().replace("°", "").trim();
            if (tempText.contains("/")) {
                String[] temps = tempText.split("/");
                try {
                    int highTemp = Integer.parseInt(temps[0].trim());
                    int lowTemp = Integer.parseInt(temps[1].trim());
                    highTemps.add(highTemp);
                    lowTemps.add(lowTemp);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid temperature data: " + tempText);
                }
            } else {
                System.err.println("Unexpected format for temperature: " + tempText);
            }
        }

        // Calculate averages:
        for (int i = 0; i < highTemps.size(); i++) {
            double average = (highTemps.get(i) + lowTemps.get(i)) / 2.0;
            averages.add(average);
        }

        // Print the results
        System.out.println("High Temperatures: " + highTemps);
        System.out.println("Low Temperatures: " + lowTemps);
        System.out.println("Average Temperatures: " + averages);

        webDriver.quit();
    }
}


