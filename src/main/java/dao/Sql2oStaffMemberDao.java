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
            String sql ="INSERT INTO staff_members (user_name, department_id) VALUES (:user_name, :departmentID)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("user_name", staffMember.getUser_name())
                    .addParameter("departmentID", staffMember.getDepartmentID())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            staffMember.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }
    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public StaffMember findStaffMember(int id) {
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

}
