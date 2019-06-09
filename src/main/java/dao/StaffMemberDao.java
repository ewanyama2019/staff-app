package dao;

import models.Department;
import models.StaffMember;

import java.util.List;

public interface StaffMemberDao {

//    //    //LIST ALL SITES
    List<StaffMember> listAllStaffMembers();

    // CREATE :SAVE TO DATABASE
    void saveStaffMember(StaffMember staffMember);
    //
//    // READ SITES BY ID
    StaffMember findStaffMember(int id);

//    // UPDATE
//    void updateStaffMember();
//
//    // DELETE SITE BY ID
//    void deleteStaffMemberById(int id);
//
//
//    // DELETE ALL SITES
//    void ClearAllStaffMembers();

}

