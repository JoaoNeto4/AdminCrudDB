package ifpr.adminCrudDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	//private static final String ENDERECO = "jdbc:mysql://127.0.0.1/AdminCrudDB?useTimezone=true&serverTimezone=UTC";
    private static final String ENDERECO = "jdbc:mysql://localhost/AdminCrudDB?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");

    		return DriverManager.getConnection(ENDERECO, USUARIO, SENHA);
    	} catch(SQLException e) {
    		System.out.println("Erro ao abrir conexao: "+e);
    		return null;
    	}
    }
    
    public static void fechaConexao(Connection con, PreparedStatement stmt) {
    	try {
    		if(stmt != null) {
    			stmt.close();
    		}
    		if(con != null) {
    			con.close();
    		}
    	}catch (Exception e) {
			System.out.println("Erro ao fechar conexao: "+e);
		}
    }
    
    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
    	try {
    		if(rs != null) {
    			rs.close();
    		}
    		if(stmt != null) {
    			stmt.close();
    		}
    		if(con != null) {
    			con.close();
    		}
    	}catch (Exception e) {
    		System.out.println("Erro ao fechar conexao: "+e);
		}
    }
   
    /*
    public static void main(String []args) throws ClassNotFoundException{
        try{
            getConexao();
            System.out.println("Conectado ao Banco de Dados!!");
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao Banco de Dados \n \n");
            e.printStackTrace();
        }
    }
    */
}

