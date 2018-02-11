<%--
  Created by IntelliJ IDEA.
  User: emin
  Date: 12/02/18
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Документы</title>
</head>
<body>
    <h1>Документы</h1>
    <c:url var="addUrl" value="/krams/main/persons/add" />
    <table style="border: 1px solid; width: 500px; text-align:center">
        <thead style="background:#fcf">
        <tr>
            <th>НОМЕР</th>
            <th>ДАТА</th>
            <th>СУММА</th>
            <th colspan="3"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${documents}" var="document">
            <c:url var="editUrl" value="/krams/main/persons/edit?id=${document.id}" />
            <c:url var="deleteUrl" value="/krams/main/persons/delete?id=${document.id}" />
            <tr>
                <td><c:out value="${document.id}" /></td>
                <td><c:out value="${document.date}" /></td>
                <td><c:out value="${document.amount}" /></td>
                <td><a href="${editUrl}">Редактировать</a></td>
                <td><a href="${deleteUrl}">Удалить</a></td>
                <td><a href="${addUrl}">Добавить</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty documents}">
        В таблице отсутствуют документы!<a href="${addUrl}">Добавить</a> документ.
    </c:if>

</body>
</html>
