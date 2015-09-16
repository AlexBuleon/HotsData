package CodeSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HotsData {

	public static String getHtmlSource(String heroName) {

		URL url;

		try {
			// get URL content
			String a = "http://heroesofthestorm.gamepedia.com/" + heroName;
			url = new URL(a);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				builder.append(inputLine + "\n");
			br.close();
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Hero hero = new Hero("Falstad");
	}
}
