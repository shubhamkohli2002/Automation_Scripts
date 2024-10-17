import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PwPageSpeedInsights extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }
    @Test
    public void TestCase1(){
        List<String> list = new ArrayList<>(Arrays.asList("https://www.physiciansweekly.com/", "https://www.physiciansweekly.com/category/allergy-immunology/", "https://www.physiciansweekly.com/category/cardiology/", "https://www.physiciansweekly.com/category/critical-care/", "https://www.physiciansweekly.com/category/dermatology/", "https://www.physiciansweekly.com/category/endocrinology/", "https://www.physiciansweekly.com/category/gastroenterology/", "https://www.physiciansweekly.com/category/infectious-disease/", "https://www.physiciansweekly.com/category/nephrology/", "https://www.physiciansweekly.com/category/neurology/", "https://www.physiciansweekly.com/category/obgyn/", "https://www.physiciansweekly.com/category/oncology-hematology/", "https://www.physiciansweekly.com/category/ophthalmology/", "https://www.physiciansweekly.com/category/pain/", "https://www.physiciansweekly.com/category/pediatrics/", "https://www.physiciansweekly.com/category/primary-care/", "https://www.physiciansweekly.com/category/psychiatry/", "https://www.physiciansweekly.com/category/pulmonology/", "https://www.physiciansweekly.com/category/rheumatology/", "https://www.physiciansweekly.com/category/surgery/", "https://www.physiciansweekly.com/category/urology/", "https://www.physiciansweekly.com/deep-dives/spotlight/", "https://www.physiciansweekly.com/deep-dives/case-consult/", "https://www.physiciansweekly.com/category/indepth/", "https://www.physiciansweekly.com/deep-dives/peer-to-peer/", "https://www.physiciansweekly.com/category/doctors-voice/", "https://www.physiciansweekly.com/category/business-of-medicine/", "https://www.physiciansweekly.com/podcast/", "https://www.physiciansweekly.com/category/cartoons/", "https://www.physiciansweekly.com/about-us/", "https://www.linkedin.com/company/physician%27s-weekly/jobs/", "https://www.physiciansweekly.com/memberships-and-verifications/", "https://www.physiciansweekly.com/pw-in-the-press/", "https://www.physiciansweekly.com/advertise/", "https://www.physiciansweekly.com/partners/", "https://www.physiciansweekly.com/blog/", "https://www.physiciansweekly.com/terms-of-use/" ,"https://www.physiciansweekly.com/privacy-policy/", "https://www.physiciansweekly.com/editorial-policy/", "https://www.physiciansweekly.com/contact-us/", "https://www.figure1.com/?_gl=1*r90v04*_ga*MTkwNjYxNDEwMC4xNzEwNDA1MDM0*_ga_83RP7WFN5M*MTcxODEwNTY5NC4xMjMuMS4xNzE4MTA4MzczLjAuMC4w", "https://oncweekly.com/?_gl=1*r90v04*_ga*MTkwNjYxNDEwMC4xNzEwNDA1MDM0*_ga_83RP7WFN5M*MTcxODEwNTY5NC4xMjMuMS4xNzE4MTA4MzczLjAuMC4w"));
        for(int i=0; i<list.size();i++)
        {
            driver.manage().window().maximize();
            driver.get("https://pagespeed.web.dev/");
            driver.findElement(By.xpath("//*[@id=\"i4\"]")).sendKeys(list.get(i));
            driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div/div[2]/form/div[2]/button")).click();
            if(i==list.size()-1) {
                break;
            }
            else {
                driver.switchTo().newWindow(WindowType.TAB);
            }
        }
    }
}
