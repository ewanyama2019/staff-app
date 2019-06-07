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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
