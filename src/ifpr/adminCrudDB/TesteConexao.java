package ifpr.adminCrudDB;

import java.sql.Connection;
import java.sql.SQLException;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TesteConexao {

	/*
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        
        	System.out.println("Aberta");
        
        con.close();
    }
	*/
	



	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        PreparedStatement ps = null;

	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/AdminCrudDB?useTimezone=true&serverTimezone=UTC&user=root&password=root");

	           // stmt = conn.createStatement();

	            ps = conn.prepareStatement("INSERT INTO cliente (nome, email, tipo, cpf_cnpj, telefone) VALUES(?, ?, ?, ?, ?)");

	            ps.setString(1, "teste");
	            ps.setString(2, "teste@juca");
	            ps.setString(3, "PF");
	            ps.setString(4, "88888");
	            ps.setString(5, "88888");

	            ps.executeUpdate();
/*
	            rs = stmt.executeQuery("SELECT id, nome, idade, email FROM pessoa");

	            while(rs.next()) {
	                System.out.println("Resultado: " + rs.getInt("id") + ", " +
	                    rs.getString("nome") + ", " +
	                    rs.getInt("idade") + ", " +
	                    rs.getString("email"))
	            }
			*/
	        } catch(SQLException e) {
	            System.out.println(e);
	        } finally {
	            try{

	                if(rs != null) {
	                    rs.close();
	                }
	                
	                if(stmt != null) {
	                    stmt.close();
	                } 

	                if(conn != null) {
	                    conn.close();
	                }
	            } catch(SQLException e) {
	                System.out.println(e);
	            }
	        }
	    }
	
	
}
