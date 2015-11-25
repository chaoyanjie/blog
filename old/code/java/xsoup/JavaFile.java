package us.codecraft.xsoup;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
 
public class JavaFile {
	
	public static String getSql(String str){
		String temp1=str.substring(0,str.indexOf(","));
		String temp2=str.substring(str.indexOf(",")+1);
		return "update shujuk set zc='"+temp2+"'  where fm='"+temp1.trim()+"';";
	}
	
	public static List<String> getUrl(){
		List<String> list=new ArrayList();
		   try {
	            StringBuffer sb= new StringBuffer("");
	            FileReader reader = new FileReader("e://data//test.txt");
	            BufferedReader br = new BufferedReader(reader);
	           
	            String str = null;
	           
	            while((str = br.readLine()) != null) {
	                list.add(str);
	            }
	           
	            br.close();
	            reader.close();
	      }
	      catch(FileNotFoundException e) {
	                  e.printStackTrace();
	            }
	            catch(IOException e) {
	                  e.printStackTrace();
	            }
		   return list;
	      }
		
      public static void main(String[] args) {
            try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
           
            FileReader reader = new FileReader("e://data//data1-1.txt");
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
                  sb.append(str+"/n");
                 
                  System.out.println(getSql(str));
            }
           
            br.close();
            reader.close();
           
            // write string to file
//            FileWriter writer = new FileWriter("c://test2.txt");
//            BufferedWriter bw = new BufferedWriter(writer);
//            bw.write(sb.toString());
//           
//            bw.close();
//            writer.close();
      }
      catch(FileNotFoundException e) {
                  e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
      }
}
 