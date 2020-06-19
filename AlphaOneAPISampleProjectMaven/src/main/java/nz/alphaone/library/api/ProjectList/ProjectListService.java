package nz.alphaone.library.api.ProjectList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nz.alphaone.library.api.Authentication.Authorization;
import nz.alphaone.library.api.Entity.*;
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
            String response = wr.getRequest(api_url, (new Properties()), headers);

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
                String[] schema = submissionStatuses.getStringSchema();
                /*
                for(String elem_item : schema) {
                    for (int i = 0; i < subStatusObj.size(); i++) {
                        JsonElement elem = subStatusObj.get(i);
                        JsonObject obj = elem.getAsJsonObject();
                        if (obj.has(elem_item)) {
                            submissionStatuses.setData(elem_item, obj.get(elem_item).getAsString());
                            break;
                        }
                    }
                }*/
                for(String elem_item : schema) {
                    for (JsonElement elem : subStatusObj) {
                        JsonObject obj = elem.getAsJsonObject();

                        if (obj.has(elem_item)) {
                            if (obj.get(elem_item).isJsonNull()) {
                                submissionStatuses.setData(elem_item, null);
                            } else {
                                submissionStatuses.setData(elem_item, obj.get(elem_item).getAsString());
                            }

                            break;
                        }
                    }
                }
                projectDetailsResponse.setSubmissionStatuses(submissionStatuses);


                // inspections
                ArrayList<InspectionReport> ir_list = new ArrayList<>();
                JsonArray inspections_list = dataObj.getAsJsonArray("inspections");
                for (JsonElement elem : inspections_list) {
                    JsonObject inspection = elem.getAsJsonObject();

                    InspectionReport ir = new InspectionReport();
                    ir.setBuildingId(inspection.get("building_id").getAsString());
                    ir.setBuildingName(inspection.get("building_name").getAsString());
                    ir.setInspectionId(inspection.get("inspection_id").getAsString());
                    ir.setInspectionType(inspection.get("inspection_type").getAsString());
                    ir.setInspectedDate(inspection.get("inspected_date").getAsString());
                    ir.setInspectedBy(inspection.get("inspected_by").getAsString());
                    ir.setInspectionResult(inspection.get("inspection_result").getAsString());
                    ir_list.add(ir);
                }
                projectDetailsResponse.setInspections(ir_list);

                // submission files
                JsonArray documents = dataObj.getAsJsonArray("submission_files");
                projectDetailsResponse.setSubmissionFiles(parseDocuments(documents));

                documents = dataObj.getAsJsonArray("ccc_files");
                projectDetailsResponse.setCccFiles(parseDocuments(documents));

                documents = dataObj.getAsJsonArray("consent_files");
                projectDetailsResponse.setConsentFiles(parseDocuments(documents));

                documents = dataObj.getAsJsonArray("compiled_files");
                projectDetailsResponse.setCompiledFiles(parseCompiledDocuments(documents));

                // set status of the return class
                projectDetailsResponse.setResult(true);
                projectDetailsResponse.setMessage("Success!");
            } else {
                projectDetailsResponse.setResult(jsonObj.get("Result").getAsBoolean());
                projectDetailsResponse.setMessage(jsonObj.get("Message").getAsString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            projectDetailsResponse.setResult(false);
            projectDetailsResponse.setMessage(e.getMessage());
        }

        return projectDetailsResponse;
    }

    /**
     * process the project documents by
     *      - lodged/submission files
     *      - ccc files / required document
     *      - consent files
     * @param documents JsonArray
     * @return ArrayList
     */
    private ArrayList<ProjectDocument> parseDocuments(JsonArray documents)
    {
        ArrayList<ProjectDocument> documents_list = new ArrayList<>();
        for(JsonElement elem : documents)
        {
            JsonObject doc_item = elem.getAsJsonObject();

            ProjectDocument projDoc = new ProjectDocument();
            projDoc.setDocumentType(doc_item.get("document_type").getAsString());
            projDoc.setDocumentCategory(doc_item.get("document_category").getAsString());
            projDoc.setDocumentName(doc_item.get("document_name").getAsString());
            projDoc.setReceivedDate(doc_item.get("received_date").getAsString());
            projDoc.setFileGuid(doc_item.get("file_guid").getAsString());
            projDoc.setUrl(doc_item.get("url").getAsString());
            projDoc.setFileName(doc_item.get("file_name").getAsString());
        }

        return documents_list;
    }

    /**
     * process the project documents by
     *      - compiled documents
     * @param documents JsonArray
     * @return ArrayList
     */
    private ArrayList<CompiledDocument> parseCompiledDocuments(JsonArray documents)
    {
        ArrayList<CompiledDocument> documents_list = new ArrayList<>();
        for(JsonElement elem : documents)
        {
            JsonObject doc_item = elem.getAsJsonObject();

            CompiledDocument projDoc = new CompiledDocument();
            projDoc.setDocumentType(doc_item.get("document_type").getAsString());
            projDoc.setDocumentCategory(doc_item.get("document_category").getAsString());
            projDoc.setDocumentName(doc_item.get("document_name").getAsString());
            projDoc.setReceivedDate(doc_item.get("received_date").getAsString());
            projDoc.setFileGuid(doc_item.get("file_guid").getAsString());
            projDoc.setUrl(doc_item.get("url").getAsString());
            projDoc.setFileName(doc_item.get("file_name").getAsString());
            projDoc.setCompiledBy(doc_item.get("compiled_by").getAsString());
        }

        return documents_list;
    }

    /**
     * mark as done so it won't be listed in the project list
     * @param project ProjectEntry
     * @return MarkDoneResponse
     */
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
