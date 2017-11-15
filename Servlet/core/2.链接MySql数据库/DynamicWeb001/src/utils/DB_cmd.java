package utils;
/**
 * 对MySql数据库 CURD操作  命令
 * made by: fjw0312
 * date:2017.10.25
 * */
public class DB_cmd {

	public DB_cmd() {
		// TODO Auto-generated constructor stub
	}
	
	//创建表  （如果表存在会异常抛出）
	public static String createTable(String TBALE) {
		String sql = "create table "+TBALE+"("
	    		+"id int(4) not null primary key auto_increment,"
	    		+"userName char(8) not null,"
	    		+"sex char(2),"
	    		+"born date"+")";
		return sql;
	}
	//创建表  （如果已存在则跳过） 
	public static String createTable2(String TBALE) {
		String sql = "create table if not exists "+TBALE+"("
	    		+"id int(4) not null primary key auto_increment,"
	    		+"userName char(8) not null,"
	    		+"sex char(2),"
	    		+"born date"+")";
		return sql;
	}
	
	//删除表    （如果表不存在会异常抛出）
	public static String dropTable(String TBALE) {
		String sql = "drop table "+TBALE;
		return sql;
	}
	//删除表    
	public static String dropTable2(String TBALE) {
		String sql = "drop table if exists "+TBALE;
		return sql;
	}
	//清空 表 数据
	public static String clearTable(String TBALE) {
		String sql = "delete from "+TBALE;
		return sql;
	}

	/**
	 * 清空 表 某条数据
	 * whereDec>>eg: "id=1"
	 **/
	public static String clearVlaue(String TBALE,String whereDec) {
		//"delect from TBALE where id=1"
		String sql = "delete from "+TBALE+" where "+whereDec;
		return sql;
	}
	
	/**
	 * 修改更新 某个数据
	 * 设置setDec>>eg: "born='1999-10-10'"
	 * 定位whereDec>>eg: "userName='张三'"
	 * */
	public static String updateTable(String TBALE,String setDec, String whereDec) {
		//"update TBALE set born='1999-10-10' where userName='张三'";
		String sql = "update "+TBALE+" set "+setDec+ " where "+whereDec; 
		return sql;
	}
	
	/**
	 * 插入记录
	 * 完整 整条插入
	 * values>>eg: "'2','张三','男','1991-01-01'"
	 * values>>eg: "null,'张三','男','1991-01-01'"
	 * */
	public static String insertTable(String TBALE,String values) {
		//"insert into TBALE values('2','张三','男','1991-01-01')"
		String sql = "insert into "+TBALE+" values("+values+")";
		return sql;
	}
	/**
	 * 插入记录
	 * 不完整记录 
	 * valueName>>eg:"userName,sex,born"
	 * values>>eg: "'张三','男','1991-01-01'"
	 * */
	public static String insertTable2(String TBALE,String valueName,String values) {
		//"insert into TBALE(userName,sex,born) values('张三','男','1991-01-01')"
		String sql = "insert into "+TBALE+"("+valueName+") values("+values+")";
		return sql;
	}
	
    
	/**
	 * 查询整个表的记录
	 * */
	public static String selectTable(String TBALE) {
		String sql = "select * from "+TBALE;
		return sql;
	}
	/**
	 * 查询某个字段  记录
	 * whereDec>>eg: "id=1"
	 *  eg: "userName='张三'"
	 * */
	public static String selectTableLine(String TBALE,String whereDec) {
		String sql = "select * from "+TBALE+" where "+whereDec;
		return sql;
	}
	/**
	 * 精确查询  查询字段条件某个 类型值
	 *  whereDec>>eg: "id=1"
	 *  selectDec>>eg: "userName"
	 * */
	public static String selectTableValue(String TBALE,String selectDec, String whereDec) {
		String sql = "select "+selectDec+" from "+TBALE+" where "+whereDec;
		return sql;
	}
    
}
