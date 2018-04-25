<%--
  Created by IntelliJ IDEA.
  User: qingyun
  Date: 18/4/7
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
Long id = (Long)session.getAttribute("id");
Long di = (Long)session.getAttribute("di");
%>
<%=di+id%>清清浅浅
</body>
</html>
