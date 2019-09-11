package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.ITestResult;
import org.testng.SkipException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReport extends Action {

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	private static final String UserDir = "./Extent/";
	private static final String FileName = "ExecutionReport-";

	public void extentInitialize() {
		String date = currentdate().toString();
		Path path = Paths.get(UserDir);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
				System.out.println("Created Filepath for ExtentReports");
			} catch (IOException e) {
				System.out.println("Failed to create directory for ExtentReports");
				e.printStackTrace();
			}
		} else {
			System.out.println("Filepath is available for Extenteports");
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(UserDir + FileName + date + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		/*-----------------------------------------------------*/
		extent.setSystemInfo("Project Name", "Diigidesk_PTE");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Host Name", "Rinash");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("Report path in SourceCode", path.toString());
		htmlReporter.config().setDocumentTitle("Digidesk-Exide_PTE Automation - Testing");
		htmlReporter.config().setReportName("Digidesk-Exide_PTE Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		/*-----------------------------------------------------*/
	}

	public void createTest(String TestcaseName, ExtentTest logger2) throws Exception {
		logger2 = extent.createTest(TestcaseName);
		logger = logger2;
	}

	public void testFail(String TestcaseName, ExtentTest logger2, Throwable e) throws Exception {
		logError(e, TestcaseName);
		takeScreen(TestcaseName);
	}

	public void testSkip() {
		logger = extent.createTest("TestSkipped");
		throw new SkipException("This test case is not ready for Execution");
	}

	public void teststeps(String steps) {
		logger.info(steps);
	}

	public void errorStatus(String description) {
		logger.error(MarkupHelper.createLabel(description, ExtentColor.GREY));
	}

	public void takeScreen(String name) throws IOException {
		logger.addScreenCaptureFromPath(captureScreenshot(name));
	}

	public void logError(Throwable e, String TestName) {
		logger.log(Status.ERROR, e);
		e.fillInStackTrace();
		//ExceptionUtils.getStackTrace(e);
		logger.fail(MarkupHelper.createLabel(TestName + " - FAILED", ExtentColor.RED));
	}

	public void threadNode(String testName, String node) {
		logger = extent.createTest(testName);
		logger.createNode(node);
	}

	public void flush() {
		extent.flush();
	}

	public void getPassResult(String TestName) {
//		SimpleDateFormat formatter= new SimpleDateFormat("K:mm a");
//		Date date = new Date(System.currentTimeMillis());
//		formatter.format(date);
		
		//getting time alone
		//LocalTime time = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
		logger.log(Status.PASS, MarkupHelper.createLabel(TestName + " - PASSED", ExtentColor.GREEN));
	}

	public void getFailResult(String TestName) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(TestName + " FAILED", ExtentColor.RED));
	}

	public static void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "TestCase PASSED", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "TestCase FAILED", ExtentColor.RED));
		} else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "TestCase SKIPPED", ExtentColor.BLUE));
		}
	}
}