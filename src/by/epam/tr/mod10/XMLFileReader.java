package by.epam.tr.mod10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLFileReader {
	public static void main(String[] args){
		StringBuilder str = new StringBuilder();
		String path = "Example1.xml";
		str = read(path);
		System.out.println(str);
		parse(str);
	}
	
	public static StringBuilder read(String path){
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder str = new StringBuilder();
			while ((br.ready()) == true) {
				str.append(br.readLine());
			}
			fr.close();			
			return str;
		} catch (FileNotFoundException e) {// к этому занятию мы исключения еще не брали, но на всякий случай - так делать не надо
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void parse(StringBuilder str){
		String pattern = "(<([^(?|>|/)]+)>(*)<)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group(2));
			System.out.println(m.group(3));
			//System.out.println(m.group(1));
		}
		/*Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group(0));
		}*/
		
	}

}
