<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <form action="/social/response" method="post">
  Name : <input type="text" name="uname" /> <br>
  Email : <input type="text" name="email" /> <br>
  Password : <input type="password" name="password" /> <br>
  <input type="submit" value="Register">
  
  </form>
</body>
</html>
