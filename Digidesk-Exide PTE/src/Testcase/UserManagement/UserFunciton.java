package Testcase.UserManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Objects.UserManagement.UserObjects;
import Utils.Action;

public class UserFunciton extends Action {

	private static String username = generateName();
	private static String updateName = generateName();
	
	public static void Searchuser() throws Exception {
		String tc11 = "UserManagement SearchBox Check";
		report.createTest(tc11, logger);
		try {
			wait(2000);
			click(UserObjects.UserManagement());
			wait(3000);
			report.teststeps("Clicked On User Management Queue");
			sendKeys(UserObjects.SearchUser(), "Ashok");
			report.teststeps("Searched with User name in SearchBox");
			PressEnter();
			wait(2000);
			report.teststeps("Clicked Enter button");
			WebElement ele = UserObjects.SearchValidation();
			if (ele.isDisplayed()) {
				report.teststeps("User Name is displayed in ActiveUsers page");
				String text = UserObjects.SearchValidation().getText();
				Assert.assertEquals(text, "ashokkumar.n@heptagon.in");
				clear(UserObjects.SearchUser());
				report.teststeps("Cleared SearchBox");
			}
			wait(1000);
			sendKeys(UserObjects.SearchUser(), "9514926381");
			report.teststeps("Searched with User PhoneNumber in SearchBox");
			PressEnter();
			wait(2000);
			report.teststeps("Clicked Enter button");
			WebElement ele1 = UserObjects.SearchValidation1();
			if (ele1.isDisplayed()) {
				report.teststeps("User PhoneNumber is displayed in ActiveUsers page");
				String text = UserObjects.SearchValidation1().getText();
				Assert.assertEquals(text, "9514926381");
				clear(UserObjects.SearchUser());
				report.teststeps("Cleared SearchBox");
			}
			wait(1000);
			sendKeys(UserObjects.SearchUser(), "rinash.a@heptagon.in");
			report.teststeps("Searched with User Email-Id in SearchBox");
			PressEnter();
			wait(2000);
			report.teststeps("Clicked Enter button");
			WebElement ele2 = UserObjects.SearchValidation2();
			if (ele2.isDisplayed()) {
				report.teststeps("User Email-Id is displayed in ActiveUsers page");
				String text = UserObjects.SearchValidation2().getText();
				Assert.assertEquals(text, "rinash.a@heptagon.in");
				click(UserObjects.ClearSearch());
				report.teststeps("Clicked ClearSearch link");
				wait(3000);
				report.teststeps("Expected Result - Search is working properly");
				System.out.println("Tescase 11: " + tc11 + " - [Passed]");
				report.getPassResult(tc11);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 11: " + tc11 + " - [Failed]");
			report.errorStatus(
					"Search option not working properly or search details were not displayed in Active Users page");
			report.testFail(tc11, logger, e);
		}
	}

	public static void AddUserCheck() throws Exception {
		String tc12 = "Add new User Check";
		report.createTest(tc12, logger);
		try {
			wait(3000);
			click(UserObjects.AddNewUser());
			report.teststeps("Clicked on Add New User button");
			wait(3000);
			sendKeys(UserObjects.UserName(), username);
			report.teststeps("Passed Username as - " + username);
			String email = username.replace(" ", "") + RandomString() + "@gmail.com";
			sendKeys(UserObjects.UserEmail(), email);
			report.teststeps("Passed Email-Id as - " + email);
			String phone = generateRandomNumber();
			sendKeys(UserObjects.UserPhone(), phone);
			report.teststeps("Passed PhoneNumber as - " + phone);
			click(UserObjects.UserRegion());
			click(UserObjects.Regionselectall());
			report.teststeps("Selected all in User Region");
			wait(2000);
			click(UserObjects.UserLocation());
			click(UserObjects.Locationselectall());
			report.teststeps("Selected all User Location");
			report.teststeps("City field auto selected a value");
			wait(1000);
			selectByValue(UserObjects.UserDepartment(), 1);
			report.teststeps("Selected User Department as - Human Resource");
			wait(2000);
			selectByValue(UserObjects.UserRole(), 1);
			report.teststeps("Selected User Role as - Admin");
			wait(1000);
			PageScroll("200");
			WebElement ele = UserObjects.AccessSettingsHeader();
			if (ele.isDisplayed()) {
				click(UserObjects.AccessRegion());
				click(UserObjects.AccessRegionAll());
				report.teststeps("Selected all Access Regions");
				wait(1000);
				click(UserObjects.AccessState());
				click(UserObjects.AccessStateAll());
				report.teststeps("Selected all Access States");
				wait(1000);
				click(UserObjects.AccessCity());
				click(UserObjects.AccessCityAll());
				report.teststeps("Selected all Access Cties");
				wait(1000);
				clickCheckboxFromList(UserObjects.AccessDelete());
				report.teststeps("Checked Delete option");
				PageScroll("300");
				wait(2000);
				WebElement ele1 = UserObjects.AccessModuleHeader();
				if (ele1.isDisplayed()) {
					click(UserObjects.ToggleOnbarding());
					report.teststeps("Enabled Toggled button for Onboarding");
					wait(1000);
					clickCheckboxFromList(UserObjects.Onboardingall());
					report.teststeps("Clicked on all onboarding modules");
					wait(1000);
					PageScroll("200");
					click(UserObjects.ToggleUserManagement());
					report.teststeps("Enabled Toggled button for User Management");
					wait(1000);
					clickCheckboxFromList(UserObjects.Usermanagementall());
					report.teststeps("Clicked on all User Management modules");
					wait(1000);
					PageScroll("200");
					click(UserObjects.ToggleDashboard());
					report.teststeps("Enabled Toggled button for Dashboard");
					wait(1000);
					clickCheckboxFromList(UserObjects.Dashboardall());
					report.teststeps("Clicked on all Dashboard modules");
					wait(1000);
					PageScroll("200");
					click(UserObjects.ToggleReport());
					report.teststeps("Enabled Toggled button for Report");
					wait(1000);
					clickCheckboxFromList(UserObjects.Reportall());
					report.teststeps("Clicked on all Report modules");
					wait(1000);
					PageScroll("200");
					click(UserObjects.ToggleMaster());
					report.teststeps("Enabled Toggled button for Master");
					wait(1000);
					clickCheckboxFromList(UserObjects.Masterall());
					report.teststeps("Clicked on all Master modules");
					wait(2000);
					PageScroll("400");
					waitUntilElementTobeCliable(UserObjects.CreateUserButton());
					click(UserObjects.CreateUserButton());
					report.teststeps("Clicked on Create User button");
					wait(9000);
					waitForPageLoad();
					waitUntilElementTobeCliable(UserObjects.SearchUser());
					sendKeys(UserObjects.SearchUser(), username);
					report.teststeps("Searched with Created Username in SearchBox");
					PressEnter();
					report.teststeps("Clicked Enter button");
					wait(2000);
					WebElement search = driver.findElement(
							By.xpath("//tr[@class='queueTableList odd']//td[contains(text(),'" + username + "')]"));
					if (search.isDisplayed()) {
						report.teststeps("Created User is displayed in ActiveUsers list");
						String nametext = search.getText();
						Assert.assertEquals(nametext, username);
						report.teststeps("Expected Result - A new user is created and added to the list successfully");
						System.out.println("Tescase 12: " + tc12 + " - [Passed]");
						report.getPassResult(tc12);
					}
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 12: " + tc12 + " - [Failed]");
			report.errorStatus("User is not created successfully or any element is not found while selecting");
			report.testFail(tc12, logger, e);
		}

	}

	public static void AddUserValidationCheck() throws Exception {
		String tc13 = "Add new User Validations Check";
		report.createTest(tc13, logger);
		try {
			wait(3000);
			click(UserObjects.AddNewUser());
			report.teststeps("Clicked on Add New User button");
			wait(3000);
			String username = generateName();
			sendKeys(UserObjects.UserName(), username);
			report.teststeps("Passed Username as - " + username);
			String email = username.replace(" ", "") + RandomString() + "@gmail.com";
			sendKeys(UserObjects.UserEmail(), email);
			report.teststeps("Passed Email-Id as - " + email);
			String phone = generateRandomNumber();
			sendKeys(UserObjects.UserPhone(), phone);
			report.teststeps("Passed PhoneNumber as - " + phone);
			click(UserObjects.UserRegion());
			click(UserObjects.Regionselectall());
			report.teststeps("Selected all in User Region");
			wait(2000);
			click(UserObjects.UserLocation());
			click(UserObjects.Locationselectall());
			report.teststeps("Selected all User Location");
			report.teststeps("City field auto selected a value");
			wait(1000);
			selectByValue(UserObjects.UserDepartment(), 1);
			report.teststeps("Selected User Department as - Human Resource");
			wait(2000);
			selectByValue(UserObjects.UserRole(), 1);
			report.teststeps("Selected User Role as - Admin");
			wait(1000);
			PageScroll("200");
			WebElement ele = UserObjects.AccessSettingsHeader();
			if (ele.isDisplayed()) {
				click(UserObjects.AccessRegion());
				click(UserObjects.AccessRegionAll());
				report.teststeps("Selected all Access Regions");
				wait(1000);
				click(UserObjects.AccessState());
				click(UserObjects.AccessStateAll());
				report.teststeps("Selected all Access States");
				wait(1000);
				click(UserObjects.AccessCity());
				click(UserObjects.AccessCityAll());
				report.teststeps("Selected all Access Cties");
				wait(2000);
				PageScroll("800");
				wait(2000);
				click(UserObjects.CreateUserButton());
				report.teststeps("Clicked on Create User button");
				wait(2000);
				WebElement alert = UserObjects.AlertPopUp();
				report.teststeps("Select SubMenu items Alert displayed");
				wait(2000);
				if (alert.isDisplayed()) {
					click(UserObjects.AlertOK());
					report.teststeps("Clicked on Alert OK button");
					PageScroll("800");
					wait(2000);
					click(UserObjects.ToggleOnbarding());
					report.teststeps("Enabled Toggled button for Onboarding");
					wait(3000);
					PageScroll("700");
					click(UserObjects.CreateUserButton());
					wait(2000);
					report.teststeps("Clicked on Create User button");
					WebElement ele1 = UserObjects.AlertSubMenu();
					if (ele1.isDisplayed()) {
						String text = ele1.getText();
						Assert.assertEquals(text, "ONBOARDING");
						report.teststeps("Please select SubMenu for - ONBOARDING is displayed");
						click(UserObjects.AlertOK());
						report.teststeps("Clicked on Alert OK button");
						wait(2000);
						PageScroll("1000");
						waitUntilElementTobeCliable(UserObjects.CancelButton());
						click(UserObjects.CancelButton());
						report.teststeps("Clicked on Cancel button");
						wait(5000);
						report.teststeps(
								"Expected Result - Validation Alerts in Add Users page were displayed successfully!");
						System.out.println("Tescase 13: " + tc13 + " - [Passed]");
						report.getPassResult(tc13);
					}
				}
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 13: " + tc13 + " - [Failed]");
			report.errorStatus("Validation Alerts popups were not displayed");
			report.testFail(tc13, logger, e);
		}
	}

	public static void EditUser() throws Exception {
		String tc14 = "UserManagement Edit User Check";
		report.createTest(tc14, logger);
		try {
			wait(2000);
			sendKeys(UserObjects.SearchUser(), username);
			report.teststeps("Searched with already exsisting Username in SearchBox");
			PressEnter();
			report.teststeps("Clicked Enter button");
			wait(1000);
			hoverToElement(UserObjects.Action(), UserObjects.Edit());
			report.teststeps("Hovered to Action and Clicked on Edit button");
			wait(3000);
			waitForPageLoad();
			clear(UserObjects.UserName());
			report.teststeps("Cleared UserName");
			sendKeys(UserObjects.UserName(), updateName);
			report.teststeps("Passed Updated UserName");
			wait(2000);
			waitUntilElementTobeCliable(UserObjects.ToggleMaster());
			PageScroll("500");
			click(UserObjects.ToggleMaster());
			report.teststeps("Disabled MASTER Access");
			wait(1000);
			click(UserObjects.ToggleReport());
			report.teststeps("Disable REPORT Access");
			wait(1000);
			PageScroll("300");
			click(UserObjects.CreateUserButton());
			wait(1000);
			report.teststeps("Clicked on Create User button"); 		
			wait(7000);
			waitForPageLoad();
			sendKeys(UserObjects.SearchUser(), updateName);
			report.teststeps("Searched with Updated Username in SearchBox");
			PressEnter();
			report.teststeps("Clicked Enter button");
			wait(2000);
			WebElement result = driver.findElement(
					By.xpath("//tr[@class='queueTableList odd']//td[contains(text(),'" + updateName + "')]"));
			if (result.isDisplayed()) {
				report.teststeps("Created User is displayed in ActiveUsers list");
				String name = result.getText();
				Assert.assertEquals(name, updateName);
				wait(2000);
				report.teststeps("Expected Result - User Updated Successfully!");
				System.out.println("Tescase 14: " + tc14 + " - [Passed]");
				report.getPassResult(tc14);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 14: " + tc14 + " - [Failed]");
			report.errorStatus("User Updating failed");
			report.testFail(tc14, logger, e);
		}
	}

	public static void DeleteUser() throws Exception {
		String tc15 = "UserManagement Delete User Check";
		report.createTest(tc15, logger);
		try {
			wait(3000);
			sendKeys(UserObjects.SearchUser(), updateName);
			report.teststeps("Searched with already exsisting Username in SearchBox");
			PressEnter();
			report.teststeps("Clicked Enter button");
			wait(1000);
			hoverToElement(UserObjects.Action(), UserObjects.Delete());
			report.teststeps("Hovered to Action and Clicked on Delete button");
			wait(3000);
			waitForPageLoad();
			WebElement ele = UserObjects.DeleteUserPopUp();
			if (ele.isDisplayed()) {
				String text = ele.getText();
				Assert.assertEquals(text, "Are you sure you want to delete this User?");
				report.teststeps("Delete User pop is displayed");
				click(UserObjects.DeleteYes());
				report.teststeps("Clicked on Yes button");
				wait(5000);
				click(UserObjects.ClearSearch());
				report.teststeps("Cleared Search button");
				wait(2000);
				sendKeys(UserObjects.SearchUser(), updateName);
				report.teststeps("Searched with already exsisting Username in SearchBox");
				PressEnter();
				report.teststeps("Clicked Enter button");
				wait(2000);
			}
			WebElement elem = UserObjects.NoUserFound();
			if (elem.isDisplayed()) {
				String ele1 = ele.getText();
				Assert.assertEquals(ele1, "No user found");
				report.teststeps("User Deleted from the Active List");
				report.teststeps("Expected Result - User Deleted Successfully!");
				System.out.println("Tescase 15: " + tc15 + " - [Passed]");
				report.getPassResult(tc15);
				wait(4000);
			}
		} catch (AssertionError e) {
			System.out.println("Tescase 15: " + tc15 + " - [Failed]");
			report.errorStatus("User Deleting failed");
			report.testFail(tc15, logger, e);
		}
	}
}
