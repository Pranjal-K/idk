package com.travelFactory.letsVisitTG;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Letsc {

	public static void main(String[] args) {
		try {
		    URL url = new URL("https://rest.reserve-online.net/property?country=Turkey");
		    String encoding = "dHJpcGZhY3RvcnkyMzYyMzo5MjBBNDQ1Q0JCRDBGMTUwNjk2MEI1NUMyQzM4NjFCM0VGOENFQTgw";
		    
		    // get data
		    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		    connection.setRequestMethod("GET");
		    connection.setDoOutput(true);
		    connection.setRequestProperty("Authorization", "Basic " + encoding);
		    connection.setRequestProperty("Accept", "application/json");
		    InputStream content = connection.getInputStream();
		    
		    BufferedReader in = new BufferedReader(new InputStreamReader(content));
		    
		    // store data in json object
		    JSONParser parse = new JSONParser(); 
		    JSONObject jobj = (JSONObject)parse.parse(in); 
		    System.out.println(jobj);
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}