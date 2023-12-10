import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class automationExerciseAccountInformationPage {
    private WebDriver driver;
    private final By accountInformation_Text = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    private final By passwordAccountInformation = By.id("password");
    private final By mobileAddressInformation = By.xpath("//*[@id=\"mobile_number\"]");
    private final By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");

    private final By accountCreated_Text = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    private final By zipcode = By.id("zipcode");
    private final By city =By.id("city");
    private final By state =By.id("state");
    private final By countryList =By.name("country");
    private final By address2 =By.id("address2");
    private final By address1 =By.id("address1");
    private final By company =By.id("company");
    private final By lastname = By.id("last_name");
    private final By firstname =By.id("first_name");
    private final By daysList = By.name("days");
    private final By monthsList =  By.name("months");
    private final By yearsList = By.name("years");
    private final By newsletterCheckbox= By.id("newsletter");

    private final By optinCheckbox= By.id("optin");

    public automationExerciseAccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }


    ///actions

    public void userAccountInformation(String dayvalue, String monthvalue, String yearvalue) {
        driver.findElement(passwordAccountInformation).sendKeys("Body@123");
        Select days = new Select(driver.findElement(daysList));
        days.selectByValue(dayvalue);
        Select month = new Select(driver.findElement(monthsList));
        month.selectByValue(monthvalue);
        Select years = new Select(driver.findElement(yearsList));
        years.selectByValue(yearvalue);
        WebElement checkbox = driver.findElement(newsletterCheckbox);
        checkbox.click();
        WebElement checkbox2 = driver.findElement(optinCheckbox);
        checkbox2.click();
    }


    public  void userAddressInformation() {
        driver.findElement(firstname).sendKeys("Tarek");
        driver.findElement(lastname).sendKeys("megahd");
        driver.findElement(company).sendKeys("GizaSystems");
        driver.findElement(address1 ).sendKeys("Dokki");
        driver.findElement(address2).sendKeys("Dokki");
        Select country = new Select(driver.findElement(countryList));
        country.selectByValue("Canada");
        driver.findElement(state).sendKeys("India");
        driver.findElement(city ).sendKeys("India");
        driver.findElement(zipcode).sendKeys("123");
        driver.findElement(mobileAddressInformation).sendKeys("01114193988");
        driver.findElement(createAccountButton).click();
    }



    ///validations
   public  void asserOnAccountCreatedColor(String expectedColor) {
        WebElement successMessage = driver.findElement(accountCreated_Text);
        String actualColor = successMessage.getCssValue("color");
        Assert.assertEquals(actualColor, expectedColor);
    }

   public  void assertOnAccountCreatedText(String expected) {
        String ACCOUNT_CREATED = driver.findElement(accountCreated_Text).getText();
        Assert.assertEquals(ACCOUNT_CREATED, expected);
    }
  public void assertOnAccountInformation(String expected) {
        String ACCOUNT_INFORMATION = driver.findElement(accountInformation_Text).getText();
        Assert.assertEquals(ACCOUNT_INFORMATION, expected);
    }

}
