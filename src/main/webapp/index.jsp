<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Авторизация</title>
	</head> 
	<body>
		<h1>Авторизация</h1>
		<c:url value="/document/list" var="messageUrl" />
		<a href="${messageUrl}">Перейти к списку документов</a>
	</body>
</html>
