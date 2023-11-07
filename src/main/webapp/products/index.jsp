<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Products</title>
</head>
<body>

<h1>Search products:</h1>
<form method="POST" action="/searchProduct">

    <label for="search"></label><input type="text" name="search" id="search">

</form>

<c:if test="${searchTerm != null}">
<h2>Showing Results for <c:out value="${searchTerm}" /></h2>
</c:if>


<h1>Here are all the products:</h1>
<c:forEach var="product" items="${viewProducts}">
    <div class="product">
        <h2>${product.name}</h2>
        <p>Price: $ ${product.price}</p>
    </div>
</c:forEach>

</body>
</html>
