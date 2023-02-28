<%@ page language="java" import="com.calc.*, com.user.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="scripts/script.js"></script>
<link href="styles/base_style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String[] measures = ContentContainer.getMeasures();
String[] from = ContentContainer.getFrom();

int tarif = 1;
double[] out_sum = new double[3];
boolean fromCountry = false;
try{
	if (request.getParameter("select").equals(measures[0])) tarif=1;
	if (request.getParameter("select").equals(measures[1])) tarif=2;
	if (request.getParameter("select").equals(measures[2])) tarif=3;
	if(request.getAttribute("fromback").equals("true")) fromCountry = true;
}catch(Exception e){
	
}
%>
<header>
<%@ include file="header.html"%> <!--  можно дефолтный хтмл или jsp вставлять  -->
</header>

<div class="container">

	<form name="myform" action="index" method="post"><!--GET (получение данных из сервера)  POST (отправка данных на сервер) -->
	
	<select name="select" id="tarifs" onchange="fun1()">
	  <option  <%= tarif==1? "selected" : "" %>> <%= measures[0] %> </option>
	  <option  <%= tarif==2? "selected" : "" %>> <%= measures[1] %> </option>
	  <option  <%= tarif==3? "selected" : "" %>> <%= measures[2] %> </option>
	</select>
	
	<select name="from">
	  <option> <%= from[0] %> </option>
	  <option <%= fromCountry==true? "selected":"" %>> <%= from[1] %> </option>
	</select>
	
		<input type="checkbox" id="contactChoice1"
     name="hasGas" value="has">
    <label for="contactChoice1">Есть газовая плита</label>
	
	
    <div class="ind" id="1">
    Показания в дневной зоне предудущие/текущие <br>
    <input name="11" id="11" type="number" min="0" max="999999"/>
    <input name="12" type="number" min="0" max="999999"/>
    </div>
    
    <div class="ind" id="2" <%= tarif==3||tarif==2? "" : "hidden" %> >
    Показания в ночной зоне предудущие/текущие <br>
    <input name="21" type="number" min="0" max="999999"/>
    <input name="22" type="number" min="0" max="999999"/>
    </div>
    
    <div class="ind" id="3" <%= tarif==3? "" : "hidden" %> >
    Показания в полупиковой зоне предудущие/текущие <br>
    <input name="31" type="number" min="0" max="999999"/>
    <input name="32" type="number" min="0" max="999999"/>
    </div>
    
	<input class="inpt" type='submit' value="послать данные" />
    
</form>

<!-- параметр(request) это то что мы с фронта передаем
атрибуты передаем с бэка !-->

 <div class="error">
  <p><%= request.getAttribute("error")=="yes"? "ОШИБКА" : "" %></p>
 </div>

 <div <%= request.getAttribute("calc")==null? "hidden" : "" %>>
  <p> <%= request.getAttribute("calc") %></p>
  <a href="${pageContext.request.contextPath}/mainAss.pdf" target="_blank" > Получить развернутый отчет</a>
  <p <%= tarif==1? "hidden='true'" : "" %>'> Всего вы должны заплатить: ${sum} руб</p>
 </div>

</div>





</body>
</html>