package dao;

import models.DB;
import models.Department;
import dao.DepartmentDao;
import models.StaffMember;
import dao.Sql2oStaffMemberDao;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao departmentDao;
    private Sql2oStaffMemberDao staffMemberDao;
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

//    @Test
//    public void listAllStaffMembersByDepartmentReturnsStaffMembersCorrectly() throws Exception {
//        Department department = setupNewDepartment();
//        departmentDao.saveDepartment(department);
//        int departmentId = department.getId();
//        StaffMember newStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9991, departmentId);
//        StaffMember otherStaffMember = new StaffMember("ewanyama0002", "Edwin", "Cheche", "Wanyonyi", 9992, departmentId);
//        StaffMember thirdStaffMember = new StaffMember("ewanyama0003", "Enock", "bwayoi", "Koti", 9993, departmentId);
//        staffMemberDao.saveStaffMember(newStaffMember);
//        staffMemberDao.saveStaffMember(otherStaffMember);
//        assertEquals(2, departmentDao.listAllStaffMembersByDepartment(departmentId).size());
//        assertTrue(departmentDao.listAllStaffMembersByDepartment(departmentId).contains(newStaffMember));
//        assertTrue(departmentDao.listAllStaffMembersByDepartment(departmentId).contains(otherStaffMember));
//        assertFalse(departmentDao.listAllStaffMembersByDepartment(departmentId).contains(thirdStaffMember));
//    }

    ///Helper method

    public Department setupNewDepartment() {
        return new Department("Digital IT", "Digital IT departmetn for Innovation");
    }

}
