package Utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import Listeners.MyListener;
import Listeners.TestNGListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class Action {

	public static WebDriver driver;
	public static EventFiringWebDriver edriver;
	public static TestNGListeners itest = new TestNGListeners();
	public static ExtentReport report = new ExtentReport();
	public static SoftAssert softAssert = new SoftAssert();
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String value = "";
	public static Properties properties;
	public static ExtentTest logger;
	public static WebDriverWait wait;
	private static ChromeOptions options;
	// public static Logger log4j;

	private static String url1 = "http://exidelifepte-";
	private static String url2 = ".digidesk.co/index.php";

	// ChromeDriver initialization
	protected static void driverInit(String env, String browser) throws Exception {
		try {
			// System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equals("opera")) {
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
			} else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("no browser is defined in Runner class...");
			}
			String Combine = url1 + env + url2;
			driver.get(Combine);
			driver.manage().window().maximize();
			int code = RestAssured.get(Combine).statusCode();
			Assert.assertEquals(code, 200);
			if (code == 200) {
				System.out.println(Combine + " - retured status code = '" + code + "'");
			} else {
				System.err.println("failed to load URL " + Combine);
			}
			edriver = new EventFiringWebDriver(driver);
			MyListener listen = new MyListener();
			edriver.register(listen);
			wait(2000);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for driver Initialization");
		}
	}

	// For handling chrome Notifications
	public static void gethandleChromeNotification() {
		options = new ChromeOptions();
		options.addArguments("disable-infobars");
	}

	// ReadProp file
	public static String readData(String key) throws IOException {
		properties = new Properties();
		File file = new File(System.getProperty("user.dir"), "src\\Utils\\File.properties");
		FileReader read = new FileReader(file);
		properties.load(read);
		String data = properties.getProperty(key);
		return data;
	}

	// For FindingElement
	public static WebElement FindElement(By element) {
		try {
			return edriver.findElement(element);
		} catch (Exception e) {
			System.out.println("ExceptionFindElement" + e.toString());
		}
		return null;
	}

	// create a path in directory
	public static String configurePath(String UserDirPath) {
		Path path = Paths.get(UserDirPath);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
				System.out.println("Created new Filepath");
			} catch (IOException e) {
				System.out.println("Failed to create new Filepath");
				e.printStackTrace();
			}
		} else {
			System.out.println("Filepath is already available");
		}
		return UserDirPath;
	}

	// To find element with headerName
	public static void ChooseFromHeader(List<WebElement> element, String headerName) {
		for (int i = 0; i < element.size(); i++) {
			String Text = element.get(i).getText();
			if (Text.equalsIgnoreCase(headerName)) {
				click(element.get(i));
			}
		}
	}
	
	//random dropdown selection
	public static void selectRandomValue(List<WebElement> element) {
		//List<WebElement> se = new Select(driver.findElement(By.xpath("//select[@id='country']"))).getOptions();
		List<WebElement> selects = element;
		Random rand = new Random();
		for(WebElement select : selects){
		    List<WebElement> options = element;
		    int all = rand.nextInt(options.size());
		    options.get(all).click();
		} 
	}
	
	// For finding list of elements
	public static void getListofElements(List<WebElement> element) {
		List<WebElement> list = element; // driver.findElement(By.xpath(".//*[@id='__dialog1-footer']/button[1]/div"));
		for (WebElement resultItem : list) {
			String print = resultItem.getText();
			System.out.println(print);
		}
	}

	// For Sendkeys
	public static void sendKeys(WebElement element, String key) {
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			element.sendKeys(key);
		} catch (Exception e) {
			throw new TestException(String.format("Error in sending to the following element: ", key, e.toString()));
		}
	}

	// For clicking element
	public static boolean click(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			element.click();
			return true;
		} catch (Exception c) {
			System.out.println("element not clickable - " + c);
		}
		return false;
	}

	// for mouse hovering
	public static void hoverToElement(WebElement hoverFrom, WebElement hoverTo) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(hoverFrom).moveToElement(hoverTo).click().build().perform();
		} catch (Exception e) {
			System.out.println("element not visible - " + e);
		}
	}

	// For fecthing data from excel
	public static String fetchData(int index, int rowNum, int cellNum) throws IOException {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File("./ExcelDatas/UserAccess.xlsx")));
			sheet = workbook.getSheetAt(index);
			value = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
			return value;
		} catch (Exception r) {
			System.out.println("Driver failed to load Excel" + r.toString());
		}
		return null;
	}

	// For Threadsleep
	public static void wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	// For generating random mailid's
	public static String generateRandomEmailID(String username) {
		String email = null;
		Random rad = new Random();
		for (int j = 1; j <= 1; j++) {
			email = username + rad.nextInt(100) + "@gmail.com";
		}
		return email;
	}
	
	//zooming
	public void zoom(double factor) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("document.body.style.transform = 'scale(' + arguments[0] + ')';" +
	        "document.body.style.transformOrigin = '0 0';",factor);
	  }

	// For Scrollup
	public static void PageScroll(String value) throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + value + ")"); // "window.scrollBy(0,-250)"
		// pass negative value for scrolling up
	}

	// For selecting value from dropdown
	public static void selectByValue(WebElement element, int Index) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(Index);
		} catch (Exception e) {
			System.out.println("Exception occured" + e.toString());
		}
	}

	// For selecting visible from dropdown
	public static void selectByVisibleText(WebElement element, String value) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("Exception occured" + e.toString());
		}
	}

	// For refresh the current page
	public static void Refresh() {
		edriver.navigate().refresh();
	}

	// For removing readonly condition
	public static void removeReadOnly() {
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		for (WebElement input : inputs) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", input);
		}
	}

	// For sending current date in an element
	public static void SendCurrentsDate(WebElement element) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println("Selected Date:" + date1);
		element.sendKeys(date1);
	}

	// for sending desired date in an element
	public static void SendDesiredDate(WebElement element) {
		// Create object of SimpleDateFormat class and decide the format
		SimpleDateFormat currentdate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, +5); // Negative value for prevous / and positive for past date
		// Date after adding the days to the given date
		String newDate = currentdate.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition: " + newDate);
		element.sendKeys(newDate);
	}

	// JavaScript method for datepicker(disabled)
	public static void sendValueByJs(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + value + "');", element);
		} catch (Exception e) {
			System.out.println("Exception occured" + e.toString());
		}
	}

	// For sending date in JQuery readonly field
	public static void SelectJQueryDate(String fromDate, String toDate) {
		// For From or StartDate box
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('start_leave_date').removeAttribute('readonly',0);");
		WebElement fromDateBox = driver.findElement(By.name("from_date"));
		fromDateBox.clear();
		fromDateBox.sendKeys(fromDate); // Enter date in required format

		// For To or EndDate box
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('end_leave_date').removeAttribute('readonly',0);");
		WebElement toDateBox = driver.findElement(By.name("to_date"));
		toDateBox.clear();
		toDateBox.sendKeys(toDate); // Enter date in required format
	}

	// For Comparing two dates and show count -
	// reference//https://crunchify.com/how-to-calculate-the-difference-between-two-java-date-instances/
	public static void Datedifference() throws ParseException {
		String date1 = "07/15/2019";
		String date2 = "07/20/2019";

		String format = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateObj1 = sdf.parse(date1);
		Date dateObj2 = sdf.parse(date2);
		System.out.println(dateObj1);
		System.out.println(dateObj2 + "\n");
		long diff = dateObj2.getTime() - dateObj1.getTime();
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		System.out.println("difference between days: " + diffDays);
	}

	// For force clicking an element
	public static void JavaScriptForceClick(WebElement element) {
		try {
			WebElement data = element;
			String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
			((JavascriptExecutor) driver).executeScript(js, data);
			data.click();
		} catch (Exception e) {
			System.out.println("Exception occured" + e.toString());
		}
	}

	// seting window size
	public static void setWindowSize(int Dimension1, int dimension2) {
		driver.manage().window().setSize(new Dimension(Dimension1, dimension2));
	}

	// For keyboard Events
	public static void keyboardEvents(WebElement webelement, Keys key, String alphabet) {
		webelement.sendKeys(Keys.chord(key, alphabet));
	}

	// For pressing enter key
	public static void PressEnter() {
		Actions press = new Actions(driver);
		press.sendKeys(Keys.ENTER).build().perform();
	}

	// For pressing Down key
	public static void pressKeyDown(WebElement element) {
		element.sendKeys(Keys.DOWN);
	}

	// For pressing Up key
	public static void pressKeyUp(WebElement element) {
		element.sendKeys(Keys.UP);
	}

	// For pressing TAB key
	public static void moveToTab(WebElement element) {
		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
	}

	// For navigate Forward
	public static void navigate_forward() {
		edriver.navigate().forward();
	}

	// For navigate backward
	public static void navigate_back() {
		edriver.navigate().back();
	}

	// For clicking multiple times
	public static void ClickMultipletimes(WebElement element) throws Exception {
		for (int i = 0; i < 3; i++) {
			element.click();
			Thread.sleep(1000);
		}
	}

	// For clicking multiple elements
	public static void clickMultipleElements(WebElement someElement, WebElement someOtherElement) {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement).click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}

	// double click webElement
	public static void doubleClickWebelement(WebElement doubleclickonWebElement) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);
	}

	// For hilighting elements
	public static void highlightelement(WebElement element) {
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: solid red; border: 6px solid yellow;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	// click checkbox from list
	public static void clickCheckboxFromList(WebElement element) {
		WebElement elementToClick = element;
		elementToClick.click();
	}

	// For Clearing texts
	public static void clear(WebElement element) {
		element.clear();
	}

	// For navigating to other URL
	public static void navigateToURL(String URL) {
		System.out.println("Navigating to: " + URL);
		System.out.println("Thread id = " + Thread.currentThread().getId());
		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("URL did not load: " + URL);
			throw new TestException("URL did not load");
		}
	}

	// For getting page title
	public static String getPageTitle() {
		try {
			System.out.print(String.format("The title of the page is: ", driver.getTitle()));
			return driver.getTitle();
		} catch (Exception e) {
			throw new TestException(String.format("Current page title is: ", driver.getTitle()));
		}
	}

	// For Capturing screenshot
	public static String captureScreenshot(String testname) throws IOException {
		// String date = new SimpleDateFormat("hh:mm:ss a").format(new Date());
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + testname + currentdate() + ".png";
		File Destination = new File(Dest);
		FileHandler.copy(source, Destination);
		return Dest;
	}

	// For Drag and Drop
	public static void dragNDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		WebElement SorceLocator = element1;
		WebElement DestinationLocator = element2;
		action.dragAndDrop(SorceLocator, DestinationLocator);
	}

	// For clicking submenu items
	public static void SubMenuselector(WebElement element) {
		Actions makevisible = new Actions(driver);
		makevisible.moveToElement(element).build().perform();
		;
	}

	// For AutoIT
	public static void UploadData(String path) throws IOException {
		Runtime.getRuntime().exec(path);// path of AutoIT.exe file
	}

	// For Upload files using Robot Class
	public static void uploadFiles(WebElement element, String filePath) throws Exception {
		try {
			Robot robot = new Robot();
			element.click();
			robot.setAutoDelay(2000);
			StringSelection select = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("File Upload using Robot class Failed");
			throw (e);
		}
	}

	// For fetching response code
	public static Object getResponsCode() throws Exception {

		String currenturl = driver.getCurrentUrl();
		URL url = new URL(currenturl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		// System.out.println("Response code of the currenturl is " + code);
		if (code == 200) {
			System.out.println("Response code of the currenturl is " + code);
		} else {
			System.out.println("ResponseCode not matched");
		}
		return code;
	}

	// get Respose code of url via RestAssured
	public static void getStatusCode(String url) {
		int code = RestAssured.get(url).statusCode();
		Assert.assertEquals(code, 200);
		System.out.println(url + " - retured status code = '" + code + "'");
	}

	// For information
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	// Method to stopExecution
	public static void close() {
		driver.close();
	}

	// To check alert present or not
	public static boolean isAlertPresent() {
		boolean foundAlert = false;
		wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	// For Js and Jquery waiting
	public static ExpectedCondition<Boolean> Ajaxcall() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
	}

	// Method for wait until page title found
	public static void waitUntil(String pageTitle, int waitsec) throws InterruptedException {
		wait = new WebDriverWait(driver, waitsec);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	// Method for wait element to click
	public static void waitForElement(WebElement element, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	// Method for wait till element found
	public static void waitTillElementFound(WebElement ElementTobeFound, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
	}

	// wait till page loads
	public static void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public static void waitUntilElementTobeCliable(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listElement));
	}

	// Switch parent window
	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

	// Method to open new tab
	public static void OpenNewtab(String url, int tabcount) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabcount));
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Exception occurred in select dropdown" + e.toString());
		}
	}

	// Method to open previous tab
	public static void previoustab(int prevtabcount) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			// Thread.sleep(2000);
			driver.switchTo().window(tabs.get(prevtabcount));
		} catch (Exception e) {
			System.out.println("Exception occurred in select dropdown" + e.toString());
		}
	}

	// get tooltip text
	public static String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		return tooltip;
	}

	// navigate to all link in page
	public static void navigateToEveryLinkInPage(List<WebElement> element) throws InterruptedException {
		List<WebElement> linksize = element;
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		String[] links = new String[linksCount];
		System.out.println("List of links Available: ");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
		}
	}

	// to get currrentDate
	public static String currentdate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date(System.currentTimeMillis());
		String newDate = formatter.format(date);
		// System.out.println(newDate);
		return newDate;
	}

	/* ..........................Random Methods........................ */

	public static String generateRandomNumber() {
		int aNumber = (int) ((Math.random() * 900000000) + 100000000);
		int bNumber = (int) ((Math.random() * 1) + 9);
		return " " + (Integer.toString(aNumber) + Integer.toString(bNumber));
	}

	public static String RandomString() {
		int n = 3;
		String AlphaNumericString = "0123456789"; // +0123456789+abcdefghijklmnopqrstuvxyz
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static String agentRandom() {
		int aNumber = (int) ((Math.random() * 90000000) + 10000000);
		return " " + (Integer.toString(aNumber));
	}

	public static void waitUntilVisible(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public static String generateFirstName() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}

	public static String generateMiddleName() {
		Faker faker = new Faker();
		return faker.name().username();
	}

	public static String generateLastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public static String generateName() {
		Faker faker = new Faker();
		return faker.name().name();
	}

	public static String RandomPan() {
		int n = 3, c = 4, d = 1;
		String Char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Number = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (Char.length() * Math.random());
			sb.append(Char.charAt(index));
		}
		StringBuilder sd = new StringBuilder(c);
		for (int i = 0; i < c; i++) {
			int index1 = (int) (Number.length() * Math.random());
			sd.append(Number.charAt(index1));
		}
		StringBuilder sc = new StringBuilder(d);
		for (int i = 0; i < d; i++) {
			int index2 = (int) (Char.length() * Math.random());
			sc.append(Char.charAt(index2));
		}
		return sb.toString() +"PF"+ sd.toString() + sc.toString();
	}

	public static String generateRandoms(String type) {
		if (type.equals("fullname")) {
			Faker faker = new Faker();
			return faker.name().fullName();
		} else if (type.equals("username")) {
			Faker faker = new Faker();
			return faker.name().username();
		} else if (type.equals("lastname")) {
			Faker faker = new Faker();
			return faker.name().lastName();
		} else {
			Faker faker = new Faker();
			return faker.name().name();
		}
	}
}