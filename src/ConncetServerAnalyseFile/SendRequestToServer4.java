package ConncetServerAnalyseFile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SendRequestToServer4 {
	static String text;
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:5000/hello/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        
        // This place should content the data from the user (which is the file that the user insert to the program )
        setText("Test String");
        
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
            System.out.println(response.toString());
        } else {
            System.out.println("Failed to get response from server, response code: " + responseCode);
        }
    }
	public static String getText() {
		return text;
	}
	public static void setText(String text) {
		SendRequestToServer4.text = text;
	}
}
