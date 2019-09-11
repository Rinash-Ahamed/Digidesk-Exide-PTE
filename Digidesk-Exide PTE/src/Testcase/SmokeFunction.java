package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.SmokeObjects;
import Utils.Action;

public class SmokeFunction extends Action {
	
	private static String smoke = "SmokeResult for Admin";

	public static void Smoke() throws Exception {
		try {
		wait(2000);
		report.createTest(smoke, logger);
		sendKeys(SmokeObjects.userName(), "rinash.a@heptagon.in");
		report.teststeps("Entered username as 'rinash.a@heptagon.in'");
		sendKeys(SmokeObjects.password(), "Admin@123");
		report.teststeps("Entereed password as 'Admin@123'");
		click(SmokeObjects.loginButton());
		report.teststeps("Clicked on Login Button");
		Ajaxcall();
		wait(3000);
		WebElement ele = SmokeObjects.logo();
		if (ele.isDisplayed()) {
			report.teststeps("Dashboard Screen Digidesk Logo is displayed");
			String check = SmokeObjects.Hellocheck().getText();
			Assert.assertEquals(check, "Hello");
			report.teststeps("User Welcome Message is displayed");
			report.teststeps("Login Passed Successfully!");
			System.out.println("Login Passed");
			wait(4000);
		}
		String header = driver.findElement(By.xpath("//*[@id='tabResults']/div[2]/h1")).getText();
		Assert.assertEquals(header, "Candidates");
		report.teststeps("Checked Dashboard metric is available");
		report.teststeps("Dashboard Passed Successfully!");
		System.out.println("Dashboard Passed");
		click(SmokeObjects.Onboarding());
		report.teststeps("Clicked on Onboarding tab");
		wait(3000);
		click(SmokeObjects.Draft());
		report.teststeps("Clicked on Draft Queue");
		wait(3000);
		click(SmokeObjects.QCQueue());
		report.teststeps("Clicked on Quality Check Queue");
		wait(2000);
		selectByValue(SmokeObjects.filterAll(), 0);
		click(SmokeObjects.filterButton());
		report.teststeps("Applied Filter for AllTime");
		wait(2000);
		boolean elem = SmokeObjects.viewDocx().isDisplayed();
		Assert.assertTrue(elem);
		String tex = SmokeObjects.viewDocx().getText();
		Assert.assertEquals(tex, "View Documents");
		report.teststeps("View Document link is displayed");
		report.teststeps("QualityCheck Passed Successfully!");
		System.out.println("QualityCheck Passed");
		wait(3000);
		click(SmokeObjects.ORmCleared());
		report.teststeps("Clicked on ORM Cleared Queue");
		wait(2000);
		boolean elem1 = SmokeObjects.ORMComments().isDisplayed();
		Assert.assertTrue(elem1);
		String tex1 = SmokeObjects.ORMComments().getText();
		Assert.assertEquals(tex1, "ORM Comments");
		report.teststeps("ORM Comment link is displayed");
		report.teststeps("ORM Cleared Passed Successfully!");
		System.out.println("ORM Cleared Passed");
		wait(3000);
		click(SmokeObjects.SSORM());
		report.teststeps("Clicked on PTE HelpDesk ORM Queue");
		wait(2000);
		boolean elem2 = SmokeObjects.NonStatus().isDisplayed();
		Assert.assertTrue(elem2);
		String tex2 = SmokeObjects.NonStatus().getText();
		Assert.assertEquals(tex2,
				"No Poach |DNH (Employer) |DNH (Education) |Rehire |AFT (Anti Fraud Theft) "
						+ "|Age deviation|Document not available "
						+ "|IRDA|CTC Deviation |Fresher Hiring |Interim DOJ |CRP|Education deviation |Others |");
		report.teststeps("PTE helpDesk ORM Passed Successfully!");
		System.out.println("PTE helpDesk ORM Passed");
		wait(3000);
		click(SmokeObjects.QCCompleted());
		report.teststeps("Clicked on QC Completed Queue");
		wait(2000);
		boolean elem4 = SmokeObjects.ReqOL().isDisplayed();
		Assert.assertTrue(elem4);
		String tex4 = SmokeObjects.ReqOL().getText();
		Assert.assertEquals(tex4, "Request Offer Letter");
		report.teststeps("Request Offer Letter link is displayed");
		report.teststeps("QC Completed Passed Successfully!");
		System.out.println("QC Completed Passed");
		wait(3000);
		click(SmokeObjects.OLMenu());
		report.teststeps("Clicked on OL Menu dropdown");
		wait(1000);
		click(SmokeObjects.OLReleased());
		report.teststeps("Clicked on OL Released Queue");
		wait(2000);
		click(SmokeObjects.OLMenu());
		report.teststeps("Clicked on OL Menu dropdown");
		wait(1000);
		click(SmokeObjects.OLAccept());
		report.teststeps("Clicked on OL accepted Queue");
		wait(1000);
		click(SmokeObjects.OLMenu());
		report.teststeps("Clicked on OL Menu dropdown");
		wait(1000);
		click(SmokeObjects.OLReject());
		report.teststeps("Clicked on OL Rejected Queue");
		wait(1000);
		click(SmokeObjects.OLMenu());
		report.teststeps("Clicked on OL Menu dropdown");
		wait(1000);
		click(SmokeObjects.OLReRequest());
		report.teststeps("Clicked on OL Re Request Queue");
		wait(1000);
		report.teststeps("OL Menu items Passed Successfully!");
		System.out.println("OL Menu Passed");
		click(SmokeObjects.AdditionalMenu());
		report.teststeps("Clicked on Additional Menu dropdown");
		wait(1000);
		click(SmokeObjects.ApproveOnboard());
		report.teststeps("Clicked on Approve Onboarding Queue");
		wait(1000);
		click(SmokeObjects.AdditionalMenu());
		report.teststeps("Clicked on Additional Menu dropdown");
		wait(1000);
		click(SmokeObjects.OnboardReject());
		}catch (AssertionError | Exception e) {
			System.out.println("Smoke Run - [Failed]");
			report.errorStatus("Login Unsuccessfull or Dashboard elements were not displayed");
			report.testFail(smoke, logger, e);
		}
	}
}
