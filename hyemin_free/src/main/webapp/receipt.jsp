<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hyemin_free.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RECEIPT</title>
		<link rel="stylesheet" href="css/netflix.css">
		<link rel="stylesheet" href="css/seat.css">
	</head>
	
	<header class="iconos">
        <div class="imagen-iconos">
            <a id="title2" href="http://localhost:8080/hyemin_free/MovieServlet?cmdReq=list"><img id="imagen" src="media/logo-netflix.png" alt=""></a>
        </div>
    </header>
	
	
	<%
		String selectedSeats = request.getParameter("selectedSeats");
		String movie_name = request.getParameter("movie_name");
		String id = (String)session.getAttribute("id");
	%>

	
	<body style='background-color: black;'>
	
	<div align=center>
	
		<h2 class="titulo1">영수증</h2>
	
		<table>
			<tr>
				<td><h2 class="titulo1">결제할 ID</h2></td>
				<td><h2 class="titulo1"><%=id %></h2></td>
			</tr>
			
			<tr>
				<td><h2 class="titulo1">결제할 영화</h2></td>
				<td><h2 class="titulo1"><%=movie_name %></h2></td>
			</tr>
			
			<tr>
				<td><h2 class="titulo1">결제할 좌석</h2></td>
				<td><h2 class="titulo1"><%=selectedSeats %></h2></td>
			</tr>
		
		</table>
		
	</div>
	
	<div class="panel-inicio">
		<a id="title2" href="http://localhost:8080/hyemin_free/login.jsp"><h3>결제하기</h3></a>
    </div>
	
	</body>
	
</html>