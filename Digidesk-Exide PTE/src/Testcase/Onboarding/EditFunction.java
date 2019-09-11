package Testcase.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.Onboarding.EditObject;
import Utils.Action;

public class EditFunction extends Action {

	public static void Edit() throws Exception {
		String tc8 = "Edit Info Update Check";
		report.createTest(tc8, logger);
		try {
			waitForPageLoad();
			wait(5000);
			waitUntilElementTobeCliable(EditObject.CandidateQ());
			click(EditObject.CandidateQ());
			report.teststeps("Clicked On Candidate Queue");
			wait(3000);
			selectByValue(EditObject.filterAll(), 0);
			click(EditObject.filterbutton());
			report.teststeps("Filtered aplied for All Time");
			wait(3000);
			hoverToElement(EditObject.Action(), EditObject.EditInfo());
			report.teststeps("Hovered to Action button and Clicked on Edit link");
			wait(2000);
			WebElement ele = EditObject.headname();
			if (ele.isDisplayed()) {
				String ele1 = EditObject.headname().getText();
				Assert.assertEquals(ele1, "Candidate Queue");
				report.teststeps("EditInfo page is diaplayed and header name is present");
				WebElement readOnly = EditObject.MobileNumber();
				WebElement readoly2 = EditObject.EmailId();
				Assert.assertTrue(readOnly.getAttribute("readOnly").equals("true"), "Element ReadOnly");
				report.teststeps("Checked Mobile Number field is - Readonly");
				Assert.assertTrue(readoly2.getAttribute("readOnly").equals("true"), "Element ReadOnly");
				report.teststeps("Checked Email Id field is - Readonly");
				clear(EditObject.FirstName());
				String currentname = EditObject.FirstName().getText();
				report.teststeps("Cleared FirstName - "+currentname);
				wait(2000);
				String name = generateName();
				sendKeys(EditObject.FirstName(), name.toLowerCase());
				report.teststeps("Passed FirstName - "+name);
				wait(2000);
				PageScroll("1000");
				click(EditObject.UpdateButton());
				report.teststeps("Clicked on Update button");
				waitForPageLoad();
				wait(8000);
				selectByValue(EditObject.filterAll(), 0);
				click(EditObject.filterbutton());
				report.teststeps("Filter applied All Time");
				wait(4000);
				String replacedot = name.replace(".", "");
				WebElement EditSavedName = driver
						.findElement(By.xpath("//strong[contains(text(),'" + replacedot + "')]"));
				String Fname = EditSavedName.getText();
				Assert.assertEquals(Fname, replacedot);
				wait(4000);
				report.teststeps("Checked Updated changes reflected in Candidate Queue");
				if (Fname.equals(replacedot)) {
					report.teststeps("Expected Result - Changes Updated and Saved Successfully!");
					System.out.println("Tescase 8: " + tc8 + " - [Passed]");
					report.getPassResult(tc8);
					wait(4000);
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 8: " + tc8 + " - [Failed]");
			report.errorStatus("");
			report.testFail(tc8, logger, e);
		}
	}
	
	public static void Delete() throws Exception {
		String tc9 = "Delete & Dropped Check";
		report.createTest(tc9, logger);
		try {
			wait(3000);
			waitUntilElementTobeCliable(EditObject.Action());
			String getName = EditObject.CQNameToDelete().getText();
			hoverToElement(EditObject.Action(), EditObject.Delete());
			report.teststeps("Hovered to Action button and Clicked on Delete link");
			wait(2000);
			String ele = EditObject.PopupText().getText();
			Assert.assertEquals(ele, "Are you sure you want to delete this candidate from onboarding?");
			report.teststeps("Checked PopUp Question is Present");
			selectByValue(EditObject.Reason(), 1);
			report.teststeps("Selected Reason from Reason DropDown");
			wait(1000);
			click(EditObject.YesButton());
			report.teststeps("Clicked Yes button from Deleted popup");
			wait(7000);
			waitForPageLoad();
			click(EditObject.Dropped());
			report.teststeps("Clicked on Dropped Queue");
			wait(3000);
			selectByValue(EditObject.filterAll(), 0);
			wait(1000);
			click(EditObject.filterbutton());
			report.teststeps("Applied AllTime filter");
			wait(3000);
			String DroppedName = driver.findElement(By.xpath("(//tr[@class='queueTableList odd']//strong)[1]")).getText();
			Assert.assertEquals(getName, DroppedName);
			report.teststeps("Deleted Candidate is present in Dropped Queue");
			report.teststeps("Expected Result - Deleted Candidate moved to Dropped Queue Successfully");
			System.out.println("Tescase 9: " + tc9 + " - [Passed]");
			report.getPassResult(tc9);
			wait(3000);
		} catch (AssertionError e) {
			System.out.println("Tescase 9: " + tc9 + " - [Failed]");
			report.errorStatus("Delete popup is not displayed or Deleted Candidate is not present in Dropped Queue");
			report.testFail(tc9, logger, e);
		}
	}
	
	public static void sendSMS_Email() throws Exception {
		String tc10 = "Send SMS/Email check";
		report.createTest(tc10, logger);
		try {
			waitForPageLoad();
			wait(4000);
			click(EditObject.CandidateQ());
			report.teststeps("Clicked on Candidate Queue");
			wait(4000);
			hoverToElement(EditObject.Action(), EditObject.smsEmail());
			report.teststeps("Hovered to Action button and Clicked on Send SMS/Email link");
			wait(2000);
			String ele = EditObject.smsText().getText();
			Assert.assertEquals(ele, "Would you like to send an SMS/Email to candidate to download the Digidesk App?");
			report.teststeps("Send SMS/Email popUp question is displayed");
			selectByValue(EditObject.sendDropdown(), 1);
			report.teststeps("Clicked on SMS option from Select-Method DropDown");
			click(EditObject.sendButton());
			report.teststeps("Clicked on Send button");
			wait(4000);
			WebElement text1 = EditObject.smsSuccess();
			if (text1.isDisplayed()) {
				report.teststeps("Expected Result - SMS sent Successfully message is Displayed");
				System.out.println("Tescase 10: " + tc10 + " - [Passed]");
				report.getPassResult(tc10);
				wait(3000);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 10: " + tc10 + " - [Failed]");
			report.errorStatus("Send SMS/Email popup is not displayed or sending SMS Unsuccessfull");
			report.testFail(tc10, logger, e);
		}
	}
}