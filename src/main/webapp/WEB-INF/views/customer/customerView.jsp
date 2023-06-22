<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.daos.CustomerDao,app.models.Customer,java.util.List" %>
<%@ page import="app.daos.CustomerDao" %>
<%@ page import="app.models.Customer" %>

<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1>Customer View Page</h1>
<%
    CustomerDao dao=new CustomerDao();
    List<Customer>  customer=dao.getAllCustomer();
    request.setAttribute("com",customer);%>
<div class="container">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${com}" var="com">
            <tr>
                <td>${com.getId()}</td>
                <td>${com.getName()}</td>
                <td>${com.getEmail()}</td>
                <td>${com.getPhone()}</td>
                <td>${com.getAddress()}</td>
                <td><a href="/customer/edit?id=${com.getId()}">Edit</a></td>
                <td><a href="/customer/delete?id=${com.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>