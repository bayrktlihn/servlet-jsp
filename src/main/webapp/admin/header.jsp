<div style="display: flex; flex-direction: column; justify-content: center">
    <img src="${pageContext.request.contextPath}/images/BookstoreAdminLogo.png">
</div>

<div style="display: flex; flex-direction: row; column-gap: 10px">
    <span>Welcome, ${sessionScope.username}</span>
    <a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</div>

<div style="display: flex; flex-direction: row; column-gap: 10px; padding: 10px">
    <a href="${pageContext.request.contextPath}/admin/list-user">Users</a>
    <a href="${pageContext.request.contextPath}/admin/list-category">Categories</a>
    <a href="#">Books</a>
    <a href="#">Customers</a>
    <a href="#">Reviews</a>
</div>