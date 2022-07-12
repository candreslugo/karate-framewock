package karate;

import org.apache.commons.io.FileUtils;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestParallel {
    @Test
    public void testAll(){
        Results results = Runner.path("classpaht:karate").outputCucumberJson(true)
                .tags("~@ignore")
                        .parallel(2);
                generateReport(results.getReportDir());
                assertEquals(0,results.getFailCount(), results.getErrorMessages());
    }

    private static void generateReport(String karateOutPutPath) {
        Collection<File> jsonFiles = FileUtils.listFiles (new File(karateOutPutPath), new String[]{"json"},true);
                List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
                jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
            Configuration config = new Configuration(new File("target"),"demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
