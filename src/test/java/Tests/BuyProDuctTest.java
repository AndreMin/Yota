package Tests;

import Driver.MyDriverFactory;
import Pages.BalancePages;
import Pages.SliderPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Andrej on 06.02.2017.
 */
public class BuyProDuctTest extends BaseTest {


    @BeforeSuite
    public void setUp() throws Exception {
        System.out.println("Starting BuyProDuctTest");
        driver = new MyDriverFactory().getDriver();

        driver.get(url);
        sl = new SliderPage(driver);
    }


    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("BuyProDuctTest done");
    }

    @Test(dataProvider = "executeString2")
    //"Тест проверяет покупку продукта: Продукт стал текущим, списание средств"
    public void testBuyProduct(int d1, String d2, int d3) throws Exception {

        BalancePages a = new BalancePages(driver);
        int beforeBuy = a.getBalance();
        a = sl.viewAndBuy(d3);
        Thread.sleep(100);
        Assert.assertEquals(a.getBalance(), beforeBuy, "wrong decommissioning funds");
        Assert.assertEquals(a.getCurrentCost(), d3, "Cost not current");
        Assert.assertEquals(a.getCurrentTime(), d1, "Duration not current");
        Assert.assertEquals(a.getCurrentSpeed(), d2, "Speed not current");

    }


    @DataProvider(name = "executeString2")
    public Object[][] createTestData2() {
        return new Object[][]{

                new Object[]{0, "320", 300},
                new Object[]{0, "416", 350},
                new Object[]{0, "512", 400},
                new Object[]{0, "640", 450},
                new Object[]{0, "768", 500},
                new Object[]{0, "896", 550},
                new Object[]{0, "1.0", 600},
                new Object[]{0, "1.3", 650},
                new Object[]{0, "1.7", 700},
                new Object[]{0, "2.1", 750},
                new Object[]{0, "3.1", 800},
                new Object[]{0, "4.1", 850},
                new Object[]{0, "5.0", 900},
                new Object[]{0, "5.7", 950},
                new Object[]{0, "6.4", 1000},
                new Object[]{0, "7.1", 1050},
                new Object[]{0, "7.8", 1100},
                new Object[]{0, "8.5", 1150},
                new Object[]{0, "9.2", 1200},
                new Object[]{0, "10.0", 1250},
                new Object[]{0, "12.0", 1300},
                new Object[]{0, "15.0", 1350},
                new Object[]{0, "Макс", 1400}
        };


    }
}
