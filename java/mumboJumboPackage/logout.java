package mumboJumboPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public logout() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession Session = request.getSession();
		// Get all current sessions
		Enumeration<String> sessionIds = request.getSession().getAttributeNames();

		// Invalidate each session
		while (sessionIds.hasMoreElements()) {
			String sessionId = sessionIds.nextElement();
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				response.sendRedirect("login.html");
			}
		}

	}

}
