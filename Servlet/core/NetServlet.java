package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetServlet
 */
@WebServlet(
		description = "����������Ӧ����", 
		urlPatterns = { 
				"/NetServlet", 
				"/Fang/TestNet"
		})
public class NetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NetServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * //����ҵ���߼�   http://localhost:8080/Fang/TestNet?M=1  //M = 1.2.3.4.5
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("utf-8");  
	    response.setContentType("text/html;charset=utf-8"); 
	    
		  //��ȡ ������Ӧ ����
		  int size = 5; //Ĭ�� 5
		  String m = request.getParameter("M");
		  if(m!=null && "".equals(m)==false){
			  size = Integer.parseInt(m); 
			  if(size>100) size = 100;  //���100
		  }
	  
	    
	    //�����ֽ���  ������
	    byte[] buf = new byte[1024*1024*size];
	    ServletOutputStream out = response.getOutputStream();
	    out.write(buf);
	    out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("utf-8");  
	    response.setContentType("text/html;charset=utf-8"); 
	    
	    //��ȡ����
	    byte[] buf = new byte[5*1024*1024];
	    ServletInputStream in = request.getInputStream();
	    int ret = 0;
	    while((ret=in.read(buf, 0, 1))>0);
	    while((ret=in.read(buf, 0, buf.length))>0);
	    //request.getInputStream();
	    
	    
	}

}
