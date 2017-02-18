package Tests;

import Driver.MyDriverFactory;
import Pages.BalancePages;
import Pages.SliderPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Andrej on 17.02.2017.
 */
public class TestNewOffer extends BaseTest {

    @BeforeSuite
    public void setUp() throws Exception {
        System.out.println("Starting TestNewOffer");
        driver = new MyDriverFactory().getDriver();

        driver.get(url);
        sl = new SliderPage(driver);
    }


    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("TestNewOffer done");
    }

    @Test(dataProvider = "executeString")
    //"Тест проверяет что по нажатию вправо будут отображены новые условия для подключения и кнопка 'Поодключить' не активна "
    public void testNewOffer(int d1, String d2, int d3) throws Exception {

        BalancePages a = sl.slideRight();
        Assert.assertEquals(a.getNewCost(), d3, "Cost not current");
        Assert.assertEquals(a.getNewTime(), d1, "Duration not current");
        Assert.assertEquals(a.getNewSpeed(), d2, "Speed not current");
        Assert.assertTrue(sl.btnDsbl(), "Active but expected disable");

    }

    @DataProvider(name = "executeString")
    public Object[][] createTestData() {
        return new Object[][]{

                new Object[]{30, "320", 300},
                new Object[]{30, "416", 350},
                new Object[]{30, "512", 400},
                new Object[]{30, "640", 450},
                new Object[]{30, "768", 500},
                new Object[]{30, "896", 550},
                new Object[]{30, "1.0", 600},
                new Object[]{30, "1.3", 650},
                new Object[]{30, "1.7", 700},
                new Object[]{30, "2.1", 750},
                new Object[]{30, "3.1", 800},
                new Object[]{30, "4.1", 850},
                new Object[]{30, "5.0", 900},
                new Object[]{30, "5.7", 950},
                new Object[]{30, "6.4", 1000},
                new Object[]{30, "7.1", 1050},
                new Object[]{30, "7.8", 1100},
                new Object[]{30, "8.5", 1150},
                new Object[]{30, "9.2", 1200},
                new Object[]{30, "10.0", 1250},
                new Object[]{30, "12.0", 1300},
                new Object[]{30, "15.0", 1350},
                new Object[]{30, "Макс", 1400}
        };


    }
}
