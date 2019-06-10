package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class GeneralNewsTest {

    @Rule
    public DataBaseRule databaseRule = new DataBaseRule();

    @Test
    public void DepartmentalNews_instantiatesCorrectly_True() {
        GeneralNews testGeneralNews = new GeneralNews("Safaricom Announces Full Year results ", "Its been a turbulent time for Telcos ");
        assertEquals(true, testGeneralNews instanceof GeneralNews);
    }

    @Test
    public void DepartmentalNews_InstantiatesWithNews_Headlines_String() {
        GeneralNews testGeneralNews = new GeneralNews("Safaricom Announces Full Year results ", "Its been a turbulent time for Telcos ");
        assertEquals("Safaricom Announces Full Year results ", testGeneralNews.getNews_headlines());
    }

    @Test
    public void GeneralNews_InstantiatesWithNews_details_String() {
        GeneralNews testGeneralNews = new GeneralNews("Safaricom Announces Full Year results ", "Its been a turbulent time for Telcos ");
        assertEquals("Its been a turbulent time for Telcos ", testGeneralNews.getNews_details());
    }

    @Test
    public void equals_returnsTrueIfGeneralNewsItemsAreSame_true() {
        GeneralNews testGeneralNews = new GeneralNews("Safaricom Announces Full Year results ", "Its been a turbulent time for Telcos ");
        GeneralNews anotherTestGeneralNews = new GeneralNews("Safaricom Announces Full Year results ", "Its been a turbulent time for Telcos ");
        assertTrue(testGeneralNews.equals(anotherTestGeneralNews));
    }


}
