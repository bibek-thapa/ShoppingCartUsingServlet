package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.service.ItemService;
import com.example.service.LoginService;
import com.example.service.ResultService;

public class LoginController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private ItemService itemService;
	private ResultService resultService;
	HttpSession session;
	
	
	@Override
	public void init() throws ServletException {
		
		loginService = new LoginService();
		itemService = new ItemService();
		resultService = new ResultService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String page = request.getParameter("page");
		String action = request.getParameter("action");
		
	
		
		String nextPage = "/login.jsp";
		if(page != null) 
		{
			if(page.equalsIgnoreCase("login")) 
			{
				if(action.equalsIgnoreCase("login")) {
					String userName = request.getParameter("username");
					String password = request.getParameter("password");
					Boolean isValidUser = loginService.authenticate(userName, password);
					if(isValidUser) 
					{
						request.setAttribute("loginSuccess", "Succesfully logged in");
						session = request.getSession(true);
						session.setAttribute("userName", userName);
						session.setAttribute("password", password);
						
						nextPage = "/items.jsp";
						request.setAttribute("items",itemService.getAllItems());
					}
					else 
					{
						request.setAttribute("loginError", "Invalid Username and password");
						nextPage = "/login.jsp";
						
					}
				
			}}
			else if(page.equalsIgnoreCase("items")) 
			{
				
				
				 if(action.equalsIgnoreCase("Proceed to Checkout"))
				{
					 nextPage = "/summary.jsp";
					
				}
				 else if(action.equalsIgnoreCase("Add to Cart")) 
					 
				 {
					 	
					 	String[] names = request.getParameterValues("checkedBox");
						String[] quantity = request.getParameterValues("quantity");
					
						if(names!=null && quantity!=null) {
							
							session.setAttribute("checkedItemsSession", resultService.calculate(names));
							session.setAttribute("checkedQuantitySession", quantity);
							
							
							request.setAttribute("items", itemService.getAllItems());		
							request.setAttribute("addCartSuccess", "Succesfully added to the cart");
							nextPage = "/items.jsp";
						}
						else 
						{
							request.setAttribute("items", itemService.getAllItems());
							request.setAttribute("cartEmpty", "Add the elements in the cart");
							nextPage = "/items.jsp";
						}
					 
				 }
				 else if(action.equalsIgnoreCase("Logout")) 
				 {
					 session.invalidate();
					 nextPage = "/login.jsp";
				 }
				 else if(action.equalsIgnoreCase("help")) 
				 {
					 nextPage = "/help.jsp";
				 }
				
			}
			
			else if(page.equalsIgnoreCase("summary")) 
			{
				if(action.equalsIgnoreCase("Checkout")) 
				{
					nextPage = "/logout.jsp";
				}
				else if(action.equalsIgnoreCase("Back to Cart")) 
				{
					nextPage = "/items.jsp";
					request.setAttribute("items",itemService.getAllItems());
					
				}
				
				 else if(action.equalsIgnoreCase("Logout")) 
				 {
					 session.invalidate();
					 nextPage = "/login.jsp";
				 }
				 else if(action.equalsIgnoreCase("help")) 
				 {
					 nextPage = "/help.jsp";
				 }
				
				
				
			}
			
			else if(page.equalsIgnoreCase("logout")) 
			{
				  if(action.equalsIgnoreCase("Logout")) 
				 {
					  session.invalidate();
					 nextPage = "/login.jsp";
				 }
				 else if(action.equalsIgnoreCase("help")) 
				 {
					 nextPage = "/help.jsp";
				 }
				
				
			}
			
		
		
		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	

	
	
	
	
	}}
