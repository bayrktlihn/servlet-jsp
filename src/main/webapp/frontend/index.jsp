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
            margin: 15px 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }


    </style>
</head>
<body>

<div class="index-container">

    <jsp:include page="header.jsp"></jsp:include>

    <div class="content">
        <h3>This is main content:</h3>
        <h2>New Books:</h2>
        <h2>Best-Selling Books:</h2>
        <h2>Most-favored Books:</h2>
    </div

    <jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>
