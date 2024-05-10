package controllers;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class RegistrationAssignmentServlet
 */
public class RegistrationAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Email = request.getParameter("email");
		String designation = request.getParameter("designation");
		
		String st2 = "SELECT FirstName, LastName FROM RegistrationAssignmentTable WHERE TRIM(FirstName) = ? AND TRIM(LastName) = ?";
		
		
		
		try {
			PreparedStatement ps2 = con.prepareStatement(st2);
			ps2.setString(1, FirstName.trim());
			ps2.setString(2, LastName.trim());
			PrintWriter out = response.getWriter();	
			System.out.print(st2);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()) {
				
				String fname = rs2.getString(1).trim();
				String lname = rs2.getString(2).trim();
				System.out.print("First If");
				request.setAttribute("error","Record already Exists");
				if(fname.equals(FirstName.trim()) && lname.equals(LastName.trim())) {
					System.out.print("In if");
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("Views/Error.jsp");
					dispatcher1.forward(request, response);
					
					
					
				}
		   }
			else {
				System.out.print("In else");
				String st = "insert into RegistrationAssignmentTable (FirstName, LastName,Email,Designation) values (?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(st);
				ps1.setString(1, FirstName);
				ps1.setString(2,  LastName);
				ps1.setString(3,  Email);
				ps1.setString(4,  designation);
				
				int rowinserted = ps1.executeUpdate();
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("Views/Success.jsp");
				dispatcher1.forward(request, response);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
