package edu.handon.csee.java.webpagecrawler;

import java.util.ArrayList;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class MainURL {
	static ArrayList<String> inputLines = new ArrayList<String>();
	private static boolean help;
	static String inputURL;
	static String outputPath;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Options options = createOptions();
		if(parseOptions(options, args)) {
			help = false;
			if(help) {
				printHelp(options);
				return;
			}
		}
    	ReadURL readerURL = new ReadURL();
    	readerURL.readURL();
    	WriteHTML writerHTML = new WriteHTML();
    	writerHTML.createHTML(inputLines, outputPath);
    	System.out.println("Successively creat HTML file!");

	}

	private static boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			inputURL = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			help = cmd.hasOption("h");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}

	private static void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "Web page crawler program";
		String footer = "\nPlease report issues at https://github.com/LimSujin0/WebPageCrawler/Issues";
		formatter.printHelp("WebPageCrawler", header, options, footer, true);

	}

	private static Options createOptions() {
		Options options = new Options();
		options.addOption(Option.builder("u").longOpt("inputURL")
				.desc("Set a URL that contain web page you want to save.")
				.hasArg()
				.argName("A URL address.")
				.required()
				.build());
		options.addOption(Option.builder("d").longOpt("outputPath")
				.desc("Set a file path name where the HTML file are saved.")
				.hasArg()
				.argName("A output Path.")
				.required()
				.build());
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help. ")
				.build());

		return options;
	}
}
