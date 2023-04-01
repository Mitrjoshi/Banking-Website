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

@WebServlet("/forgotPassword")
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public forgotPassword() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String userName = request.getParameter("username");
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM registerDetails WHERE username ='" + userName + "'");

			PreparedStatement ps2 = con.prepareStatement("update registerDetails set password = ? where username = ?");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String ogPass = rs.getString(3);

				if (!newPassword.equals(ogPass)) {

					if (newPassword.equals(confirmPassword)) {

						ps2.setString(1, confirmPassword);
						ps2.setString(2, userName);

						int i = ps2.executeUpdate();

						response.sendRedirect("login.html");
					} else {
						response.sendRedirect("loginFailed.html");
					}
				} else {
					response.sendRedirect("loginFailed.html");
				}

			} else {
				response.sendRedirect("loginFailed.html");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
