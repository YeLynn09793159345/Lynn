package app.controllers;

import app.daos.CustomerDao;
import app.daos.UserDao;
import app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping(value = "/user/create")
    public String createUserGet(){
        System.out.println("Get Method");
        return "user/userCreate";
    }

    @PostMapping ("/user/create")
    public String createUserPost(@RequestParam String username,String password,int employeeid){
        UserDao dao=new UserDao(username,password,employeeid);
        int status=dao.createUser(user);
        if (status==1){
            return "user/userCreate";
        }

        return "user/userCreate";
    }

    @GetMapping("/user/view")
    public String viewUser(){
        return "user/userView";
    }

    @GetMapping("/user /delete")
    public String deleteUser(@RequestParam int id){
        UserDao dao=new UserDao();
        int status=dao.deleteUser(id);
        if(status==1){
            return "user/userView";
        }
        return "user/userView";
    }


}
