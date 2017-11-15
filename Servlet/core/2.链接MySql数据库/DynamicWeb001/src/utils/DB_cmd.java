package utils;
/**
 * ��MySql���ݿ� CURD����  ����
 * made by: fjw0312
 * date:2017.10.25
 * */
public class DB_cmd {

	public DB_cmd() {
		// TODO Auto-generated constructor stub
	}
	
	//������  ���������ڻ��쳣�׳���
	public static String createTable(String TBALE) {
		String sql = "create table "+TBALE+"("
	    		+"id int(4) not null primary key auto_increment,"
	    		+"userName char(8) not null,"
	    		+"sex char(2),"
	    		+"born date"+")";
		return sql;
	}
	//������  ������Ѵ����������� 
	public static String createTable2(String TBALE) {
		String sql = "create table if not exists "+TBALE+"("
	    		+"id int(4) not null primary key auto_increment,"
	    		+"userName char(8) not null,"
	    		+"sex char(2),"
	    		+"born date"+")";
		return sql;
	}
	
	//ɾ����    ����������ڻ��쳣�׳���
	public static String dropTable(String TBALE) {
		String sql = "drop table "+TBALE;
		return sql;
	}
	//ɾ����    
	public static String dropTable2(String TBALE) {
		String sql = "drop table if exists "+TBALE;
		return sql;
	}
	//��� �� ����
	public static String clearTable(String TBALE) {
		String sql = "delete from "+TBALE;
		return sql;
	}

	/**
	 * ��� �� ĳ������
	 * whereDec>>eg: "id=1"
	 **/
	public static String clearVlaue(String TBALE,String whereDec) {
		//"delect from TBALE where id=1"
		String sql = "delete from "+TBALE+" where "+whereDec;
		return sql;
	}
	
	/**
	 * �޸ĸ��� ĳ������
	 * ����setDec>>eg: "born='1999-10-10'"
	 * ��λwhereDec>>eg: "userName='����'"
	 * */
	public static String updateTable(String TBALE,String setDec, String whereDec) {
		//"update TBALE set born='1999-10-10' where userName='����'";
		String sql = "update "+TBALE+" set "+setDec+ " where "+whereDec; 
		return sql;
	}
	
	/**
	 * �����¼
	 * ���� ��������
	 * values>>eg: "'2','����','��','1991-01-01'"
	 * values>>eg: "null,'����','��','1991-01-01'"
	 * */
	public static String insertTable(String TBALE,String values) {
		//"insert into TBALE values('2','����','��','1991-01-01')"
		String sql = "insert into "+TBALE+" values("+values+")";
		return sql;
	}
	/**
	 * �����¼
	 * ��������¼ 
	 * valueName>>eg:"userName,sex,born"
	 * values>>eg: "'����','��','1991-01-01'"
	 * */
	public static String insertTable2(String TBALE,String valueName,String values) {
		//"insert into TBALE(userName,sex,born) values('����','��','1991-01-01')"
		String sql = "insert into "+TBALE+"("+valueName+") values("+values+")";
		return sql;
	}
	
    
	/**
	 * ��ѯ������ļ�¼
	 * */
	public static String selectTable(String TBALE) {
		String sql = "select * from "+TBALE;
		return sql;
	}
	/**
	 * ��ѯĳ���ֶ�  ��¼
	 * whereDec>>eg: "id=1"
	 *  eg: "userName='����'"
	 * */
	public static String selectTableLine(String TBALE,String whereDec) {
		String sql = "select * from "+TBALE+" where "+whereDec;
		return sql;
	}
	/**
	 * ��ȷ��ѯ  ��ѯ�ֶ�����ĳ�� ����ֵ
	 *  whereDec>>eg: "id=1"
	 *  selectDec>>eg: "userName"
	 * */
	public static String selectTableValue(String TBALE,String selectDec, String whereDec) {
		String sql = "select "+selectDec+" from "+TBALE+" where "+whereDec;
		return sql;
	}
    
}
