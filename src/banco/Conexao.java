package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static String url = "jdbc:postgresql://localhost/jdbc01";
	public static String user = "rubenbdpaz";
	public static String pass = "rubenbdpaz";
	
	private static Connection conexao;
	
	public static Connection getConnection() throws SQLException {
		if (conexao == null) {
			conexao = fazerConexao();
		}
		return conexao;
	}
	
	private static Connection fazerConexao() throws SQLException {
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexão Aberta");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Erro na abertura da conexão");
		}
		return conexao;
	}
}
