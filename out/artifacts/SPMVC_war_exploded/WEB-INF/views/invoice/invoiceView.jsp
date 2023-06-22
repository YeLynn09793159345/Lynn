<
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.daos.InvoiceDao,app.models.Invoice,java.util.List" %>
<%@ page import="app.daos.InvoiceDao" %>
<%@ page import="app.models.InvoiceDetails" %>

<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1>Invoice View Page</h1>
<%
    InvoiceDao dao=new InvoiceDao();
    List<InvoiceDetails> details=dao.getAllInvoiceDetails();
    request.setAttribute("details",details);
%>
<div class="container">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Invoice Id</th>
            <th scope="col">Invoice No</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Employee Id</th>
            <th scope="col">Employee Name</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${details}" var="detail">
            <tr>
                <td>${detail.getInvoiceid()}</td>
                <td>${detail.getInvoiceno()}</td>
                <td>${detail.getCustomerid()}</td>
                <td>${detail.getCustomername()}</td>
                <td>${detail.getEmployeeid()}</td>
                <td>${detail.getEmployeename()}</td>
                <td><a href="/employee/edit?id=${emp.getId()}">Edit</a></td>
                <td><a href="/employee/delete?id=${emp.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>