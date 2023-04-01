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

/**
 * Servlet implementation class edit
 */
@WebServlet("/editDetails")
public class editDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editDetails() {
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
			String password = request.getParameter("password");
			String cardNumber = request.getParameter("cardNumber");
			String cardName = request.getParameter("cardName");
			String expiryDate = request.getParameter("expiryDate");
			String cvv = request.getParameter("cvv");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps2 = con
					.prepareStatement("select * from registerDetails where username = '" + userName + "'");

			String query = "update registerDetails set password = ?, cardNumber = ?, cardName = ?, expiryDate = ?, cvv = ? where username = ?";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				ps.setString(1, password);
				ps.setString(2, cardNumber);
				ps.setString(3, cardName);
				ps.setString(4, expiryDate);
				ps.setString(5, cvv);
				ps.setString(6, userName);

				int i = ps.executeUpdate();

				response.sendRedirect("profile.jsp");

				Session.setAttribute("password", password);

				Session.setAttribute("cardNumber", cardNumber);

				Session.setAttribute("cardHolder", cardName);

				Session.setAttribute("expirydate", expiryDate);

				Session.setAttribute("cvv", cvv);
			} else {
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
