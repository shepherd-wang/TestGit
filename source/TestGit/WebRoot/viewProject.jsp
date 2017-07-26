<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看工程信息</title>
</head>
<body>
<h3>查看工程信息</h3>
<hr/>
<br>
<form action="viewCommittedLog" method="post" target="_self">
工程名称：<input type="text" name="projectName" value="<%=request.getAttribute("projectName")%>" size="100"/><br>
本地工作目录：<input type="text" name="workPath" value="<%=request.getAttribute("workTreeAbsolutePath")%>" size="100"/><br>
本地仓库路径：<input type="text" name="repositoryPath" value="<%=request.getAttribute("directoryAbsolutePath")%>" size="100"/><br>
<input type="submit" value="查看提交日志">
</form>
<hr/>
<form action="diffVersion" method="post" target="_blank">
工程名称：<input type="text" name="projectName" value="<%=request.getAttribute("projectName")%>" size="100"/><br>
本地工作目录：<input type="text" name="workPath" value="<%=request.getAttribute("workPath")%>" size="100"/><br>
本地仓库路径：<input type="text" name="repositoryPath" value="<%=request.getAttribute("repositoryPath")%>" size="100"/><br>
新版本号(TreeName)：<input type="text" name="newVersionNo" value="" size="100"/><br>
旧版本号(TreeName)：<input type="text" name="oldVersionNo" value="" size="100"/><br>
<input type="submit" value="比较版本差异">
</form>
<hr/>
版本信息：
<br>
<%=request.getAttribute("committedLogInfo")%><br>
</body>
</html>