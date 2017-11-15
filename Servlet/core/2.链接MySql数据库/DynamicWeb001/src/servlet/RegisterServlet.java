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
 * 每次访问数据库时获取一个连接
 * 用来处理用户注册业务
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
     * 由于我们还没有说到POST请求，所以还是用GET来处理，汗颜啊，有点慢    目前中文请求乱码未解决
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    request.setCharacterEncoding("utf-8");  	   
	    response.setContentType("text/html;charset=utf-8"); 
    	
    	String account = request.getParameter("account"); // 从 request 中获取名为 account 的参数的值  
    	//String account = new String(value.getBytes("ISO-8859-1"), "gb2312");
    //	String account = new String(request.getParameter("account").getBytes("ISO8859-1"),"UTF-8");
        String password = request.getParameter("password"); // 从 request 中获取名为 password 的参数的值   
        System.out.println("account:" + account + "\npassword:" + password); // 打印出来看一看  
  
        String resCode = "";  
        String resMsg = "";  
        String userId = "";  
          
 
        /* 这里我们做一个最简单的注册逻辑，当然，你的实际业务可以相当复杂   */  
        HashMap<String, String> map = new HashMap<>(); 
        DBUtil.openConnect();
        try {
       // 	DBUtil.rs = DBUtil.statement.executeQuery(DB_cmd.selectTableLine("mytable", "userName='牛牛'"));
        	DBUtil.rs = DBUtil.statement.executeQuery(DB_cmd.selectTableLine("mytable", account+"="+password));
        	while(DBUtil.rs.next()) {
        		map.put("id", DBUtil.rs.getString("id"));
        		map.put("userName", DBUtil.rs.getString("userName"));
        		map.put("sex", DBUtil.rs.getString("sex"));
        		map.put("born", DBUtil.rs.getString("born"));
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询数据库 异常抛出！");
			e.printStackTrace();
		}
        DBUtil.closeConnect();
           
       
        response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式   
        PrintWriter pw = response.getWriter(); // 获取 response 的输出流   
        pw.println(map.toString()+""); // 通过输出流把业务逻辑的结果输出      
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
