package com.earth.jaehyunki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/super-simple")
public class SuperSimpleServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[SuperSimpleServlet] service() 호출");

		// 웹 브라우저에서 전송된 데이터와 인코딩 실행
		req.setCharacterEncoding("utf-8");
		// 응답할 데이터 종류가 html인 설정
		resp.setContentType("text/html;charset=utf-8");

		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String servname = getServletName();

		req.setAttribute("name", name);
		req.setAttribute("servname", servname);

		RequestDispatcher get = req.getRequestDispatcher("WEB-INF/views/helloearth.jsp");

		get.forward(req, resp);
	}

}
