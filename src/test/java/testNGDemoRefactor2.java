import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGDemoRefactor2 {

    WebDriver driver ;
    JsonFileManager testData;
    private automationExerciseAccountInformationPage automationExerciseAccountInformationPage;
    private automationExerciseHomePage automationExerciseHomePage;
    private automationExerciseSignupLoginPage automationExerciseSignupLoginPage;



    @Test
    public void NavigateToSignup() throws InterruptedException {
        automationExerciseHomePage.assertOnUrl();
        elementAction.click(driver,automationExerciseHomePage.sigupLoginMenu_button());
        automationExerciseSignupLoginPage.assertOnSignupPage(testData.getTestData("test1.excpeted"));
        automationExerciseSignupLoginPage.userSignUp("ahmed","ubigos@gmail.com");
        automationExerciseAccountInformationPage.assertOnAccountInformation("ENTER ACCOUNT INFORMATION");
        automationExerciseAccountInformationPage.userAccountInformation("2","2","2001");
        automationExerciseAccountInformationPage.userAddressInformation();
        automationExerciseAccountInformationPage.assertOnAccountCreatedText("ACCOUNT CREATED!");
        automationExerciseAccountInformationPage.asserOnAccountCreatedColor("rgba(0, 128, 0, 1)");
    }

    @BeforeClass
    public void BeforeClass(){
         testData =new JsonFileManager("src/test/resources/testData.json");
    }
    @BeforeMethod
    public void BeforeTest() {
        PropertiesReader.loadProperties();
        driver = driverFactory.initDriver();
        automationExerciseAccountInformationPage =new automationExerciseAccountInformationPage(driver);
        automationExerciseHomePage = new automationExerciseHomePage(driver);
        automationExerciseSignupLoginPage = new automationExerciseSignupLoginPage(driver);
        automationExerciseHomePage.navigateToGoogleUrl("https://automationexercise.com/");
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();

    }

}
