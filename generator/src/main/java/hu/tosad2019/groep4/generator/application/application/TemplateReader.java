package hu.tosad2019.groep4.generator.application.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class TemplateReader {

	public TemplateReader() {

	}
	
	public Scanner read(String templatename) throws FileNotFoundException {
		URL url = getClass().getClassLoader().getResource(templatename + ".template");

//		Scanner in = new Scanner(new FileReader(templatename + ".template"));

		File myObj = new File(url.getFile());
		Scanner reader = new Scanner(myObj);
		return reader;
	}

}
