<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.thiwcd.entity.Phone" %>
<%@ page import="java.util.Objects" %>

<%
    Phone phone = (Phone) request.getAttribute("phone");
    if (phone == null) {
        phone = new Phone();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<%System.out.println(errors);%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
    .button {
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        transition-duration: 0.4s;
        cursor: pointer;
    }

    .button1 {
        background-color: white;
        color: black;
        border: 2px solid #4CAF50;
    }

    .button1:hover {
        background-color: #4CAF50;
        color: white;
    }

    .button2 {
        background-color: white;
        color: black;
        border: 2px solid #008CBA;
    }

    .button2:hover {
        background-color: #008CBA;
        color: white;
    }

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .valid {
        color: red;
        font-size: 13px;
    }
</style>
<body>

<div class="w3-container">

    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Input Phone</h2>
        </div>

        <form action="/addphone" method="post" class="w3-container">
            <p>
                <label>Name</label>
                <input class="w3-input" name="name" type="text" value="<%=phone.getName()%>"/>
                    <%
            if (errors.containsKey("name")) {
        %>
            <p class="valid">* <%=errors.get("name")%>
            </p>
            <%}%>
            </p>


            <label>Brand</label>
            <select name="brand">
                <option value="Apple">Apple</option>
                <option value="Samsung">Samsung</option>
                <option value="Nokia">Nokia</option>
                <option value="Others">Others</option>
            </select>
            <p>
                <label>Price</label>
                <input class="w3-input" name="price" type="number" value="<%=phone.getPrice()%>">
                    <%
            if (errors.containsKey("price")) {
        %>
            <p class="valid">* <%=errors.get("price")%>
            </p>
            <%}%>
            </p>
            <p>
                <label>Description</label>
                <input class="w3-input" name="description" type="text" value="<%=phone.getDescription()%>">
                    <%
                if (errors.containsKey("description")) {
            %>
            <p class="valid">* <%=errors.get("description")%>
            </p>
            <%}%>
            </p>
            <button type="submit" class="button button1">Save</button>
            <button type="reset" class="button button2">Reset</button>
        </form>
    </div>
</div>

</body>
</html>