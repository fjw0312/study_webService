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
				@WebInitParam(name = "UserName", value = "fang", description = "�û���")
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
		/* ������������Ӧ���ĵı����ʽ  */  
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
		//��ȡ ������Ӧ ����
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println("account:"+account+"  password:"+password);
		
		//����ҵ���߼�   http://localhost:8080/DynamicWeb001/MyFirstServlet?account=fang&password=pass
		String result = "";
		if("fang".equals(account) && "pass".equals(password)){
			result = "Login Sucess! ��¼�ɹ�";
		}else {
			result = "Sorry! Account or password error! ��¼ʧ��";
		}
		
		//���� ���� ��Ӧ����
		PrintWriter pw = response.getWriter(); // ��ȡ response �������  
        pw.println(result); // ͨ���������ҵ���߼��Ľ����� 
        pw.flush();
	}

}
