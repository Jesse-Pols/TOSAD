package hu.tosad2019.groep4.generator.application.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class TemplateReader {

	public TemplateReader() {

	}
	
	public Scanner read(String templatename) throws FileNotFoundException {
		URL url = getClass().getClassLoader().getResource("templates/RuleTemplates/" + templatename + ".template");
		File myObj = new File(url.getFile().replaceAll("%20", " "));
		Scanner reader = new Scanner(myObj);
		return reader;
	}

}
