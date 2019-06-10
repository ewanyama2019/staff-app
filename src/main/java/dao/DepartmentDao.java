package dao;

import models.Department;
import models.StaffMember;

import java.util.List;


public interface DepartmentDao {

    //LIST ALL DEPARTMENTS
    List<Department> listAllDepartments();

    // CREATE :DEPARTMENTS TO DATABASE
    void saveDepartment(Department department);

    // READ DEPARTMENTS BY ID
    Department findDepartment(int id);

    // UPDATE DEPARTMENTS
    void updateDepartment(int id, String newName);

    // DELETE DEPARTMENTS BY ID
    void deleteDepartmentById(int id);


    // DELETE ALL DEPARTMENTS
    void DeleteAllDepartment();

    //LIST ALL STAFF MEMBERS  BY DEPARTMENTS
    List<StaffMember> listAllStaffMembersByDepartment(int department_id);

    //LIST ALL NEWS ITEMS BY DEPARTMENTS
//    List<StaffMember> listAllNewsItemsByDepartment(int department_id);

}
