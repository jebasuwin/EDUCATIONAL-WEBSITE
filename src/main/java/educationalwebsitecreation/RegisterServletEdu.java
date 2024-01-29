package educationalwebsitecreation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class RegisterServletEdu  extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String name3 = req.getParameter("name");
		String password3 = req.getParameter("password");
		String mobilenum3 = req.getParameter("mobile");
        String insertInto = "INSERT INTO Employii (name, password) VALUES (?, ?)";

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employi","root", "Praveen@19");
//			Statement st = con.createStatement();
//			st.executeUpdate(insertInto);
			
			PreparedStatement pst = con.prepareStatement(insertInto);
            pst.setString(1, name3);
            pst.setString(2, password3);
            pst.executeUpdate();
            res.sendRedirect("Loginedu.html");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
