package RCV1_xml2txt;

import static org.junit.Assert.*;

import java.awt.image.ConvolveOp;
import java.io.File;

import org.junit.Test;


public class Tests {
	File testfile = new File("/Users/sven/Documents/reuters/RCV1 english/cd1/19960820/3009newsML.xml");
	File testfile2 = new File("/Users/sven/Documents/reuters/RCV1 english/cd1/19960820/2817newsML.xml");
	File testfile3 = new File("/Users/sven/Documents/reuters/RCV1 english/cd1/19960820/4947newsML.xml");

	@Test
	public void test_xml2txtConverter() throws Exception{
		System.out.println(FileConverter_xml2txt.convert2txt(testfile));
//		System.out.println("looser");
		System.out.println(FileConverter_xml2txt.convert2txt(testfile2));
		System.out.println(FileConverter_xml2txt.convert2txt(testfile3));
	}

}
