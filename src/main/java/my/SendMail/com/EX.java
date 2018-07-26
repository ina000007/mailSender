package my.SendMail.com;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX {

	public static void main(String[] args) {
		 ReadFile read = new ReadFile();
		// String filePath = "src/main/java/my/SendMail/com/App.java";
		// String s = read.getFileContent(filePath);
		// System.out.println(s);
		String validData="";
		File folder = new File("src");
		File[] listOfFiles = folder.listFiles();
		String fileName = "";
		String data = "";
		ArrayList<String> ls = new ArrayList();
		ls.add("name1");
		ls.add("name5");
		ls.add("name3");
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("spec")) {
				fileName = listOfFiles[i].getName();
				data = read.getFileContent("src/"+fileName);
				validData = getMatchedPath(ls,data);
				read.putFileContent("src/"+fileName, validData);
			}
		}

	}

	public static String getMatchedPath(ArrayList<String> nameList, String data) {
		String validPath = "";
		for (String name : nameList) {
			Pattern p = Pattern.compile(name+".*");
			Matcher m = p.matcher(data);
			while(m.find())
			validPath = validPath+m.group()+"\n";
		}
		return validPath;
	}
}