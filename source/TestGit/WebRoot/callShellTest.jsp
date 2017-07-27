<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调用Shell脚本测试</title>
</head>
<body>
<h3>调用Shell脚本测试</h3>
<hr/>
<form action="compare" method="post" target="_blank">
Git服务器地址:<input type="text" name="gitServerURL" value="http://diff.vm1.devops:8000" size="100"/><br><br>
脚本路径:<input type="text" name="scriptPath" value="/home/hadoop/repository/compare.sh" size="100"/><br><br>
版本库路径:<input type="text" name="repositoryPath" value="/home/hadoop/repository/test" size="100"/><br><br>
新版本号:<input type="text" name="newVersionNum" value="HEAD" size="100"/><br><br>
旧版本号:<input type="text" name="oldVersionNum" value="HEAD^^^^" size="100"/><br><br>
<input type="submit" value="对比">
<hr/>
</form>
<br><br>




</body>
</html>