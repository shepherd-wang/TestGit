<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Webdiff Http Server</title>
</head>
<body>
<h3>Webdiff Server 控制</h3>
<hr/>
<form action="webdiffHttpServer" method="post" target="_blank">
启动Shell脚本地址:<input type="text" name="shellPath" value="/home/hadoop/repository/startHttpServer.sh" size="100"/><br><br>
Webdiff Server主机名:<input type="text" name="serverHostname" value="diff.vm1.devops" size="100"/>（域名或IP地址）<br><br>
Webdiff Server端口号:<input type="text" name="serverPort" value="8000" size="100"/><br><br>
<input type="submit" value="启动">
<hr/>
</form>
<hr/>
<form action="http://diff.vm1.devops:8000/kill" method="post" target="_blank">
<input type="submit" value="停止">
<hr/>
</form>
</body>
</html>