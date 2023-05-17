package demo;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle{
    ChromeDriver driver;

    public void testCase01(ChromeDriver driver){
        // Navigate to given URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // Switch to result frame Using Locator "XPath" //iframe[@id='iframeResult']
        driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='iframeResult']"));
        // Click on "Try It" button Using Locator "XPath" //button[@onclick='myFunction()']
        driver.findElementByXPath("//button[@onclick='myFunction()']").click();
        // Get all the window handles  
        String parent = driver.getWindowHandle();
        Set<String>windows=driver.getWindowHandles();
        // Switch to new window  
        for(String window : windows){
            if(!window.equals(parent)){
                driver.switchTo().window(window);
                // Get the URL,Title, and take the screenshot  
                System.out.println("URL of the window : " + driver.getCurrentUrl());
                System.out.println("Title of the window : " + driver.getTitle());
                TestCases.takeScreenshot(driver, "New_Window");
                // Close the new window
                driver.close();
            }
        } 
        // Switch back to the original window 
        driver.switchTo().window(parent);
    }  
}
