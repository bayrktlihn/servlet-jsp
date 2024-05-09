<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        html, body {
            padding: 0;
            margin: 0;
            height: 100%;
        }

        .index-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .content {
            display: flex;
            flex-direction: column;
            margin: 15px 0;
        }


    </style>
</head>
<body>

<div class="index-container">

    <jsp:include page="header.jsp"></jsp:include>


    <div class="content">
        <h2>Please login:</h2>
        <form style="display: flex; flex-direction: column; row-gap: 10px">
            <div>
                Email: <input type="text" size="10">
            </div>
            <div>
                Password: <input type="password" size="10">
            </div>
            <div>
                <input type="submit" value="login">
            </div>
        </form>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>
