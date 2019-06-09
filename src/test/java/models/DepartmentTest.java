package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class DepartmentTest {

//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void department_InstantiatesCorrectly_true() {
        Department testDepartment = new Department("Digital IT", "Digital IT departmetn for Innovation");
        assertEquals(true, testDepartment instanceof Department);
    }

}
