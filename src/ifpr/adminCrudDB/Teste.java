package ifpr.adminCrudDB;

import java.sql.SQLException;

public class Teste {

	/*
	public static void main(String[] args) {
	Cliente cli = new Cliente();
	
	cli.setNome("juca juca");
	cli.setEmail("juca@juca");
	cli.setTipo("PF");
	cli.setCpf_cnpj("9999999999");
	cli.setTelefone("46-98888-9999");
	
	try {
		DAO.Inserir(cli);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		
	}
	*/
	
	
	public static void main(String []args) throws ClassNotFoundException{
        try{
            Conexao.getConexao();
            System.out.println("Conectado ao Banco de Dados!!");
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao Banco de Dados \n \n");
            e.printStackTrace();
        }
    }
	
	
}
