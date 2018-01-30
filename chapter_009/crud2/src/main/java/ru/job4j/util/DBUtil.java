package ru.job4j.util;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * Not used.
 * @author Anton Oleynikov
 * created on 23.10.2017
 */
public class DBUtil {
	
	private static DataSource dataSource;
	
	private static final String JNDI_LOOKUP_SERVICE = "java:/comp/env/jdbc/crud2";
			
	static{
		try {
			Context context = new InitialContext();
			Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
			if(lookup != null){
				dataSource =(DataSource)lookup;
			}else{
				new RuntimeException("JNDI look up issue.");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		
		return dataSource;
	}
}
