import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Random;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("Yanka@gmail.com").withPassword("Yyana12345$"));
        }
    }


    @Test
    public void addNewContactSuccess() {

        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder().
                name("Lola" + i).
                lastName("Kola").
                phone("45455654" + i).
                email("lol" + i + "@gmail.com").
                address("Kiev").
                description("sister").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactAllForm(contact);
        app.getHelperContact().saveContactWithTab();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessRequiredFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Nadin" + i)
                .lastName("Snow")
                .phone("3434345" + i)
                .email("nadin" + i + "@mail.com")
                .address("Haifa")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactRequiredForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactWrongName() {

        Contact contact = Contact.builder()
                .lastName("Snow")
                .phone("34343452143568")
                .email("zoa@mail.com")
                .address("Haifa")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactRequiredForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
}
