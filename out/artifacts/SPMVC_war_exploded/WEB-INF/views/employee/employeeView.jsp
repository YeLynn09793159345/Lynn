<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.daos.EmployeeDao,app.models.Employee,java.util.List" %>

<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1>Employee View Page</h1>
<%
    EmployeeDao dao=new EmployeeDao();
    List<Employee> employees=dao.getAllEmployee();
    request.setAttribute("emp",employees);%>
<div class="container">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">City</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${emp}" var="emp">
            <tr>
                <td>${emp.getId()}</td>
                <td>${emp.getName()}</td>
                <td>${emp.getEmail()}</td>
                <td>${emp.getPhone()}</td>
                <td>${emp.getCity()}</td>
                <td><a href="/employee/edit?id=${emp.getId()}">Edit</a></td>
                <td><a href="/employee/delete?id=${emp.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>