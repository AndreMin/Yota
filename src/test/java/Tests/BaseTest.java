package Tests;

import Driver.MyDriverFactory;
import Pages.SliderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



/**
 * Created by Andrej on 06.02.2017.
 */
public class BaseTest {
    protected WebDriver driver;
    protected SliderPage sl;


    String url = "http://localhost:4567/index.html";


    @BeforeClass
    public void startServer() throws Exception {
        Process process = Runtime.getRuntime().exec("java -jar test-slider-1.0.0-SNAPSHOT.jar");
    }

    @AfterClass
    public void beforeTest() {
        System.out.println("reset");

        sl.reset();
    }



}
