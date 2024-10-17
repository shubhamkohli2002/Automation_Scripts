
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class OwAdsTesting extends Main {
    @Test
    void TestCase1() throws Exception{
        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        // Add incognito argument
        options.addArguments("--incognito");
        // Instantiate the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Open a URL
        driver.get("https://oncweekly.com/oncweekly-content/?jdfjj");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        for (int i=0;i<4;i++)
        {
            driver.switchTo().frame(i);
            WebElement element = driver.findElement(By.xpath("(//div[@id='google_image_div'])/a["+i+"]"));
            WebElement Element = driver.findElement(By.xpath("//a[@id='aw0']"));
            // Scrolling down the page till the element is found
            js.executeScript("arguments[0].scrollIntoView();", Element);
            String ads = element.getDomAttribute("href");
            if (!ads.contains("https://googleads")) {
                System.out.println(ads);
            } else {
                System.out.println("Pass");
            }
        }
    }
}
