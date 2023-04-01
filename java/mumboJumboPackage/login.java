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

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM registerDetails WHERE username ='" + userName + "' and password='" + inputPassword + "'");

			PreparedStatement ps2 = con.prepareStatement("select sum(amountPaid) from stocks where username=?");
			
			ResultSet rs = ps.executeQuery();
			
			

			HttpSession Session = request.getSession();

			if (rs.next()) {

				String username = rs.getString(1);
				Session.setAttribute("username", username);

				String emailId = rs.getString(2);
				Session.setAttribute("emailId", emailId);
				
				String password = rs.getString(3);
				Session.setAttribute("password", password);

				String cardnumber = rs.getString(4);
				Session.setAttribute("cardNumber", cardnumber);

				String cardHolder = rs.getString(5);
				Session.setAttribute("cardHolder", cardHolder);

				String expirydate = rs.getString(6);
				Session.setAttribute("expirydate", expirydate);
				
				String cvv = rs.getString(7);
				Session.setAttribute("cvv", cvv);
				
				int balance = rs.getInt(8);
				Session.setAttribute("newBalance", balance);
				
				ps2.setString(1, username);
				ResultSet rs2 = ps2.executeQuery();
				
				if (rs2.next()) {
					String invested = rs2.getString(1);
					Session.setAttribute("invested", invested);
				}
				
				response.sendRedirect("profile.jsp");

			} else {
				response.sendRedirect("loginFailed.html");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
