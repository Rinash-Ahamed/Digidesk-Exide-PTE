package Objects.CommonTabs.Dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Action;

public class DashboardObjects extends Action{
	static By FilterbyRegion = By.xpath("//*[@id='regionList']/span/div/button");
	static By selectAll = By.xpath("//*[@id='regionList']/span/div/ul/li[2]/a/label/input");
	static By FilterbyState = By.xpath("//*[@id='stateList']/span/div/button");
	static By selectall = By.xpath("//*[@id=\"stateList\"]/span/div/ul/li[2]/a/label/input");
	static By FilterbyLocation = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/div[1]/div[3]/div/button/span[1]");
	static By FilterbyToday = By.id("dateFilter");
	static By FilterbyExecutive = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/div[1]/div[7]/div/button/span[1]");
	static By FilterButton = By.className("filterBtn");
	static By CearFilterButton = By.className("clrFilter");
	
	public static List<WebElement>  FilterbyRegion() {
		return driver.findElements(FilterbyRegion);
	}
	public static WebElement selectAll() {
		return FindElement(selectAll);
	}
	public static WebElement FilterbyState() {
		return FindElement(FilterbyState);
	}
	public static WebElement selectall() {
		return FindElement(selectall);
	}
	public static WebElement FilterbyLocation() {
		return FindElement(FilterbyLocation);
	}
	public static WebElement FilterbyToday() {
		return FindElement(FilterbyToday);
	}
	public static WebElement FilterbyExecutive() {
		return FindElement(FilterbyExecutive);
	}
	public static WebElement FilterButton() {
		return FindElement(FilterButton);
	}
	public static WebElement CearFilterButton() {
		return FindElement(CearFilterButton);
	}
	
}
