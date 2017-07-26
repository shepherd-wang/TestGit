package com.hpe.devops.test;

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
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class ViewCommittedLogServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call ViewCommittedLogServlet.doGet().");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call ViewCommittedLogServlet.doPost().");
    	StringBuilder committedLogInfo = new StringBuilder();
		String projectName = request.getParameter("projectName");
		String workPath = request.getParameter("workPath");
		String repositoryPath = request.getParameter("repositoryPath");
		String workTreeAbsolutePath = workPath;
		String directoryAbsolutePath = repositoryPath;
		try {
			
			Repository repository = new FileRepositoryBuilder().setGitDir(new File(repositoryPath + "")).build(); 
			Git git = new Git(repository);
//			Map<String, Ref> tagMap = repository.getTags();
//    		Set<String> keySet = tagMap.keySet();
//    		for (String tagKey : keySet) {
//    			if (null!=tagKey && !"".equals(tagKey)) {
//    				System.out.println("tag=" + tagKey + " : " + tagMap.get(tagKey));
//    			}
//    		}
    		
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
		    	committedLogInfo.append("Version: " + revCommit.getName() + "<br>");
		    	committedLogInfo.append("TreeName: " + revCommit.getTree().getName() + "<br>");
		    	committedLogInfo.append("Message: " + revCommit.getShortMessage() + "<br>");
		    	committedLogInfo.append("Author: " + revCommit.getAuthorIdent().getName() + "<br>");
		    	committedLogInfo.append("Time: " + revCommit.getAuthorIdent().getWhen() + "<br>");
		    	committedLogInfo.append("-----------------------------------------------------------------<br>");
		    }
			request.setAttribute("projectName", projectName);
			request.setAttribute("workTreeAbsolutePath", workTreeAbsolutePath);
			request.setAttribute("directoryAbsolutePath", directoryAbsolutePath);
			request.setAttribute("workPath", workPath);
			request.setAttribute("repositoryPath", repositoryPath);
			request.setAttribute("committedLogInfo", committedLogInfo.toString());
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("/viewProject.jsp").forward(request, response);
    }

    public void init() throws ServletException {
    	System.out.println("Call ViewCommittedLogServlet.init().");
    }

}
