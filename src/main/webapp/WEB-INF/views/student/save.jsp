<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 24.07.2022
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${student.firstName} <br/>
${student.lastName} <br/>
${student.hobbies} <br/>
<ul>
    <c:forEach items="${student.hobbies}" var="hobby">
        <li> ${hobby} </li>
    </c:forEach>
</ul>
</body>
</html>
