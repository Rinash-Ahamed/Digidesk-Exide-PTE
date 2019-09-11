package Objects.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.Action;

public class LoginObjects extends Action{

	static By userName = By.id("username");
	static By password = By.id("password");
	static By loginButton = By.className("loginLnk");
	static By loginerror = By.xpath("//div[@class='invalid_errors']");
	static By logo = By.xpath("//a[@class='logo-link']//img");
	static By Hellocheck = By.xpath("//span[contains(text(),'Hello')]");
	static By DashboardMetric = By.xpath("//h1[@class='dashTitle'][contains(text(),'Candidates')]");

	
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
	public static WebElement DashboardMetric() {
		return FindElement(DashboardMetric);
	}
}

