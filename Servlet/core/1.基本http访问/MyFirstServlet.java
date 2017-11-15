package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet(
		urlPatterns = { 
				"/MyFirstServlet", 
				"/FangWeb/FirstServlet"
		}, 
		initParams = { 
				@WebInitParam(name = "UserName", value = "fang", description = "用户名")
		})
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyFirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		/* 先设置请求、响应报文的编码格式  */  
	    request.setCharacterEncoding("utf-8");  
	    response.setContentType("text/html;charset=utf-8"); 
		accoutFun(request,response);
    //    response.getWriter().append("fjw->into doGet,Served !");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		response.getWriter().append("fjw->into doPost,Served !");
	}
	
	//fang add
	private void accoutFun(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//获取 请求响应 数据
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println("account:"+account+"  password:"+password);
		
		//处理业务逻辑   http://localhost:8080/DynamicWeb001/MyFirstServlet?account=fang&password=pass
		String result = "";
		if("fang".equals(account) && "pass".equals(password)){
			result = "Login Sucess! 登录成功";
		}else {
			result = "Sorry! Account or password error! 登录失败";
		}
		
		//设置 返回 响应数据
		PrintWriter pw = response.getWriter(); // 获取 response 的输出流  
        pw.println(result); // 通过输出流把业务逻辑的结果输出 
        pw.flush();
	}

}
