package Objects.CommonTabs.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Action;

public class UnderprocessObj extends Action{
	static By ReportsTab =By.linkText("Reports");
	static By FilterbyRegion = By.xpath("//*[@id='regionList']/span/div/button");
	static By RegionSelectall =By.xpath("//*[@id='regionList']/span/div/ul/li[2]/a/label/input");
	static By FilterbyState = By.xpath("//*[@id='stateList']/span/div/button");
	static By StateSelectall =By.xpath("//*[@id='stateList']/span/div/ul/li[2]/a/label/input");
	static By FilterbyLocation = By.xpath("//*[@id='cityList']/span/div/button");
	static By LocationSelectall =By.xpath("//*[@id='cityList']/span/div/ul/li[2]/a/label/input");
	static By DateFilter =By.id("dateFilter");
	static By DownloadButton =By.className("filterBtn");

	public static WebElement ReportsTab() {
		return FindElement(ReportsTab);
	}
	public static WebElement FilterbyRegion() {
		return FindElement(FilterbyRegion);
		}
	public static WebElement RegionSelectall() {
		return FindElement(RegionSelectall);
		}
	public static WebElement FilterbyState() {
		return FindElement(FilterbyState);
		}
	public static WebElement StateSelectall() {
		return FindElement(StateSelectall);
		}
	public static WebElement FilterbyLocation() {
		return FindElement(FilterbyLocation);
		}
	public static WebElement LocationSelectall() {
		return FindElement(LocationSelectall);
		}
	public static WebElement DateFilter() {
		return FindElement(DateFilter);
		}
	public static WebElement DownloadButton() {
		return FindElement(DownloadButton);
		}
}