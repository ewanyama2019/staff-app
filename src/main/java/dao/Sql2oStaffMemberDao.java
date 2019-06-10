package dao;

import models.DB;
import models.Department;
import models.StaffMember;
import org.sql2o.*;
import java.util.List;

public class Sql2oStaffMemberDao implements StaffMemberDao { //implementing our interface

    private final Sql2o sql2o;

    public Sql2oStaffMemberDao(Sql2o sql2o) {
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it

    }

    //---------------------SAVE / ADD NEW  STAFF MEMBER /USER ----------------------//
    @Override
    public void saveStaffMember(StaffMember staffMember) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO staff_members (user_name, first_name, middle_name, sir_name, ek_number, department_id) VALUES (:user_name, :first_name, :middle_name, :sir_name, :ek_number, :department_id)"; //raw sql

            // user_name, first_name, middle_name, sir_name, ek_number, department_id

            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("user_name", staffMember.getUser_name())
                    .addParameter("first_name", staffMember.getFirst_name())
                    .addParameter("middle_name", staffMember.getMiddle_name())
                    .addParameter("sir_name", staffMember.getSir_name())
                    .addParameter("ek_number", staffMember.getEk_number())
                    .addParameter("department_id", staffMember.getDepartmentID())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            staffMember.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }
    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public StaffMember findStaffMemberById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM staff_members WHERE id=:id";
            StaffMember staffMember = con.createQuery(sql)
                    .addParameter("id", id)  //key/value pair, key must match above
                    .executeAndFetchFirst(StaffMember.class);  //fetch an individual item
            return staffMember;
        }
    }

    // --------------------LIST ALL --------------------------------//
    @Override
    public List<StaffMember> listAllStaffMembers() {
        String sql = "SELECT * FROM staff_members";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(StaffMember.class);  //fetch a list
        }
    }

    @Override
    public void updateStaffMember(int id, String newUser_name, String newFirst_name, String newMiddle_name, String newSir_name, int newEk_number, int newDepartment_id) {
        String sql = "UPDATE staff_members SET (user_name, first_name, middle_name, sir_name, ek_number, department_id) = (:user_name, :first_name, :middle_name, :sir_name, :ek_number, :department_id) WHERE id=:id";   //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("user_name", newUser_name)
                    .addParameter("first_name", newFirst_name)
                    .addParameter("middle_name", newMiddle_name)
                    .addParameter("sir_name", newSir_name)
                    .addParameter("ek_number", newEk_number)
                    .addParameter("department_id", newDepartment_id)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteStaffMemberById(int id) {
        String sql = "DELETE from staff_members WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public void deleteAllStaffMember() {
        String sql = "DELETE from staff_members";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
