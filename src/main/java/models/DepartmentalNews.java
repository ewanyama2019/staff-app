package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentalNews {

    private String news_headlines;
    private String news_details;
    private int department_id;
    private int id;


    public DepartmentalNews(String news_headlines, String news_details, int department_id) {
        this.news_headlines = news_headlines;
        this.news_details = news_details;
        this.department_id = department_id;
    }

    // ----------Getters ------------------
    public String getNews_headlines() {
        return news_headlines;
    }

    public String getNews_details() {
        return news_details;
    }

    public int getDepartment_id(){
        return department_id;
    }

    public int getId() {
        return id;
    }

    // ------------Setters ----------------

    public void setNews_headlines(String news_headlines) {
        this.news_headlines = news_headlines;
    }

    public void setNews_details(String news_details) {
        this.news_details = news_details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object otherDepartmentalNews) {
        if (this == otherDepartmentalNews) return true;
        if (!(otherDepartmentalNews instanceof DepartmentalNews)) return false;
        DepartmentalNews that = (DepartmentalNews) otherDepartmentalNews;
        return getDepartment_id() == that.getDepartment_id() &&
                Objects.equals(getNews_headlines(), that.getNews_headlines()) &&
                Objects.equals(getNews_details(), that.getNews_details());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNews_headlines(), getNews_details(), getDepartment_id());
    }
}
