package seperateRCV_v2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.*;

public class moveAllFiles {
	public static void main (String args[]) throws IOException{
		File from = new File(args[0]);
		File to = new File(args[1]);
		for (File file: from.listFiles()){
			Files.move(new File(from.toString()+"/"+file.getName()).toPath(), new File(to.toString()+"/"+file.getName()).toPath(), REPLACE_EXISTING);
		}
	}

}
