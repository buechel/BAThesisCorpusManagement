package RCV1_xml2txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.*;

import org.hamcrest.core.SubstringMatcher;

import static java.nio.file.StandardCopyOption.*;

public class RCV1_xml2txt_Converter {

	/**
	 * 
	 * @param args: Arg 1: Folder of XML-File. Arg2: A Folder where the resulting txt-files should be saved.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File source = new File(args[0]);
		File target = new File(args[1]);
		for (File sourcefile: source.listFiles()){
			System.err.println("Reading file... \t\t"+sourcefile.getName());
			String txtContent = FileConverter_xml2txt.convert2txt(sourcefile);
			String targetFileName = sourcefile.getName().substring(0, sourcefile.getName().length()-4)+".txt";
			File targetFile = new File(target.toString()+"/"+targetFileName);
			FileWriter writer = new FileWriter(targetFile);
			writer.write(txtContent);
			writer.close();
		}

	}

}
