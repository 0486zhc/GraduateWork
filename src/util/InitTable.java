package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InitTable {
	public static void main(String[] args) {
		Configuration cf =new Configuration().configure();
		SchemaExport se= new SchemaExport(cf);
		se.create(true, true);
		System.out.println("Init OK!");
	}
}