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
    <h1>Change Routes Data</h1>
    <a href="/" class="btn btn-primary">Home</a>
    <a href="/listTransports" class="btn btn-info">Back</a>
    <a href="/logout" class="btn btn-danger">Logout</a>
</div>
<div class="container">
    <form method="post">
        <div>
            <input type="hidden" name="id" value=${transport.id}>
        </div>
        <div>
            <label for="numberOfSeats">Number of seats:</label>
            <input type="number" class="form-control" id="numberOfSeats" name="numberOfSeats" required
                   value=${transport.numberOfSeats}>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name="price" required value=${transport.price}>
        </div>
        <div>
            <input type="submit" class="btn btn-primary center-block" value="Update">
        </div>
    </form>
</div>
</body>
</html>
