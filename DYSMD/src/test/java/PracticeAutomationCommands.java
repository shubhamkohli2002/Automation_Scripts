import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class PracticeAutomationCommands extends Main{
    @Before
    public void setUpTest() {
        setUp();
    }

    @Test
    public void TestCase1(){
    driver.get("https://demoqa.com/elements");
    driver.findElement(By.xpath("(//ul[@class='menu-list'])[1]/li[1]")).click();
    driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[1]/input")).sendKeys("Shubham Kohli");
    driver.findElement(By.xpath("//form[@id='userForm']/div[5]/div/button")).click();
    }
}
