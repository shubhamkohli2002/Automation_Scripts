import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.awt.SystemColor.window;

public class BlankTestOW extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }
    @Test
    public void Test001(){
        int count=0;
        driver.get("https://oncweekly.com/category/latest-research/");
List<WebElement> target = driver.findElements(By.xpath("(//div[@id='content-cat']/div/div/div/div/div/article/div/h2/a)"));

for (WebElement element: target)

        {
    driver.get(element.getDomAttribute("href"));
    List<WebElement> target1= driver.findElements(By.xpath("//div[@id='post-content-cstm']/p/a"));
    count++;
    for (WebElement element1: target1){
    if (element1.getDomAttribute("target").equals("_self")){

        System.out.println(count+")"+driver.getCurrentUrl());
        count++;
    }
    else
    {

        System.out.println(count+")"+"No self link found.");
        count++;
    }}
}
    }
}

