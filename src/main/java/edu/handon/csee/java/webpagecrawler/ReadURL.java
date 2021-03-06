package edu.handon.csee.java.webpagecrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadURL extends MainURL{
	
    public void readURL() throws Exception{
        URL oracle = new URL(inputURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            inputLines.add(inputLine);
        }
        in.close();
        System.out.println("***Example usage of the program in Windows or Mac***");
        System.out.println("	C:\\> WebPageCrawler -u "+ inputURL + " -d " + outputPath);
        System.out.println("	$ WebPageCrawler -u " + inputURL + " -d " + outputPath + "\n");
    }

}
