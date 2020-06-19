package nz.alphaone.library.api.Entity;

import java.util.HashMap;

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
 * Time: 8:14 AM
 */
public class SubmissionStatuses
{
    private final HashMap<String, String> submission_status = new HashMap<>();

    /**
     * @return String[]
     */
    public String[] getStringSchema() {
        return new String[] {
                "accepted_date",
                "accepted_by",
                "granted_date",
                "granted_by",
                "issued_date",
                "issued_by",
                "cancelled_date",
                "cancelled_by",
                "rejected_date",
                "rejected_by",
                "withdrawn_date",
                "withdrawn_by",
                "lapsed_date",
                "lapsed_by"
        };
    }

    public void setData(String item_name, String item_value) {
        submission_status.put(item_name, item_value);
    }

    public String getAcceptedDate() {
        return submission_status.get("accepted_date");
    }

    public void setAcceptedDate(String accepted_date) {
        submission_status.put("accepted_date", accepted_date);
    }

    public String getAcceptedBy() {
        return submission_status.get("accepted_by");
    }

    public void setAcceptedBy(String accepted_by) {
        submission_status.put("accepted_by", accepted_by);
    }

    public String getGrantedDate() {
        return submission_status.get("granted_date");
    }

    public void setGrantedDate(String granted_date) {
        submission_status.put("granted_date", granted_date);
    }

    public String getGrantedBy() {
        return submission_status.get("granted_by");
    }

    public void setGrantedBy(String granted_by) {
        submission_status.put("granted_by", granted_by);
    }

    public String getIssuedDate() {
        return submission_status.get("issued_date");
    }

    public void setIssuedDate(String issued_date) {
        submission_status.put("issued_date", issued_date);
    }

    public String getIssuedBy() {
        return submission_status.get("issued_by");
    }

    public void setIssuedBy(String issued_by) {
        submission_status.put("issued_by", issued_by);
    }

    public String getCccIssuedDate() {
        return submission_status.get("cccissued_date");
    }

    public void setCccIssuedDate(String cccissued_date) {
        submission_status.put("cccissued_date", cccissued_date);
    }

    public String getCccIssuedBy() {
        return submission_status.get("cccissued_by");
    }

    public void setCccIssuedBy(String cccissued_by) {
        submission_status.put("cccissued_by", cccissued_by);
    }

    public String getCancelledDate() {
        return submission_status.get("cancelled_date");
    }

    public void setCancelledDate(String cancelled_date) {
        submission_status.put("cancelled_date", cancelled_date);
    }

    public String getCancelledBy() {
        return submission_status.get("cancelled_by");
    }

    public void setCancelledBy(String cancelled_by) {
        submission_status.put("cancelled_by", cancelled_by);
    }

    public String getRejectedDate() {
        return submission_status.get("rejected_date");
    }

    public void setRejectedDate(String rejected_date) {
        submission_status.put("rejected_date", rejected_date);
    }

    public String getRejectedBy() {
        return submission_status.get("rejected_by");
    }

    public void setRejectedBy(String rejected_by) {
        submission_status.put("rejected_by", rejected_by);
    }

    public String getWithdrawnDate() {
        return submission_status.get("withdrawn_date");
    }

    public void setWithdrawnDate(String withdrawn_date) {
        submission_status.put("withdrawn_date", withdrawn_date);
    }

    public String getWithdrawnBy() {
        return submission_status.get("withdrawn_by");
    }

    public void setWithdrawnBy(String withdrawn_by) {
        submission_status.put("withdrawn_by", withdrawn_by);
    }

    public String getLapsedDate() {
        return submission_status.get("lapsed_date");
    }

    public void setLapsedDate(String lapsed_date) {
        submission_status.put("lapsed_date", lapsed_date);
    }

    public String getLapsedBy() {
        return submission_status.get("lapsed_by");
    }

    public void setLapsedBy(String lapsed_by) {
        submission_status.put("lapsed_by", lapsed_by);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("SubmissionStatuses{");
        for(String item : getStringSchema()) {
            print.append(item).append("='").append(submission_status.get(item)).append("',");
        }
        print.append("}\n");

        return print.toString();
    }
}
