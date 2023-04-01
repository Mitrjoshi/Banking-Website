package mumboJumboPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deposit() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String amount = request.getParameter("amount");
			String cvv = request.getParameter("cvv");

			LocalDateTime currentDateTime = LocalDateTime.now();

			LocalDate currentDate = currentDateTime.toLocalDate();

			LocalTime currentTime = currentDateTime.toLocalTime();

			Class.forName("com.mysql.cj.jdbc.Driver");

			HttpSession Session = request.getSession();

			String username = (String) Session.getAttribute("username");

			String cardNumber = (String) Session.getAttribute("cardNumber");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			PreparedStatement ps = con.prepareStatement("insert into payment values (?,?,?,?,?,?)");

			PreparedStatement ps2 = con.prepareStatement("update registerDetails set balance = ? where username = ?");

			PreparedStatement ps3 = con
					.prepareStatement("select * from registerDetails where username = '" + username + "'");

			ResultSet rs = ps3.executeQuery();

			java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
			java.sql.Time sqlTime = java.sql.Time.valueOf(currentTime);

			ps.setString(1, cardNumber);
			ps.setString(2, amount);
			ps.setString(3, cvv);
			ps.setDate(4, sqlDate);
			ps.setTime(5, sqlTime);
			ps.setString(6, username);

			if (rs.next()) {

				String balance = rs.getString(8);
				String ogCvv = rs.getString(7);

				if (cvv.equals(ogCvv)) {
					int newBalance = Integer.parseInt(balance) + Integer.parseInt(amount);

					ps2.setInt(1, newBalance);
					ps2.setString(2, username);
					int i = ps.executeUpdate();

					int j = ps2.executeUpdate();

					response.sendRedirect("depositesuccessfull.html");

					Session.setAttribute("newBalance", newBalance);
				} else {
					response.sendRedirect("paymentUnsuccessful.html");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
