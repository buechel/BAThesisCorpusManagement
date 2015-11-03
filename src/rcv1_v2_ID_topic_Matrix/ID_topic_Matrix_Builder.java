package rcv1_v2_ID_topic_Matrix;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import util.Util;

public class ID_topic_Matrix_Builder {
	
	public static void main (String[] args) throws Exception{
		Exception failure = new Exception("Please pass 3 arguments: 1 - ID-file; 2 - topic-file; 3 - topics per ID.");
		if (!(args.length==3)) throw failure;
		File IDFile = new File(args[0]);
		File topicFile = new File  (args[1]);
		File ID_Topic_File = new File (args[2]);
	
		
		//Read files
		String[] ID_Vector = Util.readFile2Array(IDFile.getPath(), StandardCharsets.UTF_8);
		String[] topic_Vector = Util.readFile2Array(topicFile.getPath(), StandardCharsets.UTF_8);
		String[] IDs_per_Topic = Util.readFile2Array(ID_Topic_File.getPath(), StandardCharsets.UTF_8);
		boolean[][] ID_Topic_Matrix = new boolean[ID_Vector.length][topic_Vector.length];
//	Ich lasse den output erstmal so. Es ist flexibler, wenn ich es mir gleich anzeigen lassen kann.
		//redirect output
//		PrintStream originalStream = System.out;
//		PrintStream newOut = new PrintStream(outputFile);
//		System.setOut(newOut);
		
		
		//Matrix füllen.
		for (String line: IDs_per_Topic){
			String[] parts = line.split(" ");
			String topic = parts[0];
			String ID = parts[1];
			int IDindex = Arrays.binarySearch(ID_Vector, ID, null); //die binäre Suche in diesem riesigen Array dauert vll zu lange...
			int topicIndex = Arrays.binarySearch(topic_Vector, topic, null);
			try {
				ID_Topic_Matrix[IDindex][topicIndex]=true;
			} catch (Exception e) {
				System.err.println("ID or topic not found!\n\tID:\t\t"+ID+"\n\ttopic\t\t"+topic);
			}
		}
		
		//Ausgabe
		//Print head-line of output table
		System.out.print ("\nID");
		for (String topic: topic_Vector) System.out.print("\t"+topic);
		System.out.print("\n");
		//alle anderen Reihen ausgeben.
		for (int IDindex = 0; IDindex < ID_Vector.length; IDindex++ ){
			System.out.print(ID_Vector[IDindex]);
			for (int topicIndex = 0; topicIndex < topic_Vector.length; topicIndex++){
				System.out.print("\t");
				int bool2int = (ID_Topic_Matrix[IDindex][topicIndex]) ? 1 : 0;
				System.out.print(bool2int);
			}
			System.out.print("\n");
		}
		
		
	}

}
