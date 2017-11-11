<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String user=(String)session.getAttribute("user");
String username=null;
String sessionid= null;
Cookie[] cookie=request.getCookies();
if(cookie != null){
for(Cookie cookies:cookie){
if(cookies.getName().equals("user")) username=cookies.getValue();
if(cookies.getName().equals("JSESSIONID")) sessionid=cookies.getValue();
}
}
%>

<h3>Hi <%=username %>, Login successful. Your Session ID=<%=sessionid %></h3>
<br>
User=<%=user %>
<br>
<a href="CheckoutPage.jsp">Checkout Page</a>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>