package nz.alphaone.library.api.ProjectList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nz.alphaone.library.api.Authentication.Authorization;
import nz.alphaone.library.api.Entity.ProjectEntry;
import nz.alphaone.library.api.Response.MarkDoneResponse;
import nz.alphaone.library.api.Util.WebRequest;

import java.util.ArrayList;
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
 * Time: 8:50 PM
 */
public class ProjectListService
{
    private static Authorization authorization;

    public ProjectListService(Authorization auth) {
        authorization = auth;
    }

    public ArrayList<ProjectEntry> getAlphaGoProjectList(int offset)
    {
        Properties headers = new Properties();
        headers.setProperty("username", authorization.getUsername());
        headers.setProperty("session_key", authorization.getSessionKey());

        String api_url = authorization.getApiBaseUrl() + "/v1/alphago/list";
        ArrayList<ProjectEntry> new_list = new ArrayList<>();

        JsonArray list = new JsonArray();
        try {
            WebRequest wr = new WebRequest();
            String response = wr.getRequest(api_url, (new Properties()), headers);

            JsonParser parser = new JsonParser();
            JsonObject jsonObj = (JsonObject) parser.parse(response);
            JsonObject data = jsonObj.get("Data").getAsJsonObject();
            list = data.get("List").getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // reformat to readable object
        for (int i = 0; i < list.size(); i++)
        {
            JsonObject item = list.get(i).getAsJsonObject();
            new_list.add(new ProjectEntry(
                item.get("AlphaID").getAsString(),
                item.get("ConsentNumber").getAsString(),
                item.get("ApplicationState").getAsString(),
                item.get("ApplicationFlag").getAsString(),
                item.get("RequestKey").getAsString()
            ));
        }

        return new_list;
    }

    public MarkDoneResponse markAlphaGoProjectAsDone(ProjectEntry project)
    {
        Properties post_data = new Properties();
        post_data.setProperty("flag", project.getApplicationFlag());
        post_data.setProperty("request_key", project.getRequestKey());

        Properties headers = new Properties();
        headers.setProperty("username", authorization.getUsername());
        headers.setProperty("session_key", authorization.getSessionKey());

        String api_url = authorization.getApiBaseUrl();
        api_url += "/v1/alphago/list/" + project.getAlphaID() + "/mark";

        try {
            WebRequest wr = new WebRequest();
            String response = wr.postRequest(api_url, post_data, headers);

            JsonParser parser = new JsonParser();
            JsonObject jsonObj = (JsonObject) parser.parse(response);

            return new MarkDoneResponse(
                    jsonObj.get("Result").getAsString(),
                    jsonObj.get("Message").getAsString(),
                    jsonObj.get("Timestamp").getAsString(),
                    jsonObj.get("ResponseID").getAsString()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MarkDoneResponse(
                "false", "Error! Failed Request.",
                null, ""
        );
    }
}
