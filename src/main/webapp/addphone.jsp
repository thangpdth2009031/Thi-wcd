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
    <h2>Input Phone</h2>

    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Input Phone</h2>
        </div>

        <form action="/addphone" method="post"  class="w3-container">
            <p>
                <input class="w3-input" name="name" type="text" value="<%=phone.getName()%>"/>
                    <%
            if (errors.containsKey("name")) {
        %>
            <p class="valid">* <%=errors.get("name")%>
            </p>
            <%}%>
                <label>Name</label></p>


            <select name="brand">
                <option value="Apple">Apple</option>
                <option value="Samsung">Samsung</option>
                <option value="Nokia">Nokia</option>
                <option value="Others">Others</option>
            </select>
            <label>Brand</label>
            <p>
                <input class="w3-input" name="price" type="number">
                    <%
            if (errors.containsKey("price")) {
        %>
            <p class="valid">* <%=errors.get("price")%>
            </p>
            <%}%>
                <label>Price</label></p>
            <p>
                <input class="w3-input" name="description" type="text" value="<%=phone.getDescription()%>">
                    <%
                if (errors.containsKey("description")) {
            %>
            <p class="valid">* <%=errors.get("description")%>
            </p>
            <%}%>
                <label>Description</label></p>
            <button type="submit" class="registerbtn">Save</button>
            <button type="reset" class="ui-helper-reset">Reset</button>
        </form>
    </div>
</div>

</body>
</html>