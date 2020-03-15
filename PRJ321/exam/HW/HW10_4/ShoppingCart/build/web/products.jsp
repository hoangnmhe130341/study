<%-- 
    Document   : products
    Created on : Oct 4, 2019, 8:29:46 PM
    Author     : hoangnm
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 25px;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
        }
        table, td {
            border: 1px solid black;
        }

        .button:hover {
            background-color: green;
        }
    </style>
    <body>
        <%
            ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("listP");
        %>
        <table style="width:50%; border:1px solid black">
            <tr>
                <td>Name</td>
                <td>Price</td>
                <td>Buy</td>
            </tr>
            <%
                for (Product p : list) {

            %>
            <tr>
                <td><%=p.getName()%></td>
                <td><%=p.getPrice()%></td>
                <td><button onclick="addToCart()" class="button" type="button" name="<%=p.getId()%>">Buy</button></td>
            </tr>
            <%}%>
        </table>
    </body>

    <script>
        function addToCart {
            var listCard = [];
        }
    </script>
</html>
