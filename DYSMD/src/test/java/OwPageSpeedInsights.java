import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OwPageSpeedInsights extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }

    @Test
    public void TestCase1(){
        //***************** OW PAGE SPEED INSIGHTS **************
//        List<String> list = new ArrayList<>(Arrays.asList(
//                "https://oncweekly.com/1110-cell-depleting-agents-assessment-in-preclinical-models/",
//                "https://oncweekly.com/38-serum-proteomics-signature-and-its-association-with-immune-related-toxicities-and-survival-in-patients-with-non-small-cell-lung-cancers-nsclc-receiving-immunotherapy/",
//                "https://oncweekly.com/category/gastrointestinal-cancer/liver/",
//                "https://oncweekly.com/category/leukemia/cll/",
//                "https://oncweekly.com/category/lymphoma/follicular/",
//                "https://oncweekly.com/category/lymphoma/marginal-zone/",
//                "https://oncweekly.com/category/skin-cancer/basal-bcc/",
//                "https://oncweekly.com/comet-2-trial-treatment-tolerance-with-patient-reported-outcomes-data-and-toxicity-index-evaluated/",
//                "https://oncweekly.com/correction-statin-drugs-enhance-responses-to-immune-checkpoint-blockade-in-head-and-neck-cancer-models/",
//                "https://oncweekly.com/gastrointestinal-cancer/liver/",
//                "https://oncweekly.com/genomic-abnormalities-and-mutations-evaluated-as-prognostic-factors-for-therapy-in-patients-with-cll/",
//                "https://oncweekly.com/gynecologic-cancer/ovarian/",
//                "https://oncweekly.com/leukemia/acute-lymphoblastic-leukemia-all/",
//                "https://oncweekly.com/lung-cancer/sclc/",
//                "https://oncweekly.com/mr-confirmed-protein-links-in-skin-cancer/",
//                "https://oncweekly.com/new-treatment-for-extensive-stage-sclc-atezolizumab-in-mauris-trial/"
//        ));
      List<String> list = new ArrayList<>(Arrays.asList("https://oncweekly.com/", "https://oncweekly.com/brain-cancer/", "https://oncweekly.com/breast-cancer/", "https://oncweekly.com/gastrointestinal-cancer/", "https://oncweekly.com/gynecologic-cancer/", "https://oncweekly.com/head-neck-cancer/", "https://oncweekly.com/leukemia/", "https://oncweekly.com/lung-cancer/", "https://oncweekly.com/lymphoma/", "https://oncweekly.com/skin-cancer/", "https://oncweekly.com/meeting-coverage/", "https://oncweekly.com/category/latest-research/", "https://oncweekly.com/about-us/", "https://oncweekly.com/terms-of-use/", "https://oncweekly.com/privacy-policy/", "https://oncweekly.com/editorial-policy/", "https://oncweekly.com/contact-us/", "https://oncweekly.com/newsletter-signup/"));
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

