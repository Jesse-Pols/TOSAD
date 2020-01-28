package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TemplateParser {

	public static String parse(BusinessRule businessRule, HashMap<String, String> variables) {
		String rawfile = "";
		String replacedfile = "";
		Scanner ruleSc;
		Scanner headerSc;
		Scanner footerSc;

//		try {
////			ruleSc = new TemplateReader().read(templatename);
//			headerSc = new TemplateHeaderFooterReader().readHeader(variables);
//			footerSc = new TemplateHeaderFooterReader().readHeader(variables);
//
//
//
//
//       } //catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
////			System.err.println("Template with name " + templatename + " not found.");
//			return null;
//		}

//		rawfile += fillRawFile(ruleSc, headerSc, footerSc);
//
//		replacedfile = rawfile;
//		Set<Map.Entry<String, String>> set = variables.entrySet();
//
//	    for (Entry<String, String> me : set) {
//	    	replacedfile = replacedfile.replace("{{"+me.getKey()+"}}", me.getValue());
//	    }
//
//		System.out.println(replacedfile);
//
//		return replacedfile;

		return fillTemplate(businessRule.getName(), variables);
	}

	public static String fillTemplate(String templatename, HashMap<String, String> variables) {

		String templateCode = null;

		try {
			Scanner ruleSc = new TemplateReader().read(templatename);
			Scanner headerSc = new TemplateHeaderFooterReader().readHeader();
			Scanner footerSc = new TemplateHeaderFooterReader().readFooter();

			templateCode = fillRawFile(ruleSc, headerSc, footerSc);

			Set<Map.Entry<String, String>> set = variables.entrySet();

			templateCode = loopThoughVariables(set, templateCode);

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.err.println("Template with name " + templatename + " not found.");
		}

		return templateCode;
	}

	public static String fillRawFile(Scanner ruleSc, Scanner headerSc, Scanner footerSc) {

		String rawFile = "";

		while(headerSc.hasNextLine()) {
			rawFile += headerSc.nextLine() + "\n";
		}

		while(ruleSc.hasNextLine()) {
			rawFile += ruleSc.nextLine() + "\n";
		}

		while(headerSc.hasNextLine()) {
			rawFile += footerSc.nextLine() + "\n";
		}

		ruleSc.close();
		headerSc.close();
		footerSc.close();

		return rawFile;
	}

	public static String loopThoughVariables(Set<Map.Entry<String, String>> list, String templateCode) {

		String filledTemplateCode = "";
		filledTemplateCode = templateCode;

		for (Entry<String, String> me : list) {

			filledTemplateCode = filledTemplateCode.replace("{{" + me.getKey() + "}}", me.getValue());
		}

		return filledTemplateCode;
	}
}
