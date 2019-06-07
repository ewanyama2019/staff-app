package dao;

import models.Department;
//import models.Users;
import java.util.List;


public interface DepartmentDao {
//
//    //LIST ALL SITES
    List<Department> listAllDepartments();

    // CREATE :SAVE TO DATABASE
    void saveDepartment(Department department);
//
//    // READ SITES BY ID
    Department findDepartment(int id);

//    // UPDATE
//    void updateDepartment();
//
//    // DELETE SITE BY ID
//    void deleteDepartmentById(int id);
//
//
//    // DELETE ALL SITES
//    void ClearAllDepartment();

}
