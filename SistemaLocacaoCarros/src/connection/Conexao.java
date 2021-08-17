package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Conexao conexao;
	private final String host = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "docker";
	private final String database = "rentx";
	
	private Conexao() {
	}
	
	public static Conexao getInstance() {
		if(conexao == null ) {
			return new Conexao();
		}
		return conexao;
	}
			
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database, user, password);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
