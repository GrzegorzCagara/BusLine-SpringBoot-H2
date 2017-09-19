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
    <h1>Register</h1>
    <a href="/" class="btn btn-primary">Home</a>
    <a href="/login" class="btn btn-success">Login</a>
</div>
<form method="post">
    <div class="container">
        <div class="form-group">
            <label for="login">Login:</label>
            <input class="form-control" id="login" name="login" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="mail">Adress e-mail:</label>
            <input class="form-control" id="mail" name="mail" required>
        </div>
    </div>
    <div>
        <input type="submit" class="btn btn-primary center-block" value="Register">
    </div>
</form>
</body>
</html>
