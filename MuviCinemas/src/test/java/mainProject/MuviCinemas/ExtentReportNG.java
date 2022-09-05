/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG{
	
    public static final ExtentReports extentReports = new ExtentReports();
	public static ExtentSparkReporter report;

	public synchronized static ExtentReports ExtentReportsGenerator() {
		
	// create report
	report = new ExtentSparkReporter("target/Spark/Spark.html");
	extentReports.attachReporter(report);
	extentReports.setSystemInfo("OS", "Mawaddah Hanbali");
	report.config().setTheme(Theme.DARK);
	report.config().setReportName("muvi cinemas Report");
	report.config().setDocumentTitle("Main Project");
	return extentReports;
	
	}
}
