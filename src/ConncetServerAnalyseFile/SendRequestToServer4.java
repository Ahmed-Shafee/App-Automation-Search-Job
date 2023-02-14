package ConncetServerAnalyseFile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import store.user.data.StoreUserDataLocal;

public class SendRequestToServer4 {
	private static String text;
    public static String analyseDataFile() throws IOException {
        URL url = new URL("http://localhost:5000/hello/");
        String fileAnalyse=null;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        
        // This place should content the data from the user (which is the file that the user insert to the program )
        String fileLocation=StoreUserDataLocal.getFileCVPathLoaction();
        String FileTotext=convetFileToText(fileLocation);       
        setText(FileTotext);
        
        JSONObject payload = new JSONObject().put("message", text);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(payload.toString());
        out.flush();
        out.close();

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(	new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            fileAnalyse= response.toString();
        } else {
            System.out.println("Failed to get response from server, response code: " + responseCode);
        }
        return fileAnalyse;
    }
	public static String getText() {
		return text;
	}
	private static void setText(String text) {
		SendRequestToServer4.text = text;
	}
	 public static String convetFileToText(String fileLocation) {
	        // Create a File object for the input file
	        File inputFile = new File(fileLocation);
	        String fileContents = null;
	        try {
	            // Create a Scanner to read the input file
	            Scanner scanner = new Scanner(inputFile);

	            // Read the contents of the file and store it as a string
	            StringBuilder stringBuilder = new StringBuilder();
	            while (scanner.hasNextLine()) {
	                stringBuilder.append(scanner.nextLine());
	            }
	             fileContents = stringBuilder.toString();

	            // Close the Scanner
	            scanner.close();

	            // Do something with the file contents (e.g. print it)
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found: " + e.getMessage());
	        }
	        return fileContents;           
	    }

	
}
