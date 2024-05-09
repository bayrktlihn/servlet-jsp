<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <style>

        .admin-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .content {
            margin: 20px 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-width: 700px;
        }

        th, td {
            padding: 5px 10px;
        }

        table {
            padding: 1rem;
        }

    </style>
</head>
<body>

<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">

        <h2>Users Management</h2>

        <c:if test="${sessionScope.deletedUserMessage != null}">
            <h4>${sessionScope.deletedUserMessage}</h4>
            <c:remove var="deletedUserMessage" scope="session"/>
        </c:if>

        <c:if test="${sessionScope.createUserMessage != null}">
            <h4>${sessionScope.createUserMessage}</h4>
            <c:remove var="createUserMessage" scope="session"/>
        </c:if>

        <c:if test="${sessionScope.userNotFoundMessage != null}">
            <h4>${sessionScope.userNotFoundMessage}</h4>
            <c:remove var="userNotFoundMessage" scope="session"/>
        </c:if>


        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/user-form.jsp">Create New User</a>

        <table class="table">
            <tr>
                <th>Index</th>
                <th>ID</th>
                <th>Email</th>
                <th>Fullname</th>
                <th>Actions</th>
            </tr>

            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td>${loop.index}</td>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.fullName}</td>
                    <td style="display: flex; flex-direction: row; column-gap: 15px">
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/edit-user?id=${user.id}">Edit</a>
                        <a class="btn btn-danger" href="javascript:confirmDelete(${user.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <jsp:include page="footer.jsp"></jsp:include>

    <script>
        function confirmDelete(id) {
            let confirmed = confirm('Are you sure want to delete the user with ID ' + id);
            if (confirmed) {
                window.location = "${pageContext.request.contextPath}/admin/delete-user?id=" + id;
            }
        }
    </script>

</div>

</body>
</html>
