package Objects.CommonTabs.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Action;

public class ClosureReportObj extends Action{

	static By ClosureReports =By.linkText("Closure Reports");
	static By FilterbyRegion = By.xpath("//*[@id='regionList']/span/div/button");
	static By RegionSelectall =By.xpath("//*[@id='regionList']/span/div/ul/li[2]/a/label/input");
	static By FilterbyState = By.xpath("//*[@id='stateList']/span/div/button");
	static By StateSelectall =By.xpath("//*[@id='stateList']/span/div/ul/li[2]/a/label/input");
	static By FilterbyLocation = By.xpath("//*[@id='cityList']/span/div/button");
	static By LocationSelectall =By.xpath("//*[@id='cityList']/span/div/ul/li[2]/a/label/input");
	static By Weekly =By.xpath("//*[@id='dateFilter']");
	static By Status =By.xpath("//*[@id='reportType']");
	static By DownloadButton =By.className("filterBtn");

	public static WebElement ClosureReports() {
		return FindElement(ClosureReports);
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
	public static WebElement Weekly() {
		return FindElement(Weekly);
		}
	public static WebElement Status() {
		return FindElement(Status);
		}
	public static WebElement DownloadButton() {
		return FindElement(DownloadButton);
		}
} 

