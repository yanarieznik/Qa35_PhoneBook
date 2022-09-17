package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
 WebDriver wd;
 HelperUser helperUser;

 public void init(){
     wd = new ChromeDriver();
     wd.manage().window().maximize(); /// open full screen
     wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
     helperUser = new HelperUser(wd);

 }
  public  void stop()  {
      wd.quit();

  }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
