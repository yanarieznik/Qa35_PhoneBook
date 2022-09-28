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
    public void registrationSuccess(){
    System.currentTimeMillis();
    int a =(int) System.currentTimeMillis()/1000%3600;
    User user = new User().withEmail("kola"+1+"@gmail.com").withPassword("Kola1234$");

    app.getHelperUser().openLpginRegform();
    app.getHelperUser().fillLoginRegistrationForm(user);
    app.getHelperUser().submitRegistration();
   // Assert.assertEquals(app.getHelperUser().getMessage(), "No Contacts here!");
   //  Assert.assertTrue(app.getHelperUser().isButtonPresent());








}












}
