import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGDemoRefactor {
    WebDriver driver = new ChromeDriver();

    private final By sigupLoginMenu_button = By.linkText("Signup / Login");
    private final By signupPage_text = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");

    private final By nameFelidInSigupPage = By.name("name");
    private final By emailFelidInSigupPage = By.xpath("//div[@class='signup-form']//input[@name='email']");

    private final By SigupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

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



    @BeforeMethod
    public void BeforeTest() {
        navigateToGoogleUrl("https://automationexercise.com/");
    }

    @Test
    public void NavigateToSignup() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        driver.findElement(sigupLoginMenu_button).click();
        assertOnSignupPage("New User Signup!");
        userSignUp();
        assertOnAccountInformation("ENTER ACCOUNT INFORMATION");
        userAccountInformation("2","2","2001");
        userAddressInformation();
        assertOnAccountCreatedText("ACCOUNT CREATED!");
        asserOnAccountCreatedColor("rgba(0, 128, 0, 1)");
    }


    private void navigateToGoogleUrl(String url) {
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    private void asserOnAccountCreatedColor(String expectedColor ) {
        WebElement successMessage = driver.findElement(accountCreated_Text);
        String actualColor = successMessage.getCssValue("color");
        Assert.assertEquals(actualColor, expectedColor);
    }

    private void assertOnAccountCreatedText(String expected) {
        String ACCOUNT_CREATED = driver.findElement(accountCreated_Text).getText();
        Assert.assertEquals(ACCOUNT_CREATED, expected);
    }

    private void userAccountInformation(String dayvalue,String monthvalue,String yearvalue) {
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


    private void userAddressInformation() {
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

    private void assertOnAccountInformation(String expected) {
        String ACCOUNT_INFORMATION = driver.findElement(accountInformation_Text).getText();
        Assert.assertEquals(ACCOUNT_INFORMATION, expected);
    }

    private void userSignUp() {
        driver.findElement(nameFelidInSigupPage).sendKeys("Ahmed");
        driver.findElement(emailFelidInSigupPage).sendKeys("mnfeawgy@gmail.com");
        driver.findElement(SigupButton).click();
    }

    private void assertOnSignupPage(String expected) {
        String verfy_signup = driver.findElement(signupPage_text).getText();
        Assert.assertEquals(verfy_signup, expected);
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();

    }


}
