package Runner;

import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Testcase.Login.LoginFunction;
import Testcase.Onboarding.AddnewrequestFunction;
import Testcase.Onboarding.DraftFunction;
import Testcase.Onboarding.EditFunction;
import Testcase.UserManagement.UserFunciton;
import Utils.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterRunner extends Action {

	private StringBuffer verificationErrors = new StringBuffer();

	// run through xml file -parallel execution
//	@BeforeTest
//	@Parameters(value = {"browser"})
//	public void setUpTest(String browser) throws Exception {
//		report.extentInitialize();
//		if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			getURL("test");
//		}else if(browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			getURL("stage");
//		}else {
//			System.out.println("no browser is defined in xml file...");
//		}
//	}
//	
//	private void getURL(String URLenv) throws Exception {
//	driver.get("http://exidelifepte-" + URLenv + ".digidesk.co/");
//	driver.manage().window().maximize();
//	Thread.sleep(2000);
//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//	driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
//	}

	@BeforeTest(alwaysRun = true)
	public static void Initialize() throws Exception {
		System.out.println("Execution of BeforeTest is carring on");
		driverInit("stage", "chrome");
		report.extentInitialize();
	}

	@Test(priority = 0)
	public static void Login() throws Exception {
		System.out.println("Execution of Main test is carring on");
		//LoginFunction.Login1();
		LoginFunction.Login2();
	}

//	@Test(priority = 1)
//	public static void Onboarding() throws Exception {
//		for (int i = 0; i < 5; i++) {
//			AddnewrequestFunction.Onboardingfunction();
//			wait(2000);
//		}
//		try {
//			AddnewrequestFunction.Onboardingfunction();
//			AddnewrequestFunction.OnboardingValidationCheck();
//			AddnewrequestFunction.DocxSubmissioncheck();
//			AddnewrequestFunction.DocxValidationCheck();
//		} catch (Exception e) {
//			System.err.println("Exception occured in Onboarding" + e);
//			report.testFail("", logger, e);
//		}
	//}

//	@Test(priority = 2)
//	public static void Draft() throws Exception {
//		DraftFunction.DraftSubmission();
//	}
//
//	@Test(priority = 3)
//	public static void Action() throws Exception {
//		EditFunction.Edit();
//		EditFunction.Delete();
//		EditFunction.sendSMS_Email();
//	}
//
//	@Test(priority = 4)
//	public static void UserManagement() throws Exception {
//		UserFunciton.Searchuser();
//		UserFunciton.AddUserCheck();
//		UserFunciton.AddUserValidationCheck();
//		UserFunciton.EditUser();
//		UserFunciton.DeleteUser();
//	}

	@AfterTest(alwaysRun = true)
	public void Teardown() {
		System.out.println("Execution of AfterTest is carring on");
		report.flush();
		if (driver != null) {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
				report.errorStatus(verificationErrorString);
			}
		}
	}
}
