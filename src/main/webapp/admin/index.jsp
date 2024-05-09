<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
        <h2>Administrative Dashboard</h2>

        <hr style="width: 100%">

        <h2>Quick Actions</h2>
        <div style="display: flex; flex-direction: row; column-gap: 10px">
            <a href="${pageContext.request.contextPath}/create-book">New Book</a>
            <a href="${pageContext.request.contextPath}/create-user">New User</a>
            <a href="${pageContext.request.contextPath}/create-category">New Category</a>
            <a href="${pageContext.request.contextPath}/create-customer">New Customer</a>
        </div>
        <hr style="width: 100%;">


        <h2>Recent Sales</h2>
        <hr style="width: 100%">
        <h2>Recent Reviews</h2>
        <hr style="width: 100%">
        <h2>Statistics</h2>
        <hr style="width: 100%">


    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
