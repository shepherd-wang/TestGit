package com.hpe.devops.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author gacl
 * @WebServlet是Servlet3.0提供的注解，目的是将一个继承了HttpServlet类的普通java类标注为一个Servlet
 * CompareServlet使用了@WebServlet标注之后，就不需要在web.xml中配置了
 */
public class CompareServlet extends HttpServlet {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call CompareServlet.doGet().");
        //获取所有的用户信息
        //List<User> lstUsers = userService.getAllUser();
        //request.setAttribute("lstUsers", lstUsers);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call CompareServlet.doPost().");
        //this.doGet(request, response);
    	System.out.println("Test Call Shell!");  
		String strCmd = "pwd";//执行shell命令
		Process process = null;
		BufferedReader strCon = null;
		String line;
		
		String gitServerURL = request.getParameter("gitServerURL");
		String scriptPath = request.getParameter("scriptPath");//"/home/hadoop/repository/compare.sh"
		String repositoryPath = request.getParameter("repositoryPath");
		String newVersionNum = request.getParameter("newVersionNum");
		String oldVersionNum = request.getParameter("oldVersionNum");
//		String newVersionFileName = "";
//		String oldVersionFileName = "";
		//在linux下调用shell脚本并在console端输出脚本的执行结果
        strCmd = scriptPath + " " + repositoryPath + " " + newVersionNum + " " + oldVersionNum;//待调用shell脚本  
        System.out.println("strCmd=" + strCmd);
        process = Runtime.getRuntime().exec(strCmd);//通过执行cmd命令
//        strCon = new BufferedReader(new InputStreamReader(process.getInputStream()));  
//        while ((line = strCon.readLine()) != null) {  
//            System.out.println("Output:\n" + line);  
//        }
        
        request.getRequestDispatcher("/viewDiff.jsp").forward(request, response);
    }

    public void init() throws ServletException {
    	System.out.println("Call CompareServlet.init().");
    }
}