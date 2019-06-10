package dao;

import models.DB;
import models.GeneralNews;
import org.sql2o.*;
import java.util.List;

public class Sql2oGeneralNewsDao implements GeneralNewsDao {

    private final Sql2o sql2o;

    public Sql2oGeneralNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it

    }

    @Override
    public void saveGeneralNews(GeneralNews generalNews) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO general_news (news_headlines, news_details) VALUES (:news_headlines, :news_details)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("news_headlines", generalNews.getNews_headlines())
                    .addParameter("news_details", generalNews.getNews_details())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            generalNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }
    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public GeneralNews findGeneralNewsById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM general_news WHERE id=:id";
            GeneralNews generalNews = con.createQuery(sql)
                    .addParameter("id", id)  //key/value pair, key must match above
                    .executeAndFetchFirst(GeneralNews.class);  //fetch an individual item
            return generalNews;
        }
    }

    // --------------------LIST ALL --------------------------------//
    @Override
    public List<GeneralNews> listAllGeneralNews() {
        String sql = "SELECT * FROM general_news";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(GeneralNews.class);  //fetch a list
        }
    }

    @Override
    public void updateGeneralNews(int id, String newNews_headlines, String newNews_details) {
        String sql = "UPDATE general_news SET (news_headlines, news_details) VALUES (:news_headlines, :news_details)";   //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("news_headlines", newNews_headlines)
                    .addParameter("news_details", newNews_details)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteGeneralNewsById(int id) {
        String sql = "DELETE from general_news WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAllGeneralNews() {
        String sql = "DELETE from general_news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



}
