import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class PracticeAutomationCommands extends Main{
    @Before
    public void setUpTest() {
        setUp();
    }

    @Test
    public void InputFields(){
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[1]/a")).click();
        driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Shubham Kohli");
        WebElement inputField=  driver.findElement(By.xpath("//input[@id='join']"));
        inputField.sendKeys(" automation tester"+Keys.TAB);
        String txt = driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println("Input Field Text: "+txt);
        driver.findElement(By.id("clearMe")).clear();
        driver.findElement(By.id("noEdit")).isEnabled();

    }
    @Test
    public void Buttons(){
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[2]/a")).click();
//        driver.findElement(By.id("home")).click();
        WebElement pnt = driver.findElement(By.id("position"));
        Point point= pnt.getLocation();
        int x = point.getX();
        int y = point.getY();

        System.out.println("X=> "+x+"/nY=> "+y);
        String color = driver.findElement(By.id("color")).getCssValue("color");
        System.out.println("Color: "+color);

        driver.findElement(By.id("property")).getSize();
        WebElement button_location = driver.findElement(By.xpath("(//button[@id='isDisabled'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button_location);
        actions.clickAndHold().perform();
    }
    @Test
    public void Dropdowns() throws InterruptedException {
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[4]/a")).click();
        driver.findElement(By.id("modern")).click();
        Thread.sleep(5000);
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("Shubham Kohli");
//        alert.accept();
        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//        String text= alert.getText();
//        alert.dismiss();
//        System.out.println("Alert Text : "+text);
//        driver.switchTo();
//        Select options = new Select(driver.findElement(By.id("country")));
//        options.selectByValue("India");
//        String selectedValue = options.getFirstSelectedOption().getText();
//        System.out.println("Selected Country: "+selectedValue);



//        List<WebElement> all = options.getOptions();
//        for(WebElement i : all)
//        {
//            System.out.println(i.getText());
//        }
    }
    @Test
    public void Frames(){
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[5]/a")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("Shubham");
        driver.findElement(By.xpath("//input[@class='input ng-untouched ng-pristine ng-invalid']")).sendKeys("Kohli");
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@yopmail.com");
    }
    @Test
    public void Radio_Buttons(){
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[6]/a")).click();
//        driver.findElement(By.id("no")).click();
//        driver.findElement(By.id("one")).click();
//        driver.findElement(By.id("two")).click();
//        boolean select = driver.findElement(By.id("one")).isSelected();
//        boolean select1 = driver.findElement(By.id("two")).isSelected();
//        if(select1==select){
//            System.out.println("Both radio buttons are selectable.");
//        }
//        else {
//            System.out.println("Only one radio button is selectable.");
//        }
//        boolean select = driver.findElement(By.id("foo")).isSelected();
//        boolean select1 = driver.findElement(By.id("notfoo")).isSelected();
//
//        if(select){
//            System.out.println("Foo is selected.");
//        }
//        else if(select1){
//            System.out.println("Bar is selected.");
//        }
//        boolean select = driver.findElement(By.id("maybe")).isEnabled();
//        if (!select){
//            System.out.println("Radio button is disabled.");
//        }
//        else {
//            System.out.println("Radio button is enabled.");
//        }
//        boolean select =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
//        if(select){
//            System.out.println("Checkbox is checked.");
//        }
//        else{
//            System.out.println("Checkbox is not checked.");
//        }
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    }
    @Test
    public void Windows_Handling(){
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[7]/a")).click();
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.id("multi")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windowHandles);
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(mainWindow);
        driver.close();
        driver.switchTo().window(list.get(1));
        driver.close();
        driver.switchTo().window(list.get(2));
        driver.quit();
        setUp();
        driver.get("https://letcode.in/test");
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[7]/a")).click();
        driver.findElement(By.id("multi")).click();
        Set<String> windowHandles2 = driver.getWindowHandles();
        List<String> list2 = new ArrayList<>(windowHandles2);
        for(int i=0; i<windowHandles2.size();i++){
            driver.switchTo().window(list2.get(i));
            System.out.println(driver.getTitle());
        }
        driver.quit();

    }
    @Test
    public void Elements_All() throws InterruptedException{
        driver.get("https://letcode.in/test");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//footer[@class='card-footer'])[8]/a")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shubhamkohli2002");
        driver.findElement(By.id("search")).click();
    }
}
