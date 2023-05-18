package search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSuccessfulProductName(){
        SearchPage search = homePage.search("rare beauty");
        boolean result = search.elements();
        Assert.assertEquals(result,true);
    }

    @Test
    public void testSuccessfulProductNameAllCaps(){
        SearchPage search = homePage.search("RARE BEAUTY");
        boolean result = search.elements();
        Assert.assertEquals(result,true);
    }

    @Test
    public void testSuccessfulHalfProductName(){
        SearchPage search = homePage.search("fenty");
        boolean result = search.elements();
        Assert.assertEquals(result,true);
    }

    @Test
    public void testProductNameMisspelled(){
        SearchPage search = homePage.search("rare betu");
        boolean result = search.incorrectSpelling("rare beauty");
        Assert.assertEquals(result,true);
    }


    //The way the website works is that it will always output 20 items even if the product does not
    // exist. I think that logic is wrong so in this test I check if the name is included in the product, if
    // it's not, but there are still products output on the page it fails. The test fails as expected.
    @Test
    public void testUnSuccessfulProductName(){
        SearchPage search = homePage.search("zzmwjdhwjdqp");
        boolean result = search.elementsNotExisting();
        Assert.assertEquals(result,true);
    }


    @Test
    public void testSuccessfulCategory(){
        SearchPage search = homePage.search("lipstick");
        boolean result = search.elements();
        Assert.assertEquals(result,true);
    }

    //Same as the second test it still outputs elements which don't have anything to do with the category
    @Test
    public void testUnSuccessfulCategory(){
        SearchPage search = homePage.search("shoes");
        boolean result = search.elements();
        Assert.assertEquals(result,true);
    }



}
