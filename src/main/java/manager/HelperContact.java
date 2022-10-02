package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void fillAddForm(Contact contact){
        type(By.xpath("//input[@placeholder=Name]"),contact.getName());
        type(By.xpath("//input[@placeholder=Last Name]"),contact.getLastName());
        type(By.xpath("//input[@placeholder=Phone]"),contact.getPhone());
        type(By.xpath("//input[@placeholder=email]"),contact.getEmail());
        type(By.xpath("//input[@placeholder=Address]"),contact.getAddress());
        type(By.xpath("//input[@placeholder=description]"),contact.getDescription());








    }


    public void openAddForm() {
        WebElement add = wd.findElement(By.className("active"));
        add.click();
    }


    public void clicButtonSave() {
        WebElement save = wd.findElement(By.xpath("//*[text()='Save']"));
        save.click();
    }
}
