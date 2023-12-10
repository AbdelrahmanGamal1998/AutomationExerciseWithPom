import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class automationExerciseHomePage {
    private WebDriver driver;
    private final By sigupLoginMenu_button = By.linkText("Signup / Login");


    public automationExerciseHomePage(WebDriver driver) {
        this.driver = driver;
    }


    ///actions
    public void navigateToGoogleUrl(String url) {
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
    public By sigupLoginMenu_button(){
      return sigupLoginMenu_button;
    }
    public void assertOnUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    ///assertions
}
