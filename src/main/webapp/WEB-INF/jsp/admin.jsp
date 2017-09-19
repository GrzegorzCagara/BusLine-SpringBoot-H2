<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BusLine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Welcome to Admin panel</h1>
    <a href="/logout" class="btn btn-danger">Logout</a>
</div>
<div class="text-center">
    <a href="/listUsers" class="btn btn-info btn-lg">View all users</a>
    <br/><br/>
    <a href="/listTransports" class="btn btn-info btn-lg">View all routes</a>
    <br/><br/>
    <a href="/addNewRoute" class="btn btn-success btn-lg">Add new route</a>
</div>
</body>
</html>
