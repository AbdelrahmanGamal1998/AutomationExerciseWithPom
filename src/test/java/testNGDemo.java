import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class testNGDemo {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void BeforeTest() {

        navigateToGoogleUrl("https://automationexercise.com/");

    }

    private void navigateToGoogleUrl(String url) {
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }


    @Test
    public void NavigateToSignup() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));

        String verfy_signup =driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
          Assert.assertEquals (verfy_signup, "New User Signup!");

        driver.findElement(By.name("name")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']")).sendKeys("mneagy@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

        String ACCOUNT_INFORMATION = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b")).getText();
        Assert.assertEquals (ACCOUNT_INFORMATION, "ENTER ACCOUNT INFORMATION");

        driver.findElement(By.id("password")).sendKeys("Body@123");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b")).getText();


        Select days = new Select(driver.findElement(By.name("days")));
        days.selectByValue("2");
        Select month = new Select(driver.findElement(By.name("months")));
        month.selectByValue("2");
        Select years = new Select(driver.findElement(By.name("years")));
        years.selectByValue("2001");


        WebElement checkbox = driver.findElement(By.id("newsletter"));
        checkbox.click();
        WebElement checkbox2 = driver.findElement(By.id("optin"));
        checkbox2.click();



        driver.findElement(By.id("first_name")).sendKeys("Tarek");
        driver.findElement(By.id("last_name")).sendKeys("megahd");
        driver.findElement(By.id("company")).sendKeys("GizaSystems");
        driver.findElement(By.id("address1")).sendKeys("Dokki");
        driver.findElement(By.id("address2")).sendKeys("Dokki");

        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByValue("Canada");

        driver.findElement(By.id("state")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("India");
        driver.findElement(By.id("zipcode")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("01114193988");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

        String ACCOUNT_CREATED =driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
        Assert.assertEquals(ACCOUNT_CREATED ,"ACCOUNT CREATED!");


        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualColor = successMessage.getCssValue("color");
        String expectedColor = "rgba(0, 128, 0, 1)";  // Assuming the color is green
        Assert.assertEquals(actualColor,expectedColor);


    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();

    }


}
