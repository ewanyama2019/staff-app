package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DataBaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/staff_app", "postgres", "wanyama123"); //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteDepartmentsQuery = "DELETE FROM departments *;";
//            String deleteUsersQuery = "DELETE FROM users *;";  // uncomment after adding users
            con.createQuery(deleteDepartmentsQuery).executeUpdate();
//            con.createQuery(deleteUsersQuery).executeUpdate();  // uncomment after adding usfers
        }
    }



}
