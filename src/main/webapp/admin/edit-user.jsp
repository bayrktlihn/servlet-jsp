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

    </style>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<div class="admin-container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">

        <h2>Edit User</h2>

        <c:if test="${sessionScope.updateUserFailMessage != null}">
            <h4>${sessionScope.updateUserFailMessage}</h4>
            <c:remove var="updateUserFailMessage" scope="session" />
        </c:if>


        <form method="post" onsubmit="return validateInputs()" id="createUserForm" action="${pageContext.request.contextPath}/admin/update-user">
            <table>
                <input type="hidden" name="id" value="${user.id}">
                <tr>
                    <td>Email:</td>
                    <td><input class="form-control" type="text" value="${user.email}" name="email" size="20"></td>
                </tr>
                <tr>
                    <td>Full name:</td>
                    <td><input class="form-control" type="text" value="${user.fullName}" name="fullName" size="20"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="form-control" type="password" value="${user.password}" name="password" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="display: flex;
    margin: 0 auto;
    flex-direction: row;
    justify-content: center;
    column-gap: 10px;">
                            <button class="btn btn-warning" type="submit">Update</button>
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
