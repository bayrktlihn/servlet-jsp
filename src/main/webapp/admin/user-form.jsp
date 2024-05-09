<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
        }

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

    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">

        <h2>Create New User</h2>

        <c:if test="${sessionScope.createUserFailMessage != null}">
            <h4>${sessionScope.createUserFailMessage}</h4>
            <c:remove var="createUserFailMessage" scope="session" />
        </c:if>


        <form method="post" onsubmit="return validateInputs()" id="createUserForm" action="${pageContext.request.contextPath}/admin/create-user">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input class="form-control" type="text" name="email" size="20"></td>
                </tr>
                <tr>
                    <td>Full name:</td>
                    <td><input class="form-control" type="text" name="fullName" size="20"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="form-control" type="password" name="password" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="display: flex;
    margin: 0 auto;
    flex-direction: row;
    justify-content: center;
    column-gap: 10px;">
                            <button class="btn btn-primary" type="submit">Save</button>
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

    function cancelHandle(){
        console.log("vasildi")
        location.replace("${pageContext.request.contextPath}/admin/list-user")
    }

    function validateInputs(){
        let userForm = document.querySelector("#createUserForm");

        let emailInput = userForm.querySelector(`input[name="email"]`);
        let fullnameInput = userForm.querySelector(`input[name="fullName"]`);
        let passwordInput = userForm.querySelector(`input[name="password"]`);

        if(!emailInput.value){
            alert("Email is required!");
            emailInput.focus();
            return false;
        }

        if(!fullnameInput.value){
            alert("Full name is required!");
            fullnameInput.focus();
            return false;
        }


        if(!passwordInput.value){
            alert("Password is required!");
            passwordInput.focus();
            return false;
        }


        return true;
    }
</script>

</body>
</html>
