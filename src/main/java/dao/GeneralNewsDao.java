package dao;


import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {

    //   LIST ALL GENERAL NEWS
    List<GeneralNews> listAllGeneralNews();

    // CREATE :SAVE GENERAL NEWS  TO DATABASE
    void saveGeneralNews(GeneralNews generalNews);

    // READ GENERAL NEWS  BY ID
    GeneralNews findGeneralNewsById(int id);

    // UPDATE GENERAL NEWS
    void updateGeneralNews(int id, String newNews_headlines, String newNews_details);

    // DELETE GENERAL NEWS  BY ID
    void deleteGeneralNewsById(int id);

    // DELETE GENERAL NEWS
    void deleteAllGeneralNews();
}
