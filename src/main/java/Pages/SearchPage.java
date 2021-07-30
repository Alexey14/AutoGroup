package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static Properties.Property.*;
import static Properties.Locators.*;
import static Utilities.Utility.*;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver){
        if (!driver.getCurrentUrl().contains(link)) {
            throw new AssertionError("This is not the page you are expected!");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    void waitTime(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //timeout for wait elements
    }

    void closeDriver(){
        driver.quit();
    }

    void clickOnBrandButton(){
        driver.findElement(By.cssSelector(btnBrandFilter_byCSS)).click();
    }

    void clickOnBrand(){
        driver.findElement(By.cssSelector(selectValue_byCSS(brandVolkswagen))).click();
    }

    void clickOnModel(String nameModel){
        driver.findElement((By.cssSelector(selectValue_byCSS(nameModel)))).click();
    }

    void clickOnBasicFilter(){
        driver.findElement(By.cssSelector(btnBasicFilter_byCSS)).click();
    }

    void clickOnMaxMileageFilter(){
        driver.findElement(By.cssSelector(btnMaxMileage_byCSS)).click();
    }

    void selectMileage(){
        driver.findElement((By.xpath(setTextValueInSelector_byXPath(mileage)))).click();
    }

    void isFiltersCorrect_for3filters(String filters, String filter_1, String filter_2, String filter_3){
        for (Object data : getArrayTextsFromSelectors_byCSS(driver, filters)){
            String a = data.toString();

            if(a.substring(a.length()-filter_1.length()).equals(filter_1)
                || a.substring(a.length()-filter_2.length()).equals(filter_2)
                || a.substring(a.length()-filter_3.length()).equals(filter_3));
            else throw new AssertionError("Filter's can't be applied!");
        }
    }

    public void selectVWGolf_max25000km(){
        waitTime();

        clickOnBrandButton();
        clickOnBrand();
        clickOnModel(modelGolf);
        clickOnBasicFilter();
        clickOnMaxMileageFilter();
        selectMileage();
        clickOnBasicFilter();
        isFiltersCorrect_for3filters(filters_byCSS, mileage, brandVolkswagen, modelGolf);
        closeDriver();
    }
}
