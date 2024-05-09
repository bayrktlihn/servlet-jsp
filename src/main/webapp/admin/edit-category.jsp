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

    </style>
</head>
<body>

<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">

        <h2>Edit Category</h2>

        <c:if test="${sessionScope.categoryNameAlreadyExists != null}">
            <h4>${sessionScope.categoryNameAlreadyExists}</h4>
            <c:remove var="categoryNameAlreadyExists" scope="session"/>
        </c:if>

        <form method="post" onsubmit="return validateInputs()" id="updateCategoryForm"
              action="${pageContext.request.contextPath}/admin/update-category">
            <table>
                <input type="hidden" name="id" value="${category.id}">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" value="${category.name}" name="name" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="display: flex;
    margin: 0 auto;
    flex-direction: row;
    justify-content: center;
    column-gap: 10px;">
                            <button class="btn-warning btn" type="submit">Update</button>
                            <button class="btn btn-secondary" type="button" onclick="cancelHandle()">Cancel</button>
                        </div>
                    </td>
                </tr>
            </table>
        </form>

    </div>
    <jsp:include page="footer.jsp"></jsp:include>

</div>

<script>

    function cancelHandle() {
        location.replace("${pageContext.request.contextPath}/admin/list-category")
    }

    function validateInputs() {
        let updateCategoryForm = document.querySelector("#updateCategoryForm");

        let nameInput = updateCategoryForm.querySelector(`input[name="name"]`);


        if (!nameInput.value) {
            alert("Name is required!");
            nameInput.focus();
            return false;
        }


        return true;
    }
</script>

</body>
</html>
