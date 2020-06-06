package nz.alphaone.library.api.Util;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 6/06/2020
 * Time: 10:49 PM
 */
public class WebRequest {

    /**
     * get content using get method without params parameter
     * @param url String
     * @return String
     */
    public String getRequest(String url) {
        Properties params = new Properties();
        params.setProperty("t", EncryptionUtil.md5((new Date()).toString()));
        try {
            return getRequest(url, params, (new Properties()));
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     * get content using get method without params parameter
     * @param url String
     * @return String
     */
    public String getRequest(String url, Properties params) {
        try {
            return getRequest(url, params, (new Properties()));
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     * get content using get method
     *
     * @param url String
     * @param params Properties
     * @return String
     * @throws IOException
     * @throws InterruptedException
     */
    public String getRequest(String url, Properties params, Properties headers)
            throws IOException, InterruptedException
    {
        String get_params = "";
        @SuppressWarnings("unchecked")
        Enumeration<String> enums = (Enumeration<String>) params.propertyNames();
        while (enums.hasMoreElements())
        {
            String key = URLEncoder.encode(enums.nextElement(), StandardCharsets.UTF_8);
            String value = URLEncoder.encode(params.getProperty(key), StandardCharsets.UTF_8);

            get_params = (get_params.equals("")) ?
                    String.format("%s=%s", key, value) :
                    String.format("&%s=%s", key, value);
        }
        url = url + "?" + get_params;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        if (headers.isEmpty()) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
        } else {
            // add authorization header entries
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .setHeader("Auth-username", (
                        (headers.containsKey("username")) ?
                            headers.getProperty("username") : ""
                    ))
                    .setHeader("Auth-session-key", (
                        (headers.containsKey("session_key")) ?
                                headers.getProperty("session_key") : ""
                    ))
                    .build();
        }

        // send request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        // return response as a string
        return response.body();
    }

    public String postRequest(String url, Properties params, Properties headers) {


        return "";
    }

}
