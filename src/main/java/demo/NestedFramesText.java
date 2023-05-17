package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesText{
    ChromeDriver driver;

    public void testCase01(ChromeDriver driver){
        // INTV Session-5 Activity 2
        // Navigate to given URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Locating parent frame and switch into it Using Locator "Name" frame-top
        driver.switchTo().frame(driver.findElementByName("frame-top"));
        // Get the size of all child frames Using Locator "Tag Name" frame
        int childFrames = driver.findElementsByTagName("frame").size();
        // Switch child frame  
        // Get text of child frame Using Locator "Tag Name" body
        // Switch to parent frame  
        // Repeat steps 7 to 9 equal to child frame size  
        for(int i = 0; i < childFrames; i++){
            driver.switchTo().frame(i);
            System.out.println("Text : " + driver.findElementByTagName("body").getText());
            driver.switchTo().parentFrame();
        }
        // Switch to default frame  
        driver.switchTo().defaultContent();
        // Switch to another frame Using Locator "Name" frame-bottom
        driver.switchTo().frame(driver.findElementByName("frame-bottom"));
        // Get text of the frame  
        System.out.println("Text : " + driver.findElementByTagName("body").getText());
        // Switch to parent frame  
        driver.switchTo().parentFrame();
    }
}
