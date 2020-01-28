package hu.tosad2019.groep4.generator.application.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class TemplateHeaderFooterReader {

    public Scanner readHeader() throws FileNotFoundException {

        URL url = getClass().getClassLoader().getResource("templates/HEADER_TEMPLATE.template");
        File myObj = new File(url.getFile().replaceAll("%20", " "));
        Scanner reader = new Scanner(myObj);
        return reader;
    }

    public Scanner readFooter() throws FileNotFoundException {

        URL url = getClass().getClassLoader().getResource("templates/FOOTER_TEMPLATE.template");
        File myObj = new File(url.getFile().replaceAll("%20", " "));
        Scanner reader = new Scanner(myObj);
        return reader;
    }


}
