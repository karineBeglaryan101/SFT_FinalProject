package brand;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandPage;
import pages.QuicklookPage;
import pages.SearchPage;

public class BrandTest extends BaseTest {

    @Test
    public void testValentino(){
        SearchPage search = homePage.search("perfume");
        BrandPage page = search.oneBrand("Valentino");
        boolean result = page.elementsOneBrand("Valentino");;
        Assert.assertEquals(result,true);
    }


    @Test
    public void testChanel(){
        SearchPage search = homePage.search("perfume");
        BrandPage page = search.oneBrand("Chanel");
        boolean result = page.elementsOneBrand("Chanel");;
        Assert.assertEquals(result,true);
    }


    @Test
    public void testBoth(){
        SearchPage search = homePage.search("perfume");
        BrandPage page = search.brandPage2filters("Valentino", "Chanel");
        boolean result = page.elements("Valentino", "Chanel");
        Assert.assertEquals(result,true);
    }

}
