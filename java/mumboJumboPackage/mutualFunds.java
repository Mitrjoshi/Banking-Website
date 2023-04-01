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

@WebServlet("/mutualFunds")
public class mutualFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public mutualFunds() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbojumbo", "root", "");

			HttpSession Session = request.getSession();

			String userName = (String) Session.getAttribute("username");
			String inputPassword = (String) Session.getAttribute("password");

			String amount = request.getParameter("amount");
			String months = request.getParameter("months");
			String cvv = request.getParameter("cvv");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM registerDetails WHERE username ='" + userName
					+ "' and password='" + inputPassword + "'");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int amountPaid = Integer.parseInt(amount) * Integer.parseInt(months);

				Session.setAttribute("cvvTemp", cvv);
				Session.setAttribute("quantityTemp", amount);
				Session.setAttribute("amountPaid", amountPaid);

				String balance = rs.getString(8);
				String ogCvv = rs.getString(7);

				if (Integer.parseInt(balance) > amountPaid) {

					if (Integer.parseInt(amount) > 0) {

						if (cvv.equals(ogCvv)) {

							response.sendRedirect("mutualFundsConfirmed.jsp");
						} else {
							response.sendRedirect("paymentUnsuccessful.html");
						}
					} else {
						response.sendRedirect("paymentUnsuccessful.html");
					}
				} else {
					response.sendRedirect("paymentUnsuccessful.html");
				}
			} else {
				response.sendRedirect("loginFailed.html");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
