package Objects.UserManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class UserObjects extends Action{

	static By UserManagement = By.linkText("User Management");
	static By ActiveUsers = By.linkText("Active Users");
	static By SearchUser = By.id("searchKeyword");
	static By SearchValidation = By.xpath("//td[contains(text(),'ashokkumar.n@heptagon.in')]");
	static By SearchValidation1 = By.xpath("//td[contains(text(),'9514926381')]");
	static By SearchValidation2 = By.xpath("//td[contains(text(),'rinash.a@heptagon.in')]");
	static By ClearSearch = By.linkText("Clear Search");
	static By AddNewUser = By.linkText("Add New User");
	static By UserName = By.id("usrName");
	static By UserEmail = By.id("usrEmail");
	static By UserPhone = By.id("usrPhone");
	static By UserRegion = By.xpath("(//div//button[@title='Select Region'])[1]");
	static By Regionselectall = By.xpath("//*[@id='usercityAccess']/span/div/ul/li[2]/a/label/input");	
	static By UserLocation = By.xpath("//span[contains(text(),'Select Location')]");
	static By Locationselectall = By.xpath("//*[@id='usercityAccess1']/span/div/ul/li[2]/a/label/input");
	static By UserCity = By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select City')]");
	static By UserDepartment = By.id("departFilter");
	static By UserRole = By.id("roleFilter");
	
	//Access Setting Objects
	static By AccessSettingsHeader = By.xpath("//h1[contains(text(),'Access Settings')]");
	static By AccessRegion = By.xpath("//div[@id='cityAccess']//button[@class='multiselect dropdown-toggle btn btn-default']");
	static By AccessRegionAll = By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input");
	static By AccessState = By.xpath("//div[@id='cityAccess1']//button[@class='multiselect dropdown-toggle btn btn-default']");
	static By AccessStateAll = By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input");
	static By AccessCity = By.xpath("//div[@id='cityAccess2']//button[@class='multiselect dropdown-toggle btn btn-default']");
	static By AccessCityAll = By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input");
	static By AccessDelete = By.xpath("//input[@id='delflag']");
	static By AccessModuleHeader = By.xpath("//h2[contains(text(),'Access Modules')]");
	
	//Access Modules
	static By ToggleOnbarding =By.xpath("(//*[@id='switchslider']//div)[3]");
	static By Onboardingall =By.id("ONBOARDING_all");
	static By ToggleUserManagement =By.xpath("(//*[@id='switchslider']//div)[4]");
	static By Usermanagementall =By.id("USERMANAGEMENT_all");
	static By ToggleDashboard =By.xpath("(//*[@id='switchslider']//div)[5]");
	static By Dashboardall =By.id("DASHBOARD_all");
	static By ToggleReport =By.xpath("(//*[@id='switchslider']//div)[6]");
	static By Reportall =By.id("REPORT_all");
	static By ToggleMaster =By.xpath("(//*[@id='switchslider']//div)[7]");
	static By Masterall =By.id("MASTER_all");
	static By CreateUserButton = By.className("frmBtmBtn");
	
	//alerts
	static By AlertPopUp =By.xpath("//div[@id='alertPop']//div[@class='md-content']");
	static By AlertOK =By.xpath("//a[@class='popAssignBtn']");
	static By AlertSubMenu =By.xpath("//strong[contains(text(),'ONBOARDING')]");
	static By CancelButton =By.xpath("//a[@class='frmBtmcanBtn']");
	
	//Action Elements
	static By Action =By.xpath("//div[@id='dropbutton']");
	static By Edit =By.xpath("//a[contains(text(),'Edit')]");
	static By Delete =By.xpath("//a[contains(text(),'Delete')]");
	static By DeleteUserPopUp =By.xpath("//p[contains(text(),'Are you sure you want to delete this User?')]");
	static By DeleteYes =By.xpath("//a[@class='popAssignBtn']");
	static By NoUserFound =By.xpath("//span[contains(text(),'No user found')]");
	
	public static WebElement UserManagement() {
		return FindElement(UserManagement);
	}
	public static WebElement ActiveUsers() {
		return FindElement(ActiveUsers);
	}
	public static WebElement SearchUser() {
		return FindElement(SearchUser);
	}
	public static WebElement SearchValidation() {
		return FindElement(SearchValidation);
	}
	public static WebElement SearchValidation1() {
		return FindElement(SearchValidation1);
	}
	public static WebElement SearchValidation2() {
		return FindElement(SearchValidation2);
	}
	public static WebElement ClearSearch() {
		return FindElement(ClearSearch);
	}
	public static WebElement AddNewUser() {
		return FindElement(AddNewUser);
	}
	public static WebElement UserName() {
		return FindElement(UserName);
	}
	public static WebElement UserEmail() {
		return FindElement(UserEmail);
	}
	public static WebElement UserPhone() {
		return FindElement(UserPhone);
	}
	public static WebElement UserRegion() {
		return FindElement(UserRegion);
	}
	public static WebElement Regionselectall() {
		return FindElement(Regionselectall);
	}
	public static WebElement UserLocation() {
		return FindElement(UserLocation);
	}
	public static WebElement Locationselectall() {
		return FindElement(Locationselectall);
	}
	public static WebElement UserCity() {
		return FindElement(UserCity);
	}
	public static WebElement UserDepartment() {
		return FindElement(UserDepartment);
	}
	public static WebElement UserRole() {
		return FindElement(UserRole);
	}
	
	
	//Access Setting
	public static WebElement AccessSettingsHeader() {
		return FindElement(AccessSettingsHeader);
	}
	public static WebElement AccessRegion() {
		return FindElement(AccessRegion);
	}
	public static WebElement AccessRegionAll() {
		return FindElement(AccessRegionAll);
	}
	public static WebElement AccessState() {
		return FindElement(AccessState);
	}
	public static WebElement AccessStateAll() {
		return FindElement(AccessStateAll);
	}
	public static WebElement AccessCity() {
		return FindElement(AccessCity);
	}
	public static WebElement AccessCityAll() {
		return FindElement(AccessCityAll);
	}
	public static WebElement AccessDelete() {
		return FindElement(AccessDelete);
	}
	public static WebElement AccessModuleHeader() {
		return FindElement(AccessModuleHeader);
	}
	
	
	//Access Modules
	public static WebElement ToggleOnbarding() {
		return FindElement(ToggleOnbarding);
	}
	public static WebElement Onboardingall() {
		return FindElement(Onboardingall);
	}
	public static WebElement ToggleUserManagement() {
		return FindElement(ToggleUserManagement);
	}
	public static WebElement Usermanagementall() {
		return FindElement(Usermanagementall);
	}
	public static WebElement ToggleDashboard() {
		return FindElement(ToggleDashboard);
	}
	public static WebElement Dashboardall() {
		return FindElement(Dashboardall);
	}
	public static WebElement ToggleReport() {
		return FindElement(ToggleReport);
	}
	public static WebElement Reportall() {
		return FindElement(Reportall);
	}
	public static WebElement ToggleMaster() {
		return FindElement(ToggleMaster);
	}
	public static WebElement Masterall() {
		return FindElement(Masterall);
	}
	public static WebElement CreateUserButton() {	
		return FindElement(CreateUserButton);
	}
	
	//alert
	public static WebElement AlertPopUp() {
		return FindElement(AlertPopUp);
	}
	public static WebElement AlertOK() {
		return FindElement(AlertOK);
	}
	public static WebElement AlertSubMenu() {
		return FindElement(AlertSubMenu);
	}
	public static WebElement CancelButton() {
		return FindElement(CancelButton);
	}
	
	//Action
	public static WebElement Action() {
		return FindElement(Action);
	}
	public static WebElement Edit() {
		return FindElement(Edit);
	}
	public static WebElement Delete() {
		return FindElement(Delete);
	}
	public static WebElement DeleteUserPopUp() {
		return FindElement(DeleteUserPopUp);
	}
	public static WebElement DeleteYes() {
		return FindElement(DeleteYes);
	}
	public static WebElement NoUserFound() {
		return FindElement(NoUserFound);
	}
}
