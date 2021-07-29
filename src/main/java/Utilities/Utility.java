package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static String setTextValueInSelector_byXPath(String text){
        return "//*[text()='Bis']/..//*[text()='" + text + "']";
    }

    public static String selectValue_byCSS(String setValue){
        return "[value='" + setValue + "']";
    }

    public static List getArrayTextsFromSelectors_byCSS(WebDriver driver, String filters){
        List<WebElement> list = driver.findElements(By.cssSelector(filters));

        List<String> res = new ArrayList<String>();
        for(WebElement data : list){
            res.add(0, data.getText());
        }

        return res;
    }
}
