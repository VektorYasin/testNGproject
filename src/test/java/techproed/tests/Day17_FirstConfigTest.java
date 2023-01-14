package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;

public class Day17_FirstConfigTest {

    @Test
    public void firstConfigTest() {

//      Go to techproed homepage
//      Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));

//      Assert the title
//      assertEquals("Techpro Education | Online It Courses & Bootcamps", Driver.getDriver().getTitle()); //==> Hard Codding
        assertEquals(ConfigReader.getProperty("app_title"), Driver.getDriver().getTitle());


    }
}