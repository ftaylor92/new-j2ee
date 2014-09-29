package com.fmt.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

public class DatabaseAccess {
	public static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public final static String SQL_STATEMENT = "select * from keyvalue";

	@Resource(name="java:jdbc/primaryDB")
    private javax.sql.DataSource dsc;

	public void jbdcMisc() throws SQLException, ClassNotFoundException {
		System.out.println("Misc JDBC: "+(new Date()).toString());
		//String url = "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com/fmt-test?"
		//		+ "user=ftaylor92&password=ftaylor92";
		

		
		ResultSet resultSet = null;
		ResultSet rs = null;

		Class.forName(JDBC_DRIVER_CLASS_NAME);
		
		//using Apache Commons DBUtils
		try (Connection c = dsc.getConnection()) {
		    
		   /* new QueryRunner()
		        .query(c, sql, new ArrayListHandler())

		        // We can transform any Collection into a Stream
		        .stream()
		        .map(array -> new Schema(
		            (String) array[0],
		            (Boolean) array[1]
		        ))

		        // ... and then profit from the new Stream methods
		        .forEach(System.out::println);*/
		}
		
		//Using JOOQ
		try (Connection c = dsc.getConnection()) {
			
			try (PreparedStatement stmt = c.prepareStatement(SQL_STATEMENT)) {

				/*
				DSL.using(c)
			       .fetch(sql)

			       // We can use lambda expressions to map jOOQ Records
			       .map(rs -> new Schema(
			           rs.getValue("SCHEMA_NAME", String.class),
			           rs.getValue("IS_DEFAULT", boolean.class)
			       ))

			       // ... and then profit from the new Collection methods
			       .forEach(System.out::println);
				*/
				
				/*
				 * using joox 
				 * We can wrap a Statement or a ResultSet in a 
				 * Java 8 ResultSet 
				 * Stream c.stream(stmt, Unchecked.function(rs
				 * -> new Schema( rs.getString("SCHEMA_NAME"),
				 * rs.getBoolean("IS_DEFAULT") ) ))
				 * .forEach(System.out::println);
				 */

				/*
				 * Java7 way: rs = stmt.executeQuery();
				 * 
				 * 
				 * if(stmt.execute()) { System.out.println("execute worked"); }
				 * else { System.err.println("execute failed"); }
				 * 
				 * while (resultSet.next()) { foo= resultSet.getString("name");
				 * } resultSet.close(); statement.close(); connect.close();
				 */

				while (rs.next()) {
					String foo = rs.getString("name");
					System.out.println("foo: " + foo);
				}
				rs.close();
				stmt.close();
				c.close();

				// rs.stream(
				// stmt, /* Unchecked.function( */
				// rs -> new SQLGoodies.Schema(
				// rs.getString("SCHEMA_NAME"), rs
				// .getBoolean("IS_DEFAULT")))// )
				// .forEach(System.out::println);
				// ----

				/*
				 * StreamSupport.stream(Spliterators.spliteratorUnknownSize( new
				 * ResultSetIterator<>( supplier, rowFunction,
				 * exceptionTranslator ), 0 ), false);
				 * 
				 * /* Unfortunately, this method doesn't exist Stream.generate(
				 * // Supplier, generating new POJOs () -> { rs.next(); return
				 * new SQLGoodies.Schema( rs.getString("SCHEMA_NAME"),
				 * rs.getBoolean("IS_DEFAULT") ); },
				 * 
				 * // Predicate, terminating the Stream () -> { !rs.isLast(); }
				 * );
				 */
			}
		}
	}
}
