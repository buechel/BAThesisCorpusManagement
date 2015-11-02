package seperateRCV_v2;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.*;

public class RCV_v2_Seperator {
	/**
	 * This class is used to seperate the files of the RCV-v2-Coprus of these of the RCV1-v1 Corpus (see:Lewis, D. D.; Yang, Y.; Rose, T.; and Li, F. RCV1: A New Benchmark Collection for Text Categorization Research. Journal of Machine Learning Research, 5:361-397, 2004.)
	 * Algorithm: 
	 * 1 create directory "RCV-v2" as a sister-node of the folder with the xml files.
	 * 2 read the file (linewise), containing the IDs.
	 * 3 for each line
	 * 4	build expected filename
	 * 5	check if file exists
	 * 5	if not, write into "missing files"
	 * 6	if so, copy in the new folder
	 * 
	 * @param args. First Arguement: Path to the folder where the xml-files lie. Second Argument: Path to the
	 * file which indicates which IDs are part of RCV-v2.
	 * @throws Exception 
	 */
	public static void main (String args[]) throws Exception{
		String failureMessage ="Please indicate folder as first argument and ID-file as second Argument";
		if (! (args.length==2)) throw new Exception(failureMessage);
		ArrayList<String> missingFiles = new ArrayList<String>();
		File xmlFolder = new File(args[0]);
		System.out.println("Files in xml-Folder:");
		for (String file: xmlFolder.list()){
			System.out.println(file);
		}
		if (!xmlFolder.isDirectory()) throw new Exception(failureMessage);
		File v2Folder = new File(xmlFolder.getParent()+"/RCV-v2");
		v2Folder.mkdir();
		File idFile = new File(args[1]);
		List<String> ids = Files.readAllLines(idFile.toPath());
		String expectedFilename;
		File expectedFile;
		boolean exists;
		for (String id: ids){
			expectedFilename = id+"newsML.xml";
			expectedFile = new File(xmlFolder+"/"+expectedFilename);
			exists = expectedFile.isFile();
			if (!exists){ 
				missingFiles.add(expectedFile.getName());}
			else{
				Files.move(expectedFile.toPath(), new File(v2Folder.getPath()+"/"+expectedFilename).toPath(), REPLACE_EXISTING);}
		}
		System.out.println("Missing Files:\n\n");
		for (String missingFile: missingFiles){
			System.out.println(missingFile);
		}
		
	}

}
