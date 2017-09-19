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
    <h1>Change User Data</h1>
    <a href="/" class="btn btn-primary">Home</a>
    <a href="/listUsers" class="btn btn-info">Back</a>
    <a href="/logout" class="btn btn-danger">Logout</a>
</div>
<div class="container">
    <form method="post">
        <div>
            <input type="hidden" name="id" value=${user.id}>
        </div>
        <div>
            <label for="login">Login:</label>
            <input class="form-control" id="login" name="login" required value=${user.login}>
        </div>
        <div class="form-group">
            <label for="password">New Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="mail">E-mail:</label>
            <input class="form-control" id="mail" name="mail" required value=${user.mail}>
        </div>
        <div>
            <input type="submit" class="btn btn-primary center-block" value="Update">
        </div>
    </form>
</div>
</body>
</html>
