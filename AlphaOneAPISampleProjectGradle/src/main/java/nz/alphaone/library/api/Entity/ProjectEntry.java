package nz.alphaone.library.api.Entity;

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
 * Time: 8:38 PM
 */
public class ProjectEntry
{
    private static String AlphaID;
    private static String ConsentNumber;
    private static String ApplicationState;
    private static String ApplicationFlag;
    private static String RequestKey;

    public ProjectEntry(
        String alpha_id, String consent_id, String app_state,
        String app_flag, String request_key
    ) {
        AlphaID = alpha_id;
        ConsentNumber = consent_id;
        ApplicationState = app_state;
        ApplicationFlag = app_flag;
        RequestKey = request_key;
    }

    public String getAlphaID() {
        return AlphaID;
    }

    public String getApplicationState() {
        return ApplicationState;
    }

    public String getApplicationFlag() {
        return ApplicationFlag;
    }

    public String getRequestKey() {
        return RequestKey;
    }

    @Override
    public String toString() {
        return "{\n\tAlphaID: " + AlphaID + ", \n" +
                "\tApplicationState: " + ApplicationState + ", \n" +
                "\tApplicationFlag: " + ApplicationFlag + ", \n" +
                "\tRequestKey: " + RequestKey + ", \n" +
                "}";
    }
}
