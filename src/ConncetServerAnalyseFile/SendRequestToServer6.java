package ConncetServerAnalyseFile;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.json.JSONObject;

import store.user.data.StoreUserDataLocal;

public class SendRequestToServer6 {
	private static String fileTotext="";
	private static String fileLocation="C:\\Users\\shafe\\OneDrive\\Desktop\\Resume Many Versions\\Software Developer Ahmed.Sh.cv.docx";
	
	public static void main(String[] args) throws IOException
	{
		
    String text=analyseData();		
		System.out.println(text);
	}
	
	public static String analyseData() throws IOException {
		   // This place should content the data from the user (which is the file that the user insert to the program )
	       // fileLocation=StoreUserDataLocal.getFileCVPathLoaction();
		    fileTotext=convetFileToText(fileLocation);       
	        setFileTotext(fileTotext);
	        fileTotext=analyseDataFile(fileTotext);
	        return fileTotext;
	}
	private static String analyseDataFile(String textFile) throws IOException {
    	fileTotext= SendRequestToServer5.convetFileToText(fileLocation);
        URL url = new URL("http://localhost:5000/hello/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        JSONObject payload = new JSONObject().put("message",fileTotext);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(payload.toString());
        out.flush();
        out.close();		

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
           return response.toString();            
           
        } else {
            System.out.println("Failed to get response from server, response code: " + responseCode);
        }
        return null;
    }
	public static String getFileTotext() {
		return fileTotext;
	}
	public static void setFileTotext(String fileTotext) {
		SendRequestToServer6.fileTotext = fileTotext;
	}
	public static String getFileLocation() {
		return fileLocation;
	}
	public static void setFileLocation(String fileLocation) {
		SendRequestToServer6.fileLocation = fileLocation;
	}
	
	 public static String convetFileToText(String fileLocation) throws IOException {
	        // Create a File object for the input file
	     try (XWPFDocument doc = new XWPFDocument(
	                Files.newInputStream(Paths.get(fileLocation)))) {

	            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
	            String docText = xwpfWordExtractor.getText();        
                return docText;	            
	        
	        }

	    }
	
}
