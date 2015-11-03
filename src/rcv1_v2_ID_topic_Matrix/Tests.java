package rcv1_v2_ID_topic_Matrix;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import util.Util;

public class Tests {

	@Test
	public void test() throws Exception {
		File ids = File.createTempFile("ids", "txt");
		File topics = File.createTempFile("topics", "txt");
		File ids_topics = File.createTempFile("ids_topics", "txt");
		
		List<String> idList = Arrays.asList(new String[]{"1", "2", "3", "4"});
		List<String> topicList = Arrays.asList(new String[]{"t1", "t2", "t3", "t4"});
		List<String> id_topic_list = Arrays.asList(new String[]{"t1 1 1", "t2 2 1", "t3 3 1", "t4 4 1", "t4 1 1"});
		
		Util.writeList2File(idList, ids.getPath());
		Util.writeList2File(topicList, topics.getPath());
		Util.writeList2File(id_topic_list, ids_topics.getPath());
		
		ID_topic_Matrix_Builder.main(new String[]{ids.getPath(), topics.getPath(), ids_topics.getPath()});
	}

}
