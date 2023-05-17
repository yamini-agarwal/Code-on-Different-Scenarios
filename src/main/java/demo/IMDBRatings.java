package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IMDBRatings{
    ChromeDriver driver;

    public void testCase01(ChromeDriver driver){
        // INTV Session-5 Activity 4
        // Navigate to given URL  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        // Get the list of ratings for all movies Using Locator "XPath" //table/tbody/tr/td[contains(@class,'ratingColumn')]/strong
        List<WebElement> imdbColumn = driver.findElementsByXPath("//table/tbody/tr/td[contains(@class,'ratingColumn')]/strong");
        // "Get the name of the movie which have highest rating Using Locator ""XPath"" .//../preceding-sibling::td[@class='titleColumn']/a"
        List<Float> ratings = new ArrayList<>();
        for(int i = 0; i < imdbColumn.size(); i++){
           ratings.add(Float.parseFloat(imdbColumn.get(i).getText()));
        }
        float maxrating = Collections.max(ratings);
        WebElement highestRatedMovie;
        for(int i =0; i < ratings.size(); i++){
            if(ratings.get(i) == maxrating){
                highestRatedMovie =  imdbColumn.get(i);
                System.out.println("Highest Rated Movie Name : " + highestRatedMovie.findElement(By.xpath("./../preceding-sibling::td[@class='titleColumn']/a")).getText());
            }
        }        
        // "Get the count of How many movies are included in the table Using Locator ""XPath"" //table/tbody/tr"
        int totalMovies = driver.findElementsByXPath("//table/tbody/tr").size();
        System.out.println("Total movies in list = " + totalMovies);
        
        // Get the list of years Using Locator "XPath" //table/tbody/tr/td[@class='titleColumn']/span
        List<WebElement> releaseYears = driver.findElementsByXPath("//table/tbody/tr/td[@class='titleColumn']/span");
        List<Integer> years = new ArrayList<>();
        // Get the name of the oldest movie on the list Using Locator "XPath" .//preceding-sibling::a
        for(int i = 0; i < releaseYears.size(); i++){
            String text = releaseYears.get(i).getText();
            String[] year = text.split("\\(")[1].split("\\)");
            years.add(Integer.parseInt(year[0]));
        }
        int minYear = Collections.min(years);
        int indexOfYears = years.indexOf(minYear);
        WebElement oldestMovie =  releaseYears.get(indexOfYears);
        System.out.println("Oldest Movie in the list : " + oldestMovie.findElement(By.xpath(".//preceding-sibling::a")).getText());
        
        // Get the name of the most recent movie on the list Using Locator "XPath" .//preceding-sibling::a
        int maxYear = Collections.max(years);
        indexOfYears = years.indexOf(maxYear);
        WebElement recentMovie =  releaseYears.get(indexOfYears);
        System.out.println("Recent Movie in the list : " + recentMovie.findElement(By.xpath(".//preceding-sibling::a")).getText());
        // Split the values of title attribute(List of ratings)  
        List<Integer> userRatings = new ArrayList<>();
        for(int i = 0; i < imdbColumn.size(); i++){
            String[] titleRating = imdbColumn.get(i).getAttribute("title").split("on ")[1].split(" ");
            String rating = titleRating[0].replace(",", "");
            // Store the split value in a list  
            userRatings.add(Integer.parseInt(rating));
        } 
        // Sort the list  
        int maxUserrating = Collections.max(userRatings);
        int indexOfUserRatings = userRatings.indexOf(maxUserrating);
        WebElement mostUerRatingMovie =  releaseYears.get(indexOfUserRatings);
        // Print the name of movie have most user ratings  
        System.out.println("Most User Rating Movie in the list : " + mostUerRatingMovie.findElement(By.xpath(".//preceding-sibling::a")).getText());
    }
    
}
