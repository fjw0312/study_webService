package utils;
/**
 * ��MySql���ݿ� CURD����
 * 
 * */
public class DB_CURD {

	public DB_CURD() {
		// TODO Auto-generated constructor stub
	}
	public static String TBALE = "mytable";
	//������  ���������ڻ��쳣�׳���
    public static String sql_createTbale = "create table "+TBALE+"("
    		+ "id int(4) not null primary key auto_increment,"
    		+"userName char(8) not null,"
    		+"sex char(2),"
    		+"born date"+")";
   
    //�����¼
    public static String sql_insert = "insert into "+TBALE+" values("
    		+"'2','����','��','1991-01-01'"+")";
    public static String sql_insert_nokey = "insert into "+TBALE+"(userName,sex,born)"	
    		+" values('����','��','1991-01-01')"; 
    public static String sql_insert_null = "insert into "+TBALE+" values("
    		+"null,'����','��','1991-11-01'"+")";
    
    //�޸ļ�¼
    public static String sql_update = "update "+TBALE+" set born='1999-10-10'"
    		+ " where userName='����'"; 
    
    //ɾ����¼
    public static String sql_deleteValue = "delect from"+TBALE+"where id=1";
    //ɾ�������м�¼
    public static String sql_delete = "delect from"+TBALE;
    //ɾ����
    public static String sql_drop = "drop table"+TBALE;
    
    //��ѯ��¼
    public static String sql_select = "select * from "+TBALE;
    //��ѯ��¼ ĳ����¼
    public static String sql_select_value = "select * from "+TBALE+" where id=1";
    //��ѯ��¼ ĳ��ģ����¼
    public static String sql_select_value2 = "select * from "+TBALE+" where userName='%��%'";
    //��ѯ��¼ ĳ���ֶμ�¼         //��ѯid=1 �ü�¼��userName���ڶ���
    public static String sql_select_value3 = "select userName from "+TBALE+" where id=1";
}
