package Runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Testcase.SmokeFunction;
import Utils.Action;

public class SmokeRunner extends Action{
	
	public SmokeRunner() throws Exception {
		driverInit("test","firefox");
	}
	

	@Test
	public static void SmokeTest() throws Exception {
		SmokeFunction.Smoke();
		}
	
	@AfterTest
	public static void TearDown() throws Exception {
	driver.close();
	}
}
