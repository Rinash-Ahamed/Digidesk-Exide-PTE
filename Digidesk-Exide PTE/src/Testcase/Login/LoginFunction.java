package Testcase.Login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.Login.LoginObjects;
import Utils.Action;

public class LoginFunction extends Action {

	public static void Login1() throws Exception {
		String tc1 = "Negative(Login)";
		report.createTest(tc1, logger);
		try {
			sendKeys(LoginObjects.userName(), "karthikk@heptagon.in");
			report.teststeps("Entered Invalid UserName");
			sendKeys(LoginObjects.password(), "Admin@1234");
			report.teststeps("Entered Invalid Password");
			wait(1000);
			click(LoginObjects.loginButton());
			report.teststeps("Clicked on Login Button");
			wait(2000);
			WebElement ele = LoginObjects.loginerror();
			if (ele.isDisplayed()) {
				String check = LoginObjects.loginerror().getText();
				Assert.assertEquals(check, "The username or password you entered is incorrectt");
				report.teststeps("Expected Result - " + check + " - alert is displayed");
				System.out.println("Tescase 1: " + tc1 + " - [Passed]");
				report.getPassResult(tc1);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 1: " + tc1 + " - [Failed]");
			report.errorStatus("'The username or password you entered is incorrect' alert is not displayed or wrong alert is displayed");
			report.testFail(tc1, logger, e);		
		}
	}

	public static void Login2() throws Exception, AssertionError {
		String tc2 = "Positive(Login)";
		report.createTest(tc2, logger);
		try {
			clear(LoginObjects.userName());
			clear(LoginObjects.password());
			wait(1000);
			sendKeys(LoginObjects.userName(), readData("PTEEmail"));
			report.teststeps("Entered valid UserName - ashokkumar.n@heptagon.in");
			sendKeys(LoginObjects.password(), readData("Password"));
			report.teststeps("Entered valid Password - Admin@123");
			click(LoginObjects.loginButton());
			report.teststeps("Clicked on Login Button");
			Ajaxcall();
			wait(2000);
			WebElement ele = LoginObjects.logo();
			// WebElement ele1 = LoginObjects.DashboardMetric();
			if (ele.isDisplayed()) {
				String check = LoginObjects.Hellocheck().getText();
				Assert.assertEquals(check, "Hello");
				// String check1 = LoginObjects.DashboardMetric().getText();
				// Assert.assertEquals(check1, "Candidates");
				report.teststeps("Expected result - User Logged In Successfully and landed to the Dashboard Screen");
				System.out.println("Tescase 2: " + tc2 + " - [Passed]");
				report.getPassResult(tc2);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 2: " + tc2 + " - [Failed]");
			report.errorStatus("Login Unsuccessfull or Dashboard elements were not displayed");
			report.testFail(tc2, logger, e);
		}
	}
}
