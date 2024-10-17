import org.example.Main;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OWarticleTesting extends Main {
    @Before
    public void setUpTest() {
        setUp();
    }
    @Test
    public void TestCase1() {
        List<String> urls = Arrays.asList(
                "https://oncweekly.com/predicting-eoc-outcomes-via-acetylation-and-immune-infiltration/",
                "https://oncweekly.com/microbiota-as-prognostic-markers-in-ovarian-serous-cystadenocarcinoma/",
                "https://oncweekly.com/effective-t-all-treatment-with-indisulam-via-rbm39-mis-splicing/",
                "https://oncweekly.com/axillary-node-prediction-in-bc-with-slnb-after-nac/",
                "https://oncweekly.com/nff-in-unresectable-pc-shows-superior-os-vs-s-1/",
                "https://oncweekly.com/efficacy-of-crt-post-noncurative-esd-in-esophageal-scc/",
                "https://oncweekly.com/super-t2-flair-mismatch-prognostic-marker-for-idh-astrocytomas/"
        );


//
//        List<String> urls = Arrays.asList(
//                "https://oncweekly.com/the-role-of-cox-2-expression-in-breast-cancer-prognosis/",
//                "https://oncweekly.com/sips-predicts-traes-and-prognosis-in-escc-with-nict/",
//                "https://oncweekly.com/standardizing-ptx-radiotherapy-for-elderly-escc/",
//                "https://oncweekly.com/exploring-smcc-of-the-esophagus-a-center-review/",
//                "https://oncweekly.com/68ga-nota-xh05-for-targeting-lag-3-in-melanoma-imaging/",
//                "https://oncweekly.com/impact-of-lot-on-qol-in-pts-with-fl-real-world-data/",
//                "https://oncweekly.com/gna-bap1-mutation-impact-on-protein-mrna-expression-in-um/"
//        );

        for (String urlz : urls) {
            driver.get(urlz);
            String current_url = driver.getCurrentUrl();
            String title = driver.getTitle();
            int count = 0;
            if(title.equals("404 Not Found | Oncweekly")){
                count++;
                System.out.println(count+") 404 Page found: ");
                System.out.println(current_url);
                continue;
            }
            else {
                count++;
                System.out.println(count+") No 404 page found.");
            }
            List<WebElement> links = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='cat-two-columns']/div/div/p/a")));

            for (WebElement url : links) {
                String target = url.getDomAttribute("target");
                driver.get(url.getDomAttribute("href"));
                if(title.equals("404 Not Found")){
                    count++;
                    System.out.println(count+") 404 Page found: ");
                    System.out.println(current_url);
                    continue;
                }
                else {
                    count++;
                    System.out.println(count+") No 404 page found.");
                }
                if (target.equals("_blank")) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                    System.out.print("URL: ");
                    System.out.println(url.getDomAttribute("href"));
                }
            }

            WebElement endLink = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='parent']/a")));
            String target1 = endLink.getDomAttribute("target");
            if (target1.equals("_blank")) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
                System.out.println("URL: ");
                System.out.println(endLink.getDomAttribute("href"));
            }
        }

    }

}
