<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="styles/base_style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>

<header>
<%@ include file="header.html"%> <!--  можно дефолтный хтмл или jsp вставлять  -->
</header>

<div class="container">
<form name="myform" action="person" method="post"><!--GET (получение данных из сервера)  POST (отправка данных на сервер) -->
		
    <div class="ind" id="1">
    Введите Имя <br>
    <input name="first_name" type="text"/> <br><br>
    
    Введите Фамилию <br>
    <input name="last_name" type="text"/><br><br>
    
    Введите Отчество <br>
    <input name="fath_name" id="11" type="text"/><br><br>
    
    Введите Адрес <br>
    <input name="adress" id="11" type="text"/><br><br>
    
    Введите Номер лицевого счёта <br>
    <input name="bank_acc" id="11" type="number"/><br><br>
    
    </div>
    
	<input class="inpt" type='submit' value="Подтвердить изменения" />
    
</form>
 </div>
</body>
</html>