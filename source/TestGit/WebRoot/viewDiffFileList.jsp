<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看版本差异信息</title>
</head>
<body>
<h3>查看版本差异信息</h3>
<hr/>
<br>
<form action="prepareDiffFiles" method="post" target="_blank">
工程名称：<input type="text" name="projectName" value="<%=request.getAttribute("projectName")%>" size="100"/><br>
本地工作目录：<input type="text" name="workPath" value="<%=request.getAttribute("workPath")%>" size="100"/><br>
Shell脚本：<input type="text" name="shellPath" value="/home/hadoop/repository/prepareDiffFile.sh" size="100"/><br>
临时对比目录：<input type="text" name="tempPath" value="/home/hadoop/repository/temp/" size="100"/><br>
新版本号：<input type="text" name="newVersionNo" value="<%=request.getAttribute("newVersionNo")%>" size="100"/>(Version_TreeName)<br>
旧版本号：<input type="text" name="oldVersionNo" value="<%=request.getAttribute("oldVersionNo")%>" size="100"/>(Version_TreeName)<br><br>
<input type="submit" value="准备比对工程文件">
</form>

<hr/>

<form action="viewDiffSource.jsp" method="post" target="_blank">
工程名称：<input type="text" name="projectName" value="<%=request.getAttribute("projectName")%>" size="100"/><br>
本地工作目录：<input type="text" name="workPath" value="<%=request.getAttribute("workPath")%>" size="100"/><br>
本地仓库路径：<input type="text" name="repositoryPath" value="<%=request.getAttribute("repositoryPath")%>" size="100"/><br>
新版本号：<input type="text" name="newVersionNo" value="<%=request.getAttribute("newVersionNo")%>" size="100"/>(Version_TreeName)<br>
旧版本号：<input type="text" name="oldVersionNo" value="<%=request.getAttribute("oldVersionNo")%>" size="100"/>(Version_TreeName)<br>
比对服务器地址：<input type="text" name="webdiffURL" value="http://diff.vm1.devops:8000" size="100"/><br><br>
比对文件路径：<input type="text" name="diffFilePath" value="" size="100"/><br><br>
<input type="submit" value="查看源文件差异">
</form>
差异文件信息：
<br>
<%=request.getAttribute("diffFileListInfo")%><br>
</body>
</html>