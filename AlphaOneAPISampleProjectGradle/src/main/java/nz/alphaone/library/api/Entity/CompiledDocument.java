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
public class CompiledDocument extends ProjectDocument {
    private String compiled_by;
    // private String compiled_date;

    public String getCompiledBy() {
        return compiled_by;
    }

    public void setCompiledBy(String compiled_by) {
        this.compiled_by = compiled_by;
    }

    @Override
    public String toString() {
        return "CompiledDocument{" +
                "document_type='" + getDocumentType() + '\'' +
                "document_category='" + getDocumentCategory() + '\'' +
                "document_name='" + getDocumentName() + '\'' +
                "received_date='" + getReceivedDate() + '\'' +
                "file_guid='" + getFileGuid() + '\'' +
                "url='" + getUrl() + '\'' +
                "file_name='" + getFileName() + '\'' +
                "compiled_by='" + compiled_by + '\'' +
                '}';
    }

    //    public String getCompiledDate() {
//        return compiled_date;
//    }
//
//    public void setCompiledDate(String compiled_date) {
//        this.compiled_date = compiled_date;
//    }
}
