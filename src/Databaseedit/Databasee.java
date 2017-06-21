package Databaseedit;
import java.sql.*;

import javax.print.DocFlavor.CHAR_ARRAY;
public class Databasee {
	private String user;
	private String pass;
	private String address;
	private int port;
	private String database;
	private int id;
	Connection conn;
	/**
	 * 
	 * @param add -url
	 * @param port -portnumber (3306 for mysql)
	 * @param db -database name
	 * @param user -admin user
	 * @param pass -password
	 */
	public Databasee(String add,int port,String db,String user,String pass){
		this.user = user;
		this.pass = pass;	
		this.address = add;
		this.port = port;
		this.database = db;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public boolean createTable(String tablename){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+address+":"+port+"/"+database+"?"+"user=" + user +"&"+"password=" + pass);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Create Table "+tablename); 
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean dropTable(String tablename){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+address+":"+port+"/"+database+"?"+"user=" + user +"&"+"password=" + pass);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Drop Table "+tablename); 
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean connect(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+address+":"+port+"/"+database+"?"+"user=" + user +"&"+"password=" + pass);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from T_Accounts"); 
			
			while(rs.next()){  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)); 
				id = rs.getRow();
			}
				conn.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public String getDatabase(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+address+":"+port+"/"+database+"?"+"user=" + user +"&"+"password=" + pass);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from t_Accounts"); 
			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
				id = rs.getRow();
			}
				conn.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	public void insertDatabase(String tablename,String[] values){
		String val="";
		for(int i =0;i<values.length;i++){
			if(i==values.length-1){
				val = val + values[i];
			}else{
				val = val + values[i] + ",";
			}
		}
		System.out.println(val);
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+address+":"+port+"/"+database+"?"+"user=" + user +"&"+"password=" + pass);
			Statement stmt=conn.createStatement();
			/**
			id = id +1;
			val = "'"+id +"',"+ val;
			System.out.println(val);
			**/
			stmt.execute("INSERT INTO "+tablename+" VALUES ("+val+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
