<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.daos.EmployeeDao,app.models.Employee,java.util.List" %>
<%@ page import="app.daos.UserDao" %>
<%@ page import="app.models.UserDetail" %>

<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1>User View Page</h1>
<%
    UserDao dao=new UserDao();
    List<UserDetail> userDetails=dao.getAllUser();
    request.setAttribute("user",userDetails);%>
<div class="container">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">UserName</th>
            <th scope="col">Password</th>
            <th scope="col">Employeeid</th>
            <th scope="col">Employeename</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">City</th>

            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="userdetail">
            <tr>
                <td>${userdetail.getId()}</td>
                <td>${userdetail.getUserName()}</td>
                <td>${userdetail.getPassword()}</td>
                <td>${userdetail.getEmployeeid()}</td>
                <td>${userdetail.getEmplpoyeename()}</td>
                <td>${userdetail.getEmail()}</td>
                <td>${userdetail.getPhone()}</td>
                <td>${userdetail.getCtiy()}</td>
                <td>${userdetail.getDelete()}</td>


                <td><a href="/employee/edit?id=${emp.getId()}">Edit</a></td>
                <td><a href="/employee/delete?id=${emp.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>