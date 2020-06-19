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
    private String AlphaID;
    private String ConsentNumber;
    private String ApplicationState;
    private String ApplicationFlag;
    private String RequestKey;

    public ProjectEntry(
        String alpha_id, String consent_id, String app_state,
        String app_flag, String request_key
    ) {
        this.AlphaID = alpha_id;
        this.ConsentNumber = consent_id;
        this.ApplicationState = app_state;
        this.ApplicationFlag = app_flag;
        this.RequestKey = request_key;
    }

    public String getAlphaID() {
        return AlphaID;
    }

    public void setAlphaID(String alphaID) {
        AlphaID = alphaID;
    }

    public String getConsentNumber() {
        return ConsentNumber;
    }

    public void setConsentNumber(String consentNumber) {
        ConsentNumber = consentNumber;
    }

    public String getApplicationState() {
        return ApplicationState;
    }

    public void setApplicationState(String applicationState) {
        ApplicationState = applicationState;
    }

    public String getApplicationFlag() {
        return ApplicationFlag;
    }

    public void setApplicationFlag(String applicationFlag) {
        ApplicationFlag = applicationFlag;
    }

    public String getRequestKey() {
        return RequestKey;
    }

    public void setRequestKey(String requestKey) {
        RequestKey = requestKey;
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
