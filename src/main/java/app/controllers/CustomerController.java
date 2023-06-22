package app.controllers;

import app.daos.CustomerDao;
import app.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @GetMapping(value = "/customer/create")
    public String createCustomerGet(){
        System.out.println("Get Method");
        return "customer/customerCreate";
    }

    @PostMapping ("/customer/create")
    public String createCustomerPost(@RequestParam String name,String email,String phone,String address){
        Customer customer=new Customer(name,email,phone,address);
        CustomerDao dao=new CustomerDao();
        int status=dao.createCustomer(customer);
        if(status==1){
            return "customer/customerView";
        }
        return "customer/customerCreate";
    }

    @RequestMapping("/customer/view")
    public String viewCustomer(){
        return "customer/customerView";
    }

    @RequestMapping("/customer /delete")
    public String deleteCustomer(@RequestParam int id){
        CustomerDao dao=new CustomerDao();
        int status=dao.deleteCustomer(id);
        if(status==1){
            return "customer/customerView";
        }
        return "customer/customerView";
    }

    @GetMapping("/customer/edit")
    public String editCustomerGet(){

        return "customer/customerEdit";
    }

    @PostMapping("/customer/edit")
    public String editCustomerPost(@RequestParam int hiddenid,String name,String email,String phone,String address){
        CustomerDao dao=new CustomerDao();
        Customer customer=new Customer(hiddenid,name,email,phone,address);
        int status=dao.updateCustomer(customer);
        if(status==1) {
            return "customer/customerView";
        }else{
            return "customer/customerEdit";
        }
    }
}
