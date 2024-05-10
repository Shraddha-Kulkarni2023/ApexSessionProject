package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	
    	super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String dbUrl = getServletContext().getInitParameter("dbUrl");
		String dbUser = getServletContext().getInitParameter("dbUser");
		String dbPassword = getServletContext().getInitParameter("dbPassword");
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			 System.out.println("Connection successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("username", username);
		session1.setAttribute("password", password);
		PrintWriter out = response.getWriter();
		List<Order> orderlist = new ArrayList<>();
		if(!username.isEmpty() && !password.isEmpty()) {
			String st4 = "select * from `Order`";
			try {
				PreparedStatement pst1 = con.prepareStatement(st4);
				ResultSet table1 = pst1.executeQuery();
				while(table1.next()) {
				Order order = new Order();
				order.setId(table1.getInt(1));
				order.setName(table1.getString(2));
				order.setdate1(table1.getString(3));
				order.setProductName(table1.getString(4));
				orderlist.add(order);
				
			} 
				System.out.print(orderlist.size());
				request.setAttribute("orderlist", orderlist);
				RequestDispatcher dispatcher3 = request.getRequestDispatcher("Views/SuccessPage.jsp");
				dispatcher3.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else {
			
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("Views/LoginPage.jsp");
			dispatcher3.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
