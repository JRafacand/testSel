package runner;

import io.cucumber.java.AfterStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import pages.BasedPage;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
        glue="steps", 
        plugin = {"testng", "html:target/cucumber-reports"})

        public class TesteRunner {
        public class StepHooks {
                private long loadTime;

                @AfterStep
                public void afterStep() {
                        System.out.println("Load time Page: " + loadTime);
                }

                public void setLoadTime(long loadTime) {
                        this.loadTime = loadTime;
                }
        }
                @AfterClass // closed class
                public static void tearDown() {
                        BasedPage.closeBrowser();
                }
    
}
