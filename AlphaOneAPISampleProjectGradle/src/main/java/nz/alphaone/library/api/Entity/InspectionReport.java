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
 * Time: 8:02 AM
 */
public class InspectionReport {
    private String building_id;
    private String building_name;
    private String inspection_id;
    private String inspection_type;
    private String inspected_date;
    private String inspected_by;
    private String inspection_result;

    public String getBuildingId() {
        return building_id;
    }

    public void setBuildingId(String building_id) {
        this.building_id = building_id;
    }

    public String getBuildingName() {
        return building_name;
    }

    public void setBuildingName(String building_name) {
        this.building_name = building_name;
    }

    public String getInspectionId() {
        return inspection_id;
    }

    public void setInspectionId(String inspection_id) {
        this.inspection_id = inspection_id;
    }

    public String getInspectionType() {
        return inspection_type;
    }

    public void setInspectionType(String inspection_type) {
        this.inspection_type = inspection_type;
    }

    public String getInspectedDate() {
        return inspected_date;
    }

    public void setInspectedDate(String inspected_date) {
        this.inspected_date = inspected_date;
    }

    public String getInspectedBy() {
        return inspected_by;
    }

    public void setInspectedBy(String inspected_by) {
        this.inspected_by = inspected_by;
    }

    public String getInspectionResult() {
        return inspection_result;
    }

    public void setInspectionResult(String inspection_result) {
        this.inspection_result = inspection_result;
    }
}
