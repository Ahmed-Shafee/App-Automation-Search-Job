package ConncetServerAnalyseFile;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendRequestToServer1 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:5000/tasks/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        String payload = "{\"title\":\"Task 3\",\"description\":\"Description 3\"}";
        byte[] payloadBytes = payload.getBytes();
        con.setRequestProperty("Content-Length", Integer.toString(payloadBytes.length));

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(payloadBytes);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());
    }
}
