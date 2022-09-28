package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {

        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logout() {
        wd.findElement(By.xpath("//button[text()='Sign Out']")).click();

    }

    public void openLpginRegform() {

        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        loginTab.click();


    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);


//    WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder='Email']"));
//    inputEmail.click();
//    inputEmail.clear();
//    inputEmail.sendKeys(email);
//
//
//
//    WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder='Password']"));
//    inputPassword.click();
//    inputPassword.clear();
//    inputPassword.sendKeys(password);

    }

    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }


    public void submitLogin() {

        WebElement loginButton = wd.findElement(By.xpath("//*[text()=' Login']"));
        loginButton.click();

    }

    public boolean isAlertPresent() {
        Alert alert = wd.switchTo().alert();
        if (alert == null) {
            return false;

        } else {
            return true;
        }


    }

    public boolean isErroeWrongFormat() {
        Alert alert = wd.switchTo().alert();
        String errorText = alert.getText();
        System.out.println(errorText);
        // click  Ok
        alert.accept();
        //click cancel
        // alert.dismiss();
        //type
        // alert.sendKeys("helllo");
        return errorText.contains("Wrong email or password format");

    }

    public void submitRegistration() {
        WebElement regButton = wd.findElement(By.xpath("//*[text()=' Registration']"));
        regButton.click();
    }
}

//    public boolean isButtonPresent() {
//
//       WebElement button = wd.findElement(By.xpath("//a[@href='/contacts']")) ;
//
//    }
//}

