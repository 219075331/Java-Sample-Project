package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//つぶやきListをapplication scopeから取得
		
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = 
				(List<Mutter>)application.getAttribute("mutterList");
		
		
		// 取得できなかった場合は、つぶやきリストを新規作成して
	    // アプリケーションスコープに保存
		if( mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		
		
		// ログインしているか確認するため
	    // セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/sampleApplication/");
		}else { // ログイン済みの場合
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//request parameterを取得　
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力値をチェック
		if(text != null & text.length() !=0){
			
			//application scope に保存されたつぶやきlistを取得
			
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = 
					(List<Mutter>)application.getAttribute("mutterList");
			
		
			//Session scope に保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//つぶやきlistに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.excute(mutter, mutterList);
			
			//application scope につぶやきlistを保存
			application.setAttribute("mutterList", mutterList);					
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
