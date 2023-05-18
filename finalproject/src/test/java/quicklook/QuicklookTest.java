package quicklook;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FilterPage;
import pages.QuicklookPage;
import pages.SearchPage;

public class QuicklookTest extends BaseTest {

    @Test
    public void testQuickLookFunctionality(){
        SearchPage search = homePage.search("rare beauty");
        QuicklookPage element = search.quicklook();
        boolean result = element.name();
        Assert.assertEquals(result,true);
    }


}
