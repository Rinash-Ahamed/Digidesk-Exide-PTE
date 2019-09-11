package Testcase.CommonTabs.UserManagement;

import Objects.CommonTabs.UserManagement.UsermanagementObjects;
import Utils.Action;

public class UsermanagementFunction extends Action {
	
	public static void UserManagement() throws InterruptedException {
	wait(3000);
	ChooseFromHeader("User Management");
	wait(3000);
	sendKeys(UsermanagementObjects.Searchbox(),"merlin");
	wait(1000);
	click(UsermanagementObjects.SearchButton());
	wait(4000);
	click(UsermanagementObjects.ClearSearch());
	wait(1000);
	click(UsermanagementObjects.AddNewUser());
	wait(3000);
	sendKeys(UsermanagementObjects.UserName(),"Susmitha");
	sendKeys(UsermanagementObjects.EmailAddress(),"susmitha@heptagon.in");
	sendKeys(UsermanagementObjects.PhoneNumber(),"7887445628");
	click(UsermanagementObjects.Region());
	wait(1000);
	click(UsermanagementObjects.Regionselectall());
	wait(1000);
	click(UsermanagementObjects.State());
	wait(1000);
	click(UsermanagementObjects.Stateselectall());
	wait(2000);
	selectByValue(UsermanagementObjects.Location(),2);
	wait(1000);
	selectByValue(UsermanagementObjects.Department(),1);
	wait(3000);
	selectByValue(UsermanagementObjects.Role(),3);
	wait(1000);
	PageScroll("500");
	//Functions for access settings
	click(UsermanagementObjects.AccessRegion());
	wait(1000);
	click(UsermanagementObjects.RegionAccessall());
	wait(1000);
	click(UsermanagementObjects.AccessState());
	wait(1000);
	click(UsermanagementObjects.StateAccessall());
	wait(2000);
	click(UsermanagementObjects.AccessCity());
	wait(1000);
	click(UsermanagementObjects.CityAccessall());
	wait(1000);
	click(UsermanagementObjects.DeleteOption());
	wait(1000);
	click(UsermanagementObjects.ToggleOnbarding());
	wait(1000);
	click(UsermanagementObjects.Onboardingall());
	wait(1000);
	click(UsermanagementObjects.ToggleUserManagement());
	wait(1000);
	click(UsermanagementObjects.Usermanagementall());
	wait(1000);
	click(UsermanagementObjects.ToggleDashboard());
	wait(1000);
	click(UsermanagementObjects.Dashboardall());
	wait(1000);
	click(UsermanagementObjects.ToggleReport());
	wait(1000);
	click(UsermanagementObjects.Reportall());
	wait(1000);
	PageScroll("500");
    click(UsermanagementObjects.ToggleMaster());
    wait(1000);
    click(UsermanagementObjects.Masterall());
    wait(1000);
	click(UsermanagementObjects.CreateUserButton());
	}
public static void ChooseFromHeader(String elementName) {
		try {
		for(int i = 0 ;i<UsermanagementObjects.Usermanagement().size();i++) {
			
			String Text = UsermanagementObjects.Usermanagement().get(i).getText();
				if(Text.equalsIgnoreCase(elementName)) {
					click(UsermanagementObjects.Usermanagement().get(i));
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured" +e.toString());
		}
	}
}