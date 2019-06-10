package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffMember {

    private String user_name;
    private String first_name;
    private String middle_name;
    private String sir_name;
    private int ek_number;
    private int department_id;
    private int id;



    // -----------constructor  StaffMember ----------------------

    public StaffMember(String user_name, String first_name, String middle_name, String sir_name, int ek_number, int department_id) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.sir_name = sir_name;
        this.ek_number = ek_number;
        this.department_id = department_id;
    }


    // -------------- GETTERS ------------------------

    public String getUser_name() {
        return user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getSir_name() {
        return sir_name;
    }

    public int getEk_number() { return ek_number; }

    public int getDepartmentID() {
        return department_id;
    }

    public int getId() { return id; }


    //------------- SETTERS -------------------------


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setSir_name(String sir_name) {
        this.sir_name = sir_name;
    }

    public void setEk_number(int ek_number) { this.ek_number = ek_number; }

    public void setDepartmentID(int department_id) {
        this.department_id = department_id;
    }

    public void setId(int id) { this.id = id; }



    // -----------Override Method --------------------------

    @Override
    public boolean equals(Object otherStaffMember) {
        if (this == otherStaffMember) return true;
        if (!(otherStaffMember instanceof StaffMember)) return false;
        StaffMember that = (StaffMember) otherStaffMember;
        return getEk_number() == that.getEk_number() &&
                department_id == that.department_id &&
                Objects.equals(getUser_name(), that.getUser_name()) &&
                Objects.equals(getFirst_name(), that.getFirst_name()) &&
                Objects.equals(getMiddle_name(), that.getMiddle_name()) &&
                Objects.equals(getSir_name(), that.getSir_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_name(), getFirst_name(), getMiddle_name(), getSir_name(), getEk_number(), department_id);
    }


}