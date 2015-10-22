package controllers;
 
import static controllers.Security.authenticate;
import models.User;
import play.*;
import play.mvc.*;

@With(Secure.class)
@Check("administrator")
public class Users extends CRUD {  

    @Before
    static void admin() {
        if (!authenticate("admin@admin.com", "admin")) {
            User admin = new User();
            admin.name = "admin";
            admin.email = "admin@admin.com";
            admin.password = "admin";
            admin.save();
            System.out.println("asasds");
        }
    }
}
