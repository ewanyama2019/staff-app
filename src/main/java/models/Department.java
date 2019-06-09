package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    private String name;
    private String description;
    private int id;

    //-----Department constructor
    public Department(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object otherDepartment) {
        if (this == otherDepartment) return true;
        if (otherDepartment == null || getClass() != otherDepartment.getClass()) return false;
        Department that = (Department) otherDepartment;
        return name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description) ;
    }
}
