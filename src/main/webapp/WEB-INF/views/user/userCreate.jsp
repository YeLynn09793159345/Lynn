
<%@ page import="java.util.List" %>

<%@ page import="app.daos.EmployeeDao" %>
<%@ page import="app.models.Employee" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1 style="text-align: center">User Create Page</h1>
<%

    EmployeeDao dao1=new EmployeeDao();
    List<Employee> employees=dao1.getAllEmployee();

    request.setAttribute("employees",employees);
%>
<div class="container col-md-6 offset-md-3">
    <form action="/user/create" method="post">

        <div class="form-group">
            <label for="uesrname">Username</label>
            <input type="text" class="form-control" id="username" name="username">
        </div>

        <div class="form-group">
            <label for="password">InvoiceNo</label>
            <input type="text" class="form-control" id="password" name="password">
        </div>

        <div class="form-group">
            <label for="employeeid">Employee Id</label>
            <select class="form-control" name="employeeid" id="employeeid">
                <c:forEach items="${employees}" var="emp">
                    <option value="${emp.getId()}">${emp.getId()}-${emp.getName()}</option>
                </c:forEach>
            </select>
        </div>



        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>