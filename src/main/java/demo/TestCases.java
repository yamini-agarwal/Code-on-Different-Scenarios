package demo;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;
// import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
// import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.AWTException;
// import java.awt.AWTException;
// import java.awt.Robot;
// import java.awt.Toolkit;
// import java.awt.datatransfer.StringSelection;
// import java.awt.event.KeyEvent;
import java.io.File;

//Selenium Imports
// import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.By.ByXPath;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;
    JavascriptExecutor j;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        j = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public static void takeScreenshot(ChromeDriver driver, String description) {
		try {
			File theDir = new File("/screenshots");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			// String timestamp = String.valueOf(java.time.LocalDateTime.now());
			String fileName = String.format("screenshot_%s.png", description);

			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File("screenshots/" + fileName);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void run() throws AWTException{
        SearchAmazon activity_01 = new SearchAmazon();
        activity_01.testCase01(driver);

        CountHyperlinks activity_02 = new CountHyperlinks();
        activity_02.testCase01(driver);

        PostOnLinkedIn activity_03 = new PostOnLinkedIn();
        activity_03.testCase01(driver);

        GoogleNameLinks activity_04 = new GoogleNameLinks();
        activity_04.testCase01(driver);

        ImageURLs activity_05 = new ImageURLs();
        activity_05.testCase01(driver);

        Image_VideoOnLinkedIn activity_06 = new Image_VideoOnLinkedIn();
        activity_06.testCase01(driver);

        NestedFramesText activity_07 = new NestedFramesText();
        activity_07.testCase01(driver);

        AlertPrompt activity_08 = new AlertPrompt();
        activity_08.testCase01(driver);

        IMDBRatings activity_09 = new IMDBRatings();
        activity_09.testCase01(driver);

        WindowHandle activity_10 = new WindowHandle();
        activity_10.testCase01(driver);
    }
}
