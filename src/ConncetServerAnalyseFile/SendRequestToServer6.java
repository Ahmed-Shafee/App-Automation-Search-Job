package ConncetServerAnalyseFile;

//Libraries 

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.json.JSONObject;

public class SendRequestToServer6 
{
	//Data Area 
	
	private static String fileTotext = "";
	private static String fileLocation = "";
	
	//Implementation Method 
	
	public static String analyseData() throws IOException 
	{
	   
	   //FileLocation = StoreUserDataLocal.getFileCVPathLoaction();
		
	    fileTotext = convetFileToText(fileLocation);       
	    setFileTotext(fileTotext);
	    fileTotext = analyseDataFile(fileTotext);
	      
	    return fileTotext;
	}
	
	//Function that get data ,return the analyse of the data 
	
	private static String analyseDataFile(String textFile) throws IOException 
	{
		assert(textFile != null);
		
		// How to add the hello file inside the tomcat server 
		
		URL url = new URL("http://localhost:5000/hello/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        JSONObject payload = new JSONObject().put("message",textFile);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(payload.toString());
        out.flush();
        out.close();		

        int responseCode = con.getResponseCode();
        if (responseCode == 200) 
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) 
            {
                response.append(inputLine);
            }
            in.close();
           return response.toString();            
           
        }
        else 
        {
            System.out.println("Failed to get response from server, response code: " + responseCode);
        }
        return null;
    }
	
	public static String convetFileToText(String fileLocation) throws IOException 
	{
		assert(fileLocation == null);
		
		// Create a File object for the input file
		
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(fileLocation)))) 
		 {
		
		    XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
		    String docText = xwpfWordExtractor.getText();
		    xwpfWordExtractor.close();
		    return docText;	            
		    
		 }
	
	}

	// Gets and Sets Functions 
	
	public static String getFileTotext() 
	{
		return fileTotext;
	}
	public static void setFileTotext(String fileTotext) 
	{
		SendRequestToServer6.fileTotext = fileTotext;
	}
	public static String getFileLocation() 
	{
		return fileLocation;
	}
	public static void setFileLocation(String fileLocation) 
	{
		SendRequestToServer6.fileLocation = fileLocation;
	}	
	
}
