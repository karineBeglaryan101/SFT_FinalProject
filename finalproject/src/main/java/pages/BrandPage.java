package pages;

import locators.BrandPageConstants;
import locators.SearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrandPage {
    private WebDriver driver;
    private By productGrid = By.xpath(BrandPageConstants.products);


    public BrandPage(WebDriver driver){
        this.driver=driver;
    }


    public boolean elementsOneBrand(String brand1){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3500)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        return helper(products, brand1);
    }

    public boolean elements(String brand1, String brand2){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,4000)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        return helper(products, brand1, brand2);
    }



    public boolean helper(List<WebElement> products, String brand1){
        boolean condition = false;
        if(products.isEmpty()){
            return false;
        }else{
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.size());

                WebElement b = products.get(i);
                System.out.println(b.getText());
                if(b.getText().toLowerCase().contains(brand1.toLowerCase())){
                    condition = true;
                }else{
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }

    public boolean helper(List<WebElement> products, String brand1, String brand2){
        boolean condition = false;
        if(products.isEmpty()){
            return false;
        }else{
            for (int i = 0; i < products.size(); i++) {
                WebElement b = products.get(i);
                if(b.getText().toLowerCase().contains(brand1.toLowerCase()) || b.getText().toLowerCase().contains(brand2.toLowerCase())){
                    condition = true;
                }else{
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }





}
