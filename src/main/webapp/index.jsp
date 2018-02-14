<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Документы</title>
	</head>
	<body>
		<%
			String docListLocation = "/document/list";
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", docListLocation);
		%>
	</body>
</html>
