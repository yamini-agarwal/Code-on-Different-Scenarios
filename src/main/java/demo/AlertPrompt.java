package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPrompt{
    ChromeDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 30);

    public void testCase01(ChromeDriver driver){
        // INTV Session-5 Activity 3
        // Navigate to given URL https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // Switch to result frame Using Locator "XPath" //iframe[@id='iframeResult']
        driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='iframeResult']"));
        // Click on "Try It" button Using Locator "XPath" //button[@onclick='myFunction()']
        driver.findElementByXPath("//button[@onclick='myFunction()']").click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        // Print the text on alert  
        System.out.println("Text on alert : " + alert.getText());
        // Type "Yamini" in alert box  
        alert.sendKeys("Yamini");
        // Click on Ok  
        alert.accept();
        // Verify that "Yamini" is displayed or not  Using Locator "XPath" //body[@contenteditable='false']/p[@id='demo']
        String text = driver.findElementByXPath("//body[@contenteditable='false']/p[@id='demo']").getText();
        System.out.println("Result after send text in alert : " + text);
        boolean isDisplayed = text.contains("Yamini");
        System.out.println("Yamini name is diplayed in text box : " + isDisplayed);
    }
}
