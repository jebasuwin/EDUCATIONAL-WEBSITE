package educationalwebsitecreation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServletEdu extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw = res.getWriter();
		String name1 = req.getParameter("name");
		String password1 = req.getParameter("password");
		String query = "select * from Employii where name="+"'"+name1+"'";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employi","root", "Praveen@19");
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(query);
			String name2="";
			String password2="";
			while(r.next())
			{
				 name2 = r.getString(1);
				 password2 = r.getString(2);
			}
			if(name1.equals(name2) && password1.equals(password2))
			{
				res.sendRedirect("indexedu.html");
			}
			else
			{
				res.sendRedirect("LoginErrorPage.html");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}		
	}

}
