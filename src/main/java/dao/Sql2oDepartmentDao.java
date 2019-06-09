package dao;

import models.DB;
import models.Department;
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
}
