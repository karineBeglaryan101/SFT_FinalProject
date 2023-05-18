package filter;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FilterPage;
import pages.SearchPage;

public class FilterTest extends BaseTest {

    @Test
    public void testFilterUnder25(){
        SearchPage search = homePage.search("rare beauty");
        FilterPage page = search.filter();
        boolean result = page.under25();
        Assert.assertEquals(result,true);
    }

    @Test
    public void testFilterBetween50And100(){
        SearchPage search = homePage.search("fenty beauty");
        FilterPage page = search.filter();
        boolean result = page.between50And100();
        Assert.assertEquals(result,true);
    }

    @Test
    public void testFilterCustom(){
        SearchPage search = homePage.search("sol de janeiro");
        FilterPage page = search.filter();
        boolean result = page.custom("10", "30");
        Assert.assertEquals(result,true);
    }


    //the website will not let you enter not numbers, so selenium will wait until it is allowing it, but it will never allow
    // it to be clicked, so in this test i check if the timeoutException is thrown and if it is the website reacts correctly
    // to letters instead of numbers.
    @Test
    public void testFilterCustomNotNumbers(){
        SearchPage search = homePage.search("fenty beauty");
        FilterPage page = search.filter();
        boolean result = page.customFail("zbjah", "abzhs");
        Assert.assertEquals(result,true);
    }

    @Test
    public void testFilterCustom0s(){
        SearchPage search = homePage.search("fenty beauty");
        FilterPage page = search.filter();
        boolean result = page.customWrongNumbers("0", "0");
        Assert.assertEquals(result,true);
    }

   // it wont let to put too long numbers so its going to give the same exception as @testFilterCustomNotNumbers()
    // that's why I am using the same method
    @Test
    public void testFilterCustomTooLongNumbers(){
        SearchPage search = homePage.search("fenty beauty");
        FilterPage page = search.filter();
        boolean result = page.customFail("1200000", "02884");
        Assert.assertEquals(result,true);
    }


    @Test
    public void testFilterCustomTooHighValue(){
        SearchPage search = homePage.search("rare beauty");
        FilterPage page = search.filter();
        boolean result = page.customWrongNumbers("1200", "7800");
        Assert.assertEquals(result,true);
    }




}
