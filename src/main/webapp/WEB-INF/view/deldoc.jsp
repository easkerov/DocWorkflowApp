<%--
  Created by IntelliJ IDEA.
  User: emin
  Date: 12/02/18
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Удаление документа</title>
</head>
<body>
    <h1>Удаление документа</h1>
        <form:form method="POST" modelAttribute="document" action="/document/delete" >
            <table>
                <tr>
                    <td>Номер документа</td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Удалить"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>
