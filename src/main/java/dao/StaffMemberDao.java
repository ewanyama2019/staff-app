package dao;

import models.Department;
import models.StaffMember;

import java.util.List;

public interface StaffMemberDao {

    ///   LIST ALL STAFF-MEMBERS
    List<StaffMember> listAllStaffMembers();

    // CREATE :SAVE STAFF-MEMBERS TO DATABASE
    void saveStaffMember(StaffMember staffMember);

    // READ STAFF-MEMBERS BY ID
    StaffMember findStaffMemberById(int id);

    // UPDATE STAFF-MEMBERS
    void updateStaffMember(int id, String newUser_name, String newFirst_name, String newMiddle_name, String newSir_name, int newEk_number, int newDepartment_id);

    // DELETE STAFF-MEMBERS BY ID
    void deleteStaffMemberById(int id);

    // DELETE ALL STAFF-MEMBERS
    void deleteAllStaffMember();

}

