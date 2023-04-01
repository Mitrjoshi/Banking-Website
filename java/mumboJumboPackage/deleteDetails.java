package mumboJumboPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteDetails")
public class deleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteDetails() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession Session = request.getSession();
			String userName = (String) Session.getAttribute("username");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM registerDetails WHERE username ='" + userName + "'");

			PreparedStatement ps2 = con
					.prepareStatement("delete from registerDetails where username='" + userName + "'");
			PreparedStatement ps3 = con.prepareStatement("delete from payment where username='" + userName + "'");
			PreparedStatement ps4 = con.prepareStatement("delete from stocks where username='" + userName + "'");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int i = ps2.executeUpdate();
				int j = ps3.executeUpdate();
				int k = ps4.executeUpdate();
				
				response.sendRedirect("accountDeleted.html");
			}

		} catch (Exception e) {

		}

	}

}
