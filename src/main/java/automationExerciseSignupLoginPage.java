import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class automationExerciseSignupLoginPage {
    private WebDriver driver;

    private final By nameFelidInSigupPage = By.name("name");
    private final By emailFelidInSigupPage = By.xpath("//div[@class='signup-form']//input[@name='email']");

    private final By SigupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private final By signupPage_text = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    public automationExerciseSignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    ///actions
    public  void userSignUp(String name, String email) {
        driver.findElement(nameFelidInSigupPage).sendKeys(name);
        driver.findElement(emailFelidInSigupPage).sendKeys(email);
        driver.findElement(SigupButton).click();
    }



    ///validations

    public  void assertOnSignupPage(String expected) {
        String verfy_signup = driver.findElement(signupPage_text).getText();
        Assert.assertEquals(verfy_signup, expected);
    }


}
