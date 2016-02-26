package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import banco.Conexao;

public class RecuperaMetaDado {
	
	private static Connection conn;

	public static void main(String[] args) throws SQLException {
		
		conn = Conexao.getConnection();
		DatabaseMetaData dm = conn.getMetaData();
		
		String   catalog          = null;
		String   schemaPattern    = null;
		String   tableNamePattern = null;
		String[] types            = null;
		
		ResultSet rs = dm.getTables(catalog, schemaPattern, tableNamePattern, types);
		
		int i=1;
		while(rs.next()){
				System.out.println(i + ": " + rs.getString(3));
				i++;
		}
	}
}
