package Objects.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class AddnewrequestObjects extends Action {
	

	static By Onboarding = By.linkText("Onboarding");
	static By AddNewRequestButton = By.linkText("Add New Request");
	static By Headername = By.xpath("//h1[@class='addsubscr_title']");
	static By MobileNumber = By.id("ref_phone");
	static By EmailId = By.id("ref_email");
	static By FirstName = By.id("ref_fname");
	static By MiddleName = By.id("ref_mname");
	static By LastName = By.id("ref_lname");
	static By Region = By.id("region");
	static By LocationName = By.id("sel_state");
	static By CityName = By.id("sel_loc");
	static By Calendar = By.xpath("//select[@id='Calendar']");
	static By Grade = By.id("level");
	static By Department = By.id("sel_depart");
	static By SubDepartment = By.id("sel_subdepart");
	static By Designation = By.id("sel_pos");
	static By BranchCode = By.id("branchcode");
	static By ESTBCode = By.id("estb");
	static By ExpectedDOJ = By.xpath("//input[@id='ref_doj']");
	static By ProposedCTC = By.id("pctc");
	static By PTE_Business_Code = By.id("RefAgentCode");
	static By Pan = By.id("RefPannumber");
	static By Adhaar = By.id("aadhar_num");
	static By cibilScore = By.id("cibil_score");
	static By hiringSscore = By.id("hiring_score");
	static By Source = By.id("source");
	static By Internal = By.xpath("//input[@id='sorcevalue']");
	static By SaveButton = By.id("sendMessageButton");
	static By AddCancelButton = By.xpath("//a[@class='btn1 btn-default']");
	
	//AttachmentPage Objects
	static By AddAttachHeader = By.xpath("//h1[@class='addsubscr_title']");
	static By Exception_Deviation = By.xpath("//input[@id='no1049']");
	static By AMC_head = By.xpath("//input[@id='no1217']");
	static By RehireApproval  = By.xpath("//input[@id='yes1218']");
	static By RehireApprovalNo  = By.xpath("//input[@id='no1218']");
		static By AttachFile1 = By.xpath("//a[@id='showAttachDoc1218']");
		static By ChooseFile1 = By.xpath("//div[@id='attachdoc1218']//div[@id='addreq']//div//input[@name='upload_MRF']");
		static By AddMoreFile = By.xpath("//a[@id='upload_doc1218']//img");
		static By DelAddMore = By.xpath("//a[@id='upload_remove']//img");
	static By PTEDocket = By.xpath("//input[@id='yes1242']");
		static By AttachFile2 = By.xpath("//a[@id='showAttachDoc1242']");
		static By ChooseFile2 = By.xpath("//div[@id='attachdoc1242']//div[@id='addreq']//div//input[@name='upload_MRF']");
	static By AadhaarCard = By.xpath("//input[@id='yes1243']");		
		static By AttachFile3 = By.xpath("//a[@id='showAttachDoc1243']");
		static By ChooseFile3 = By.xpath("//div[@id='attachdoc1243']//div[@id='addreq']//div//input[@name='upload_MRF']");
	static By PANCard = By.xpath("//input[@id='yes1244']");	
		static By AttachFile4 = By.xpath("//a[@id='showAttachDoc1244']");
		static By ChooseFile4 = By.xpath("//div[@id='attachdoc1244']//div[@id='addreq']//div//input[@name='upload_MRF']");
	static By Photograph = By.xpath("//input[@id='no1245']");	
	static By AlertWindow1 = By.xpath("//div[@id='alertPop']//div[@class='md-content']");
	static By AlertOk = By.xpath("//a[@class='popAssignBtn']");
	static By Alert2 = By.xpath("//div[contains(text(),'Only jpg,png,pdf,msg,docx formats allowed')]");
	static By AlertOk1 = By.xpath("//a[@class='popAssignBtn']");
	static By PTEDocketNo = By.xpath("//input[@id='no1242']");
	static By AdhaarCardNo = By.xpath("//input[@id='no1243']");
	static By PANCardNo = By.xpath("//input[@id='no1244']");
	static By DocxSubmit = By.linkText("Submit");
	static By DocxCancel = By.xpath("//a[@class='popBookCancelBtn1 popAddNewCancelBtn']");		
	
	static By firstNameAlert = By.xpath("//label[@id='ref_phone-error']");
	static By EmailAlert = By.xpath("//label[@id='ref_email-error']");

	public static WebElement Onboarding() {
		return FindElement(Onboarding);
	}
	public static WebElement AddNewRequestButton() {
		return FindElement(AddNewRequestButton);
	}
	public static WebElement Headername() {
		return FindElement(Headername);
	}
	public static WebElement MobileNumber() {
		return FindElement(MobileNumber);
	}
	public static WebElement EmailId() {
		return FindElement(EmailId);
	}
	public static WebElement FirstName() {
		return FindElement(FirstName);
	}
	public static WebElement MiddleName() {
		return FindElement(MiddleName);
	}
	public static WebElement LastName() {
		return FindElement(LastName);
	}
	public static WebElement LocationName() {
		return FindElement(LocationName);
	}
	public static WebElement CityName() {
		return FindElement(CityName);
	}
	public static WebElement Calendar() {
		return FindElement(Calendar);
	}
	public static WebElement Grade() {
		return FindElement(Grade);
	}
	public static WebElement Department() {
		return FindElement(Department);
	}
	public static WebElement SubDepartment() {
		return FindElement(SubDepartment);
	}
	public static WebElement Designation() {
		return FindElement(Designation);
	}
	public static WebElement PTE_Business_Code() {
		return FindElement(PTE_Business_Code);
	}
	public static WebElement Region() {
		return FindElement(Region);
	}
	public static WebElement Pan() {
		return FindElement(Pan);
	}
	public static WebElement BranchCode() {
		return FindElement(BranchCode);
	}
	public static WebElement ESTBCode() {
		return FindElement(ESTBCode);
	}
	public static WebElement ExpectedDOJ() {
		return FindElement(ExpectedDOJ);
	}
	public static WebElement hiringSscore() {
		return FindElement(hiringSscore);
	}
	public static WebElement Adhaar() {
		return FindElement(Adhaar);
	}
	public static WebElement cibilScore() {
		return FindElement(cibilScore);
	}
	public static WebElement ProposedCTC() {
		return FindElement(ProposedCTC);
	}	
	public static WebElement Source() {
		return FindElement(Source);
	}
	public static WebElement Internal() {
		return FindElement(Internal);
	}
	public static WebElement SaveButton() {
		return FindElement(SaveButton);
	}
	public static WebElement AddCancelButton() {
		return FindElement(AddCancelButton);
	}
	public static WebElement DocxCancel() {
		return FindElement(DocxCancel);
	}
	public static WebElement DocxSubmit() {
		return FindElement(DocxSubmit);
	}
	public static WebElement firstNameAlert() {
		return FindElement(firstNameAlert);
	}
	public static WebElement EmailAlert() {
		return FindElement(EmailAlert);
	}
	
	//AttachmentPage Methods
	public static WebElement Exception_Deviation() {
		return FindElement(Exception_Deviation);
	}
	public static WebElement AMC_head() {
		return FindElement(AMC_head);
	}
	public static WebElement RehireApproval() {
		return FindElement(RehireApproval);
	}
	public static WebElement RehireApprovalNo() {
		return FindElement(RehireApprovalNo);
	}
	public static WebElement AttachFile1() {
		return FindElement(AttachFile1);
	}
	public static WebElement AttachFile2() {
		return FindElement(AttachFile2);
	}
	public static WebElement AttachFile3() {
		return FindElement(AttachFile3);
	}
	public static WebElement AttachFile4() {
		return FindElement(AttachFile4);
	}
	public static WebElement ChooseFile1() {
		return FindElement(ChooseFile1);
	}
	public static WebElement ChooseFile2() {
		return FindElement(ChooseFile2);
	}
	public static WebElement ChooseFile3() {
		return FindElement(ChooseFile3);
	}
	public static WebElement ChooseFile4() {
		return FindElement(ChooseFile4);
	}
	public static WebElement AddMoreFile() {
		return FindElement(AddMoreFile);
	}
	public static WebElement DelAddMore() {
		return FindElement(DelAddMore);
	}
	public static WebElement PTEDocket() {
		return FindElement(PTEDocket);
	}
	public static WebElement PTEDocketNo() {
		return FindElement(PTEDocketNo);
	}
	public static WebElement AadhaarCard() {
		return FindElement(AadhaarCard);
	}
	public static WebElement AdhaarCardNo() {
		return FindElement(AdhaarCardNo);
	}
	public static WebElement Photograph() {
		return FindElement(Photograph);
	}
	public static WebElement PANCard() {
		return FindElement(PANCard);
	}
	public static WebElement PANCardNo() {
		return FindElement(PANCardNo);
	}
	public static WebElement AddAttachHeader() {
	return FindElement(AddAttachHeader);
	}
	public static WebElement AlertWindow1() {
		return FindElement(AlertWindow1);
	}
	public static WebElement Alertok() {
		return FindElement(AlertOk);
	}
	public static WebElement Alert2() {
		return FindElement(Alert2);
	}
	public static WebElement Alertok1() {
		return FindElement(AlertOk1);
	}
	
}