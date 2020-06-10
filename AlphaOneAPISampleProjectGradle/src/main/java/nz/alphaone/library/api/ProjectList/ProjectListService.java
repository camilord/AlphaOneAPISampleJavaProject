package nz.alphaone.library.api.ProjectList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nz.alphaone.library.api.Authentication.Authorization;
import nz.alphaone.library.api.Entity.ConsentData;
import nz.alphaone.library.api.Entity.DataConfig;
import nz.alphaone.library.api.Entity.ProjectEntry;
import nz.alphaone.library.api.Entity.SubmissionStatuses;
import nz.alphaone.library.api.Response.MarkDoneResponse;
import nz.alphaone.library.api.Response.ProjectDetailsResponse;
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
        if (offset > 0) {
            api_url += String.format("/%d", offset);
        }
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

    /**
     * @param AlphaID String
     * @return ProjectDetailsResponse
     */
    public ProjectDetailsResponse getProjectDetails(String AlphaID)
    {
        Properties headers = new Properties();
        headers.setProperty("username", authorization.getUsername());
        headers.setProperty("session_key", authorization.getSessionKey());

        String api_url = authorization.getApiBaseUrl();
        api_url += "/v1/alphago/details/" + AlphaID;
        ProjectDetailsResponse projectDetailsResponse = new ProjectDetailsResponse();

        try {
            WebRequest wr = new WebRequest();
            String response = wr.postRequest(api_url, (new Properties()), headers);

            JsonParser parser = new JsonParser();
            JsonObject jsonObj = (JsonObject) parser.parse(response);

            if (jsonObj.get("Result").getAsBoolean())
            {
                JsonObject dataObj = jsonObj.get("Data").getAsJsonObject();

                projectDetailsResponse.setSubmissionGuid(dataObj.get("submission_guid").getAsString());
                projectDetailsResponse.setSubmissionRef(dataObj.get("submission_ref").getAsString());
                projectDetailsResponse.setSubmissionTitle(dataObj.get("submission_title").getAsString());
                projectDetailsResponse.setDescriptionOfWork(dataObj.get("description_of_work").getAsString());
                projectDetailsResponse.setTaName(dataObj.get("ta_name").getAsString());
                projectDetailsResponse.setTaConsentId(dataObj.get("ta_consent_id").getAsString());
                projectDetailsResponse.setConsentId(dataObj.get("consent_id").getAsString());

                // set data config
                JsonObject configObj = dataObj.getAsJsonObject("config");
                DataConfig dataConfig = new DataConfig(configObj.get("use_compiled_pdf").getAsString());
                projectDetailsResponse.setConfig(dataConfig);

                // set consent data
                JsonObject consentDataObj = dataObj.getAsJsonObject("consent_data");
                ConsentData consentData = new ConsentData();
                consentData.setApplicationType(consentDataObj.get("application_type").toString());
                consentData.setBuildingComplexity(consentDataObj.get("building_complexity").toString());
                consentData.setSiteAddress(consentDataObj.get("site_address").toString());
                consentData.setLegalDescription(consentDataObj.get("legal_description").toString());
                consentData.setParcelId(consentDataObj.get("parcel_id").toString());
                consentData.setParcelId(consentDataObj.get("property_id").toString());
                consentData.setOwnerContactId(consentDataObj.get("owner_contact_id").toString());
                consentData.setAgentContactId(consentDataObj.get("agent_contact_id").toString());
                consentData.setEstimatedValue(consentDataObj.get("estimated_value").toString());
                consentData.setIntendedLife(consentDataObj.get("intended_life").toString());
                consentData.setConsentType(consentDataObj.get("consent_type").toString());
                consentData.setWorkCategory(consentDataObj.get("work_category").toString());
                consentData.setBuildingType(consentDataObj.get("building_type").toString());
                projectDetailsResponse.setConsentData(consentData);

                // set submission status
                JsonArray subStatusObj = dataObj.getAsJsonArray("submission_statuses");
                SubmissionStatuses submissionStatuses = new SubmissionStatuses();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return projectDetailsResponse;
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
                    jsonObj.get("Result").getAsBoolean(),
                    jsonObj.get("Message").getAsString(),
                    jsonObj.get("Timestamp").getAsLong(),
                    jsonObj.get("ResponseID").getAsString()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MarkDoneResponse(
                false, "Error! Failed Request.",
                0, ""
        );
    }
}
