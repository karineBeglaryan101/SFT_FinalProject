package pages;

import locators.QuicklookPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QuicklookPage {
    private WebDriver driver;
    private List<WebElement> elements;
    private List<WebElement> quickLooks;
    

    public QuicklookPage(WebDriver driver, List< WebElement> elements, List< WebElement> quickLooks ){
        this.driver = driver;
        this.elements = elements;
        this.quickLooks = quickLooks;
    }

    public boolean name(){
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().toLowerCase().contains(quickLooks.get(i).getText().toLowerCase())){
                continue;
            }else{
                return false;
            }

        }
        return true;

    }



}
