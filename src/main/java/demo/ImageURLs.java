package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageURLs{
    ChromeDriver driver;
    JavascriptExecutor j = (JavascriptExecutor) driver;

    public void testCase01(ChromeDriver driver){
        // INTV Session-4 Activity 5
        //Navigate to given URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // "Get the total count of image URLs for all the “Recommended Movies”  Using Locator
        //  ""XPath"" //*[text()='Recommended Movies']/../../../following-sibling::div//a"
        driver.findElementByXPath("//*[text()='Recommended Movies']/../../../following-sibling::div//*[local-name()='svg']").click();
        int count = driver.findElementsByXPath("//*[text()='Recommended Movies']/../../../following-sibling::div//a").size();
        // Print the URLs
        System.out.println("Total count of Recommended Movies : " + count);
        // driver.navigate().refresh();
        // "Get the total count of image URLs for all the
        // “Premiere” list Using Locator ""XPath"" //*[text()='Premieres']/../../../following-sibling::div//a"
        List<WebElement> premieres = driver.findElementsByXPath("//*[text()='Premieres']/../../../following-sibling::div//a");
        j.executeScript("arguments[0].scrollIntoView();", premieres);
        // Get the name of "Premiere" movies list Using Locator "XPath" //div[@class='sc-7o7nez-0 fyTNyu']
        WebElement premiere =  premieres.get(1);
        String name = premiere.findElement(By.xpath("//div[@class='sc-7o7nez-0 fyTNyu']")).getText();
        // Get the language of "Premiere" movies list Using Locator "XPath" //div[@class='sc-7o7nez-0 eeVqLW']
        String language = premiere.findElement(By.xpath("//div[@class='sc-7o7nez-0 eeVqLW']")).getText();
        // "Print name and language of premiere movies which is on second position  "
        System.out.println("Details of 2nd Premiere movies are : Name = " + name + "Language = " + language);
    }
}
