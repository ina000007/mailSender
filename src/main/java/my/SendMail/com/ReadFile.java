package my.SendMail.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;;

public class ReadFile {
	public  String getFileContent(String filePath){
		String msg="";
		
		try  {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				msg = msg+sCurrentLine+"\n";
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public void putFileContent(String filePath,String data){
        try{    
            FileWriter fw=new FileWriter(filePath);    
            fw.write(data);    
            fw.close();    
           }catch(Exception e){System.out.println(e);}    
	}
}
