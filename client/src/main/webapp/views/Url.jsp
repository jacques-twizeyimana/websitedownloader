<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&family=Fira+Code:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">

<title>Website Download Manager</title>
  <style>
        * {
            font-family: 'DM Sans', sans-serif;
        }

        body {
            background-color: #f7f7f7;
        }

        .text-primary {
            color: rgb(20 83 45) !important;
        }
        .flex{
            display: flex;
            gap: 5px;
        }
   </style>
</head>
<body>
<jsp:include page="components/Navbar.jsp"></jsp:include>
<div class="container mt-5" style="width: 100%;max-width: 700px">
    <h1 class="text-primary fw-bold text-center">Website to download</h1>
    <c:if test="${not empty param['registered']}">
        <div class="alert alert-success">
            <strong>Success!</strong> You have inputed correct url.
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
    <div class="mt-5">
        <form action="/download" method="post" class="form-inline flex my-2 my-lg-0">
            <input type="text" name="url"  class="form-control form-control-lg mr-sm-2" id="url" placeholder="https://example.com">
            <button type="submit" class="btn-lg btn btn-primary my-2 my-sm-0">Download</button>
        </form>
    </div>
</div>
</body>
</html>
