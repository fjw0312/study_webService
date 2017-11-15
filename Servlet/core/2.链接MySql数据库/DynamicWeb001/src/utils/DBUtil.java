package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	//table
		public static final String TABLE_PASSWORD = "table_user_password";  
	    public static final String TABLE_USERINFO = "table_user_info";
		
		
	    public static final String sqlDriver = "com.mysql.jdbc.Driver";
	    public static String strSql = "jdbc:mysql://localhost:3306/myweb_db001";   // ���ݿ��Url  
	    public static String userName = "fang";
	    public static String password = "root";
	    
	    //��������
	    public static Connection conn = null;
	    public static Statement statement = null;
	    //public static PreparedStatement ps = null;
	    public static ResultSet rs = null;
	  
	    // connect to MySql database  
	    public static Statement openConnect() {  
	        try {  
	            Class.forName(sqlDriver); // java���䣬�̶�д��  
	            conn = (Connection) DriverManager.getConnection(strSql, userName, password);  
	            statement = conn.createStatement();
	        } catch (ClassNotFoundException e) {
	        	System.out.println("�������ݿ�����ʧ�ܣ�");
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	        	System.out.println("�������ݿ�ʧ�ܣ�");
	            System.out.println("SQLException: " + e.getMessage());  
	            System.out.println("SQLState: " + e.getSQLState());  
	            System.out.println("VendorError: " + e.getErrorCode());  
	        }  
	        return statement;  
	    }
	    // disconnect to mySql database
	    public static void closeConnect() {
	    	if(rs != null ){              
	            try {
	               rs.close();
	            } catch (SQLException e) {
	              // TODO Auto-generated catch block
	               e.printStackTrace();
	            }              
	        }          
	        if(statement != null){              
	            try {
	              statement.close();
	            } catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	            }
	        }
	        if(conn != null){
		         try {
		        	 conn.close();
		        	 System.out.println("Database connection terminated!");
		         }catch (SQLException e) {
		         	e.printStackTrace();
		         }
	         }
	    }
	    
	    //CRUD �������ݿ�    ---���ݿ� Ƶ�����ò�����ʹ��  (ֱ��ʹ��statement.execute(sqlcmd))
	    public void executeDB(String sqlcmd) {
	    	 openConnect();
	         try {
	             statement.execute(sqlcmd);
	         } catch (SQLException e) {
	             // TODO Auto-generated catch block
	        	 System.out.println("���ݿ����ʧ�� �쳣��");
	             e.printStackTrace();
	         }finally {
	        	 closeConnect();
	         }   
	    }
	    //CRUD �������ݿ� ---���ݿ� Ƶ�����ò�����ʹ��  (ֱ��ʹ��statement.executeQuery(sqlcmd))
	    public ResultSet executeQueryDB(String sqlcmd) {
	    	openConnect();
	         try {
	        	 rs = statement.executeQuery(sqlcmd);
	         } catch (SQLException e) {
	             // TODO Auto-generated catch block
	        	 System.out.println("���ݿ����ʧ�� �쳣��");
	             e.printStackTrace();
	             rs = null;
	         }finally {
	        	 closeConnect();
	         } 
	         return rs;
	    }
	    
	    
//------------------------------�ⲿAPi ���ò���-------------------------------------//
	 public static void testCreateTable() {   
		 openConnect();
		 try {
		//	statement.execute(DB_cmd.createTable("table001"));  //test ok
		//	statement.execute(DB_cmd.createTable2("table002"));   //test ok
		//	statement.execute(DB_cmd.dropTable("table001"));    //test ok
		//	statement.execute(DB_cmd.dropTable2("table002"));    //test ok
		//	statement.execute(DB_cmd.insertTable("mytable", "null,'ţţ','��','2017-10-25'"));  //test ok
		//	statement.execute(DB_cmd.updateTable("mytable", "userName='����'", "id='4'"));  //test ok
		//	statement.execute(DB_cmd.updateTable("mytable", "born='1999-01-12'", "userName='ţţ'"));  //test ok
		//	 statement.execute(DB_cmd.clearVlaue("mytable", "id='4'"));   //test ok
			 
		//	 rs = (ResultSet)statement.executeQuery(DB_cmd.selectTable("mytable"));  //test ok
		//	 rs = (ResultSet)statement.executeQuery(DB_cmd.selectTableLine("mytable","id=1"));  //test ok
		//	 rs = (ResultSet)statement.executeQuery(DB_cmd.selectTableLine("mytable","userName='ţţ'"));  //test ok
			 rs = (ResultSet)statement.executeQuery(DB_cmd.selectTableValue("mytable","userName","id=1"));  //test ok
			 while(rs.next()){ //������¼
				 int row = rs.getRow();
				 System.out.println(">>row>>" + row);
				 for(int i=1;i<=row;i++) {
					 System.out.println(">>"+i+">>" + rs.getString(i));
				 }
				 
				 System.out.println(">>id>>" + rs.getString("id"));  //���û�и�����ᱨ��
				 System.out.println(">>userName>>" + rs.getString("userName"));
				 System.out.println(">>sex>>" + rs.getString("sex"));
				 System.out.println(">>born>>" + rs.getString("born"));
				 System.out.println(">>id-int>>" + rs.getInt("id"));
			 }
		 } catch (SQLException e) {
			 System.out.println("���ݿ����ʧ�� �쳣��");  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 closeConnect();
	 }
	    
}
