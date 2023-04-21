package kr.earth.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThrowingTwoDiceServelet
 */
@WebServlet("/twodiceservelet")
public class ThrowingTwoDiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[HelloServlet] service() 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("[HelloServlet] destroy() 호출");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[HelloServlet] service() 호출");

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;

		int a = (int) (Math.random() * 6) + 1;
		int b = (int) (Math.random() * 6) + 1;

		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<img src='img/dice" + a + ".jpg' />");
			out.println("<img src='img/dice" + b + ".jpg' />");
			out.println("</body>");
			out.println("</html>");

		} catch (IOException e) {e.printStackTrace();}

	}

}
