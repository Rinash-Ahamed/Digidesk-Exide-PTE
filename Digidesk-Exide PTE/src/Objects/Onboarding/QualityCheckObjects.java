package Objects.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Action;

public class QualityCheckObjects extends Action{
	
	static By QualityCheck = By.linkText("Quality Check");
	static By ViewDocuments = By.xpath("(//div[@id='tabResults']//tr[@class='queueTableList odd']//td[5])[1]//a[contains(text(),'View Documents')]");
	
	public static WebElement QualityCheck() {
		return FindElement(QualityCheck);
	}
	public static WebElement ViewDocuments() {
		return FindElement(ViewDocuments);
	}
}

