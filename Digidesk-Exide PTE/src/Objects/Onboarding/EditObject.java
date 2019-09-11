package Objects.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class EditObject extends Action{
	
	//Edit
	static By MobileNumber = By.id("ref_phone");
	static By EmailId = By.id("ref_email");
	static By FirstName = By.id("ref_fname");
	static By UpdateButton = By.xpath("//input[@id='sendMessageButton']");
	static By CandidateQ = By.linkText("Candidate Queue");
	static By filterAll = By.xpath("//select[@id='dateFilter']");
	static By filterbutton = By.xpath("//a[@class='filterBtn']");
	static By headname = By.xpath("//h1[@class='addsubscr_title']");
	static By Action = By.xpath("(//table[@class='queueTable']//tbody//tr[@class='queueTableList odd']//i)[1]");
	static By EditInfo = By.xpath("//tr//a[contains(text(),'Edit Info')]");
	
	//Delete
	static By CQNameToDelete = By.xpath("(//tr[@class='queueTableList odd']//strong)[1]");
	static By Delete = By.xpath("//tr//a[contains(text(),'Delete')]");
	static By PopupText = By.xpath("//p[contains(text(),'Are you sure you want to delete this candidate from onboarding?')]");
	static By Reason = By.id("reason_list");
	static By YesButton = By.linkText("Yes");
	static By Dropped = By.linkText("Dropped");
	
	//SMS/Email 
	static By smsEmail = By.xpath("//tr//a[contains(text(),'Send SMS/Email')]");
	static By smsText = By.xpath("//p[contains(text(),'Would you like to send an SMS/Email to candidate to download the Digidesk App?')]");
	static By sendDropdown = By.xpath("//select[@id='sendSms']");
	static By sendButton = By.xpath("//a[@class='popAssignBtn']");
	static By smsSuccess = By.xpath("//p[contains(text(),'SMS sent successfully!')]");
	static By emailSuccess = By.xpath("//p[contains(text(),'Email sent successfully!')]");
	static By bothSuccess = By.xpath("//p[contains(text(),'SMS and Email sent successfully!')]");
	

	public static WebElement CandidateQ() {
		return FindElement(CandidateQ);
	}
	public static WebElement filterAll() {
		return FindElement(filterAll);
	}
	public static WebElement filterbutton() {
		return FindElement(filterbutton);
	}
	public static WebElement headname() {
		return FindElement(headname);
	}
	public static WebElement Action() {
		return FindElement(Action);
	}
	public static WebElement MobileNumber() {
		return FindElement(MobileNumber);
	}
	public static WebElement EmailId() {
		return FindElement(EmailId);
	}
	public static WebElement EditInfo() {
		return FindElement(EditInfo);
	}
	public static WebElement FirstName() {
		return FindElement(FirstName);
	}
	public static WebElement UpdateButton() {
		return FindElement(UpdateButton);
	}
	public static WebElement Delete() {
		return FindElement(Delete);
	}
	public static WebElement PopupText() {
		return FindElement(PopupText);
	}
	public static WebElement Reason() {
		return FindElement(Reason);
	}
	public static WebElement YesButton() {
		return FindElement(YesButton);
	}
	public static WebElement Dropped() {
		return FindElement(Dropped);
	}
	public static WebElement CQNameToDelete() {
		return FindElement(CQNameToDelete);
	}
	public static WebElement smsEmail() {
		return FindElement(smsEmail);
	}
	public static WebElement smsText() {
		return FindElement(smsText);
	}
	public static WebElement sendDropdown() {
		return FindElement(sendDropdown);
	}
	public static WebElement sendButton() {
		return FindElement(sendButton);
	}
	public static WebElement smsSuccess() {
		return FindElement(smsSuccess);
	}
	public static WebElement emailSuccess() {
		return FindElement(emailSuccess);
	}
	public static WebElement bothSuccess() {
		return FindElement(bothSuccess);
	}
}
