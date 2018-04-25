<%--
  Created by IntelliJ IDEA.
  User: qingyun
  Date: 18/4/7
  Time: 下午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("id",1L);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/attribute/sessionAttribute.do?id=1");
    dispatcher.forward(request,response);
%>
</body>
</html>
