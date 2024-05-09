<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="display: flex; flex-direction: column; align-items: center; row-gap: 15px">

    <img src="images/BookstoreLogo.png">


    <div style="display: flex; flex-direction: row; column-gap: 10px">
        <input type="text" name="keyword" size="50"/>
        <input type="button" value="Search"/>
        <a href="login">Sign in</a>
        <a href="login">Register</a>
        <a href="login">Cart</a>
    </div>

    <div style="display: flex; flex-direction: row; column-gap: 15px">
        <c:forEach items="${categories}" var="category">
            <a href="${pageContext.request.contextPath}/view-category?id=${category.id}">${category.name}</a>
        </c:forEach>
    </div>

</div>