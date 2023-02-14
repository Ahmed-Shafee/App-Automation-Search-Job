package ConncetServerAnalyseFile;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SendRequestToServer2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:5000/text");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("text", "Hello, World!");

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(json.toString());
            out.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Response code: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
