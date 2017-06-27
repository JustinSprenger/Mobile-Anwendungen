package Databaseedit;

public class Main {

	public static void main(String[] args) {
		Databasee db = new Databasee("angewandteinfo.spdns.org",3306,"test","Justin","Tresor132");
		
		System.out.println(db.dropTable("account"));
		System.out.println(db.createTable("account"));

	}

}
