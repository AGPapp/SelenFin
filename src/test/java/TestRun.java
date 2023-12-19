
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@2"},
        plugin = "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
        features = {"src/test/resources/"}
)

public class TestRun {
}
