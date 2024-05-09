<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
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


    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">

        <h2>Categories Management</h2>


        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/category-form.jsp">Create Category User</a>

        <c:if test="${sessionScope.deletedCategoryMessage != null}">
            <h4>${sessionScope.deletedCategoryMessage}</h4>
            <c:remove var="deletedCategoryMessage" scope="session"/>
        </c:if>

        <c:if test="${sessionScope.categoryCreatedSuccessfully != null}">
            <h4>${sessionScope.categoryCreatedSuccessfully}</h4>
            <c:remove var="categoryCreatedSuccessfully" scope="session"/>
        </c:if>

        <table>
            <tr>
                <th>Index</th>
                <th>ID</th>
                <th>Name</th>
            </tr>

            <c:forEach items="${categories}" var="category" varStatus="loop">
                <tr>
                    <td>${loop.index}</td>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td style="display: flex; flex-direction: row; column-gap: 15px">
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/edit-category?id=${category.id}">Edit</a>
                        <a class="btn btn-danger" href="javascript:confirmDelete(${category.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <jsp:include page="footer.jsp"></jsp:include>

    <script>
        function confirmDelete(id) {
            let confirmed = confirm('Are you sure want to delete the category with ID '+id);
            if (confirmed) {
                window.location = "${pageContext.request.contextPath}/admin/delete-category?id=" + id;
            }
        }
    </script>

</div>

</body>
</html>
