<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int num = 20; %>
<%! int count = -2; %>

<html>
<head>
    <title><%= num == 20 %></title>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>
    <h1>The current count is: <%= count %> </h1>
    <% count += 1; %>

    <%-- JSP comment, it will not be seen in the HTML --%>

    <!-- HTML comment, it will be seen in the HTML -->

    <h1>Implicit Object in action:</h1>
    <p>Path: <%= request.getRequestURL() %></p>
    <p>Query String: <%= request.getQueryString() %></p>
    <p>"name" Parameter: <%= request.getParameter("name") %></p>
    <p>"method" Attribute: <%= request.getMethod() %></p>
    <p>User-Agent header: <%= request.getHeader("user-agent") %></p>

    <h2>EL / Expression Language</h2>
    <p>User-Agent header: ${header["user-agent"]}</p>

    <h2>What other evaluations can we do?</h2>
    <p>${2 + 2}</p>

    <% request.setAttribute("message", "Hello World!"); %>
    <% request.setAttribute("message2", "Hello Fenrir!"); %>

    <h1>${message}</h1>
    <h1>${message2}</h1>

    <h2>JSTL Functionality Demo</h2>

    <% request.setAttribute("numbers", new int[]{2, 7, 12, 21, 87}); %>

    <ul>
        <c:forEach items="${numbers}" var="number">
            <li>${number}</li>
        </c:forEach>
    </ul>

    <c:choose>
        <c:when test="false">
            <p>boolean expression 1 was true</p>
        </c:when>
        <c:when test="false">
            <p>boolean expression 1 was false, boolean expression 2 was true</p>
        </c:when>
        <c:otherwise>
            <p>none of the above tests were true</p>
        </c:otherwise>
    </c:choose>

    <c:if test="<%= num > 20 %>">
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="<%= num <= 20 %>">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>
