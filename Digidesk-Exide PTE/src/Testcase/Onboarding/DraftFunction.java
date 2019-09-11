package Testcase.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.Onboarding.DraftObjects;
import Utils.Action;

public class DraftFunction extends Action {

	public static void DraftSubmission() throws Exception {
		String tc7 = "Draft Submission Check";
		report.createTest(tc7, logger);
		Ajaxcall();
		wait(5000);
		try {
			waitForPageLoad();
			WebElement addbutton = DraftObjects.AddNewRequestButton();
			if (addbutton.isDisplayed()) {
				click(DraftObjects.AddNewRequestButton());
				report.teststeps("Clicked on Add New Request Button");
				wait(4000);
				WebElement head = DraftObjects.Headername();
				if (head.isDisplayed()) {
					String check = DraftObjects.Headername().getText();
					Assert.assertEquals("Add New Request", check);
					report.teststeps("CIS is displayed and Header is present");
					String firstname = generateName();
					String Mob = generateRandomNumber();
					String email = firstname.replace(" ", "") + RandomString() + "@gmail.com";
					sendKeys(DraftObjects.MobileNumber(), Mob);
					report.teststeps("Passed Mobile Number - " + Mob);
					wait(1000);
					sendValueByJs(DraftObjects.EmailId(), email);
					report.teststeps("Passed E-mail Id - " + email);
					wait(1000);
					String d_firstname = firstname.toLowerCase();
					sendKeys(DraftObjects.FirstName(), d_firstname);
					report.teststeps("Passed First Name - " + firstname);
					wait(1000);
					selectByValue(DraftObjects.BranchCode(), 4);
					report.teststeps("Selected BranchCode - AGR1");
					wait(2000);
					PageScroll("1000");
					click(DraftObjects.Save_as_Draft());
					wait(2000);
					report.teststeps("Clicked on Save Draft button");
					WebElement draftPopup = DraftObjects.DraftPopup();
					if (draftPopup.isDisplayed()) {
						report.teststeps("Draft Popup is present");
						String check1 = DraftObjects.DraftPopupName().getText();
						Assert.assertEquals("Do you want to save as draft", check1);
						report.teststeps("Question Verification Successfull");
						wait(1000);
						click(DraftObjects.PopUpSave());
						wait(2000);
						report.teststeps("Click on Yes buton in draft popup for Saving as Draft");
						report.teststeps("Success! Saved as Draft successfully message is displayed");
						waitForPageLoad();
						wait(10000);
						waitUntilElementTobeCliable(DraftObjects.Draftmodule());
						click(DraftObjects.Draftmodule());
						report.teststeps("Clicked On Draft Queue");
						waitForPageLoad();
						wait(3000);
						String replaceDot = firstname.replace(".", "");
						WebElement draftName = driver.findElement(By.xpath("//table[@class='queueTable']//tbody//strong[contains(text(),'" + replaceDot + "')]"));
						String ele = draftName.getText();
						report.teststeps("Checked save candidate name present in Draft Queue");
						Assert.assertEquals(ele, replaceDot);
						wait(2000);
						if (ele.equals(replaceDot)) {
							report.teststeps("Expected Result - Added candidate name matched with the data in Draft Queue");
							System.out.println("Tescase 7: " + tc7 + " - [Passed]");
							report.getPassResult(tc7);
							wait(5000);
						}
					}
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 7: " + tc7 + " - [Failed]");
			report.errorStatus("Created Draft is not displayed in Draft Queue");
			report.testFail(tc7, logger, e);
		}
	}
}
