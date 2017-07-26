<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看比较结果</title>
</head>
<body>
查看比较结果<br><br>
<hr>

<a href="http://diff.vm1.devops:8000" >查看</a><br><br>
<a href="<%=request.getParameter("gitServerURL")%>" >查看</a><br><br>
</body>
</html>