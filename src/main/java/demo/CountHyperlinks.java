package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class CountHyperlinks{
    ChromeDriver driver;

    public void testCase01(ChromeDriver driver){
        // INTV Session-4 Activity 2
        // Navigate to the URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate all the hyperlinks on the webpage and get the total count of the hyperlinks Using Locator "Tag Name" "a"
        int links = driver.findElementsByTagName("a").size(); 
        // Print the count of hyperlinks found
        System.out.println("Count of links : " + links);
    }
}
