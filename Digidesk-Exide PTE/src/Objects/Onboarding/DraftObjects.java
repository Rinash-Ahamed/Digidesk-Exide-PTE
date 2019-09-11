package Objects.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class DraftObjects extends Action{
	
	static By AddNewRequestButton = By.linkText("Add New Request");
	static By Headername = By.xpath("//h1[@class='addsubscr_title']");
	static By MobileNumber = By.id("ref_phone");
	static By EmailId = By.id("ref_email");
	static By FirstName = By.id("ref_fname");
	static By BranchCode = By.id("branchcode");
	static By Save_as_Draft = By.xpath("//button[@class='btn1 btn-primary']");
	
	static By AddCancelButton = By.xpath("//a[contains(@class,'btn1 btn-default')]");
	static By DraftPopup = By.xpath("//div[@id='savedraft']");
	static By DraftPopupName = By.xpath("//div[@class='form-pad']");
	static By PopUpSave =  By.linkText("Yes");
	static By Draftmodule = By.linkText("Draft");
	static By DraftFirstElementName = By.xpath("//tr[@id='app_list_124']//td[1]//strong");
	
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
	public static WebElement BranchCode() {
		return FindElement(BranchCode);
	}
	public static WebElement Save_as_Draft() {
		return FindElement(Save_as_Draft);
	}

	public static WebElement DraftPopup() {
		return FindElement(DraftPopup);
	}
	public static WebElement DraftPopupName() {
		return FindElement(DraftPopupName);
	}
	public static WebElement PopUpSave() {
		return FindElement(PopUpSave);
	}
	public static WebElement Draftmodule() {
		return FindElement(Draftmodule);
	}
	public static WebElement DraftFirstElementName() {
		return FindElement(DraftFirstElementName);
	}
	public static WebElement AddCancelButton() {
		return FindElement(AddCancelButton);
	}

}
