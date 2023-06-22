package app.controllers;

import app.daos.EmployeeDao;
import app.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee/create",method = RequestMethod.GET)
    public String createEmployeeGet(){
        System.out.println("Get Method");
        return "employee/employeeCreate";
    }

    @RequestMapping(value = "/employee/create",method = RequestMethod.POST)
    public String createEmployeePost(@RequestParam String name,String email,String phone,String city){
        Employee employee=new Employee(name,email,phone,city);
        EmployeeDao dao=new EmployeeDao();
        int status=dao.createEmployee(employee);
        if(status==1){
            return "employee/employeeView";
        }
        return "employee/employeeCreate";
    }

    @RequestMapping("/employee/view")
    public String viewEmployee(){
        return "employee/employeeView";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(@RequestParam int id){
        EmployeeDao dao=new EmployeeDao();
        int status=dao.deleteEmployee(id);
        if(status==1){
            return "employee/employeeView";
        }
        return "employee/employeeView";
    }

    @RequestMapping(value = "/employee/edit",method = RequestMethod.GET)
    public String editEmployeeGet(){

        return "employee/employeeEdit";
    }

    @RequestMapping(value = "/employee/edit",method = RequestMethod.POST)
    public String editEmployeePost(@RequestParam int hiddenid,String name,String email,String phone,String city){
        EmployeeDao dao=new EmployeeDao();
        Employee employee=new Employee(hiddenid,name,email,phone,city);
        int status=dao.updateEmployee(employee);
        if(status==1) {
            return "employee/employeeView";
        }else{
            return "employee/employeeEdit";
        }
    }
}
