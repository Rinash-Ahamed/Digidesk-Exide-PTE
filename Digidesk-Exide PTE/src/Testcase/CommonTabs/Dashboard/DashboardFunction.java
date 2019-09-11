package Testcase.CommonTabs.Dashboard;

import Objects.CommonTabs.Dashboard.DashboardObjects;
import Utils.Action;

public class DashboardFunction extends Action {

	public static void Dashboard() throws InterruptedException {
		wait(2000);
		ChooseFromHeader("Region");
		click(DashboardObjects.selectAll());
		wait(2000);
		JavaScriptForceClick(DashboardObjects.FilterbyState());
		click(DashboardObjects.selectall());
		wait(2000);
		selectByValue(DashboardObjects.FilterbyLocation(),2);
		selectByVisibleText(DashboardObjects.FilterbyToday(),"All Time");
		click(DashboardObjects.FilterbyExecutive());
		wait(1000);
		click(DashboardObjects.FilterButton());
		wait(5000);
	  	click(DashboardObjects.CearFilterButton());
}
	
public static void ChooseFromHeader(String elementName) {
		
		for(int i = 0 ;i<DashboardObjects.FilterbyRegion().size();i++) {
			
			String Text = DashboardObjects.FilterbyRegion().get(i).getText();
				if(Text.equalsIgnoreCase(elementName)) {
					click(DashboardObjects.FilterbyRegion().get(i));
				}
			}
}
}

