package com.hpe.devops.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepareDiffFilesServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call PrepareDiffFilesServlet.doGet().");
        //获取所有的用户信息
        //List<User> lstUsers = userService.getAllUser();
        //request.setAttribute("lstUsers", lstUsers);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call PrepareDiffFilesServlet.doPost().");
		String strCmd = "";//执行shell命令
		Process process = null;
		BufferedReader strCon = null;
		String line;
		
		String shellPath = request.getParameter("shellPath");
		String projectName = request.getParameter("projectName");
		String workPath = request.getParameter("workPath");
		String repositoryPath = request.getParameter("repositoryPath");
		String newVersionNo = request.getParameter("newVersionNo");
		String oldVersionNo = request.getParameter("oldVersionNo");

		//在linux下调用shell脚本并在console端输出脚本的执行结果
        strCmd = shellPath + " " + serverHostname + " " + serverPort;//待调用shell脚本  
        System.out.println("strCmd=" + strCmd);
        process = Runtime.getRuntime().exec(strCmd);//通过执行cmd命令
        strCon = new BufferedReader(new InputStreamReader(process.getInputStream()));  
        while ((line = strCon.readLine()) != null) {  
            System.out.println("Shell Output:\n" + line);  
        }
        request.getRequestDispatcher("/webdiffHttpServer.jsp").forward(request, response);
    }

    public void init() throws ServletException {
    	System.out.println("Call PrepareDiffFilesServlet.init().");
    }
}
