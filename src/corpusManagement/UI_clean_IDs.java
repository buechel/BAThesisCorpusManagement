package corpusManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UI_clean_IDs {

	/**
	 * Kleine Hilfsklasse, die meinen Output des Emotionanalyzer des reuters-Korpus bereinigt, sodass
	 * ich statt Dateinamen nur noch IDs habe, sodass ich diese mit der Tabelle der IDs und Topics
	 * mergen kann.
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException{
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		FileWriter fw = new FileWriter(outputFile);
		List<String> inputLines = Files.readAllLines(inputFile.toPath(), StandardCharsets.UTF_8);	
		for (String line: inputLines){
			fw.write(line.replace("newsML.txt\t", "\t") + "\n");
		}
		
	}
}
