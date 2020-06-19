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
 * Date: 10/06/2020
 * Time: 8:04 AM
 */
public class ProjectDocument {
    private String document_type;
    private String document_category;
    private String document_name;
    private String received_date;
    private String file_guid;
    private String url;
    private String file_name;

    public String getDocumentType() {
        return document_type;
    }

    public void setDocumentType(String document_type) {
        this.document_type = document_type;
    }

    public String getDocumentCategory() {
        return document_category;
    }

    public void setDocumentCategory(String document_category) {
        this.document_category = document_category;
    }

    public String getDocumentName() {
        return document_name;
    }

    public void setDocumentName(String document_name) {
        this.document_name = document_name;
    }

    public String getReceivedDate() {
        return received_date;
    }

    public void setReceivedDate(String received_date) {
        this.received_date = received_date;
    }

    public String getFileGuid() {
        return file_guid;
    }

    public void setFileGuid(String file_guid) {
        this.file_guid = file_guid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "ProjectDocument{" +
                "document_type='" + document_type + '\'' +
                ", document_category='" + document_category + '\'' +
                ", document_name='" + document_name + '\'' +
                ", received_date='" + received_date + '\'' +
                ", file_guid='" + file_guid + '\'' +
                ", url='" + url + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}
