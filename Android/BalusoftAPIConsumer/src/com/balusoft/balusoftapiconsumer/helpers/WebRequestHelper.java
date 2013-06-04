package com.balusoft.balusoftapiconsumer.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 * @author Isaac Ojeda
 *
 */
public class WebRequestHelper {

	/**
	 * 
	 */
	private static final String URL="http://192.168.1.108/api/";	
	/**
	 * 
	 * @param urlMethod
	 * @return
	 */
	public static String consumeWebService(String urlMethod)
	{
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL+urlMethod);
		httpGet.setHeader("Content-Type","application/json");
		
		try {
			HttpResponse response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if(statusCode == 200){
				HttpEntity entity = response.getEntity();
				InputStream inputStream = entity.getContent();
				BufferedReader reader = 
						new BufferedReader(new InputStreamReader(inputStream));
				String line;
				while((line=reader.readLine()) != null){
					stringBuilder.append(line);
				}
				inputStream.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
}
