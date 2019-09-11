package Testcase.Onboarding;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.Onboarding.AddnewrequestObjects;
import Utils.Action;

public class AddnewrequestFunction extends Action {

	public static void Onboardingfunction() throws Exception {
		// click(AddnewrequestObjects.Onboarding());
		String tc3 = "Add New Onboarding Request";
		report.createTest(tc3, logger);
		Ajaxcall();
		wait(3000);
		try {
			WebElement addbutton = AddnewrequestObjects.AddNewRequestButton();
			if (addbutton.isDisplayed()) {
				click(AddnewrequestObjects.AddNewRequestButton());
				report.teststeps("Clicked on Add New Request Button");
				wait(2000);
				WebElement head = AddnewrequestObjects.Headername();
				if (head.isDisplayed()) {
					String check = AddnewrequestObjects.Headername().getText();
					Assert.assertEquals("Add New Request", check);
					report.teststeps("CIS is displayed and Header is present");
					String firstname = generateFirstName();
					String lastname = generateLastName();
					String middlename = generateMiddleName();
					String Mob = generateRandomNumber();
				
					//buissness
					String buissnessCode = agentRandom();
					sendKeys(AddnewrequestObjects.PTE_Business_Code(), buissnessCode);
					report.teststeps("Passed AgentCode - " + buissnessCode);
					String panNumber = RandomPan();
					sendKeys(AddnewrequestObjects.Pan(), panNumber);
					report.teststeps("Passed Pan - " + panNumber);
					String adhaar = agentRandom();
					sendKeys(AddnewrequestObjects.Adhaar(), "2536" + adhaar);
					report.teststeps("Selected AdhaarNumber - 2536" + adhaar);
					wait(1000);
					sendKeys(AddnewrequestObjects.MobileNumber(), Mob);
					report.teststeps("Passed Mobile Number - " + Mob);
					wait(1000);					
					String email = firstname.replace(" ", "") + RandomString() + "@gmail.com";
					sendValueByJs(AddnewrequestObjects.EmailId(), email);
					report.teststeps("Passed E-mail Id - " + email);

					// String d_firstname = Introspector.decapitalize(firstname);
					String d_firstname = firstname.toLowerCase();
					// String d_lastname = Introspector.decapitalize(lastname);
					String d_lastname = lastname.toLowerCase();
					String d_middlename = middlename.toLowerCase();

					// Assert.assertEquals(firstname, Introspector.decapitalize(firstname));
					sendKeys(AddnewrequestObjects.FirstName(), d_firstname);
					report.teststeps("Passed First Name - " + firstname);
					sendKeys(AddnewrequestObjects.MiddleName(), d_middlename);
					report.teststeps("Passed First Name - " + middlename);
					sendKeys(AddnewrequestObjects.LastName(), d_lastname);
					report.teststeps("Passed Last Name - " + lastname);

					selectByValue(AddnewrequestObjects.BranchCode(), 4);
					report.teststeps("Selected BranchCode - AGR1");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Grade(), "M0");
					report.teststeps("Selected Grade - M0");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Department(), "CLCSA");
					report.teststeps("Selected Department - CLCSA");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.SubDepartment(), "Legal");
					report.teststeps("Selected Sub-Department - Legal");
					wait(2000);
					selectByValue(AddnewrequestObjects.Designation(), 1);
					report.teststeps("Selected Designation - Assistant Manager - Legal");
					wait(1000);
					PageScroll("500");
					sendValueByJs(AddnewrequestObjects.ExpectedDOJ(), "2019-08-25");
					report.teststeps("Selected ExpectedDOJ - 2019-08-25");
					sendKeys(AddnewrequestObjects.ProposedCTC(), "213232");
					report.teststeps("Passed ProposedCTC - 213232");
					sendKeys(AddnewrequestObjects.cibilScore(), "8789879");
					report.teststeps("Selected CibilScrore - 8789879");
					wait(1000);
					sendKeys(AddnewrequestObjects.hiringSscore(), "235545");
					report.teststeps("Selected HiringScore - 235545");
					wait(1000);
					selectByValue(AddnewrequestObjects.Source(), 2);
					report.teststeps("Selected Source - Ex-Employee of Exide Life");
					wait(1000);
					PageScroll("200");
					wait(1000);
					click(AddnewrequestObjects.SaveButton());
					report.teststeps("Clicked on Save&Proceed Button");
					wait(6000);
					PageScroll("300");
					click(AddnewrequestObjects.DocxCancel());
					report.teststeps("Clicked on Cancel Button in document Page");
					wait(2000);
					report.teststeps("Expected Result - Candidate information were filled and submitted successfully");
					System.out.println("Tescase 3: " + tc3 + " - [Passed]");
					report.getPassResult(tc3);
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 3: " + tc3 + " - [Failed]");
			report.errorStatus("Request not Created successfully");
			report.testFail(tc3, logger, e);
		}
	}

	public static void OnboardingValidationCheck() throws Exception {
		String tc4 = "Add Request Validation Check";
		report.createTest(tc4, logger);
		Ajaxcall();
		wait(4000);
		try {
			WebElement addbutton = AddnewrequestObjects.AddNewRequestButton();
			if (addbutton.isDisplayed()) {
				click(AddnewrequestObjects.AddNewRequestButton());
				report.teststeps("Clicked on Add New Request Button");
				wait(3000);
				PageScroll("1500");
				click(AddnewrequestObjects.SaveButton());
				report.teststeps("Clicked on Save&Proceed Button");
				wait(2000);
				PageScroll("-1500");
				WebElement alert1 = AddnewrequestObjects.firstNameAlert();
				WebElement alert2 = AddnewrequestObjects.EmailAlert();
				if (alert1.isDisplayed() && alert2.isDisplayed()) {
					report.teststeps("Validation error messages are Displayed");
					wait(1000);
					PageScroll("1500");
					click(AddnewrequestObjects.AddCancelButton());
					report.teststeps("Clicked on Cancel Button in Add New Request Page");
					report.teststeps("Expected Result - Validation Error message were displayed successfully");
					System.out.println("Tescase 4: " + tc4 + " - [Passed]");
					report.getPassResult(tc4);
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 3: " + tc4 + " - [Failed]");
			report.errorStatus("Validation were not shown while submitting");
			report.testFail(tc4, logger, e);
		}
	}

	public static void DocxSubmissioncheck() throws Exception {
		String tc5 = "Document Attachments Check";
		report.createTest(tc5, logger);
		Ajaxcall();
		wait(3000);
		try {
			WebElement addbutton = AddnewrequestObjects.AddNewRequestButton();
			if (addbutton.isDisplayed()) {
				click(AddnewrequestObjects.AddNewRequestButton());
				report.teststeps("Clicked on Add New Request Button");
				wait(4000);
				WebElement head = AddnewrequestObjects.Headername();
				if (head.isDisplayed()) {
					String check = AddnewrequestObjects.Headername().getText();
					Assert.assertEquals("Add New Request", check);
					report.teststeps("CIS is displayed and Header is present");
					String firstname = generateFirstName();
					String lastname = generateLastName();
					String middlename = generateMiddleName();
					String Mob = generateRandomNumber();
				
					//buissness
					String buissnessCode = agentRandom();
					sendKeys(AddnewrequestObjects.PTE_Business_Code(), buissnessCode);
					report.teststeps("Passed AgentCode - " + buissnessCode);
					String panNumber = RandomPan();
					sendKeys(AddnewrequestObjects.Pan(), panNumber);
					report.teststeps("Passed Pan - " + panNumber);
					String adhaar = agentRandom();
					sendKeys(AddnewrequestObjects.Adhaar(), "2536" + adhaar);
					report.teststeps("Selected AdhaarNumber - 2536" + adhaar);
					wait(1000);
					sendKeys(AddnewrequestObjects.MobileNumber(), Mob);
					report.teststeps("Passed Mobile Number - " + Mob);
					wait(1000);					
					String email = firstname.replace(" ", "") + RandomString() + "@gmail.com";
					sendValueByJs(AddnewrequestObjects.EmailId(), email);
					report.teststeps("Passed E-mail Id - " + email);

					// String d_firstname = Introspector.decapitalize(firstname);
					String d_firstname = firstname.toLowerCase();
					// String d_lastname = Introspector.decapitalize(lastname);
					String d_lastname = lastname.toLowerCase();
					String d_middlename = middlename.toLowerCase();

					// Assert.assertEquals(firstname, Introspector.decapitalize(firstname));
					sendKeys(AddnewrequestObjects.FirstName(), d_firstname);
					report.teststeps("Passed First Name - " + firstname);
					sendKeys(AddnewrequestObjects.MiddleName(), d_middlename);
					report.teststeps("Passed First Name - " + middlename);
					sendKeys(AddnewrequestObjects.LastName(), d_lastname);
					report.teststeps("Passed Last Name - " + lastname);

					selectByValue(AddnewrequestObjects.BranchCode(), 4);
					report.teststeps("Selected BranchCode - AGR1");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Grade(), "M0");
					report.teststeps("Selected Grade - M0");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Department(), "CLCSA");
					report.teststeps("Selected Department - CLCSA");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.SubDepartment(), "Legal");
					report.teststeps("Selected Sub-Department - Legal");
					wait(2000);
					selectByValue(AddnewrequestObjects.Designation(), 1);
					report.teststeps("Selected Designation - Assistant Manager - Legal");
					wait(1000);
					PageScroll("500");
					sendValueByJs(AddnewrequestObjects.ExpectedDOJ(), "2019-08-25");
					report.teststeps("Selected ExpectedDOJ - 2019-08-25");
					sendKeys(AddnewrequestObjects.ProposedCTC(), "213232");
					report.teststeps("Passed ProposedCTC - 213232");
					sendKeys(AddnewrequestObjects.cibilScore(), "8789879");
					report.teststeps("Selected CibilScrore - 8789879");
					wait(1000);
					sendKeys(AddnewrequestObjects.hiringSscore(), "235545");
					report.teststeps("Selected HiringScore - 235545");
					wait(1000);
					selectByValue(AddnewrequestObjects.Source(), 2);
					report.teststeps("Selected Source - Ex-Employee of Exide Life");
					wait(1000);
					PageScroll("200");
					wait(1000);
					click(AddnewrequestObjects.SaveButton());
					report.teststeps(
							"Clicked on Save&Proceed Button and Candidate information were filled and submitted successfully");
					wait(7000);
					waitForPageLoad();
					WebElement docxpage = AddnewrequestObjects.AddAttachHeader();
					if (docxpage.isDisplayed()) {
						String headcheck = AddnewrequestObjects.AddAttachHeader().getText();
						Assert.assertEquals("Add Attachments", headcheck);
						clickCheckboxFromList(AddnewrequestObjects.Exception_Deviation());
						report.teststeps("Checked 'No' in Exception Deviation form");
						report.teststeps("Add Attachment page is displayed");
						clickCheckboxFromList(AddnewrequestObjects.AMC_head());
						report.teststeps("Checked 'No' in AMC Head Approval form");
						wait(1000);
						clickCheckboxFromList(AddnewrequestObjects.RehireApproval());
						report.teststeps("Checked 'Yes' in Rehire Approval form");
						wait(1000);
						click(AddnewrequestObjects.AttachFile1());
						report.teststeps("Clicked Attach File button in Rehire Approval form");
						uploadFiles(AddnewrequestObjects.ChooseFile1(),
								"C:\\Users\\HP\\Documents\\TestingData\\Test.pdf");
						wait(2000);
						report.teststeps("Selected file for Uplaod in Rehire Approval form");
						wait(1000);
						click(AddnewrequestObjects.AddMoreFile());
						report.teststeps("Clicked AddMore button in Rehire Approval form");
						wait(2000);
						click(AddnewrequestObjects.DelAddMore());
						report.teststeps("Clicked Delete button in Rehire Approval form");
						wait(1000);
						clickCheckboxFromList(AddnewrequestObjects.PTEDocket());
						report.teststeps("Checked 'Yes' in PTE Docket form");
						wait(1000);
						click(AddnewrequestObjects.AttachFile2());
						report.teststeps("Clicked Attach File button in PTE Docket form");
						uploadFiles(AddnewrequestObjects.ChooseFile2(),
								"C:\\Users\\HP\\Documents\\TestingData\\Testsample.pdf");
						wait(2000);
						report.teststeps("Selected file for Uplaod in PTE Docket form");
						wait(1000);
						PageScroll("500");
						clickCheckboxFromList(AddnewrequestObjects.AadhaarCard());
						report.teststeps("Checked 'Yes' in Aadhaar Card form");
						wait(1000);
						click(AddnewrequestObjects.AttachFile3());
						report.teststeps("Clicked Attach File button in Aadhaar Card form");
						uploadFiles(AddnewrequestObjects.ChooseFile3(),
								"C:\\Users\\HP\\Documents\\TestingData\\test2pdf.pdf");
						wait(3000);
						report.teststeps("Selected file for Uplaod in Area Regional Manager document");
						wait(1000);
						clickCheckboxFromList(AddnewrequestObjects.PANCard());
						report.teststeps("Checked 'No' in AMC Head document");
						wait(1000);
						click(AddnewrequestObjects.AttachFile4());
						report.teststeps("Clicked Attach File button in PAN Card form");
						uploadFiles(AddnewrequestObjects.ChooseFile4(),
								"C:\\Users\\HP\\Documents\\TestingData\\test2pdf.pdf");
						wait(2000);
						report.teststeps("Selected file for Uplaod in PAN Card form");
						wait(1000);
						PageScroll("200");
						clickCheckboxFromList(AddnewrequestObjects.Photograph());
						report.teststeps("Checked 'No' in Photograph form");
						wait(1000);
						click(AddnewrequestObjects.DocxSubmit());
						wait(4000);
						waitForPageLoad();
						report.teststeps("Clicked on Document Submit Button");
						report.teststeps(
								"Expected Result - CIS were filled and Attachments were added and submitted successfully");
						System.out.println("Tescase 5: " + tc5 + " - [Passed]");
						report.getPassResult(tc5);
					}
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 5: " + tc5 + " - [Failed]");
			report.errorStatus("Document Page is not Displayed or Documents were not attached Successfully");
			report.testFail(tc5, logger, e);
		}
	}

	public static void DocxValidationCheck() throws Exception {
		String tc6 = "Document Page validation & Alert Check";
		report.createTest(tc6, logger);
		wait(4000);
		try {
			WebElement addbutton = AddnewrequestObjects.AddNewRequestButton();
			if (addbutton.isDisplayed()) {
				click(AddnewrequestObjects.AddNewRequestButton());
				report.teststeps("Clicked on Add New Request Button");
				wait(4000);
				WebElement head = AddnewrequestObjects.Headername();
				if (head.isDisplayed()) {
					String check = AddnewrequestObjects.Headername().getText();
					Assert.assertEquals("Add New Request", check);
					report.teststeps("CIS is displayed and Header is present");
					String firstname = generateFirstName();
					String lastname = generateLastName();
					String middlename = generateMiddleName();
					String Mob = generateRandomNumber();
				
					//buissness
					String buissnessCode = agentRandom();
					sendKeys(AddnewrequestObjects.PTE_Business_Code(), buissnessCode);
					report.teststeps("Passed AgentCode - " + buissnessCode);
					String panNumber = RandomPan();
					sendKeys(AddnewrequestObjects.Pan(), panNumber);
					report.teststeps("Passed Pan - " + panNumber);
					String adhaar = agentRandom();
					sendKeys(AddnewrequestObjects.Adhaar(), "2536" + adhaar);
					report.teststeps("Selected AdhaarNumber - 2536" + adhaar);
					wait(1000);
					sendKeys(AddnewrequestObjects.MobileNumber(), Mob);
					report.teststeps("Passed Mobile Number - " + Mob);
					wait(1000);					
					String email = firstname.replace(" ", "") + RandomString() + "@gmail.com";
					sendValueByJs(AddnewrequestObjects.EmailId(), email);
					report.teststeps("Passed E-mail Id - " + email);

					// String d_firstname = Introspector.decapitalize(firstname);
					String d_firstname = firstname.toLowerCase();
					// String d_lastname = Introspector.decapitalize(lastname);
					String d_lastname = lastname.toLowerCase();
					String d_middlename = middlename.toLowerCase();

					// Assert.assertEquals(firstname, Introspector.decapitalize(firstname));
					sendKeys(AddnewrequestObjects.FirstName(), d_firstname);
					report.teststeps("Passed First Name - " + firstname);
					sendKeys(AddnewrequestObjects.MiddleName(), d_middlename);
					report.teststeps("Passed First Name - " + middlename);
					sendKeys(AddnewrequestObjects.LastName(), d_lastname);
					report.teststeps("Passed Last Name - " + lastname);

					selectByValue(AddnewrequestObjects.BranchCode(), 4);
					report.teststeps("Selected BranchCode - AGR1");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Grade(), "M0");
					report.teststeps("Selected Grade - M0");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.Department(), "CLCSA");
					report.teststeps("Selected Department - CLCSA");
					wait(2000);
					selectByVisibleText(AddnewrequestObjects.SubDepartment(), "Legal");
					report.teststeps("Selected Sub-Department - Legal");
					wait(2000);
					selectByValue(AddnewrequestObjects.Designation(), 1);
					report.teststeps("Selected Designation - Assistant Manager - Legal");
					wait(1000);
					PageScroll("500");
					sendValueByJs(AddnewrequestObjects.ExpectedDOJ(), "2019-08-25");
					report.teststeps("Selected ExpectedDOJ - 2019-08-25");
					sendKeys(AddnewrequestObjects.ProposedCTC(), "213232");
					report.teststeps("Passed ProposedCTC - 213232");
					sendKeys(AddnewrequestObjects.cibilScore(), "8789879");
					report.teststeps("Selected CibilScrore - 8789879");
					wait(1000);
					sendKeys(AddnewrequestObjects.hiringSscore(), "235545");
					report.teststeps("Selected HiringScore - 235545");
					wait(1000);
					selectByValue(AddnewrequestObjects.Source(), 2);
					report.teststeps("Selected Source - Ex-Employee of Exide Life");
					wait(1000);
					PageScroll("200");
					wait(1000);
					click(AddnewrequestObjects.SaveButton());					report.teststeps(
							"Clicked on Save&Proceed Button and Candidate information were filled and submitted successfully");
					wait(6000);
					WebElement docxpage = AddnewrequestObjects.AddAttachHeader();
					if (docxpage.isDisplayed()) {
						String headcheck = AddnewrequestObjects.AddAttachHeader().getText();
						Assert.assertEquals("Add Attachments", headcheck);
						report.teststeps("Add Attachment page is displayed");
						clickCheckboxFromList(AddnewrequestObjects.Exception_Deviation());
						report.teststeps("Checked 'No' in Exception and Deviation form");
						wait(1000);
						clickCheckboxFromList(AddnewrequestObjects.AMC_head());
						report.teststeps("Checked 'No' in AMC Head Approval form");
						wait(2000);
						clickCheckboxFromList(AddnewrequestObjects.RehireApproval());
						report.teststeps("Checked 'Yes' in Rehire Approval form");
						wait(2000);
						click(AddnewrequestObjects.AttachFile1());
						report.teststeps("Clicked Attach File button in Rehire Approval form");
						wait(1000);
						PageScroll("1000");
						click(AddnewrequestObjects.DocxSubmit());
						report.teststeps("Clicked on Document Submit Button");
						WebElement ele = AddnewrequestObjects.AlertWindow1();
						if (ele.isDisplayed()) {
							report.teststeps("Alert Window is displayed for Rehire Approval form");
							wait(1000);
							click(AddnewrequestObjects.Alertok());
							report.teststeps("Clicked on Alert Ok button");
							wait(2000);
							uploadFiles(AddnewrequestObjects.ChooseFile1(),
									"C:\\Users\\HP\\Documents\\TestingData\\Largesizefile.pdf");
							report.teststeps("Selected a large file for uplaoding in Rehire Approval form");
							wait(1000);
							isAlertPresent();
							report.teststeps("Alert is displayed");
							wait(1000);
							String alertText = driver.switchTo().alert().getText();
							Assert.assertEquals(alertText, "File too large. File must be less than 2 MB.");
							driver.switchTo().alert().accept();
							report.teststeps("Accepted the Alert");
							wait(1000);
							uploadFiles(AddnewrequestObjects.ChooseFile1(),
									"C:\\Users\\HP\\Documents\\TestingData\\EXIDE.xlsx");
							report.teststeps("Selected a unsupportable file for uplaoding in Rehire Approval form");
							WebElement alert = AddnewrequestObjects.Alert2();
							if (alert.isDisplayed()) {
								String ele1 = AddnewrequestObjects.Alert2().getText();
								Assert.assertEquals(ele1, "Only jpg,png,pdf,msg,docx formats allowed");
								click(AddnewrequestObjects.Alertok());
								report.teststeps("Clicked on Alert Ok button");
								wait(1000);
								clickCheckboxFromList(AddnewrequestObjects.RehireApprovalNo());
								report.teststeps("Checked 'No' in Rehire Approval form");
								wait(1000);
								clickCheckboxFromList(AddnewrequestObjects.PTEDocketNo());
								report.teststeps("Checked 'No' in PTE Docket form");
								wait(1000);
								clickCheckboxFromList(AddnewrequestObjects.AdhaarCardNo());
								report.teststeps("Checked 'No' in Adhaar Card form");
								wait(1000);
								clickCheckboxFromList(AddnewrequestObjects.PANCardNo());
								report.teststeps("Checked 'No' in PAN Card form");
								wait(1000);
								PageScroll("300");
								clickCheckboxFromList(AddnewrequestObjects.Photograph());
								report.teststeps("Checked 'No' in Photograph form");
								wait(1000);
								click(AddnewrequestObjects.DocxSubmit());
								report.teststeps("Clicked on Document Submitted button");
								wait(6000);
								report.teststeps(
										"Expected Result - Document validation and Alerts were present successfully");
								System.out.println("Tescase 6: " + tc6 + " - [Passed]");
								report.getPassResult(tc6);
							}
						}
					}
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 6: " + tc6 + " - [Failed]");
			report.errorStatus("Document Page is not displayed or Validation/Alerts were not displayed");
			report.testFail(tc6, logger, e);
		}
	}
}
