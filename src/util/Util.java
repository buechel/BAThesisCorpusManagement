package util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Util {
	public static String readfile2String(String path, Charset encoding) throws IOException{
		List<String> lines = Util.readFile2List(path, encoding);
		String output = "";
		for (String line: lines){
			if (!output.isEmpty()) output=output+"\n";
			output=output+line;
		}
		return output;
	}
	
	
	/**
	 * Reads a given File und returns it listwise. Also works when packed in jar-File.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFile2List(String path, Charset encoding) throws IOException{
		List<String> lines = new ArrayList<String>();
		lines = Files.readAllLines(Paths.get(path), encoding);
		return lines;
	}
	
	public static String[] readFile2Array(String path, Charset encoding) throws IOException{
		List<String> lineList = readFile2List(path, encoding);
		return lineList.toArray(new String[lineList.size()]);
	}
	
	public static void writeList2File(List<String> list, String path) throws IOException{
		FileWriter writer = new FileWriter(path); 
		for (String line : list){
			writer.write(line+'\n');
		}
		writer.close();
	}

}
