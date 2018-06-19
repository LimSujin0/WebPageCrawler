package edu.handon.csee.java.webpagecrawler;

import java.util.ArrayList;


public class URLReader {
	static String inputURL = "https://dict.naver.com/";
	static String outputPath = "C://Users//imsuj//Desktop//output.html";
	static ArrayList<String> inputLines = new ArrayList<String>();
	
    public static void main(String[] args) throws Exception {
        if(inputURL.startsWith("$")) {
        	URLReaderMac readerMac = new URLReaderMac();
        	readerMac.readMac();
        }else {
        	URLReaderWindows readerWindows = new URLReaderWindows();
        	readerWindows.readWindows();
        }
        WriteHTML writeFile = new WriteHTML();
        writeFile.createHTML(inputLines, outputPath);
        System.out.println("Successively creat HTML file!");
    }
}