<%@ page import="app.daos.EmployeeDao" %>
<%@ page import="app.models.Employee" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1 style="text-align: center">Employee Edit Page</h1>
<%
    int id=Integer.valueOf(request.getParameter("id"));
    EmployeeDao dao=new EmployeeDao();
    Employee employee=dao.getEmployeeById(id);
    request.setAttribute("emp",employee);
%>
<div class="container col-md-6 offset-md-3">
    <form action="/employee/edit" method="post">

        <div class="form-group">

            <input type="hidden" class="form-control" id="hiddenid" name="hiddenid" value="${emp.getId()}" >
        </div>
        <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" disabled="disabled" id="id" name="id" value="${emp.getId()}">
        </div>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${emp.getName()}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${emp.getEmail()}">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" value="${emp.getPhone()}">
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" value="${emp.getCity()}">
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>