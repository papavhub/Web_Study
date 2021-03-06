<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select student</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublickKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	
	String sql = "select * from student where username like ?";
	String name = request.getParameter("username") + "%";
	int rowCount = 0;
	
	try{
		Class.forName(jdbc_driver);
		con = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet result = pstmt.executeQuery();
		
%>

<table width=100% border=1 cellpadding=1>
	<tr>
		<td align=center><b>아이디</b></td>
		<td align=center><b>암호</b></td>
		<td align=center><b>이름</b></td>
		<td align=center><b>학번</b></td>
		<td align=center><b>학과</b></td>
		<td align=center><b>휴대폰</b></td>
		<td align=center><b>이메일</b></td>
	</tr>
	
<% while(result.next()){ %>

	<tr>
		<td align=center><%=result.getString(1) %></td>
		<td align=center><%=result.getString(2) %></td>
		<td align=center><%=result.getString(3) %></td>
		<td align=center><%=result.getString(4) %></td>
		<td align=center><%=result.getString(5) %></td>
		<td align=center><%=result.getString(6) %></td>
		<td align=center><%=result.getString(7) %></td>
	</tr>
	
	
<%
		rowCount++;
	}
	result.close();
}
	
	catch(Exception e){
		out.println("Mysql : student 테이블 조회에 문제가 있습니다. <HR>");
		out.println(e.toString());
		e.printStackTrace();
	}
	finally{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}
%>

</table>


<p><hr>
<font color=blue>
<%
	if(rowCount == 0){
		out.println("조회된 결과가 없습니다.");
	}
	else{
		out.println("조회된 결과가 " + rowCount + "건 입니다.");
	}
%>
</font>





</body>
</html>