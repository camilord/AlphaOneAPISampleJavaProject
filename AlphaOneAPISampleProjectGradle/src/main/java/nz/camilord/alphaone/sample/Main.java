package nz.camilord.alphaone.sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nz.alphaone.library.api.Common.AppConfig;
import nz.alphaone.library.api.Util.WebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

/**
 * AlphaOneAPISampleProject
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 5/06/2020
 * Time: 8:59 AM
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello AlphaOne API, from Java 11");

        System.out.println("\nAPI CREDENTIALS:");
        AppConfig config = new AppConfig();
        System.out.println("  - " + config.getConfig().get("api_base_url"));
        System.out.println("  - " + config.getConfig().get("username"));
        System.out.println("  - " + config.getConfig().get("password"));

        System.out.println("\n");

        String urlx = "https://tauranga-api.abcs.co.nz/v1/reference/inspections";
        try {
            WebRequest wr = new WebRequest();
            String response = wr.getRequest(
                    urlx,
                    (new Properties()),
                    config.getConfig()
            );
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("failed");
        }

        System.out.println("\n");

        String sURL = "https://hostgator.abcs.co.nz/submissionget_160907.json"; //just a string

        // Connect to the URL using java's native library

        try {
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            String zipcode = rootobj.get("submission_guid").getAsString(); //just grab the zipcode

            System.out.println(zipcode);

            JsonArray vrfi = rootobj.get("submission_rfis").getAsJsonArray();
            System.out.println(vrfi);

            JsonObject prop = rootobj.get("property").getAsJsonObject();
            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
