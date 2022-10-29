
import javax.servlet.RequestDispatcher;  
import java.io.PrintWriter;  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servle
 */
@WebServlet("/Servle")
public class Servle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("email");  
	    String p=request.getParameter("pswd");  
	          
	    if(LoginServl.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("ValServle");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
	        rd.include(request,response);  
	    }  
	}
}