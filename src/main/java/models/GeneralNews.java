package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralNews {

    private String news_headlines;
    private String news_details;
    private int id;

    public GeneralNews(String news_headlines, String news_details) {
        this.news_headlines = news_headlines;
        this.news_details = news_details;
    }


    // ----------Getters ------------------
    public String getNews_headlines() {
        return news_headlines;
    }

    public String getNews_details() {
        return news_details;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralNews)) return false;
        GeneralNews that = (GeneralNews) o;
        return Objects.equals(getNews_headlines(), that.getNews_headlines()) &&
                Objects.equals(getNews_details(), that.getNews_details());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNews_headlines(), getNews_details());
    }
}


