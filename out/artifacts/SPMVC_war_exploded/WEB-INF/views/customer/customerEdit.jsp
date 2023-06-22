<%@ page import="app.daos.CustomerDao" %>
<%@ page import="app.models.Customer" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1 style="text-align: center">Customer Edit Page</h1>
<%
    int id=Integer.valueOf(request.getParameter("id"));
    CustomerDao dao=new CustomerDao();
    Customer customer=dao.getCustomerById(id);
    request.setAttribute("com",customer);
%>
<div class="container col-md-6 offset-md-3">
    <form action="/customer/edit" method="post">

        <div class="form-group">

            <input type="hidden" class="form-control" id="hiddenid" name="hiddenid" value="${com.getId()}" >
        </div>
        <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" disabled="disabled" id="id" name="id" value="${com.getId()}">
        </div>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${com.getName()}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${com.getEmail()}">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" value="${com.getPhone()}">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${com.getAddress()}">
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>