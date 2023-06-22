<jsp:include page="/WEB-INF/views/header.jsp"/>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<h1 style="text-align: center">Customer Create Page</h1>
<div class="container col-md-6 offset-md-3">
    <form action="/customer/create" method="post">

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>

        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>