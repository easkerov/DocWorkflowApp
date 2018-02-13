<%--
  Created by IntelliJ IDEA.
  User: emin
  Date: 12/02/18
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Новый документ</title>
</head>
<body>
<h3>Новый документ</h3>
<form:form method="POST" modelAttribute="document" action="/document/add" >
    <table>
        <tr>
            <td><form:label path="date">Дата</form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="amount">Сумма</form:label></td>
            <td><form:input path="amount"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
