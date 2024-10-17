import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OwSearchFunctionality extends Main {
    int count =0;
    @Before
    public void setUpTest() {
        setUp();
    }
    @Test
    public void TestCase1() throws InterruptedException {
        // Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://oncweekly.com/");
        WebElement search_icon= driver.findElement(By.xpath("//ul[@id='menu-header-menu-1']/li/button"));
        WebElement search_input_field= driver.findElement(By.xpath("//ul[@id='menu-header-menu-1']/div/form/label/input[1]"));
        WebElement search_button = driver.findElement(By.xpath("//ul[@id='menu-header-menu-1']/div/form/input"));

        search_icon.click();
        Thread.sleep(2000);
        List<String> givenList = Arrays.asList("BRAIN CANCER", "BREAST CANCER","GASTROINTESTINAL CANCER","GENITOURINARY CANCER","GYNECOLOGIC CANCER","HEAD & NECK CANCER","LEUKEMIA","LUNG CANCER","LYMPHOMA","SKIN CANCER");
        Random randm = new Random();
        String randomElement = (givenList.get(randm.nextInt(givenList.size())));
        search_input_field.sendKeys(randomElement);
        search_button.click();

        List<String> AllCheck = new ArrayList<>(Arrays.asList("//ul[@class='dropdown-menu']/li[1]//a/div/label[@class='check-box']","//ul[@class='dropdown-menu']/li[2]//a/div/label[@class='check-box']","//ul[@class='dropdown-menu']/li[3]//a/div/label[@class='check-box']"));
        List<String> Test = new ArrayList<>(Arrays.asList("By uncheck 'Articles' Trails Snapshot, Conferences matched & verified ","By uncheck 'Trails Snapshot' Conferences matched & verified","By uncheck 'Conferences' matched & verified & "));
        for(int i=0;i<AllCheck.size();i++)
        {
            Thread.sleep(5000);
            driver.findElement(By.xpath(AllCheck.get(i))).click();
            count++;
            if(count==3){
                WebElement result = driver.findElement(By.xpath("//div[@id='content-area']/div/div[2]/div/h2"));
                String Check3 = result.getText();
                if(Check3.equals("0 Result Found")) {
                    System.out.println(Test.get(i) + " pass with "+Check3);
                    break;
                }
            }
            else {
                List<WebElement> FirstCheck = driver.findElements(By.xpath("//div[@class='paginated_page list-wrapper']/article/div[1]"));
                for (WebElement Check1: FirstCheck)
                {
                    if (Check1.getText().equals("TRIAL SNAPSHOT") || Check1.getText().equals("CONFERENCES"))
                    {
                        System.out.println(Test.get(i));
                        break;
                    }
                    else
                    {
                        System.out.println(Test.get(i)+" fail");
                    }
                }
            }
        }
    }
}
