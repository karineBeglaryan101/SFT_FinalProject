package pages;

import locators.BrandPageConstants;
import locators.QuicklookPageConstants;
import locators.SearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SearchPage {
    private WebDriver driver;
    private String item;
    private By under = By.xpath(SearchPageConstants.under25);
    private By filter = By.id(SearchPageConstants.filter);
    private By productGrid = By.xpath(SearchPageConstants.products);
    private By quicklook = By.xpath(QuicklookPageConstants.quicklook);
    private By brandHeading = By.id(BrandPageConstants.brandHeading);
    private By brands = By.xpath(BrandPageConstants.firstBrand);


    public SearchPage(WebDriver driver,String item){
        this.driver=driver;
        this.item=item;
    }




    public boolean incorrectSpelling(String correctSpelling){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3500)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        return helper(products, correctSpelling);
    }



    public boolean elements(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3500)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        return helper(products, item);
    }



    public boolean helper(List<WebElement> products, String correctSpelling){
        boolean condition = false;
        if(products.isEmpty()){
            return false;
        }else{
            for (int i = 0; i < products.size(); i++) {
                WebElement b = products.get(i);
                if(b.getText().toLowerCase().contains(correctSpelling.toLowerCase())){
                    condition = true;
                }else{
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }

    public boolean elementsNotExisting(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3500)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        return helper(products, item);
    }


    public void filterSearch(){
        WebElement f = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(filter));
        f.click();

    }

    public FilterPage filter(){
        filterSearch();
        WebElement u = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(under));
        u.click();
        return new FilterPage(driver);
    }



    public QuicklookPage quicklook(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3500)");
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((productGrid)));
        List<WebElement> quicklookproducts =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy ((quicklook)));
        return new QuicklookPage(driver, products, quicklookproducts);
    }


    public BrandPage oneBrand(String a) {
        WebElement b = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(brandHeading));
        b.click();
        List<WebElement> checkboxes = driver.findElements(brands);
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().substring(0, checkbox.getText().indexOf(" ")).toLowerCase().contains(a.toLowerCase())) {
                checkbox.click();
                break;
            }

        }
        return new BrandPage(driver);
    }



    public BrandPage brandPage2filters(String brand1, String brand2) {
        WebElement b = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(brandHeading));
        b.click();
        List<WebElement> checkboxes = driver.findElements(brands);
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().substring(0, checkbox.getText().indexOf(" ")).toLowerCase().contains(brand1.toLowerCase())
            || checkbox.getText().substring(0, checkbox.getText().indexOf(" ")).toLowerCase().contains(brand2.toLowerCase())) {
                checkbox.click();
            }

        }
        return new BrandPage(driver);

    }


}
