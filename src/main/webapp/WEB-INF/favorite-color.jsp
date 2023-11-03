<%--
  Created by IntelliJ IDEA.
  User: gonzaloovalle
  Date: 11/2/23
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick your favorite color!</title>
</head>
<body>

<form action="favorite-color" method="post" >
    <label for="color">Pick your favorite color!
        <select name="color" id="color">
            <option value="blue">Blue</option>
            <option value="black">Black</option>
            <option value="pink">Pink</option>
        </select>
    </label>
    <input type="submit">
</form>

</body>
</html>
