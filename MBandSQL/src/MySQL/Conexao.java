package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection connection; // a ser utilizado no DAO
	private final String URL = "jdbc:mysql://localhost:3306/taxi";
	private final String USER = "root";
	private final String PASSWORD = "190898hh10@H";
	private final String TPCONEXAO = "com.mysql.jdbc.Driver";

	public Connection abrir() {
		try {
			Class.forName(TPCONEXAO);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexao Aberta");
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	public void fechar() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexão fechada!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
