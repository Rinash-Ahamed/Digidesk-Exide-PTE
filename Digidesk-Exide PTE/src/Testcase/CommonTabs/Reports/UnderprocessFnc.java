package Testcase.CommonTabs.Reports;

import Objects.CommonTabs.Reports.UnderprocessObj;
import Utils.Action;

public class UnderprocessFnc extends Action{

	public static void UnderprocessReports() throws Exception {
	wait(4000);
	click(UnderprocessObj.ReportsTab());
	wait(2000);
	click(UnderprocessObj.FilterbyRegion());
	wait(1000);
	click(UnderprocessObj.RegionSelectall());
	wait(1000);
	click(UnderprocessObj.FilterbyState());
	wait(1000);
	click(UnderprocessObj.StateSelectall());
	wait(1000);
	click(UnderprocessObj.FilterbyLocation());
	wait(1000);
	click(UnderprocessObj.LocationSelectall());
	wait(1000);
	selectByValue(UnderprocessObj.DateFilter(),4);
	wait(1000);
	click(UnderprocessObj.DownloadButton());
	}

}
