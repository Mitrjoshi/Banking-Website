package mumboJumboPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int balance = 100000;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps = con.prepareStatement("insert into registerDetails values (?,?,?,?,?,?,?,?)");

			String userName = request.getParameter("username");
			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			String cardNumber = request.getParameter("cardNumber");
			String cardName = request.getParameter("cardName");
			String expiryDate = request.getParameter("expiryDate");
			String pin = request.getParameter("cvv");

			ResultSet rs = ps.executeQuery("select * from registerDetails where username='" + userName + "'");

			if (rs.next()) {

				response.sendRedirect("registerFailed.html");

			} else {
				ps.setString(1, userName);
				ps.setString(2, emailId);
				ps.setString(3, password);
				ps.setString(4, cardNumber);
				ps.setString(5, cardName);
				ps.setString(6, expiryDate);
				ps.setString(7, pin);
				ps.setInt(8, balance);

				response.setContentType("text/html");

				int i = ps.executeUpdate();

				response.sendRedirect("login.html");

				HttpSession Session = request.getSession();

				Session.setAttribute("newBalance", balance);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
