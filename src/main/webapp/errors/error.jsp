<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String message = pageContext.getException().getMessage();
   String exception = pageContext.getException().getClass().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception</title>
</head>
<body>
<h1>В процессе работы веб приложения произошла ошибка</h1>
<p>Что пошло не так: <%= message %></p>
</body>
</html>