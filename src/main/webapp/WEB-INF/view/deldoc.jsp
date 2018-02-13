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
    <title>Удаление документа</title>
</head>
<body>
<h3>Удаление документа</h3>
<form:form method="POST" modelAttribute="document" action="/document/delete" >
    <table>
        <tr>
            <td><form:label path="id">Номер документа</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
