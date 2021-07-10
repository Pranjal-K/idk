package com.travelFactory.letsVisitTG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONObject jobj = null;
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
		    jobj = (JSONObject)parse.parse(in); 
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.getWriter().print(jobj);
	}

}
