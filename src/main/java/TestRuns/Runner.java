package TestRuns;

import Pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static Properties.Property.*;

public class Runner {
    @Test
    public void selectVolksGolf_max25000k(){
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(link); //open main page

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectVWGolf_max25000km();
    }
}
