package service.side.connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectServer {
	
public static boolean connection() throws IOException
{
	
	URL url = new URL("http://your-server-url.com");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");

	int responseCode = conn.getResponseCode();
	if (responseCode == HttpURLConnection.HTTP_OK) {
	  // The request was successful
	  BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	  String line;
	  while ((line = reader.readLine()) != null) {
	    System.out.println(line);
	  }
	  reader.close();
	} else {
	  // The request failed
	  System.out.println("Response code: " + responseCode);
	}

  return true;
}
	
	
	
	

}
