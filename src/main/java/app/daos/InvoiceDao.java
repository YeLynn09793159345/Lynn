package app.daos;

import app.helper.DBHelper;
import app.models.Invoice;
import app.models.InvoiceDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDao {
    public int createInvoice(Invoice invoice){
        int status=0;
        Connection connection=DBHelper.getInstance().getConnection();
        String query="INSERT INTO invoice (invoiceno,customerid,employeeid) VALUES (?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,invoice.getInvoiceno());
            ps.setInt(2,invoice.getCustomerid());
            ps.setInt(3,invoice.getEmployeeid());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<InvoiceDetails> getAllInvoiceDetails(){
        List<InvoiceDetails> invoiceDetails=new ArrayList<>();

        ResultSet rs;
        Connection con=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM invoice " +
                "INNER JOIN customer " +
                "ON invoice.customerid=customer.id " +
                "INNER JOIN employee " +
                "ON invoice.employeeid=employee.id";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                InvoiceDetails details=new InvoiceDetails();
                details.setInvoiceid(rs.getInt("invoiceid"));
                details.setCustomerid(rs.getInt("customerid"));
                details.setEmployeeid(rs.getInt("employeeid"));
                details.setInvoiceno(rs.getString("invoiceno"));
                details.setCustomername(rs.getString("customername"));
                details.setEmployeename(rs.getString("employeename"));
                invoiceDetails.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoiceDetails;
    }

}
