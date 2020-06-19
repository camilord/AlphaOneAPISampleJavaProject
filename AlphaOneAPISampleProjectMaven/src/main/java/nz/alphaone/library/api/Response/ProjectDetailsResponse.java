package nz.alphaone.library.api.Response;

import nz.alphaone.library.api.Entity.*;

import java.util.ArrayList;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 10/06/2020
 * Time: 7:55 AM
 */
public class ProjectDetailsResponse
{
    private boolean result;
    private String message;

    private String submission_guid;
    private String submission_ref;
    private String submission_title;
    private String description_of_work;
    private String ta_name;
    private String ta_consent_id;
    private String consent_id;
    private DataConfig config;

    private ConsentData consent_data;
    private SubmissionStatuses submission_statuses;
    private ArrayList<InspectionReport> inspections;
    private ArrayList<ProjectDocument> submission_files;
    private ArrayList<ProjectDocument> ccc_files;
    private ArrayList<ProjectDocument> consent_files;
    private ArrayList<CompiledDocument> compiled_files;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubmissionGuid() {
        return submission_guid;
    }

    public void setSubmissionGuid(String submission_guid) {
        this.submission_guid = submission_guid;
    }

    public String getSubmissionRef() {
        return submission_ref;
    }

    public void setSubmissionRef(String submission_ref) {
        this.submission_ref = submission_ref;
    }

    public String getSubmissionTitle() {
        return submission_title;
    }

    public void setSubmissionTitle(String submission_title) {
        this.submission_title = submission_title;
    }

    public String getDescriptionOfWork() {
        return description_of_work;
    }

    public void setDescriptionOfWork(String description_of_work) {
        this.description_of_work = description_of_work;
    }

    public String getTaName() {
        return ta_name;
    }

    public void setTaName(String ta_name) {
        this.ta_name = ta_name;
    }

    public String getTaConsentId() {
        return ta_consent_id;
    }

    public void setTaConsentId(String ta_consent_id) {
        this.ta_consent_id = ta_consent_id;
    }

    public String getConsentId() {
        return consent_id;
    }

    public void setConsentId(String consent_id) {
        this.consent_id = consent_id;
    }

    public DataConfig getConfig() {
        return config;
    }

    public void setConfig(DataConfig config) {
        this.config = config;
    }

    public ConsentData getConsentData() {
        return consent_data;
    }

    public void setConsentData(ConsentData consent_data) {
        this.consent_data = consent_data;
    }

    public SubmissionStatuses getSubmissionStatuses() {
        return submission_statuses;
    }

    public void setSubmissionStatuses(SubmissionStatuses submission_statuses) {
        this.submission_statuses = submission_statuses;
    }

    public ArrayList<InspectionReport> getInspections() {
        return inspections;
    }

    public void setInspections(ArrayList<InspectionReport> inspections) {
        this.inspections = inspections;
    }

    public ArrayList<ProjectDocument> getSubmissionFiles() {
        return submission_files;
    }

    public void setSubmissionFiles(ArrayList<ProjectDocument> submission_files) {
        this.submission_files = submission_files;
    }

    public ArrayList<ProjectDocument> getCccFiles() {
        return ccc_files;
    }

    public void setCccFiles(ArrayList<ProjectDocument> ccc_files) {
        this.ccc_files = ccc_files;
    }

    public ArrayList<ProjectDocument> getConsentFiles() {
        return consent_files;
    }

    public void setConsentFiles(ArrayList<ProjectDocument> consent_files) {
        this.consent_files = consent_files;
    }

    public ArrayList<CompiledDocument> getCompiledFiles() {
        return compiled_files;
    }

    public void setCompiledFiles(ArrayList<CompiledDocument> compiled_files) {
        this.compiled_files = compiled_files;
    }

    @Override
    public String toString() {
        return "ProjectDetailsResponse{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", submission_guid='" + submission_guid + '\'' +
                ", submission_ref='" + submission_ref + '\'' +
                ", submission_title='" + submission_title + '\'' +
                ", description_of_work='" + description_of_work + '\'' +
                ", ta_name='" + ta_name + '\'' +
                ", ta_consent_id='" + ta_consent_id + '\'' +
                ", consent_id='" + consent_id + '\'' +
                ", config=" + config +
                ", consent_data=" + consent_data +
                ", submission_statuses=" + submission_statuses +
                ", inspections=" + inspections +
                ", submission_files=" + submission_files +
                ", ccc_files=" + ccc_files +
                ", consent_files=" + consent_files +
                ", compiled_files=" + compiled_files +
                '}';
    }
}
