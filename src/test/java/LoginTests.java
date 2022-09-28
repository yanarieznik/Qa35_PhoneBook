import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }

    @Test
    public void loginSuccessModel() {


        User user = new User().withEmail("yanalanda7@gmail.com").withPassword("Yyana12345$");


        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());


    }


    @Test
    public void loginNegativeWrongEmailFormat() {

        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(new User().withEmail("yanalanda7gmail.com").withPassword("Yyana12345$"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErroeWrongFormat());


    }

    @Test
    public void loginNegativeWrongPasswordFormat() {
        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(new User().withEmail("yanalanda7@gmail.com").withPassword("Yyana"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());


    }


}
