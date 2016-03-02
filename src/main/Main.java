package main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banco.Conexao;

public class Main {
	
	private static Connection conn;

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
		//inserirCliente(conn);
		//alterarCliente(conn);
		//deletarCliente(conn);
		//consultarCliente(conn);
		conn.close();
		System.out.println("Banco fechado!");

	}

	private static void inserirCliente(Connection conexao) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into cliente values (default,?,?)";
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		pstmt.setString(1, "Ana Maria dos Anjos");
		pstmt.setString(2, "111.111.111-11");
		
		pstmt.execute();
		conexao.commit();
		pstmt.close();
		System.out.println("Cliente inserido!");
	}
	
	private static void alterarCliente(Connection conexao) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update cliente set nome = ? where cpf = ?";
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		pstmt.setString(1, "Maria Ana dos Anjos");
		pstmt.setString(2, "111.111.111-11");
		
		pstmt.execute();
		conexao.commit();
		pstmt.close();
		System.out.println("Cliente alterado!");
	}

	private static void deletarCliente(Connection conexao) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from cliente where nome = ? and cpf = ?";
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		pstmt.setString(1, "Maria Ana dos Anjos");
		pstmt.setString(2, "111.111.111-11");
		
		pstmt.execute();
		conexao.commit();
		pstmt.close();
		System.out.println("Cliente excluido!");
	}
	
	private static void consultarCliente(Connection conexao) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = conexao.createStatement();
		String sql = "select * from cliente";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt("idcliente") + " " + rs.getString("nome") + " " + rs.getString("cpf"));
		}
		
		stmt.close();
		rs.close();
	}

}
