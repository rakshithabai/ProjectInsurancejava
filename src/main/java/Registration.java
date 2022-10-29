
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("t1");
		String a=request.getParameter("t2");
		String ad=request.getParameter("t3");
		String ph=request.getParameter("t4");
		String e=request.getParameter("t5");
		String pa=request.getParameter("t6");
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement ps=con.prepareStatement("insert into insurance values(?,?,?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,a);
		ps.setString(3,ad);
		ps.setString(4,ph);
		ps.setString(5,e);
		ps.setString(6,pa);
		
		int i=ps.executeUpdate();
		if(i>0)
		out.print("You are successfully registered...");
		response.sendRedirect("Login.html"); 
		
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
