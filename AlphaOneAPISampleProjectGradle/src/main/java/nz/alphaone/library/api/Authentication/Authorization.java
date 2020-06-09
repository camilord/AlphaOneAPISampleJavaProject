package nz.alphaone.library.api.Authentication;

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
 * Time: 7:50 PM
 */
public class Authorization
{
    private static String ApiBaseUrl;
    private static String username;
    private static String session_key;
    private static boolean IsAuthorized;

    public Authorization(String url, String usrname, String sessionkey, boolean is_auth) {
        ApiBaseUrl = url;
        username = usrname;
        session_key = sessionkey;
        IsAuthorized = is_auth;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionKey() {
        return session_key;
    }

    public String getApiBaseUrl() {
        return ApiBaseUrl;
    }

    public boolean isAuthorized() {
        return IsAuthorized;
    }
}
