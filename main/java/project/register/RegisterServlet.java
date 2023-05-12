package project.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerPage
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    req.setCharacterEncoding("utf-8");				//reqデータを読み取る文字コードを指定
    res.setContentType("text/html;charset=utf-8");  //出力指定
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>確認画面</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h2>入力情報を確認して登録ボタンを押してください</h2>");
    out.println("氏名：<strong>" + req.getParameter("name") + "</strong><br/>");
    out.println("パスワード：<strong>" + req.getParameter("pass") + "</strong><br/>");
    String age = req.getParameter("age");
    if(age.equals("child")){
      age = "18歳未満";
    } else {
      age = "18歳以上";
    }
    out.println("年齢：<strong>" + age + "</strong><br/>");
    String[] langs = req.getParameterValues("lang");
    out.println("開発経験：<strong>");
    for(int i = 0; i < langs.length; i++){
      out.println(langs[i] + " ");
    }
    out.println("</strong><br/>");    
    out.println("住所：<strong>" + req.getParameter("address") + "</strong><br/>");
    out.println("ご意見・お問い合わせ：<br/><strong>" + req.getParameter("msg") + "</strong><br/><br/>");
    out.println("<input type=\"submit\" value=\"登録\" />");
    out.println("<input type=\"reset\" value=\"戻る\" /><br/><br/>");
    out.println("（この画面はサーブレットで出力しています）");
    out.println("</body>");
    out.println("</html>");
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    doPost(req, res);
  }
}
