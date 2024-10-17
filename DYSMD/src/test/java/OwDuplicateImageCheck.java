import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OwDuplicateImageCheck extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }
    @Test
    public void TestCase1(){

        driver.manage().window().maximize();
        driver.get("https://oncweekly.com/category/latest-research/");
       List<WebElement> url = (List<WebElement>) driver.findElement(By.xpath("//div[@id= 'content-cat']/div/div/div/div/div/article/div/h2/a"));
      for (WebElement all: url)
      {
       driver.get(all.getDomAttribute("href"));
       List<WebElement> img = (List<WebElement>) driver.findElement(By.xpath("//div[@id='ow-related-content']/div/div/div/article/div/div/a"));
        for(WebElement images: img){
            if(images.getDomAttribute("href").equals(images.getDomAttribute("href"))){
                System.out.println("Duplicate images found."+"/n"+"Page URL: "+driver.getCurrentUrl());
            }
            else {
                System.out.println("No duplicate images.");
            }
        }
      }
    }
}
