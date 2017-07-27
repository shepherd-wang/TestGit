package com.hpe.devops.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class CloneProjectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call CloneProjectServlet.doGet().");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call CloneProjectServlet.doPost().");
    	StringBuilder commitVersionInfo = new StringBuilder();
		String projectURL = request.getParameter("projectURL");//https://github.com/shepherd-wang/test.git或git@github.com:shepherd-wang/test.git
		String localPath = request.getParameter("localPath");//"/home/hadoop/repository"
		System.out.println("projectURL=" + projectURL + ", localPath=" + localPath);
		String projectName = projectURL.substring(projectURL.lastIndexOf("/") + 1).replaceAll(".git", "");
		System.out.println("projectName=" + projectName);
		try {
			Git git = Git.cloneRepository().setURI(projectURL).setDirectory(new File(localPath + "/" + projectName)).call();//Clone Project
			
			Repository repository = git.getRepository();
			String workTreeAbsolutePath = repository.getWorkTree().getAbsolutePath();
			String directoryAbsolutePath = repository.getDirectory().getAbsolutePath();
			/*
//			Map<String, Ref> tagMap = repository.getTags();
//    		Set<String> keySet = tagMap.keySet();
//    		for (String tagKey : keySet) {
//    			if (null!=tagKey && !"".equals(tagKey)) {
//    				System.out.println("tag=" + tagKey + " : " + tagMap.get(tagKey));
//    			}
//    		}
//    		
			//repository.getBranch();
			//repository.getFullBranch();
    		
			//Iterator<RevCommit> revCommitIterator = git.log().setMaxCount(5).call().iterator();//只返回5条最新提交的版本日志//可以用于翻页显示
			//Iterator<RevCommit> revCommitIterator = git.log().setSkip(3).call().iterator();//跳过最新提交的N条版本日志//可以用于翻页显示
			Iterator<RevCommit> revCommitIterator = git.log().call().iterator();//返回所有提交的版本日志
		    while (revCommitIterator.hasNext()) {
		    	RevCommit revCommit = revCommitIterator.next();
		    	System.out.println("Log:" + revCommit.toString());
		    	//System.out.println("ObjectId:" + revCommit.getId());
		    	System.out.println("Tree:" + revCommit.getTree().toString());
		    	//System.out.println("TreeName:" + revCommit.getTree().getName());
		    	//System.out.println("AnyObjectId:" + revCommit.name());//AnyObjectId
		    	//System.out.println("Name:" + revCommit.getName());
		    	System.out.println("ShortMessage:" + revCommit.getShortMessage());
		    	//System.out.println("FullMessage:" + revCommit.getFullMessage());	    	
		    	//System.out.println("CommitTime:" + revCommit.getCommitTime()); 	   
		    	System.out.println("AuthorIdent:"+ revCommit.getAuthorIdent().getName());
		    	//System.out.println("EmailAddress:"+ revCommit.getAuthorIdent().getEmailAddress());
		    	System.out.println("When:"+ revCommit.getAuthorIdent().getWhen());
		    	System.out.println("-----------------------------------------------------------------");
		    	commitVersionInfo.append("Version: " + revCommit.getName() + "<br>");
		    	commitVersionInfo.append("TreeName: " + revCommit.getTree().getName() + "<br>");
		    	commitVersionInfo.append("Message: " + revCommit.getShortMessage() + "<br>");
		    	commitVersionInfo.append("Author: " + revCommit.getAuthorIdent().getName() + "<br>");
		    	commitVersionInfo.append("Time: " + revCommit.getAuthorIdent().getWhen() + "<br>");
		    	commitVersionInfo.append("-----------------------------------------------------------------<br>");
		    }*/
			System.out.println("directoryAbsolutePath=" + directoryAbsolutePath + ", workTreeAbsolutePath" + workTreeAbsolutePath);
			request.setAttribute("projectName", projectName);
			request.setAttribute("workTreeAbsolutePath", workTreeAbsolutePath);
			request.setAttribute("directoryAbsolutePath", directoryAbsolutePath);
			request.setAttribute("commitVersionInfo", commitVersionInfo.toString());
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("/viewProject.jsp").forward(request, response);
    }

    public void init() throws ServletException {
    	System.out.println("Call CloneProjectServlet.init().");
    }

}
