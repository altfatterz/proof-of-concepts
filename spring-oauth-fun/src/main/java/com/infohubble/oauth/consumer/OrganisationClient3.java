package com.infohubble.oauth.consumer;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: zoli
 * Date: 4/18/12
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrganisationClient3 {

    private static final String CONSUMER_KEY = "myKey";
    private static final String CONSUMER_SECRET = "mySecret";

    private static final String CONSUMER_KEY2 = "myKey2";
    private static final String CONSUMER_SECRET2 = "mySecret2";

    private static final OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
            CONSUMER_KEY, CONSUMER_SECRET);

    public static void main(String[] args) throws Exception {

        String targetUrl = "http://searchdev.infohubble.com:8080/spring-oauth-fun/organisations";
        String mainUrl = "http://dummy-altfatterz.apigee.com/spring-oauth-fun/organisations";

        HttpGet request = new HttpGet(targetUrl);

        // sign the request
        consumer.sign(request);

        Header authorizationHeader = request.getHeaders("Authorization")[0];

        request = new HttpGet(mainUrl);
        request.addHeader(authorizationHeader);

        // send the request
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        InputStream inputStream = response.getEntity().getContent();

        String result = convertStreamToString(inputStream);
        System.out.println(result);

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
