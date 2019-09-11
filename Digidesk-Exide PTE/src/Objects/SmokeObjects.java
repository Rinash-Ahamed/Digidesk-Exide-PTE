package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class SmokeObjects extends Action {

	static By userName = By.id("username");
	static By password = By.id("password");
	static By loginButton = By.className("loginLnk");
	static By loginerror = By.xpath("//div[@class='invalid_errors']");
	static By logo = By.xpath("//a[@class='logo-link']//img");
	static By Hellocheck = By.xpath("//span[contains(text(),'Hello')]");
	static By Dashboard = By.linkText("Dashboard");
	static By Onboarding = By.linkText("Onboarding");
		static By AddNewRequestButton = By.linkText("Add New Request");
		static By AddCancelButton = By.xpath("//a[@class='btn1 btn-default']");
		static By Draft = By.linkText("Draft");
		static By QCQueue = By.linkText("Quality Check");
			static By filterAll = By.xpath("//select[@id='dateFilter']");
			static By filterbutton = By.xpath("//a[@class='filterBtn']");
			static By viewDocx = By.xpath("//tr[@id='app_list_318']//a[contains(text(),'View Documents')]");
		static By ORmCleared = By.linkText("ORM Cleared");
			static By ORMComments = By.xpath("//table[@class='queueTable']//tr[@id='app_list_303']//a[contains(text(),'ORM Comments')]");
		static By SSORM = By.linkText("SS helpDesk Orm");
			static By NonStatus = By.xpath("//tr[@id='app_list_311']//td[7]");
		static By QCCompleted = By.linkText("QC Completed");
			static By ReqOL = By.xpath("//a[contains(text(),'Request Offer Letter')]");
		static By OLMenu = By.xpath("//div[@class='header-user-name selectdropdownli']//div//span[@id='arrow_old']");
			static By OLReleased = By.xpath("//a[contains(text(),'OL Released')]");
			static By OLAccept = By.xpath("//a[contains(text(),'OL Accepted')]");
			static By OLReject = By.xpath("//a[contains(text(),'OL Rejected')]");
			static By OLReRequest = By.xpath("//div[@class='header-right-right group dropdown']//li[4]");
		static By AdditionalMenu = By.xpath("//div[@id='header-fade']//div//span[@id='arrow_old']");
			static By ApproveOnboard = By.xpath("//a[contains(text(),'Approve Onboarding')]");
			static By OnboardReject = By.xpath("//a[contains(text(),'Onboarding Rejected')]");
		static By EcodeRequest = By.xpath("//a[contains(text(),'E-Code Requested')]");
		static By Drop = By.xpath("//a[contains(text(),'Dropped')]");
	static By UserMangement = By.linkText("User Management");
		static By AddUser = By.xpath("//a[@class='subscr_crt_btn']");
	static By Reports = By.linkText("Reports");
		static By DownloadCSV = By.xpath("//a[@class='filterBtn']");
	static By Master = By.linkText("Master");
		static By subMenu =By.xpath("//ul[@class='submenu']//div");
		
	static By RoleUser = By.xpath("//div[@class='dropdown']");
	static By Logout = By.xpath("//a[contains(text(),'Logout')]");
	

	public static WebElement userName() {
		return FindElement(userName);
	}

	public static WebElement password() {
		return FindElement(password);
	}

	public static WebElement loginButton() {
		return FindElement(loginButton);
	}

	public static WebElement loginerror() {
		return FindElement(loginerror);
	}

	public static WebElement logo() {
		return FindElement(logo);
	}

	public static WebElement Hellocheck() {
		return FindElement(Hellocheck);
	}
	
	public static WebElement Dashboard() {
		return FindElement(Dashboard);
	}
	public static WebElement Onboarding() {
		return FindElement(Onboarding);
	}
	public static WebElement AddNewRequestButton() {
		return FindElement(AddNewRequestButton);
	}
	public static WebElement AddCancelButton() {
		return FindElement(AddCancelButton);
	}
	public static WebElement Draft() {
		return FindElement(Draft);
	}
	public static WebElement QCQueue() {
		return FindElement(QCQueue);
	}
	public static WebElement filterAll() {
		return FindElement(filterAll);
	}
	public static WebElement filterButton() {
		return FindElement(filterbutton);
	}
	public static WebElement viewDocx() {
		return FindElement(viewDocx);
	}
	public static WebElement ORmCleared() {
		return FindElement(ORmCleared);
	}
	public static WebElement ORMComments() {
		return FindElement(ORMComments);
	}
	public static WebElement SSORM() {
		return FindElement(SSORM);
	}
	public static WebElement NonStatus() {
		return FindElement(NonStatus);
	}
	public static WebElement QCCompleted() {
		return FindElement(QCCompleted);
	}
	public static WebElement ReqOL() {
		return FindElement(ReqOL);
	}
	public static WebElement OLMenu() {
		return FindElement(OLMenu);
	}
	public static WebElement OLReleased() {
		return FindElement(OLReleased);
	}
	public static WebElement OLAccept() {
		return FindElement(OLAccept);
	}
	public static WebElement OLReject() {
		return FindElement(OLReject);
	}
	public static WebElement OLReRequest() {
		return FindElement(OLReRequest);
	}
	public static WebElement AdditionalMenu() {
		return FindElement(AdditionalMenu);
	}
	public static WebElement ApproveOnboard() {
		return FindElement(ApproveOnboard);
	}
	public static WebElement OnboardReject() {
		return FindElement(OnboardReject);
	}
	public static WebElement EcodeRequest() {
		return FindElement(EcodeRequest);
	}
	public static WebElement Drop() {
		return FindElement(Drop);
	}
	public static WebElement UserMangement() {
		return FindElement(UserMangement);
	}
	public static WebElement AddUser() {
		return FindElement(AddUser);
	}
	public static WebElement Reports() {
		return FindElement(Reports);
	}
	public static WebElement DownloadCSV() {
		return FindElement(DownloadCSV);
	}
	public static WebElement Master() {
		return FindElement(Master);
	}
	public static WebElement SubMenu() {
		return FindElement(subMenu);
	}
	public static WebElement RoleUser() {
		return FindElement(RoleUser);
	}
	public static WebElement Logout() {
		return FindElement(Logout);
	}
}
