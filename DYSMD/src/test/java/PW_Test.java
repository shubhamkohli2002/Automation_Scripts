import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PW_Test extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }

    @Test
    public void TestCase1(){
        driver.get("https://www.physiciansweekly.com/");
        List<WebElement> FirstCheck = driver.findElements(By.cssSelector("a.mega-menu-link"));
        for (WebElement Check1: FirstCheck)
        {

                System.out.println(Check1.getDomAttribute("href"));

            }
    }

}
