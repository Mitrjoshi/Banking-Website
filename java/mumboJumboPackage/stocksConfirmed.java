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

@WebServlet("/stocksConfirmed")
public class stocksConfirmed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public stocksConfirmed() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession Session = request.getSession();

			String profileName = (String) Session.getAttribute("username");
			String number = "0";
			String cvv = (String) Session.getAttribute("cvv");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			String userName = (String) Session.getAttribute("username");
			String inputPassword = (String) Session.getAttribute("password");
			String investmentType = "Stocks";

			int amountPaid = (Integer) Session.getAttribute("amountPaid");
			String quantity = (String) Session.getAttribute("quantityTemp");

			LocalDateTime currentDateTime = LocalDateTime.now();
			LocalDate currentDate = currentDateTime.toLocalDate();
			LocalTime currentTime = currentDateTime.toLocalTime();

			PreparedStatement ps4 = con.prepareStatement("insert into stocks values (?,?,?,?,?,?)");

			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM registerDetails WHERE username ='" + userName
					+ "' and password='" + inputPassword + "'");

			PreparedStatement ps3 = con.prepareStatement("update registerDetails set balance = ? where username = ?");

			ResultSet rs2 = ps2.executeQuery();

			java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
			java.sql.Time sqlTime = java.sql.Time.valueOf(currentTime);

			if (rs2.next()) {
				String balance = rs2.getString(8);
				int newBalance = Integer.parseInt(balance) - amountPaid;

				ps4.setString(1, userName);
				ps4.setString(2, quantity);
				ps4.setInt(3, amountPaid);
				ps4.setDate(4, sqlDate);
				ps4.setTime(5, sqlTime);
				ps4.setString(6, investmentType);

				ps3.setInt(1, newBalance);
				ps3.setString(2, userName);

				Session.setAttribute("amountPaid", amountPaid);
				Session.setAttribute("newBalance", newBalance);

				int j = ps4.executeUpdate();
				int i = ps3.executeUpdate();

				PreparedStatement ps5 = con.prepareStatement("insert into payment values (?,?,?,?,?,?)");

				ps5.setString(1, number);
				ps5.setString(2, "-" + amountPaid);
				ps5.setString(3, cvv);
				ps5.setDate(4, sqlDate);
				ps5.setTime(5, sqlTime);
				ps5.setString(6, profileName);

				PreparedStatement ps = con.prepareStatement("select sum(amountPaid) from stocks where username=?");

				ps.setString(1, profileName);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					String invested = rs.getString(1);
					Session.setAttribute("invested", invested);
					int k = ps5.executeUpdate();
					response.sendRedirect("paymentsuccessfull.html");
				} else {
					response.sendRedirect("paymentUnsuccessful.html");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
