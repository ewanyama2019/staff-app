package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffMember {

    private String first_name;
    private String middle_name;
    private String sir_name;
    private int departmentID;
    private int id;

    // -------------- GETTERS ------------------------
    public StaffMember(String first_name) {
        this.first_name = first_name;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    //------------- SETTERS -------------------------
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getSir_name() {
        return sir_name;
    }

    public void setSir_name(String sir_name) {
        this.sir_name = sir_name;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object otherStaffMember) {
        if (this == otherStaffMember) return true;
        if (!(otherStaffMember instanceof StaffMember)) return false;
        StaffMember that = (StaffMember) otherStaffMember;
        return getFirst_name().equals(that.getFirst_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name());
    }
}