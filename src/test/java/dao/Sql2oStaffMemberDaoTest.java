package dao;

import models.DB;
import models.Department;
import models.StaffMember;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oStaffMemberDaoTest {

    private Sql2oStaffMemberDao staffMemberDao;
    private Connection conn;    //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/staff_app_test";
        DB.sql2o = new Sql2o(connectionString, "postgres", "wanyama123");
        staffMemberDao = new Sql2oStaffMemberDao(DB.sql2o); //ignore me for now
        conn = DB.sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingStaffMemberSetsId() throws Exception {
        StaffMember staffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        int originalStaffMemberId = staffMember.getId();
        staffMemberDao.saveStaffMember(staffMember);
        assertNotEquals(originalStaffMemberId, staffMember.getId());
    }





}
