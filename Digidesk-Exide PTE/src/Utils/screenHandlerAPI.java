package wordCheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;

public class screenHandlerAPI {

	static WebDriver driver;
	
	
	//For Checking
	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://mvnrepository.com/");
			captureAndPaste("sampleFile", "newDoc");
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String printScreen(String screenName) throws IOException {
		try {
			Path filepath = Paths.get("./screens");
			if (!Files.exists(filepath)) {
				Files.createDirectories(filepath);
				System.out.println("created filepath");
			} else {
				System.out.println("filepath exsist");
			}
		} catch (IOException e) {
			System.out.println("filepath creation failed" + e.toString());
		}
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/screens/" + screenName + ".png";
		File Destination = new File(Dest);
		FileHandler.copy(source, Destination);
		return Dest;
	}

	public static void createDocument(String pathTOCreateWithFileName) throws Exception {
		try {
			@SuppressWarnings("resource")
			XWPFDocument document = new XWPFDocument();
			FileOutputStream create = new FileOutputStream(new File(pathTOCreateWithFileName + ".docx"));
			document.write(create);
			create.close();
			System.out.println("createdocument.docx written successully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void captureAndPaste(String screenName, String docxName) throws Exception {
		try {
			printScreen(screenName);
			String dir = System.getProperty("user.dir") + "/screens/" + screenName + ".png";
			String screen = screenName.toLowerCase().trim() + ".png";
			FileOutputStream fos = new FileOutputStream("path" + docxName + ".docx"); // enter your path
			XWPFDocument docx = new XWPFDocument();
			XWPFParagraph para = docx.createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);
			System.out.println("XWPFrun initialized");
			XWPFRun run = para.createRun();
			InputStream image = new FileInputStream(new File(dir));
			run.setText(screenName);
			run.addBreak();
			run.addPicture(image, XWPFDocument.PICTURE_TYPE_PNG, screen, Units.toEMU(350), Units.toEMU(350));
			run.addBreak();
			docx.write(fos);
			fos.flush();
			fos.close();
			docx.close();
			System.out.println("Document Closed Successfully");
		} catch (Exception e) {
			throw new Exception(String.format("Failed function captureAndPaste: " + e.toString()));
		}
	}
}