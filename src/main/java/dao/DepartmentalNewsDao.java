package dao;

import models.DepartmentalNews;
import java.util.List;


public interface DepartmentalNewsDao {

    //   LIST ALL NEWS HEADLINES
    List<DepartmentalNews> listAllDepartmentalNews();

    // CREATE :SAVE NEWS HEADLINES TO DATABASE
    void saveDepartmentalNews(DepartmentalNews departmentalNews);

    // READ NEWS HEADLINES BY ID
    DepartmentalNews findDepartmentalNewsById(int id);

    // UPDATE NEWS HEADLINES
    void updateDepartmentalNews(int id, String newNews_headlines, String newNews_details, int newDepartment_id);

    // DELETE NEWS HEADLINES BY ID
    void deleteDepartmentalNewsById(int id);

    // DELETE NEWS HEADLINES
    void deleteAllDepartmentalNews();
}
