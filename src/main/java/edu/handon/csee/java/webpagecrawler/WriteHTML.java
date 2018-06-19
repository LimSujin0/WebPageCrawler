package edu.handon.csee.java.webpagecrawler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WriteHTML {
	public void createHTML(ArrayList<String> result, String output){	
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(output);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter fw = new BufferedWriter(outputStreamWriter);
			for(String line : result)
				fw.write(line);
			fw.flush();
			fw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
