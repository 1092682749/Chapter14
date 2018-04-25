<%--
  Created by IntelliJ IDEA.
  User: qingyun
  Date: 18/4/7
  Time: 下午3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Json
</body>
</html>
<script src="https://code.jquery.com/jquery-3.2.0.js"></script>
<!--
此处插入JavaScript脚本
-->
<script type="text/javascript">
    /** 传递JSON**/

	$(document).ready(function() {
		//JSON参数和类RoleParams一一对应
		var data = {
			//角色查询参数
			roleName : 'role',
			note : 'note',
			//分页参数
			pageParams : {
				start : 0,
				limit : 20
			}
		}
		console.log("进来了");
		//Jquery的post请求
		$.post({
			url : "./params/findRole.do",
			//此处需要告知传递参数类型为JSON，不能缺少
			contentType : "application/json",
			//将JSON转化为字符串传递
			data : JSON.stringify(data),
			//成功后的方法
			success : function(result) {
			}
		});
	});
</script>
