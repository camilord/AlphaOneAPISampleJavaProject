package nz.alphaone.library.api.Response;

import java.math.BigInteger;
import java.sql.Time;

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
    private static String Result;
    private static String Message;
    private static String Timestamp;
    private static String ResponseID;

    public MarkDoneResponse(
        String result,
        String msg,
        String timestamp,
        String response_id
    ) {
        Result = result;
        Message = msg;
        Timestamp = timestamp;
        ResponseID = response_id;
    }

    public String getResult() {
        return Result;
    }

    public String getMessage() {
        return Message;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public String getResponseID() {
        return ResponseID;
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
