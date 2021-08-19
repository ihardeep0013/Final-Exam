<%--
  Created by IntelliJ IDEA.
  User: harde
  Date: 19-Aug.-2021
  Time: 12:51 p.m.
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

    </style>
</head>
<body>
<h1>Loan Records</h1>
5.	<div class="container2">
    <p>The following are the loan records </p>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client Number</th>
            <th>Client Name</th>
            <th>Loan Amount</th>
            <th>Number of years</th>
            <th>Loan Type</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">



            <tr>
                <td>${todo.clientno}</td>
                <td>${todo.clientname}</td>
                <td>${todo.loanamount}</td>
                <td>${todo.years}</td>
                <td>${todo.loantype}</td>

                <td>    <a type="button" class="btn btn-primary"
                           href="update-todo?id=${todo.clientno}" >Edit</a> </td>



                <td>    <a type="button" class="btn btn-primary"
                           href="delete-todo?id=${todo.clientno}" >Delete</a> </td>

                <td>    <a type="button" class="btn btn-primary"
                           href="update-todo?id=${todo.clientno}" >Amortization Table</a> </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

</div>

<a class="btn btn-success" href="add-todo">Add</a>
</body>
</html>