package dao;

import models.DB;
import models.Department;
import models.DepartmentalNews;
import org.sql2o.*;
import java.util.List;


public class Sql2oDepartmentalNewsDao implements DepartmentalNewsDao {

    private final Sql2o sql2o;

    public Sql2oDepartmentalNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it

    }

    @Override
    public void saveDepartmentalNews(DepartmentalNews departmentalNews) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO departmental_news (news_headlines, news_details, department_id) VALUES (:news_headlines, :news_details, :department_id)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("news_headlines", departmentalNews.getNews_headlines())
                    .addParameter("news_details", departmentalNews.getNews_details())
                    .addParameter("department_id", departmentalNews.getDepartment_id())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            departmentalNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }
    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public DepartmentalNews findDepartmentalNewsById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM departmental_news WHERE id=:id";
            DepartmentalNews departmentalNews = con.createQuery(sql)
                    .addParameter("id", id)  //key/value pair, key must match above
                    .executeAndFetchFirst(DepartmentalNews.class);  //fetch an individual item
            return departmentalNews;
        }
    }

    // --------------------LIST ALL --------------------------------//
    @Override
    public List<DepartmentalNews> listAllDepartmentalNews() {
        String sql = "SELECT * FROM departmental_news";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(DepartmentalNews.class);  //fetch a list
        }
    }

    @Override
    public void updateDepartmentalNews(int id, String newNews_headlines, String newNews_details, int newDepartment_id) {
        String sql = "UPDATE departmental_news SET (news_headlines, news_details, department_id) VALUES (:news_headlines, :news_details, :department_id)";   //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("news_headlines", newNews_headlines)
                    .addParameter("news_details", newNews_details)
                    .addParameter("department_id", newDepartment_id)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteDepartmentalNewsById(int id) {
        String sql = "DELETE from departmental_news WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAllDepartmentalNews() {
        String sql = "DELETE from departmental_news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



}
