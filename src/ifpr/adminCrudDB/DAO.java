package ifpr.adminCrudDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DAO {
	
	public static void Inserir(Cliente pessoa) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO cliente (nome, email, tipo, cpf_cnpj, telefone) VALUES(?, ?, ?, ?, ?)";
	
		Connection con = Conexao.getConexao();

		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement stmt = con.prepareStatement(sql);

		try {
			
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getTipo());
			stmt.setString(4, pessoa.getCpf_cnpj());
			stmt.setString(5, pessoa.getTelefone());
			


			stmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		} finally {
			Conexao.fechaConexao(con, stmt);
		}
	}
	
	public void Deletar(Cliente pessoa) throws SQLException, ClassNotFoundException {
		Connection con = Conexao.getConexao();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
			stmt.setInt(1, pessoa.getId());

			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Conexao.fechaConexao(con, stmt);
		}
	}
	
	public Cliente Buscar(int id) throws SQLException, ClassNotFoundException {
		Connection con = Conexao.getConexao();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Cliente pessoa = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();

			rs.next();
			
			pessoa = new Cliente();
			
			pessoa.setId(rs.getInt("codigo"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setTipo(rs.getString("tipo"));
			pessoa.setCpf_cnpj(rs.getString("cpf_cnpj"));
			pessoa.setTelefone(rs.getString("telefone"));

			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Conexao.fechaConexao(con, stmt);
		}
		
		return pessoa;
	}
	
	public static void Atualizar(Cliente pessoa) throws SQLException, ClassNotFoundException {
		Connection con = Conexao.getConexao();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome = ?, email = ?, tipo = ?, cpf_cnpj = ?, telefone = ?  WHERE codigo = ?");
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getTipo());
			stmt.setString(4, pessoa.getCpf_cnpj());
			stmt.setString(5, pessoa.getTelefone());
			stmt.setInt(6, pessoa.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Conexao.fechaConexao(con, stmt);
		}
	}
	
	public static List<Cliente> Lista() throws SQLException, ClassNotFoundException {
		Connection con = Conexao.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> pessoas = new ArrayList<>();
		Cliente pessoa = null;
		try {
			stmt = con.prepareStatement("SELECT codigo, nome, email, tipo, cpf_cnpj, telefone FROM cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				pessoa = new Cliente();
				pessoa.setId(rs.getInt("codigo"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setTipo(rs.getString("tipo"));
				pessoa.setCpf_cnpj(rs.getString("cpf_cnpj"));
				pessoa.setTelefone(rs.getString("telefone"));
				
		
				
				pessoas.add(pessoa);
				pessoa = null;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Conexao.fechaConexao(con, stmt, rs);
		}
		return pessoas;
	}
}
