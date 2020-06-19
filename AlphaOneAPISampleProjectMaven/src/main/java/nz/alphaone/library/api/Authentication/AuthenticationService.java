package nz.alphaone.library.api.Authentication;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nz.alphaone.library.api.Common.AppConfig;
import nz.alphaone.library.api.Util.WebRequest;

import java.sql.Connection;
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
 * Date: 8/06/2020
 * Time: 8:41 PM
 */
public class AuthenticationService
{
    private static AppConfig Config;

    /**
     * @param config AppConfig
     */
    public AuthenticationService(AppConfig config) {
        Config = config;
    }

    /**
     * authenticate api access
     * @return Authorization
     */
    public Authorization authenticate()
    {
        String api_url = Config.getApiBaseUrl() + "/v1/authenticate";
        Properties post_data = new Properties();
        post_data.setProperty("username", Config.getConfig().getProperty("username"));
        post_data.setProperty("key", Config.getConfig().getProperty("password"));
        Authorization authorization;

        try {
            WebRequest wr = new WebRequest();
            String response = wr.postRequest(api_url, post_data);

            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(response);

            if (jsonObject.get("status").getAsString().equals("ok"))
            {
                authorization = new Authorization(
                    Config.getApiBaseUrl(),
                    Config.getUsername(),
                    jsonObject.get("session_key").getAsString(),
                    true
                );
            } else {
                authorization = new Authorization("", "", "", false);
            }

        } catch (Exception e) {
            System.out.println("failed");
            authorization = new Authorization("", "", "", false);
        }

        return authorization;
    }
}
