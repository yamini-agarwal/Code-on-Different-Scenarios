package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleNameLinks{
    ChromeDriver driver;

    public void testCase01(ChromeDriver driver){
        // INTV Session-4 Activity 4
        // Navigate to given URL  https://www.google.com/
        driver.get("https://www.google.com/");
        // Click on Search box Using Locator "Name" q
        WebElement search_box = driver.findElementByName("q");
        // Type "Yamini Agarwal" in search box Using Locator "Name" q
        search_box.sendKeys("Yamini");
        // Click on "Google Search" button Using Locator "XPath" (//input[@value='Google Search'])[1]
        driver.findElementByXPath("(//input[@value='Google Search'])[1]").click();
        // Locate all the hyperlinks on the webpage and get the total count of the hyperlinks Using Locator "Partial Link Text" yamini or Yamini
        int count = driver.findElementsByPartialLinkText("yamini").size(); 
        count += driver.findElementsByPartialLinkText("Yamini").size();
         // Print the count of hyperlinks found
         System.out.println("Count of links : " + count);
    }
}
