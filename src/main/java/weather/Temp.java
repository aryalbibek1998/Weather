package weather;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;


import java.time.Duration;

public  class Temp {
    static WebDriver webDriver;

    public Temp(WebDriver webDriver) {
        Temp.webDriver = webDriver;
    }

  public  static void nepTemp() throws InterruptedException {
      webDriver.manage().window().maximize();
      webDriver.get(("https://weather.com/weather/tenday/l/81875498401fd1c269fb07dce364db25ab4ee18a60c2ce3fedf0cee8f172016c"));
      //Thread.sleep(1000);
      List<WebElement> lowTempElements = webDriver.findElements(By.className("DetailsSummary--lowTempValue--ogrzb"));
      List<WebElement> highTempElements = webDriver.findElements(By.className("DetailsSummary--highTempValue--VHKaO"));
      List<WebElement> DateTElements = webDriver.findElements(By.className("DetailsSummary--daypartName--CcVUz"));

      // Create a list to store the values
      List<String> lowTemps = new ArrayList<>();
      List<String> highTemps = new ArrayList<>();
      List<String> date = new ArrayList<>();
      List<Double> averages  = new ArrayList<>();

      // Extract and store text from each element
      for (WebElement element : lowTempElements) {
          lowTemps.add(element.getText());
      }
      for (WebElement element : highTempElements) {
          highTemps.add(element.getText());
      }
      for (WebElement element : DateTElements) {
          date.add(element.getText());
      }

      // Print the values

      System.out.println("Minimum Tempeture: " + lowTemps);
      System.out.println("Maximum Tempeture: " + highTemps);

      for (int i = 0; i < lowTemps.size(); i++) {
          String minTempStr = lowTemps.get(i).replace("°", "").trim();
          String maxTempStr = highTemps.get(i).replace("°", "").trim();

          if (!minTempStr.isEmpty() && !maxTempStr.isEmpty()) {
              double minTemp = Double.parseDouble(minTempStr);
              double maxTemp = Double.parseDouble(maxTempStr);

              double average = (minTemp + maxTemp) / 2.0;
              averages.add(average);
          }
      }

      // Print the averages
      System.out.println("Averages:   " + averages);
      System.out.println("Date:       " + date);

  }
}





