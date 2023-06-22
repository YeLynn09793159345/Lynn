package app.controllers;

import app.daos.InvoiceDao;
import app.models.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceController {

    @GetMapping("/invoice/create")
    public String createInvoiceGet(){
        return "invoice/invoiceCreate";
    }

    @PostMapping("/invoice/create")
    public String createInvoicePost(@RequestParam String invoiceno,int customerid,int employeeid){
        Invoice invoice=new Invoice(invoiceno,customerid,employeeid);
        InvoiceDao dao=new InvoiceDao();
        int status=dao.createInvoice(invoice);
        return "invoice/invoiceCreate";
    }

    @GetMapping("/invoice/view")
    public String viewInvoice(){
        return "invoice/invoiceView";
    }
}
