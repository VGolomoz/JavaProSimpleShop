<%@ page import="simpleshop.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <td></td>
            <td><b>Name</b></td>
            <td><b>Price</b></td>
        </tr>
        </thead>

        <% List<Product> products = (List<Product>) request.getAttribute("products");

            for (Product p : products) {
                out.println(
                        "<tr>" +
                                "<td><input type=\"checkbox\" value=\"" + p.getId() + "\" id=\"checkbox_$" + p.getId() + "\"/></td>" +
                                "<td>" + p.getName() + "</td>" +
                                "<td>" + p.getPrice() + " $</td>" +
                                "</tr>");
            } %>

    </table>
</div>

</body>
</html>