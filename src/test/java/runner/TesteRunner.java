package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasedPage;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
        glue="steps", 
        plugin = {"pretty", "html:target/cucumber-reports"})

        public class TesteRunner {// closed class
                @AfterClass
                public static void tearDown() {
                        BasedPage.closeBrowser();
                }
    
}
