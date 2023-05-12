package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

/**
 * Servlet implementation class MinamotoIndex
 */
@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {		
		
		
		//ServletContext instanceの取得
		ServletContext application = this.getServletContext();
		
		// application scopeに保存されたサイト評価を取得
		SiteEV siteEV = (SiteEV)application.getAttribute("siteEV");
		
		// サイト評価の初期化（初回リクエスト実行）
		if( siteEV == null ) {
			siteEV = new SiteEV();
		}
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//サイト評価処理（初回リクエストは実行しない）
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if(action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
			
		}else if(action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		
		
		//application scope にサイト評価を保存
		application.setAttribute("siteEV", siteEV);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
