package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;


public class StaffMemberTest {

    @Rule
    public DataBaseRule databaseRule = new DataBaseRule();

    @Test
    public void staffMember_instantiatesCorrectly_True() {
         StaffMember testStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        assertEquals(true, testStaffMember instanceof StaffMember);
    }

    @Test
    public void staffMember_InstantiatesWithUsernameName_String() {
        StaffMember testStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        assertEquals("ewanyama0001", testStaffMember.getFirst_name());
    }

    @Test
    public void Site_InstantiatesWithDepartmentId_int() {
        StaffMember testStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        assertEquals(1, testStaffMember.getDepartmentID());
    }

    @Test
    public void equals_returnsTrueIfUserNameAndDepartmentIdAreSame_true() {
        StaffMember testStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        StaffMember anotherStaffMember = new StaffMember("ewanyama0001", "Edward", "Sichamgi", "Wanyama", 9999, 1);
        assertTrue(testStaffMember.equals(anotherStaffMember));
    }


}
