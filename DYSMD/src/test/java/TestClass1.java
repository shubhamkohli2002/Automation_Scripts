import org.example.Main;
 import org.junit.Test;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
 import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.*;


public class TestClass1 extends Main {

    protected List<String> username = new ArrayList<>(Arrays.asList("smokefemale2", "smokemale", "smokefemale", "smokemale2"));
    protected List<String> abstract_id = new ArrayList<>();
    protected String category_id;

    protected String URL="https://www.dysmd.com/admin/distribution_rules/add_evaluation/";

    // ***************** Login users for matching data & first verify total 5 abstracts are present or not ****************
    @SuppressWarnings({"deprecation"})
    @Test
    public void TestCase1(){
        for (int i=0; i< username.size();i++) {
            setUp();
            driver.get("https://www.dysmd.com/front/user");
            driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.get(i));
            driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");
            driver.findElement(By.xpath("//button[@class='log-btn']")).click();
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            driver.findElement(By.xpath("//a[normalize-space()='Medical Kit']")).click();
            boolean eleSelected = driver.findElement(By.xpath("//div[@class='med-content']//div[5]//div[1]//div[1]//div[1]//a[1]")).isDisplayed();
            if (eleSelected) {
                System.out.println("There are total 5 abstracts of user " + username.get(i));
            } else {
                System.out.println("There are not total 5 abstracts of user ." + username.get(i));
            }
            driver.findElement(By.xpath("(//div[@id='main-menu']/div/ul/li/a)[1]")).click();
            String Age = driver.findElement(By.xpath("(//div[@class='page-content']/div/div/div/div/div/div/h4)[1]")).getText();
            System.out.println("Username: "+username.get(i)+"\nAge: "+Age);
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            driver.findElement(By.xpath("//div[@class='logoDash']/a")).click();
            driver.findElement(By.xpath("//li[@class='med-chrt']/a")).click();
            driver.findElement(By.xpath("//ul[@class='med_menu']/li[3]/a")).click();

            //********************************** Collecting Current Condition ****************************

            List<String> Match_Data= new ArrayList<>();

            List<WebElement> Current_Condition  = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='page-content']/div/div/div/div/div/table/tbody/tr/td[1]")));
            for (WebElement Match_Condition: Current_Condition)
            {
                Match_Data.add(Match_Condition.getText());
            }
            List<String> All_Data = new ArrayList<>();
            for(int l=0;l<Match_Data.size();l++){
                All_Data.add(Match_Data.get(l));
            }
            System.out.println(All_Data);
            tearDown();
        }
    }

    //***************** Extracting the abstract id from articles URL for article 1 & 2 from each 4 users ********************
@SuppressWarnings("deprecation")
@Test
    public void TestCase2() throws InterruptedException{
    setUp();

    for(int i=0; i<username.size();i++) {

        driver.get("https://www.dysmd.com/front/user");
        driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.get(i));
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");
        driver.findElement(By.xpath("//button[@class='log-btn']")).click();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.xpath("//a[normalize-space()='Medical Kit']")).click();
//        if (username.get(i).equals("smokemale"))
//            {
//                driver.findElement(By.xpath("//div[@id='home']//div[1]//div[1]//div[1]//div[2]//a[1]")).click();
//            }
//            else {
            driver.findElement(By.xpath("//div[@id='home']//div[1]//div[1]//div[1]//div[1]//a[1]")).click();
//    }
        String URL1 = driver.getCurrentUrl();
            String str;
            str = URL1;
            String strNew = str.replace("https://www.dysmd.com/front/abstracts/viewAbstract/", "");
            driver.navigate().back();
//            if(username.get(i).equals("smokemale"))
//            {
//                driver.findElement(By.xpath("//div[@class='med-content']//div[2]//div[1]//div[1]//div[2]//a[1]")).click();
//            }
//            else {
                driver.findElement(By.xpath("//div[@class='med-content']//div[2]//div[1]//div[1]//div[1]//a[1]")).click();
//            }
            String URL2 = driver.getCurrentUrl();
            String str1;
            str1 = URL2;
            String str1New = str1.replace("https://www.dysmd.com/front/abstracts/viewAbstract/", "");
            driver.findElement(By.xpath("//div[@id='main-menu']//li[1]//a[1]")).click();
            driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();
            driver.findElement(By.xpath("//a[@id='logout']")).click();
            abstract_id.add(strNew);
            abstract_id.add(str1New);
        }
    for(String all: abstract_id) {
        System.out.println("Abstract Id: "+all);
    }

    // ******************** Open evaluation page & login database for matching abstract data ********************

    driver.get("http://192.168.75.171/phpmyadmin/");
    driver.findElement(By.xpath("//input[@id='input_username']")).sendKeys("dysmdUSER");
    driver.findElement(By.xpath("//input[@id='input_password']")).sendKeys("dysmdPD54$");
    driver.findElement(By.xpath("//input[@id='input_go']")).click();
    sleep(3000);
    driver.findElement(By.xpath("//div[@id='pma_navigation_tree_content']/ul/li[2]/div[1]/a/img")).click();
    sleep(3000);
    driver.findElement(By.xpath("(//a[@class='hover_show_full'])[5]")).click();

    String currentHandle= driver.getWindowHandle();

    for(int j=0;j<8;j++){
        driver.switchTo().window(currentHandle);
        sleep(2000);
        driver.findElement(By.xpath("//ul[@id='topmenu']/li[4]/a")).click();
        sleep(2000);
        driver.findElement(By.xpath("(//div[@id='fieldset_table_qbe']/div/table/tbody/tr/td[4]/input)[1]")).sendKeys(abstract_id.get(j));
        driver.findElement(By.xpath("//div[@class='card-footer']/input")).click();
        sleep(2000);
        category_id= driver.findElement(By.xpath("//td[@class='text-end data grid_edit click2 not_null text-nowrap']/span")).getText();
        System.out.println("Category Id:" +category_id);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL + category_id);

    }
}



    //******************************** Test Case For Narrow & Expand Search ********************************
    @Test
    public void TestCase3() throws IOException {
        setUp();
//        String keyword= "Parkinson’s";
        driver.get("https://www.dysmd.com/front/user");
        driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.get(0));
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");
        driver.findElement(By.xpath("//button[@class='log-btn']")).click();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.findElement(By.xpath("//a[normalize-space()='Medical Kit']")).click();
        String key_value = driver.findElement(By.xpath("(//div[@id='home']/div/div/div[1]/p[@class='med-kit-sub-cont'])[1]")).getText();
        String [] keyword = key_value.split(" ");
//        for (String all: keyword){
//            System.out.println(all);
//        }
        Random random = new Random();
        int x = random.nextInt(keyword.length-1);
//        System.out.println(keyword[x]);

        //********************** Narrow Search ************************
        driver.findElement(By.xpath("//form/input[@class='abbutton']")).click();
        driver.findElement(By.xpath("//form/div/div[2]/input[1]")).sendKeys(keyword[x]);
        driver.findElement(By.xpath("//form/div/div[4]/button")).click();
        String search_result1 = driver.findElement(By.xpath("//form/div[2]")).getText();
        if(search_result1.equals("0")){
            System.out.println("Search Library of Abstracts Failed for narrow");
        }
        else {
            System.out.println("Search Library of Abstracts Passed for narrow");
        }
        //******************************* Taking Screenshot of Narrow Search *************************
        WebElement Element = driver.findElement(By.xpath("//div[@class='search-dv']"));
        // Scrolling down the page till the element is found
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot = (TakesScreenshot)driver;
//Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        LocalDate today = LocalDate.now();
        // Format the date (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter)+" Search";
        FileUtils.copyFile(source, new File("D:\\Shubham Kohli\\DYSMD\\"+formattedDate+"/"+"Narrow_Search.png"));

        //************************** Expand Search ***************************
        driver.findElement(By.xpath("//form/div/div[3]/input[2]")).click();
        driver.findElement(By.xpath("//form/div/div[4]/button")).click();
        String search_result2 = driver.findElement(By.xpath("//form/div[2]")).getText();
        if(search_result2.equals("0")){
            System.out.println("Search Library of Abstracts Failed for expand");
        }
        else {
            System.out.println("Search Library of Abstracts Passed for expand");
        }
        //******************************* Taking Screenshot of Narrow Search *************************
        WebElement Element1 = driver.findElement(By.xpath("//div[@class='search-dv']"));
        // Scrolling down the page till the element is found
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element1);
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot1 = (TakesScreenshot)driver;
//Saving the screenshot in desired location
        File source1 = screenshot1.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        LocalDate today1 = LocalDate.now();
        // Format the date (optional)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate1 = today1.format(formatter1)+" Search";
        FileUtils.copyFile(source1, new File("D:\\Shubham Kohli\\DYSMD\\"+formattedDate1+"/"+"Expand_Search.png"));


    }
    //***************** Taking Screenshot of Abstract Articles *********************
//@SuppressWarnings("deprecation")
    @Test
    public void TestCase4() throws  IOException{

        for(int i=0;i<username.size();i++){
            setUp();
            driver.get("https://www.dysmd.com/front/user");
            driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.get(i));
            driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");
            driver.findElement(By.xpath("//button[@class='log-btn']")).click();
            driver.manage().timeouts().implicitlyWait(3, SECONDS);
            driver.findElement(By.xpath("//a[normalize-space()='Medical Kit']")).click();
//    Locating element by link text and store in variable "Element"
            WebElement Element = driver.findElement(By.xpath("(//div[@id='home']/div/div/div/p)[1]"));
            // Scrolling down the page till the element is found
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
            //Use TakesScreenshot method to capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
//Saving the screenshot in desired location
            File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
            LocalDate today = LocalDate.now();
            // Format the date (optional)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = today.format(formatter);
            List<String> Age = new ArrayList<>(Arrays.asList("57","44","42","55"));
            FileUtils.copyFile(source, new File("D:\\Shubham Kohli\\DYSMD\\"+formattedDate+"/"+username.get(i)+"_"+Age.get(i)+".png"));
            tearDown();
        }
        System.out.println("All 4 users screenshot captured successful.");
    }

    //    Deleting article 1 & 2 from each 4 users
//        @org.testng.annotations.Test
//    public void TestCase5() throws Exception{
////        for(int i=1; i<username.size();i++) {
//            setUp();
//            driver.get("https://www.dysmd.com/front/user");
//            driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
//            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.get(0));
//            driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");
//            driver.findElement(By.xpath("//button[@class='log-btn']")).click();
//            driver.manage().timeouts().implicitlyWait(3, SECONDS);
//            driver.findElement(By.xpath("//a[normalize-space()='Medical Kit']")).click();
//            driver.findElement(By.xpath("//div[@id='home']//div[1]//div[1]//div[1]//div[1]//a[3]")).click();
//            sleep(5000);
//            driver.findElement(By.xpath("//button[@class='confirm']")).click();
//            sleep(5000);
//            driver.findElement(By.xpath("//div[@id='home']//div[1]//div[1]//div[1]//div[1]//a[3]")).click();
//            sleep(5000);
//            driver.findElement(By.xpath("//button[@class='confirm']")).click();
//            System.out.println("User " + username.get(0) + " abstract 1 & 2 deleted successfully");
//            tearDown();
//        }


    //        ***************** Cron Job Execution For New Abstracts *********************
//    @Test
//    public void TestCase6(){
//    setUp();
//    driver.get("https://dysmd.com/?cronpass=abstractsmart1&action=distribute");
//    }


}
