<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<%
	Date today = Calendar.getInstance().getTime();
	SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
	SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	
	Scanner sc = new Scanner(System.in);
	
	int currYear = Integer.parseInt(yearFormat.format(today));
	int currMonth = Integer.parseInt(monthFormat.format(today));
	int currDay = Integer.parseInt(dayFormat.format(today));
	
	int birthYear = 2019;
	int birthMonth = 10;
	int birthDay = 24;
	
	int dayCount = 0;
	
	dayCount = currDay - birthDay;
	dayCount = dayCount + ((currMonth * 30) - (birthMonth * 30));
	dayCount = dayCount + ((currYear * 365) - (birthYear * 365));
%>

<!DOCTYPE html>
<html>

<style>
	.box 
	{
	    width: 200px;
	    height: 200px; 
	    border-radius: 70%;
	    overflow: hidden;
	}
	
	.profile 
	{
	    width: 100%;
	    height: 100%;
	    object-fit: cover;
	}
</style>


<head>
	<meta charset="UTF-8">
	<title>Web Service ProgrammingHomework</title>
	<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
</head>

<body>	

	<header> INTRODUCE MYSELF </header>

	<div class="box">
    	<img class="profile" src="resources/ChoiHyeMin01.jpg">
	</div>
	<h1 style="text-align:center;"> Choi Hye Min </h1>
	<hr>
	
	<div style="text-align:center;">
		<a href="https://github.com/papav-hub"><img src="resources/github.png" height="50" width="50"></a>
	</div>

	<hr>
	<br>
	
	<table>
		<tr>
			<th>기초 교과</th>
			<td>글쓰기, 영어1, 영어2, 글로벌잉글리쉬, 가치와비전, 창의와 실천</td>
		</tr>
		<tr>
			<th>커리어 교과</th>
			<td>진로와 미래</td>
		</tr>
		<tr>
			<th>핵심 교양</th>
			<td>과학기술과 대중문화, 문화유산과 역사, 소비자와 마케팅, 현대사회와 법</td>
		</tr>
		<tr>
			<th>프로그래밍 실무 능력</th>
			<td>프로그래밍 기초, 프로그래밍, 선형대수학, 이산수학, 자료구조, 객체지향언어, 확률 및 통계학, 파이썬 프로그래밍, 자바, 네트워크 프로그래밍, 모바일 프로그래밍</td>
		</tr>
		<tr>
			<th>임베디드 시스템 개발 능력</th>
			<td>하드웨어 개론, 논리회로, 컴퓨터 구조</td>
		</tr>
		<tr>
			<th>시스템 구축 및 운영 능력</th>
			<td>전산학 기초, 창의적 공학 설계, 유닉스 기초, 데이터베이스, 운영체제, 소프트웨어 공학</td>
		</tr>
		<tr>
			<th>수강중인 과목</th>
			<td>알고리즘, 웹서비스프로그래밍, 컴퓨터응용설계, 종합설계 기획, 컴퓨터 네트워크</td>
		</tr>
		<tr>
			<th>수강중인 타학과 과목</th>
			<td>OpenSource SW, 인공지능</td>
		</tr>
		<tr>
			<th>수강 예정 과목</th>
			<td>수치해석, 오픈소스SW응용, 종합설계1, 종합설계2, 네트워크 메니지먼트, IoT설계, HCI개론, 클라우드 컴퓨팅, 기술문서 작성</td>
		</tr>
	</table>
	
	<br>
	<hr>
	<br>
	
	<h2 style="text-align:center;"> 제 보물 1호를 소개합니다 </h2>
	<div class="box">
    	<img class="profile" src="resources/cat.jpg">
	</div>
	<br>
	<hr>
	<h4 style="text-align:center;">오늘은 구름이랑 만난지 <%=dayCount %>째 되는 날입니다</h4>
	<hr>
	
	<div>
		<video controls height="300">
	  		<source src="resources/cat.mp4" type="video/mp4">
		</video>
	</div>
	
</body>
</html>