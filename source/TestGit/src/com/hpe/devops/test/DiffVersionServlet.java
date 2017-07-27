package com.hpe.devops.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

public class DiffVersionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call diffVersion.doGet().");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Call diffVersion.doPost().");
    	StringBuilder diffVersionInfo = new StringBuilder();
		String projectName = request.getParameter("projectName");
		String workPath = request.getParameter("workPath");
		String repositoryPath = request.getParameter("repositoryPath");
		String newVersionNo = request.getParameter("newVersionNo");
		String oldVersionNo = request.getParameter("oldVersionNo");
		
		System.out.println("projectName=" + projectName);
		System.out.println("newVersionNo=" + newVersionNo + ", oldVersionNo=" + oldVersionNo);
		System.out.println("workPath=" + workPath + ", repositoryPath=" + repositoryPath);
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			Repository repository = builder.setGitDir(new File(repositoryPath)).readEnvironment().findGitDir().build();//"C:\\Users\\Shepherd\\test\\.git";
            ObjectId newHead = repository.resolve(newVersionNo.substring(41));
            ObjectId oldHead = repository.resolve(oldVersionNo.substring(41));
			
            ObjectReader reader = repository.newObjectReader();
    		CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
    		CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
    		newTreeIter.reset(reader, newHead);
    		oldTreeIter.reset(reader, oldHead);
    		Git git = new Git(repository);
    		List<DiffEntry> diffs= git.diff().setNewTree(newTreeIter).setOldTree(oldTreeIter).call();
			for (DiffEntry entry : diffs) {
			    System.out.println("Entry: " + entry.toString() + ", NewPath=" + entry.getNewPath() + ", OldPath=" + entry.getOldPath());  
			    diffVersionInfo.append("Entry: " + entry.toString() + ", NewPath=" + entry.getNewPath() + ", OldPath=" + entry.getOldPath() + "<br>");
			}		
			request.setAttribute("projectName", projectName);
			request.setAttribute("workPath", workPath);
			request.setAttribute("repositoryPath", repositoryPath);
			request.setAttribute("newVersionNo", newVersionNo);
			request.setAttribute("oldVersionNo", oldVersionNo);
			request.setAttribute("diffFileListInfo", diffVersionInfo);
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("/viewDiffFileList.jsp").forward(request, response);
    }

    public void init() throws ServletException {
    	System.out.println("Call diffVersion.init().");
    }

}