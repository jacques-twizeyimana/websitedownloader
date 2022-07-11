<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../styles/navbar.css">
    <title>Navbar</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;1,100&display=swap');
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        .navbar-container{
            display: flex;
            flex-direction: row;
            /*height: 3rem;*/
            width: 100%;
            background: rgb(20 83 45);
            justify-content: space-between;
            align-items: center;
            padding: 10px 50px;
        }
        .navbar-container h2{
            font-weight: bold;
            font-size: 30px;
            color: white;
        }
        .navbar-container a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
<div class="navbar-container">
    <h2><a href="/">WEBSITE DOWNLOADER</a></h2>
    <a href="/report">History</a>
</div>
</body>
</html>