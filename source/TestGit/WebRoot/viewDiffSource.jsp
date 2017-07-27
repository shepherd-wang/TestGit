<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件对比</title>
</head>
<body>
<h3>文件对比</h3>
<hr/>
webdiff服务器地址：<%=request.getParameter("webdiffURL")%>
<form action="<%=request.getParameter("webdiffURL")%>" method="post" target="viewDiffIFrame">
<input type="hidden" name="idx" id="idx" value="0" size="100"/><br><br>
新版本文件路径:<input type="text" name="path1" id="path1" value="/home/hadoop/repository/temp/<%=request.getParameter("projectName")%>_<%=request.getParameter("newVersionNo").toString().substring(0, 40)%>/<%=request.getParameter("diffFilePath")%>" size="100"/><br><br>
旧版本文件路径:<input type="text" name="path2" id="path2" value="/home/hadoop/repository/temp/<%=request.getParameter("projectName")%>_<%=request.getParameter("oldVersionNo").toString().substring(0, 40)%>/<%=request.getParameter("diffFilePath")%>" size="100"/><br><br>
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