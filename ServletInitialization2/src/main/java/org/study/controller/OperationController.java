package org.study.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.study.DAO.FilesDAO;
import org.study.entity.Files;
import org.study.entity.UserEntity;
import org.study.model.UsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name ="jdbc/project")
	private DataSource dataSource;
	public String path = "/home/dev/Downloads/uploadedimg/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page= request.getParameter("page");
		switch(page.toLowerCase()) {
		
		case "listuser":
			listUsers(request, response);
			break;
		case "adduser":
			addUserFormLoader(request, response);
			break;
		case "updateuser":
			updateUserFormLoader(request, response);
			break;
		case "deleteuser":
			deleteUser(Integer.parseInt(request.getParameter("usersid")));
			listUsers(request, response);
			break;
		case "imageupload": 
			imgUploadFormLoader(request, response);
			break;
		default:
			request.setAttribute("title", "ErrorPage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(req.getPart("form"));
		String operation = req.getParameter("form");
		if(operation==null) {
			operation= req.getParameter("page");
		}
		operation= operation.toLowerCase();		
			switch(operation) {                                                                                                                                                                                                       
			case "adduseroperation":
				UserEntity newuser = new UserEntity(req.getParameter("username"), req.getParameter("email"));
				addUserOperation(newuser);
				listUsers(req, resp);
				break;
			case "updateuseroperation":
				UserEntity updateduser =  new UserEntity(Integer.parseInt(req.getParameter("users_id")) ,req.getParameter("username"), req.getParameter("email")); 
				updateUserOperation(updateduser);
				listUsers(req, resp);
				break;
			case "imageupload":
				filesUpload(req, resp);				
				break;
			case "listingImages":
				listingImages(req, resp);
				break;
			default:
				req.setAttribute("title", "ErrorPage");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
				break;
			}
		}
			

	void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserEntity> listUsers = new ArrayList<UserEntity>();
		listUsers =  new UsersModel().listUsers(dataSource);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List User");
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}
	
	void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "List User");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}
	
	void addUserOperation(  UserEntity newuser) {
		new UsersModel().addUser( dataSource ,newuser);
		return;
	}
	
	void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Update User");
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}
	
	void imgUploadFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Image upload");
		request.getRequestDispatcher("imgUploadForm.jsp").forward(request, response);
	}
	
	void filesUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());		
		try {
			List<FileItem> images = upload.parseRequest(request);
			System.out.println(images.size());
			for(FileItem image: images) {
				System.out.println(image);
				if(image.getFieldName().equalsIgnoreCase("files")) {
					String name = image.getName();	
					try{name = name.substring(name.lastIndexOf("\\")+1);} catch(Exception e) { name = image.getName();}
					System.out.println(name);
					StringBuilder sb = new StringBuilder(new File("").getCanonicalPath()).append(File.separator).append("Downloads").append(File.separator).append("uploadedimg").append(File.separator).append(name);
					File file = new File(sb.toString());
					if(!file.exists()) {
						new FilesDAO().addFileDetails(new Files(sb.toString()));
						image.write(file);
					}					
				}					
			}
			listingImages(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void listingImages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Files> files = new FilesDAO().listFiles();
		req.setAttribute("files", files);
		req.setAttribute("path", path);
		req.getRequestDispatcher("listImage.jsp").forward(req, resp);
		
	}
	
	void updateUserOperation(UserEntity updateduser ) {
		new UsersModel().updateUser(dataSource,updateduser );
	}
	void deleteUser(int usersId) {
		new UsersModel().deleteUser(dataSource, usersId);
		return;
		
	}
	

}
