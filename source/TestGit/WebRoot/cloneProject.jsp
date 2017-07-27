<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clone Project</title>
</head>
<body>
<h3>Clone工程</h3>
<hr/>
<form action="cloneProject" method="post" target="_blank">
远程仓库地址:<input type="text" name="projectURL" value="https://github.com/shepherd-wang/test.git" size="100"/>(Git：https/ssh，*.git)<br><br>
本地工作路径:<input type="text" name="localPath" value="/home/hadoop/repository/temp" size="100"/><br><br>
<input type="submit" value="Clone Project">
<hr/>
</form>
<br><br>
</body>
</html>