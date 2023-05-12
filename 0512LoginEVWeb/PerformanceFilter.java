package com.earth.loginevweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
											//미리 초기화(early init)
//@WebServlet(urlPatterns = {"/hello", "/hello/*"}, loadOnStartup = 1)
@WebFilter(urlPatterns = "/*")
public class PerformanceFilter implements Filter {

	@Override	//초기화 작업
	public void init(FilterConfig filterConfig) throws ServletException {
													
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	FilterChain chain) throws IOException, ServletException {
		//1. 전처리 작업
		long startTime = System.currentTimeMillis();
		//2. 서블릿 또는 다음 필터를 호출
		chain.doFilter(request, response);
		//3. 후 처리 작업
		System.out.println("[" + ((HttpServletRequest)request).getRequestURI()+ "]");
		System.out.println("소요 시간 = " + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override	//정리 작업
	public void destroy() {
													
	}
	

}
