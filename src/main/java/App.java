import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import models.Site;

public class App {

    public static void main(String[] args) {

//        ProcessBuilder process = new ProcessBuilder();
//        Integer port;
//
//        // This tells our app that if Heroku sets a port for us, we need to use that port.
//        // Otherwise, if they do not, continue using port 4567.
//
//        if (process.environment().get("PORT") != null) {
//            port = Integer.parseInt(process.environment().get("PORT"));
//        } else {
//            port = 4567;
//        }
//
//        port(port);


        // ------Page routing (referring to handle bars ------- //

        //show Main landing page form
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

//------------------------------------------------------------------//
        //show new Department form
        get("/departments", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Department> departments = departmentDao.getAll(); //refresh list of links for navbar
//            model.put("departments", departments);
            return new ModelAndView(new HashMap(), "departments.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new department form
        post("/departments", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
//            Department newDepartment = new Department(name);
//            departmentDao.add(newDepartment);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//---------------------------------------------------------------//

        get("/users", (request, response) -> {
            return new ModelAndView(new HashMap(), "users.hbs");
        }, new HandlebarsTemplateEngine());

        get("/news", (request, response) -> {
            return new ModelAndView(new HashMap(), "news.hbs");
        }, new HandlebarsTemplateEngine());

        get("/faqs", (request, response) -> {
            return new ModelAndView(new HashMap(), "faqs.hbs");
        }, new HandlebarsTemplateEngine());


        get("/success", (request, response) -> {
            return new ModelAndView(new HashMap(), "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
