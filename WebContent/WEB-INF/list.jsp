<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.javaex.Vo.guestbookVo" %>   
 <%@ page import="com.javaex.Dao.guestbookDao" %> 
 <%@ page import="java.util.List" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cl?aname=add" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
<% 

guestbookDao dao = new guestbookDao();
List<guestbookVo> gList = (List<guestbookVo>)request.getAttribute("list");

   for(guestbookVo gVo : gList) {%>
	
			<table width=510 border=1>
				<tr>
					<td><%= gVo.getNo() %></td>
					<td><%= gVo.getName() %></td>
					<td><%= gVo.getRegdate()%></td>
					<td><a href="cl?aname=deleteform&no=<%=gVo.getNo()%>">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4><%=gVo.getContent() %></td>
				</tr>
			</table>
		    <br/>
<% } %>	
</body>
</html>