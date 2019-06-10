package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class DepartmentalNewsTest {

    @Rule
    public DataBaseRule databaseRule = new DataBaseRule();

    @Test
    public void DepartmentalNews_instantiatesCorrectly_True() {
        DepartmentalNews testDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        assertEquals(true, testDepartmentalNews instanceof DepartmentalNews);
    }

    @Test
    public void DepartmentalNews_InstantiatesWithNews_Headlines_String() {
        DepartmentalNews testDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        assertEquals("Safaricom Digital Academy Launched", testDepartmentalNews.getNews_headlines());
    }

    @Test
    public void DepartmentalNews_InstantiatesWithNews_Details_String() {
        DepartmentalNews testDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        assertEquals("Bob Collimore has launced the Safaricomdigital Academy at Strathmore College", testDepartmentalNews.getNews_details());
    }

    @Test
    public void Site_InstantiatesWithDepartmentId_int() {
        DepartmentalNews testDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        assertEquals(1, testDepartmentalNews.getDepartment_id());
    }

    @Test
    public void equals_returnsTrueIfUserNews_HeadlinesAndDepartmentIdAreSame_true() {
        DepartmentalNews testDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        DepartmentalNews anotherDepartmentalNews = new DepartmentalNews("Safaricom Digital Academy Launched", "Bob Collimore has launced the Safaricomdigital Academy at Strathmore College",1);
        assertTrue(testDepartmentalNews.equals(anotherDepartmentalNews));
    }

}
