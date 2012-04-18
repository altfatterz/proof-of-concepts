package com.infohubble.oauth.consumer;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.security.oauth.provider.ConsumerAuthentication;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: zoli
 * Date: 4/17/12
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrganisationClient2 {

    private static final String CONSUMER_KEY = "myKey";
    private static final String CONSUMER_SECRET = "mySecret";

    private static final OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
            CONSUMER_KEY, CONSUMER_SECRET);

    //private static String url = "http://localhost:8080/organisations";
    private static String url = "http://infohubble-altfatterz.apigee.com/spring-oauth-fun/organisations";

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; i++) {
            System.out.println("Sent request:" + i);
            sendRequest();
        }
    }

    private static void sendRequest() throws Exception {

        HttpGet request = new HttpGet(url);

        // sign the request
        consumer.sign(request);

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
