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
    private String ApiBaseUrl;
    private String username;
    private String session_key;
    private boolean IsAuthorized;

    public Authorization(String url, String usrname, String sessionkey, boolean is_auth) {
        ApiBaseUrl = url;
        username = usrname;
        session_key = sessionkey;
        IsAuthorized = is_auth;
    }

    public String getApiBaseUrl() {
        return ApiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        ApiBaseUrl = apiBaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionKey() {
        return session_key;
    }

    public void setSessionKey(String session_key) {
        this.session_key = session_key;
    }

    public boolean isAuthorized() {
        return IsAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        IsAuthorized = authorized;
    }
}
