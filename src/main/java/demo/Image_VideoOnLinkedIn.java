package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image_VideoOnLinkedIn{
    ChromeDriver driver;
    JavascriptExecutor j = (JavascriptExecutor) driver;
    public void testCase01(ChromeDriver driver) throws AWTException{
        // INTV Session-5 Activity 1
        // Navigate to given URL  https://in.linkedin.com/
        driver.get("https://in.linkedin.com/");
        driver.findElementByName("session_key").sendKeys("abc@gmail.com");
        // Type password in "Password" field Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("user@12");
        // Click on "Sign In" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        // Click on Photo Option Using Locator "XPath" //div[contains(@class,'share-box-feed-entry__closed')]//button[@aria-label='Add a photo']/span
        driver.findElementByXPath("//div[contains(@class,'share-box-feed-entry__closed')]//button[@aria-label='Add a photo']/span").click();
        // Select a image from folders and put path of image in a clipboard
        Robot robot = new Robot();
        robot.delay(2000);

        StringSelection ss = new StringSelection("C:\\Users\\Anshul\\Desktop\\SDLC.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // //imitate mouse events like ENTER, CTRL+C, CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(250);
        // Click on done Using Locator "XPath" //button[contains(@class,'share-box-footer__primary-bt')]
        j.executeScript("arguments[0].click();", driver.findElementByXPath("//button[contains(@class,'share-box-footer__primary-bt')]"));
        // Click on "Post" button Using Locator "XPath" //*[text()='Post']
        driver.findElementByXPath("//*[text()='Post']").click();
        // Verify that "Post Successful" message is displayed Using Locator "XPath" //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully : " + isDisplayed);
    }
}
