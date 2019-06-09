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
    private int departmentID;
    private int id;



    // -----------constructor  StaffMember ----------------------
    public StaffMember(String user_name, int departmentID) {
        this.first_name = user_name;
        this.departmentID = departmentID;
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

    public int getDepartmentID() {
        return departmentID;
    }


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

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setId(int id) { this.id = id; }



    // -----------Override Method --------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffMember)) return false;
        StaffMember that = (StaffMember) o;
        return getDepartmentID() == that.getDepartmentID() &&
                Objects.equals(getUser_name(), that.getUser_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_name(), getDepartmentID());
    }




//    @Override
//    public boolean equals(Object otherStaffMember) {
//        if (this == otherStaffMember) return true;
//        if (!(otherStaffMember instanceof StaffMember)) return false;
//        StaffMember that = (StaffMember) otherStaffMember;
//        return getDepartmentID() == that.getDepartmentID() &&
//                getUser_name().equals(that.getUser_name());
//    }

//    @Override
//    public boolean equals(Object otherStaffMember) {
//        if (!(otherStaffMember instanceof StaffMember)) {
//            return false;
//        } else {
//            StaffMember newStaffMember = (StaffMember) otherStaffMember;
//            return this.getUser_name().equals(newStaffMember.getUser_name())  && this.getDepartmentID() == newStaffMember.getDepartmentID();
//        }
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getUser_name(), getDepartmentID());
//    }
}