package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostOnLinkedIn{
    ChromeDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 30);
    public void testCase01(ChromeDriver driver){
        // INTV Session-4 Activity 3
        // Navigate to given URL  https://in.linkedin.com/
        driver.get("https://in.linkedin.com/");
        // Type username in "Email or Phone" field Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("abc@gmail.com");
        // Type password in "Password" field Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("user@12");
        // Click on "Sign In" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        // Print the count of "Who's viewed your profile" Using Locator "XPath" //*[contains(text(),'viewed your profile')]/../../following-sibling::div/span/strong
        System.out.println("Who's viewed your profile : "  + driver.findElementByXPath("//*[contains(text(),'viewed your profile')]/../../following-sibling::div/span/strong").getText());
        // Print the count of "Impressions of your post" Using Locator "XPath" //*[text()='Impressions of your post']/../../following-sibling::div/span/strong
        System.out.println("Impressions of your post : " + driver.findElementByXPath("//*[text()='Impressions of your post']/../../following-sibling::div/span/strong").getText());
        // Click on "Start a post" button Using Locator "XPath" //button[contains(@class,'share-box-feed-entry__trigger')]
        driver.findElementByXPath("//button[contains(@class,'share-box-feed-entry__trigger')]").click();
        // Verify that setting is set to "Anyone" or "Connections Only" Using 
        WebElement viewSetting = driver.findElementByXPath("//button//div[@class='truncate artdeco-entity-lockup__subtitle ember-view']");
        wait.until(ExpectedConditions.visibilityOf(viewSetting));
        // "If ""Connections Only"" text is not displayed then Click on dropdown to change post visibility option 
        // Using Locator ""Class"" Name share-unified-settings-entry-button__chevron-icon"
        if(!viewSetting.getText().equals("Post to Connections only")){
            driver.findElementByClassName("share-unified-settings-entry-button__chevron-icon").click();
            // Select "Connections only" option  Using Locator "ID" CONNECTIONS_ONLY
            driver.findElementById("CONNECTIONS_ONLY").click();
            // Click on "Done" button Using Locator "XPath" //div[@class='share-box-footer__main-actions']/button[contains(@class,'share-box-footer__primary-btn')]
            driver.findElementByXPath("//div[@class='share-box-footer__main-actions']/button[contains(@class,'share-box-footer__primary-btn')]").click();
        }
        // Type message in textbox Using Locator "XPath" //div[@role='textbox']
        driver.findElementByXPath("//div[@role='textbox']").sendKeys("Hi it's automated script message so please ignore");
        // Click on "Post" button Using Locator "XPath" //*[text()='Post']
        driver.findElementByXPath("//*[text()='Post']").click();
        // Verify that "Post Successful" message is displayed Using Locator "XPath" //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully : " + isDisplayed);
    }
}
