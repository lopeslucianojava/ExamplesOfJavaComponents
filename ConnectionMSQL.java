package material.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to connect and disconnect from the database.
 */
public class ConnectionMSQL {
  
  public static void main(String[] args) {
    ConnectionMSQL conexao = new ConnectionMSQL();
    Connection conn = conexao.conectar();
    conexao.desconectar(conn);
  }

  public Connection conectar() {
    Connection conn = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
      System.out.println("Conectou no banco de dados.");
    } catch (SQLException ex) {
      System.out.println("Erro: Não conseguiu conectar no BD.");
    } catch (ClassNotFoundException ex) {
      System.out.println("Erro: Não encontrou o driver do BD.");
    }

    return conn;
  }

  public void desconectar(Connection conn) {
    try {
      if(conn != null && !conn.isClosed()) {
        conn.close();
        System.out.println("Desconectou do banco de dados.");
      }
    } catch (SQLException ex) {
      System.out.println("Não conseguiu desconectar do BD.");
    }
  }
}