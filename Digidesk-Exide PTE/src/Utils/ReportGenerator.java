package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ReportGenerator extends Action {

	public FileOutputStream Fileout;
	public Map<String, Object[]> data;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	private int rowNum = 0;
	private int dataIncrementer = 0;
	private String stepsFollowed = "";
	private String testCaseID = "";
	private String testCaseDesc = "";
	private String testCaseStatus = "";
	private String Exception = "";
	private static String TestCaseShort = "TC";
	private int i = 0;
	private int id = 000;
	private String TestCase = "TC";
	private String TCID = "";

	// Function to generate the TestCaseID
	// Input : TestCase Shortcode and Integer Incremented Value
	// Output : The TestCase ID Will be auto generated

	public String setTestCaseID() {
		id++;
		TCID = TestCaseShort + "_" + id;
		// System.out.println(id);
		// System.out.println(TCID);
		return TCID;
	}

	// Function to Get the TestCaseID

	public String getTestCaseID() {
		return setTestCaseID();
	}
	// Function to set header values in the exported excel
	// Input : Default header set
	// Output : Headers added to reporting excel

	public void prepareHeader() {

		data = new TreeMap<String, Object[]>();
		data.put(getTreeIndex(),
				new Object[] { "TC_ID", "TestCaseDesc", "StepsFollowed", "Exception", "TestCaseStatus" });
	}

	// Function to set test case id
	// Input : Test Case Id
	// Output : NA
	public void setTestCaseID(String value) {

		i++;
		stepsFollowed = "";
		testCaseID = "";
		testCaseDesc = "";
		testCaseStatus = "";
		testCaseID = value;
	}

	public void setException(String e) {
		Exception = e;
	}

	public String getException() {
		return Exception;
	}

	public void setTestCaseDesc(String value) {
		testCaseDesc = value;
	}

	public void testCasePassed() {
		testCaseStatus = "Passed";
		setTestCaseDetails();
	}

	public void testCaseFailed() {
		testCaseStatus = "Failed";
		setTestCaseDetails();
	}

	// Function to set header values in the exported excel
	// Input : Default header set
	// Output : Headers added to reporting excel
	public void setTestCaseDetails() {
		data.put(getTreeIndex(),
				new Object[] { getTestCaseID(), testCaseDesc, getStepsFollowed(), getException(), testCaseStatus });
		stepsFollowed = "";
	}

	// Function to increment TreeMap index
	// Input : NA
	// Output : tree map index incremented
	public String getTreeIndex() {

		int value = dataIncrementer;
		dataIncrementer++;
		System.out.println("Data Incrementer : ");
		System.out.println(dataIncrementer);
		return Integer.toString(value);
	}

	// Function to add line breaks in string
	// Input : String
	// Output : Line breaked strings
	public void addStepsFollowed(String value) {
		int count = 0;
		count++;
		if (stepsFollowed.equals(""))
			stepsFollowed = value;
		else
			stepsFollowed += "\n" + value;
		// System.out.println("stepsFollowed " + stepsFollowed);
	}

	// Function to get steps followed
	// Input : NA
	// Output : Steps followed string with linebreaks
	public String getStepsFollowed() {
		return stepsFollowed;
	}

	// Function to write out all data collected when running test cases into an
	// excel file
	// Input : TreeMap representing test case status and details
	// Output : Test case result is exported as excel file
	public void generateTestReport(String fileName) {

		try {
			Fileout = new FileOutputStream(new File("D://ExideTesting//AutomationReport" + fileName + ".xlsx"), true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		workbook = new XSSFWorkbook();

		// Create a blank sheet
		sheet = workbook.createSheet("Test Case Result");

		// Iterate over data and write to sheet
//		Set<String> keyset = data.keySet();
//		int rownum = 0;
//		for (String key : keyset) {
//			Row row = sheet.createRow(rownum++);
//			Object [] objArr = data.get(key);
//			int cellnum = 0;
//			for (Object obj : objArr) {
//				Cell cell = row.createCell(cellnum++);
//				if(obj instanceof Date) 
//					cell.setCellValue((Date)obj);
//				else if(obj instanceof Boolean)
//					cell.setCellValue((Boolean)obj);
//				else if(obj instanceof String)
//					cell.setCellValue((String)obj);
//				else if(obj instanceof Integer)
//					cell.setCellValue((Integer)obj);
//			}
//		}
		Set<String> keyset = data.keySet();
		for (String key : keyset) {

			// this creates a new row in the sheet
			Row row = sheet.createRow(rowNum++);

			System.out.println("Row Number");
			System.out.println(rowNum);

			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		try {
			workbook.write(Fileout);
			Fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
