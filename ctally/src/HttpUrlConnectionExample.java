import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class HttpUrlConnectionExample {
 
  private List<String> cookies;
  private HttpURLConnection conn;
 
  private final String USER_AGENT = "Mozilla/5.0";
 
  public String GetPageContent(String url)  {
 
	URL obj=null;;
	try {
		obj = new URL(url);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn = (HttpURLConnection) obj.openConnection();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
	// default is GET
	try {
		conn.setRequestMethod("GET");
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
	conn.setUseCaches(false);
 
	// act like a browser
	conn.setRequestProperty("User-Agent", USER_AGENT);
	conn.setRequestProperty("Accept",
		"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	if (cookies != null) {
		for (String cookie : this.cookies) {
			conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
		}
	}
	int responseCode=0;
	String inputLine;
	StringBuffer response = new StringBuffer();
	BufferedReader in=null;
	try {
		responseCode = conn.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((inputLine = in.readLine()) != null) 
			response.append(inputLine);
			
			in.close();
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,"No Internet Connection");
	}
	
	
	
 
	// Get the response cookies
	setCookies(conn.getHeaderFields().get("Set-Cookie"));
 
	return response.toString();
 
  }

 
  public List<String> getCookies() {
	return cookies;
  }
 
  public void setCookies(List<String> cookies) {
	this.cookies = cookies;
  }
 
	public boolean isInternetReachable()
	{
		try {
	        //make a URL to a known source
	        URL url = new URL("http://www.google.com");

	        //open a connection to that source
	        HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

	        //trying to retrieve data from the source. If there
	        //is no connection, this line will fail
	        Object objData = urlConnect.getContent();
	        //System.out.println("SUCCESSFUL INTERNET CONNECTION");

	    } catch (UnknownHostException e) {
	        // TODO Auto-generated catch block

	        //System.out.println("CONNECTION FAILED");
	        //e.printStackTrace();
	        return false;
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        //System.out.println("CONNECTION FAILED");
	        //e.printStackTrace();
	        return false;
	    }
	    return true;
	}
  
}