package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.*;


import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By searchField = By.id(HomePageConstants.searchBar);
    private By name = By.className(HomePageConstants.logo);
    private By popUpPicture = By.xpath(HomePageConstants.popUp);
    private By USA = By.xpath(HomePageConstants.USA);


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPopUp(){
        WebElement popIt = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(popUpPicture));
        popIt.click();
        WebElement u = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(USA));
        u.click();
    }


    public void fillSearch(String a){
        clickPopUp();
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(searchField));
        searchButton.sendKeys(a);
        searchButton.submit();
    }

    
    public SearchPage search(String searchItem){
        fillSearch(searchItem);
        return new SearchPage(driver,searchItem);
    }




}
