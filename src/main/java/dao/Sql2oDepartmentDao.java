package dao;

import models.DB;
import models.Department;
import models.StaffMember;
import org.sql2o.*;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao { //implementing our interface

    private final Sql2o sql2o;



    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it

    }
    //---------------------SAVE / ADD NEW  DEPARTMENT ----------------------//

    @Override
    public void saveDepartment(Department department) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO departments (name, description) VALUES (:name, :description)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("name", department.getName())
                    .addParameter("description", department.getDescription())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }
    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public Department findDepartment(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM departments WHERE id=:id";
            Department department = con.createQuery(sql)
                    .addParameter("id", id)  //key/value pair, key must match above
                    .executeAndFetchFirst(Department.class);  //fetch an individual item
            return department;
        }
    }

    // --------------------LIST ALL --------------------------------//
    @Override
    public List<Department> listAllDepartments() {
        String sql = "SELECT * FROM departments";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Department.class);  //fetch a list
        }
    }

    @Override
    public void updateDepartment(int id, String newName){
        String sql = "UPDATE departments SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        String sql = "DELETE from departments WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void DeleteAllDepartment() {
        String sql = "DELETE from departments"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<StaffMember> listAllStaffMembersByDepartment(int department_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM staff_members WHERE department_id = :department_id")
                    .addParameter("department_id", department_id)
                    .executeAndFetch(StaffMember.class);
        }
    }

//    @Override
//    public List<DepartmentalNews> listAllNewsItemsByDepartment(int department_id) {
//        try(Connection con = sql2o.open()){
//            return con.createQuery("SELECT * FROM department_news WHERE department_id = :department_id")
//                    .addParameter("department_id", department_id)
//                    .executeAndFetch(StaffMember.class);
//        }
//    }


}
