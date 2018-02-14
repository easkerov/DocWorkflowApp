<%--
  Created by IntelliJ IDEA.
  User: emin
  Date: 12/02/18
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Документы</title>
</head>
<body>
    <h1>Документы</h1>
    <c:url var="addUrl" value="/document/add" />
    <c:url var="deleteUrl" value="/document/delete" />
    <a href="${addUrl}">Создать документ</a>
    <a href="${deleteUrl}">Удалить документ</a>
    <a href="<c:url value="/logout" />">Выход</a>
    <table style="border: 1px solid; width: 500px; text-align:center">
        <thead style="background:#5c7cff">
        <tr>
            <th>НОМЕР</th>
            <th>ДАТА</th>
            <th>СУММА</th>
            <th colspan="3"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${documents}" var="document">
            <tr>
                <td><c:out value="${document.id}" /></td>
                <td><c:out value="${document.date}" /></td>
                <td><c:out value="${document.amount}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${empty documents}">
        В таблице отсутствуют документы! <a href="${addUrl}">Добавить</a> документ.
    </c:if>
</body>
</html>
