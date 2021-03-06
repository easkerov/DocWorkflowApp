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
    <title>Новый документ</title>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Новый документ</h1>
    <form:form method="POST" modelAttribute="document" action="/document/add" >
        <table>
            <tr>
                <td>Номер</td>
                <td><form:input path="id"/></td>
                <td><form:errors path="id" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Сумма</td>
                <td><form:input path="amount"/></td>
                <td><form:errors path="amount" cssClass="error" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Добавить"/></td>
            </tr>
        </table>
    </form:form>
    <a href="/document/list">Список документов</a>
</body>
</html>
