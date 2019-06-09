import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import models.DB;
import models.Department;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;
import static spark.route.HttpMethod.post;

import java.util.HashMap;
//import models.User;

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


        staticFileLocation("/public");

        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Gson gson = new Gson();


//// ---------------API ROUTING ------------------------------------//
        // --------API GET ------------------------//
        get("/departments", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.listAllDepartments());
        });

        // --------API POST  ---------------------//
        post("/departments", "app/json", (request, response) -> {
            Department newDepartment = gson.fromJson(request.body(), Department.class);
            departmentDao.saveDepartment(newDepartment);
            response.status(207);
            return gson.toJson(departmentDao.listAllDepartments());
        }) ;



        // ------Page routing (referring to handle bars ------- //

        //show Main landing page form
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

////------------------------------------------------------------------//
        //show new Department form
        get("/departments", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department> departments = departmentDao.listAllDepartments(); //refresh list of links for navbar
            model.put("departments", departments);
            return new ModelAndView(new HashMap(), "departments.hbs");
        }, new HandlebarsTemplateEngine());

                //post: process new department form
        post("/departments", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            Department newDepartment = new Department(name, description);
            departmentDao.saveDepartment(newDepartment);
            response.redirect("/success");
            return null;
        }, new HandlebarsTemplateEngine());

////---------------------------------------------------------------//
//
//        get("/users", (request, response) -> {
//            return new ModelAndView(new HashMap(), "users.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/news", (request, response) -> {
//            return new ModelAndView(new HashMap(), "news.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/faqs", (request, response) -> {
//            return new ModelAndView(new HashMap(), "faqs.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
        get("/success", (request, response) -> {
            return new ModelAndView(new HashMap(), "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
