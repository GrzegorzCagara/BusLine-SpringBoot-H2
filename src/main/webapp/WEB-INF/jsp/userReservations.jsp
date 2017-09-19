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
    <h1>List of all Reservation</h1>
    <a href="/" class="btn btn-primary">Home</a>
    <a href="/" class="btn btn-info">Back</a>
    <a href="/logout" class="btn btn-danger">Logout</a>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Price</th>
            <th>Date Of Journey</th>
            <th>Number Of Seats</th>
            <th>Deprature</th>
            <th>Destiny</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transports}" var="transport">
            <tr>
                <td>&bull; ${transport.id}</td>
                <td>&bull; ${transport.price}</td>
                <td>&bull; ${transport.dateOfFlight}</td>
                <td>&bull; ${transport.numberOfSeats}</td>
                <td>&bull; ${transport.departure}</td>
                <td>&bull; ${transport.destiny}</td>
                <td>
                    <form action="reservations" method="post">
                        <div class="text-center">
                            <input type="hidden" name="id" required value=${transport.id}>
                            <input type="submit" class="btn btn-danger" value="Cancel">
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
