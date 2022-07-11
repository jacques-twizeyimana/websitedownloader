<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Download details</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;1,100&display=swap"
          rel="stylesheet">
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        .report-container {
            margin-top: 50px;
            padding: 0 50px;
        }

        .report-container-sub{
            margin-top: 50px;
        }

        .report-container h2 {
           font-size: 30px;
        }

        .table-body tr td {
            text-align: center;
            padding-top: 12px;
        }
        p{
            font-size: 16px;
        }
        a{
            color: dodgerblue;
            text-decoration: underline;
        }
        .truncate{
            overflow-x: hidden;
            text-overflow: ellipsis;

        }
    </style>
</head>
<body>
<jsp:include page="components/Navbar.jsp"></jsp:include>
<div class="report-container">
    <h2>Website download details</h2>
    <div class="report-container-sub">
        <div>
            <c:forEach items="${links}" var="url">
                <p class="py-2 truncate">
                    <a class="" href="#">${url.website.website_name}${url.link_name}</a>
                    <span>(downloaded ${url.total_downloaded_kilobytes} KB in <bold>${url.total_elapsed_time/1000} s)</bold></span>
                </p>
            </c:forEach>
        </div>
    </div>

</div>

</body>
</html>