package CodeSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HotsData {
		public static void main(String[] args) {

			URL url;

			try {
				// get URL content

				String a = "http://heroesofthestorm.gamepedia.com/Falstad?version=bf62a12727dbb685f3c639ac45595b0a";
				http://heroesofthestorm.gamepedia.com/Falstad?version=bf62a12727dbb685f3c639ac45595b0a
				url = new URL(a);
				URLConnection conn = url.openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
				// open the stream and put it into BufferedReader
				BufferedReader br = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				System.out.println("Got input stream.");
				String inputLine;
				while ((inputLine = br.readLine()) != null)
					System.out.println(inputLine);
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}
