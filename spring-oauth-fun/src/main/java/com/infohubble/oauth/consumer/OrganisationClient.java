package com.infohubble.oauth.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class OrganisationClient {

	private static final String CONSUMER_KEY = "myKey";
	private static final String CONSUMER_SECRET = "mySecret";

	private static final String CONSUMER_KEY2 = "myKey2";
	private static final String CONSUMER_SECRET2 = "mySecret2";

	private static final OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
			CONSUMER_KEY, CONSUMER_SECRET);

	public static void main(String[] args) throws Exception {

		String url = "http://localhost:8080/spring-oauth-fun/organisations";
		// String url =
		// "http://searchdev.infohubble.com:8080/spring-oauth-fun/organisations";

		HttpGet request = new HttpGet(url);

		// sign the request
		consumer.sign(request);

		// send the request
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = httpClient.execute(request);
		InputStream inputStream = response.getEntity().getContent();

		String result = convertStreamToString(inputStream);
		System.out.println(result);

		// 2nd time
//		response = httpClient.execute(request);
//		inputStream = response.getEntity().getContent();
//		result = convertStreamToString(inputStream);
//		System.out.println(result);
//
//		// 3nd time
//		response = httpClient.execute(request);
//		inputStream = response.getEntity().getContent();
//		result = convertStreamToString(inputStream);
//		System.out.println(result);

	}

	public static String convertStreamToString(InputStream is)
			throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

}
