import manager.HelperBase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();


        }
    }

    @Test
    public void registrationSuccess() {
        System.currentTimeMillis();
        int a = (int) System.currentTimeMillis() / 1000 % 3600;
        User user = new User().withEmail("kola" + 1 + "@gmail.com").withPassword("Kola1234$");

        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue((app.getHelperUser().isLogged()));
        Assert.assertTrue(app.getHelperUser().isNotContactsHere());


    }

    public void registrationWrongEmail() {
        // @ . null ru hew

        User user = new User().withEmail("foxmail.com").withPassword("Fox12345$");
        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("Wrong email or password format"));


    }

    @Test
    public void registrationWrongPassword() {

        User user = new User().withEmail("fox@mail.com").withPassword("Fox12");
        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("Wrong email or password format"));
    }

    @Test
    public void registrationUserAlreadyExists(){

        User user = new User().withEmail("noa@mail.com").withPassword("Nnoa12345$");
        app.getHelperUser().openLpginRegform();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("User already exist"));


    }

}