package Testcase.CommonTabs.Reports;

import Objects.CommonTabs.Reports.ClosureReportObj;
import Utils.Action;

public class ClosureReportsFnc extends Action{

	public static void ClosureReports() throws Exception {
		wait(3000);
		click(ClosureReportObj.ClosureReports());
		wait(2000);
		click(ClosureReportObj.FilterbyRegion());
		wait(1000);
		click(ClosureReportObj.RegionSelectall());
		wait(1000);
		click(ClosureReportObj.FilterbyState());
		wait(1000);
		click(ClosureReportObj.StateSelectall());
		wait(1000);
		click(ClosureReportObj.FilterbyLocation());
		wait(1000);
		click(ClosureReportObj.LocationSelectall());
		wait(1000);
		selectByValue(ClosureReportObj.Weekly(),1);
		wait(1000);
		selectByValue(ClosureReportObj.Status(),1);
		wait(1000);
		click(ClosureReportObj.DownloadButton());
		}

}

