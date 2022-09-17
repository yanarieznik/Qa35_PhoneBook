import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();

        }

    }


    @Test
    public void loginSuccess() {

        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm("yanalanda7@gmail.com", "Yyana12345$");
        app.getHelperUser().submitLogin();


    }



}