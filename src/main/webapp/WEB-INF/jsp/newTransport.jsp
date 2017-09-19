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
    <h1>Add new Route</h1>
    <a href="/" class="btn btn-primary">Home</a>
    <a href="/listTransports" class="btn btn-info">Back</a>
    <a href="/logout" class="btn btn-danger">Logout</a>
</div>
<div class="container">
    <form method="post">
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name="price" required>
        </div>
        <div class="form-group">
            <label for="dateOfFlight">Date Of Departure:</label>
            <input class="form-control" id="dateOfFlight" name="dateOfFlight" required>
        </div>
        <div class="form-group">
            <label for="numberOfSeats">Number of seats:</label>
            <input type="number" class="form-control" id="numberOfSeats" name="numberOfSeats" required>
        </div>
        <div class="form-group">
            <label for="departure">Departure:</label>
            <select id="departure" name="departure">
                <option value="Krakow">Krakow</option>
                <option value="Warszawa">Warszawa</option>
                <option value="Lezajsk">Lezajsk</option>
                <option value="Wroclaw">Wroclaw</option>
            </select>
        </div>
        <div class="form-group">
            <label for="destiny">Destiny:</label>
            <select id="destiny" name="destiny">
                <option value="Krakow">Krakow</option>
                <option value="Warszawa">Warszawa</option>
                <option value="Lezajsk">Lezajsk</option>
                <option value="Wroclaw">Wroclaw</option>
            </select>
        </div>
        <div>
            <input type="submit" class="btn btn-primary center-block" value="Add">
        </div>
    </form>
</div>
</body>
</html>
