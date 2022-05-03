package net.glacierclient.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API {
    private static HttpURLConnection connection;

    public static String get(String endpoint) {
        try {
            BufferedReader reader;
            String line;
            StringBuffer responceContent = new StringBuffer();
            URL url = new URL("https://api.glacierclient.net/" + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("Origin", "https://api.glacierclient.net");
            connection.setRequestProperty("Access-Control-Credentials", "true");
            connection.setRequestProperty("Access-Control-Request-Method", "GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");


            int status = connection.getResponseCode();
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responceContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responceContent.append(line);
                }
                reader.close();
            }
            connection.disconnect();
            return responceContent.toString();
        } catch (IOException e) {
            return "error";
        }
    }
}
