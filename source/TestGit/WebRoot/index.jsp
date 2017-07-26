<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
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

<h3>Clone工程</h3>
<hr/>
<form action="cloneProject" method="post" target="_blank">
远程仓库地址:<input type="text" name="projectURL" value="https://github.com/shepherd-wang/test.git" size="100"/>(Git：https/ssh，*.git)<br><br>
本地工作路径:<input type="text" name="localPath" value="/home/hadoop/repository/temp" size="100"/><br><br>
<input type="submit" value="Clone Project">
<hr/>
</form>
<br><br>

<h3>文件对比</h3>
对比服务地址：http://diff.vm1.devops:8000/
<form action="http://diff.vm1.devops:8000" method="post" target="viewDiffIFrame">
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