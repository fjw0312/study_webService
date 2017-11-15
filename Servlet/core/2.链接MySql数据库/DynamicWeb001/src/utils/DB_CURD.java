package utils;
/**
 * 对MySql数据库 CURD操作
 * 
 * */
public class DB_CURD {

	public DB_CURD() {
		// TODO Auto-generated constructor stub
	}
	public static String TBALE = "mytable";
	//创建表  （如果表存在会异常抛出）
    public static String sql_createTbale = "create table "+TBALE+"("
    		+ "id int(4) not null primary key auto_increment,"
    		+"userName char(8) not null,"
    		+"sex char(2),"
    		+"born date"+")";
   
    //插入记录
    public static String sql_insert = "insert into "+TBALE+" values("
    		+"'2','张三','男','1991-01-01'"+")";
    public static String sql_insert_nokey = "insert into "+TBALE+"(userName,sex,born)"	
    		+" values('张三','男','1991-01-01')"; 
    public static String sql_insert_null = "insert into "+TBALE+" values("
    		+"null,'张三','男','1991-11-01'"+")";
    
    //修改记录
    public static String sql_update = "update "+TBALE+" set born='1999-10-10'"
    		+ " where userName='张三'"; 
    
    //删除记录
    public static String sql_deleteValue = "delect from"+TBALE+"where id=1";
    //删除表所有记录
    public static String sql_delete = "delect from"+TBALE;
    //删除表
    public static String sql_drop = "drop table"+TBALE;
    
    //查询记录
    public static String sql_select = "select * from "+TBALE;
    //查询记录 某个记录
    public static String sql_select_value = "select * from "+TBALE+" where id=1";
    //查询记录 某个模糊记录
    public static String sql_select_value2 = "select * from "+TBALE+" where userName='%张%'";
    //查询记录 某个字段记录         //查询id=1 该记录中userName等于多少
    public static String sql_select_value3 = "select userName from "+TBALE+" where id=1";
}
