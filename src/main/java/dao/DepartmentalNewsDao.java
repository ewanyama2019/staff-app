package dao;

import models.DepartmentalNews;
import java.util.List;


public interface DepartmentalNewsDao {

    //   LIST ALL DEPARTMENTAL NEWS
    List<DepartmentalNews> listAllDepartmentalNews();

    // CREATE :SAVE DEPARTMENTAL NEWS  TO DATABASE
    void saveDepartmentalNews(DepartmentalNews departmentalNews);

    // READ DEPARTMENTAL NEWS BY ID
    DepartmentalNews findDepartmentalNewsById(int id);

    // UPDATE DEPARTMENTAL NEWS
    void updateDepartmentalNews(int id, String newNews_headlines, String newNews_details, int newDepartment_id);

    // DELETE DEPARTMENTAL NEWS BY ID
    void deleteDepartmentalNewsById(int id);

    // DELETE DEPARTMENTAL NEWS
    void deleteAllDepartmentalNews();
}
