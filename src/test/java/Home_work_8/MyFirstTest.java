package Home_work_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class MyFirstTest {

    private WebDriver driver;
    private static final String URL = "https://www.google.com/?hl=en-US";
    private static final String URL2 = "https://www.google.com.ua/";


    @BeforeClass
    private void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openUrl() {
        driver.get(URL2);
    }

    @Test
    public void test_hillel() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("hillel it school");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        Assert.assertEquals(elements.get(0).getText(), "hillel it school", "Not equal!");
    }

    @Test
    public void test_linkedin() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Linkedin test");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        Assert.assertEquals(elements.get(0).getText(), "linkedin test", "Not equal!");
    }

    @AfterMethod
    public void pauseBetweenTests() throws InterruptedException {
        Thread.sleep(3000); // пауза перед виконанням наступного тесту
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}