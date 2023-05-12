package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// User instance の生成
		User user = new User(name, pass);
		
		// login処理
		LoginLogic loginLogic= new LoginLogic();
		boolean isLogin = loginLogic.excute(user);
		
		//login成功時の処理
		if(isLogin) {
			
			// user inflormation を session scope に保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);		
			
		}
		
		//login結果画面にforward
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
		
	}
     
	 
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	

}
