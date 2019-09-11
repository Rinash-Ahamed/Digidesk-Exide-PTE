package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

public class pdfGenerattion extends Action {

	static String date = currentdate().toString();
	private static File Output = new File("C:\\Users\\HP\\Desktop\\EclipseReport\\report" + date + ".pdf");
	private static File Input = new File("./Extent/ExecutionReport-02-08-2019.html");
	static String cssSource = "https://cdn.rawgit.com/anshooarora/extentreports-java/b4a58fcfd1e137bd9287244035a7c80d3d73b3af/dist/css/extent.css";

	public static void main(String[] args) {
		try {
			ConverterProperties converter = new ConverterProperties();
			converter.setFontProvider(new DefaultFontProvider(true, true, true));
			HtmlConverter.convertToPdf(new FileInputStream(Input), new FileOutputStream(Output), converter);

//			Document document = new Document();
//			PdfWriter.getInstance(document, new FileOutputStream(Output));
//			document.open();
//			Paragraph p = new Paragraph("");
//			document.add(p);
//			document.close();

			// you need to link it in head section of your html file add: link
			// rel="stylesheet" type="text/css" href="PATHTOCSSHERE"> . <---- :dont forget
			// to put the path to the css file

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
