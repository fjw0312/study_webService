package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import utils.DBUtil;
import utils.DB_CURD;
import utils.DB_cmd;

/**
 * ÿ�η������ݿ�ʱ��ȡһ������
 * ���������û�ע��ҵ��
 * 
 * */
@WebServlet(
		urlPatterns = { 
				"/RegisterServlet", 
				"/FangWeb/RegisterServlet"
		}
		)
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;  
    
    /** 
     * @see HttpServlet#HttpServlet() 
     */  
    public RegisterServlet() {  
        super();  
    }  
  
    /** 
     * �������ǻ�û��˵��POST�������Ի�����GET���������հ����е���    Ŀǰ������������δ���
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    request.setCharacterEncoding("utf-8");  	   
	    response.setContentType("text/html;charset=utf-8"); 
    	
    	String account = request.getParameter("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ  
    	//String account = new String(value.getBytes("ISO-8859-1"), "gb2312");
    //	String account = new String(request.getParameter("account").getBytes("ISO8859-1"),"UTF-8");
        String password = request.getParameter("password"); // �� request �л�ȡ��Ϊ password �Ĳ�����ֵ   
        System.out.println("account:" + account + "\npassword:" + password); // ��ӡ������һ��  
  
        String resCode = "";  
        String resMsg = "";  
        String userId = "";  
          
 
        /* ����������һ����򵥵�ע���߼�����Ȼ�����ʵ��ҵ������൱����   */  
        HashMap<String, String> map = new HashMap<>(); 
        DBUtil.openConnect();
        try {
       // 	DBUtil.rs = DBUtil.statement.executeQuery(DB_cmd.selectTableLine("mytable", "userName='ţţ'"));
        	DBUtil.rs = DBUtil.statement.executeQuery(DB_cmd.selectTableLine("mytable", account+"="+password));
        	while(DBUtil.rs.next()) {
        		map.put("id", DBUtil.rs.getString("id"));
        		map.put("userName", DBUtil.rs.getString("userName"));
        		map.put("sex", DBUtil.rs.getString("sex"));
        		map.put("born", DBUtil.rs.getString("born"));
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ���ݿ� �쳣�׳���");
			e.printStackTrace();
		}
        DBUtil.closeConnect();
           
       
        response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ   
        PrintWriter pw = response.getWriter(); // ��ȡ response �������   
        pw.println(map.toString()+""); // ͨ���������ҵ���߼��Ľ�����      
        pw.flush();  
    }  
   
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
 	   // request.setCharacterEncoding("utf-8");  
	    request.setCharacterEncoding("GB2312"); 
	    response.setContentType("text/html;charset=utf-8"); 
    	doGet(request, response);  
    }  
}
