<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<div class="admin-container">
    <div class="content">

        <h1>Book Store Administration</h1>

        <h2>Admin Login</h2>


        <c:if test="${sessionScope.loginInvalid != null}">
            <h4>${sessionScope.loginInvalid}</h4>
            <c:remove var="loginInvalid" scope="session" />
        </c:if>

        <c:if test="${sessionScope.successfullyLogin != null}">
            <h4>${sessionScope.successfullyLogin}</h4>
            <c:remove var="successfullyLogin" scope="session" />
        </c:if>



        <form method="post" action="${pageContext.request.contextPath}/admin/login">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input class="form-control" type="text" name="email" size="20"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="form-control" type="password"  name="password" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="display: flex;
    margin: 0 auto;
    flex-direction: row;
    justify-content: center;
    column-gap: 10px;">
                            <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>

<script>


</script>

</body>
</html>
