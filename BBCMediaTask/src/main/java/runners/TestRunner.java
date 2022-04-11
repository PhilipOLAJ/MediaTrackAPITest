package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/features"}
        ,plugin = {"pretty", "json:target/report.json","de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"}
        ,glue = {"src/main/java/stepdef"}
)
public class TestRunner {


}
