import models.Contact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Random;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("yanalanda7gmail.com").withPassword("Yyana12345$"));


        }


    }
    @Test
    public void addNewContactSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000)+100;

        Contact contact = Contact.builder().
                name("Lola").
                lastName("Kola").
                phone("0584082507").
                email("lol@gmail.com").
                address("Kiev").
                description("sister").build();

        app.getHelperContact().openAddForm();
        app.getHelperContact().fillAddForm(contact);
        app.getHelperContact().clicButtonSave();









    }


}
