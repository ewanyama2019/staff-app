package dao;

import models.DB;
import models.Department;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao departmentDao;
    private Connection conn;    //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/staff_app_test";
        DB.sql2o = new Sql2o(connectionString, "postgres", "wanyama123");
        departmentDao = new Sql2oDepartmentDao(DB.sql2o); //ignore me for now
        conn = DB.sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department department = new Department("Digital IT", "Digital IT departmetn for Innovation");
        int originalDepartmentId = department.getId();
        departmentDao.saveDepartment(department);
        assertNotEquals(originalDepartmentId, department.getId());
    }

}
