<%@ page import="com.example.thiwcd.entity.Phone" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <%
        List<Phone> phones = (ArrayList<Phone>) request.getAttribute("phones");
        for(Phone phone: phones) {%>
    <tr>
        <td><%= phone.getId() %></td>
        <td>
            <%= phone.getName() %>
        </td>
        <td><%= phone.getPrice() %></td>
        <td><%= phone.getDescription() %>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
