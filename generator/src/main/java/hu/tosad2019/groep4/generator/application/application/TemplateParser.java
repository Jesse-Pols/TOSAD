package hu.tosad2019.groep4.generator.application.application;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TemplateParser {

	public static String parse(String templatename, HashMap<String, String> variables) {
		String rawfile = "";
		String replacedfile = "";
		Scanner sc;

		try {
			sc = new TemplateReader().read(templatename);
		} catch (FileNotFoundException e) {
			System.err.println("Template with name " + templatename + " not found.");
			return null;
		}
		while (sc.hasNextLine()) {
			rawfile += sc.nextLine() + "\n";
		}
		sc.close();

		replacedfile = rawfile;
		Set<Map.Entry<String, String>> set = variables.entrySet();

	    for (Entry<String, String> me : set) {
	    	replacedfile = replacedfile.replace("{{"+me.getKey()+"}}", me.getValue());
	    }

		System.out.println(replacedfile);

		return replacedfile;
	}
	
}
