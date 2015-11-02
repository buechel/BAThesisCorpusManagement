package RCV1_xml2txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;


public class FileConverter_xml2txt {
	final static Pattern textPattern =Pattern.compile("<text>.*</text>", Pattern.DOTALL);
	final static Pattern titlePattern =Pattern.compile("<title>.*</title>", Pattern.DOTALL);
	final static Pattern headlinePattern =Pattern.compile("<headline>.*?</headline>", Pattern.DOTALL);
	final static Pattern datelinePattern =Pattern.compile("<dateline>.*?</dateline>", Pattern.DOTALL);
	
	
//	public static void main (String[] args) throws Exception{
//		File file = new File(args[0]);
//		System.out.println(convert2txt(file));
//	}
	
	/**
	 * Converts a single xml-File from the rcv1 corpus to a txt-file containing only the textbody and the title/headline.
	 * Very simple, regex-based method.
	 * @param inputFile
	 * @return
	 * @throws Exception
	 */
	static String convert2txt(File inputFile) throws Exception{
		String inputString = util.Util.readfile2String(inputFile.getPath(), StandardCharsets.ISO_8859_1);	
		return convertString(inputString);
	}
	
	static String convertString(String inputString){
//		System.out.println(inputString);
		String outputString="";
		//Title
		Matcher matcher = titlePattern.matcher(inputString);
		if (matcher.find()){
			String titleString=matcher.group();
			titleString= titleString.replaceFirst("^<title>", "");
			titleString= titleString.replaceFirst("</title>$", "");
			outputString=outputString+titleString;
		}
		//headline
		matcher = headlinePattern.matcher(inputString);
		if (matcher.find()){
			String headlineString=matcher.group();
			headlineString= headlineString.replaceFirst("^<headline>", "");
			headlineString= headlineString.replaceFirst("</headline>$", "");
			outputString=outputString+"\n"+headlineString;
		}
		//dateline
		matcher = datelinePattern.matcher(inputString);
		if (matcher.find()){
			String datelineString=matcher.group();
			datelineString = datelineString.replaceFirst("^<dateline>", "");
			datelineString = datelineString.replaceFirst("</dateline>$", "");
			outputString=outputString+"\n"+datelineString;
		}
		//text body
		matcher = textPattern.matcher(inputString);
		if (matcher.find()){
			String textString=matcher.group();
			textString = textString.replaceFirst("^<text>", "");
			textString = textString.replaceFirst("</text>$", "");
			textString = textString.replaceAll("<p>", "");
			textString = textString.replaceAll("</p>", "\n");
			outputString=outputString+"\n"+textString;
		}
		return outputString;
	}

}
