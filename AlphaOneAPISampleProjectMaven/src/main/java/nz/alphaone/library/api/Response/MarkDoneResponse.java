package nz.alphaone.library.api.Response;

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
 * Time: 9:07 PM
 */
public class MarkDoneResponse
{
    private boolean Result;
    private String Message;
    private long Timestamp;
    private String ResponseID;

    public MarkDoneResponse(
        boolean result,
        String msg,
        long timestamp,
        String response_id
    ) {
        Result = result;
        Message = msg;
        Timestamp = timestamp;
        ResponseID = response_id;
    }

    public boolean getResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }

    public String getResponseID() {
        return ResponseID;
    }

    public void setResponseID(String responseID) {
        ResponseID = responseID;
    }

    @Override
    public String toString() {
        return "MarkDoneResponse {\n" +
                "\tResult: " + Result + ", \n" +
                "\tMessage: " + Message + ", \n" +
                "\tTimestamp: " + Timestamp + ", \n" +
                "\tResponseID: " + ResponseID + ", \n" +
                "}";
    }
}
