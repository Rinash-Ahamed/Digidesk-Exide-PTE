package Objects.CommonTabs.UserManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class UsermanagementObjects extends Action{

	static By UsermanagementTab = By.xpath("//a[@title='User Management']");
	static By Searchbox= By.id("searchKeyword");
	static By SearchButton = By.xpath("//*[@id='main-content']/div/div[2]/div[1]/div[2]/div/a");
	static By ClearSearch = By.linkText("Clear Search");
	static By AddNewUser =By.linkText("Add New User");
	static By UserName =By.id("usrName");
	static By EmailAddress =By.id("usrEmail");
	static By PhoneNumber =By.id("usrPhone");
	static By Region =By.xpath("//*[@id='usercityAccess']/span/div/button");
	static By Regionselectall = By.xpath("//*[@id='usercityAccess']/span/div/ul/li[2]/a/label/input");
	static By State =By.xpath("//*[@id='usercityAccess1']/span/div/button");
	static By Stateselectall = By.xpath("//*[@id='usercityAccess1']/span/div/ul/li[2]/a/label/input");
	static By Location =By.xpath("//*[@id='selPicCity']/div[2]/div/button/span[1]");
	static By Department =By.id("departFilter");
	static By Role =By.id("roleFilter");
	//Below code for Access Settings
	static By AccessRegion =By.xpath("//*[@id='cityAccess']/span/div/button");
	static By RegionAccessall =By.xpath("//*[@id=\"cityAccess\"]/span/div/ul/li[2]/a/label/input");
	static By AccessState =By.xpath("//*[@id='cityAccess1']/span/div/button");
	static By StateAccessall =By.xpath("//*[@id=\"cityAccess1\"]/span/div/ul/li[2]/a/label/input");
	static By AccessCity =By.xpath("//*[@id='cityAccess2']/span/div/button");
	static By CityAccessall =By.xpath("//*[@id='cityAccess2']/span/div/ul/li[2]/a/label/input");
	static By DeleteOption =By.id("delflag");
	static By ToggleOnbarding =By.id("//*[@data-value='On-Boarding']/div/label/div");
	static By Onboardingall =By.id("ONBOARDING_all");
	static By ToggleUserManagement =By.id("//*[@data-value='User Management']/div/label/div");
	static By Usermanagementall =By.id("USERMANAGEMENT_all");
	static By ToggleDashboard =By.id("//*[@data-value='Dashboard']/div/label/div");
	static By Dashboardall =By.id("DASHBOARD_all");
	static By ToggleReport =By.id("//*[@data-value='Report']/div/label/div");
	static By Reportall =By.id("REPORT_all");
	static By ToggleMaster =By.id("//*[@data-value='Master']/div/label/div");
	static By Masterall =By.id("MASTER_all");
	static By CreateUserButton = By.className("frmBtmBtn");
	
	public static List<WebElement> Usermanagement() {
		return driver.findElements(UsermanagementTab);
	}
	public static WebElement Searchbox() {
		return FindElement(Searchbox);
	}
	public static WebElement SearchButton() {
		return FindElement(SearchButton);
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
	public static WebElement EmailAddress() {
		return FindElement(EmailAddress);
	}
	public static WebElement PhoneNumber() {
		return FindElement(PhoneNumber);
	}
	public static WebElement Region() {
		return FindElement(Region);
	}
	public static WebElement Regionselectall() {
		return FindElement(Regionselectall);
	}
	public static WebElement State() {
		return FindElement(State);
	}
	public static WebElement Stateselectall() {
		return FindElement(Stateselectall);
	}
	public static WebElement Location() {
		return FindElement(Location);
	}
	public static WebElement Department() {
		return FindElement(Department);
	}
	public static WebElement Role() {
		return FindElement(Role);
	}
	public static WebElement AccessRegion() {
		return FindElement(AccessRegion);
	}
	public static WebElement RegionAccessall() {
		return FindElement(RegionAccessall);
	}
	public static WebElement AccessState() {
		return FindElement(AccessState);
	}
	public static WebElement StateAccessall() {
		return FindElement(StateAccessall);
	}
	public static WebElement AccessCity() {
		return FindElement(AccessCity);
	}
	public static WebElement CityAccessall() {
		return FindElement(CityAccessall);
	}
	public static WebElement DeleteOption() {
		return FindElement(DeleteOption);
	}
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

}
