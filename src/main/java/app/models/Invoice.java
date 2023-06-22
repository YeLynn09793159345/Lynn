package app.models;

public class Invoice {
    private int invoiceid,customerid,employeeid;
    private String invoiceno;

    public Invoice() {
    }

    public Invoice(String invoiceno,int customerid, int employeeid) {
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.invoiceno = invoiceno;
    }

    public Invoice(int invoiceid, int customerid, int employeeid, String invoiceno) {
        this.invoiceid = invoiceid;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.invoiceno = invoiceno;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }
}
