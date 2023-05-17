package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAmazon{
    ChromeDriver driver;
     
    public void testCase01(ChromeDriver driver){
        // INTV Session-4 Activity 1
        // Navigate to given URL https://www.google.com/
        driver.get("https://www.google.com/");
        // Click on Search box Using Locator "Name" q
        WebElement search_box = driver.findElement(By.name(("q")));
        // Type "Amazon" in search box Using Locator "Name" q
        search_box.sendKeys("Amazon");
        // Click on "Google Search" button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
        // Verify that "Amazon.in" is displayed in search result Using Locator "XPath"
        // //h3[text()='Amazon.in']
        boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed();
        System.out.println("Amazon.in is displayed in search result : " + isDisplayed);
    }
    
}
