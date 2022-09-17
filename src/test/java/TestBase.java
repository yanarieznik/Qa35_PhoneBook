import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;


public class TestBase {

    static ApplicationManager app = new ApplicationManager();


    @BeforeSuite
    public void setup() {
        app.init();

    }


    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}