package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    private String name;
    private int id;

    //-----Department constructor
    public Department(String name) {
        this.name = name;
    }

    // -------------- GETTERS ------------------------
    public String getName() {
        return name;
    }

    //------------- SETTERS -------------------------
    public void setName(){
        this.name = name;
    }

    Override
    public boolean equals(Object otherDepartment) {
        if (!(otherDepartment instanceof Department)) {
            return false;
        } else {
            Department newDepartment = (Department) otherDepartment;
            return this.getName().equals(newDepartment.getName());
        }
    }

}
