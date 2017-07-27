<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件对比</title>
</head>
<body>
<h3>文件对比</h3>
webdiff服务器地址：<%=request.getParameter("gitServerURL")%>
<form action="<%=request.getParameter("gitServerURL")%>" method="post" target="viewDiffIFrame">
<input type="hidden" name="idx" id="idx" value="0" size="100"/><br><br>
path1:<input type="text" name="path1" id="path1" value="/home/hadoop/repository/test/settings.xml" size="100"/><br><br>
path2:<input type="text" name="path2" id="path2" value="/home/hadoop/repository/test/toolchains.xml" size="100"/><br><br>
<input type="submit" value="对比">
<hr/>
<center>
<h3>文件内容</h3>
<iframe width="1300px" height="600px" id="viewDiffIFrame" name="viewDiffIFrame" src="" scrolling="auto">
</iframe>
</center>
</form>
</body>
</html>