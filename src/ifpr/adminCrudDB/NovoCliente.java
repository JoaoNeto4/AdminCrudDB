package ifpr.adminCrudDB;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.*;

@WebServlet("/NovoCliente")
public class NovoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//http://localhost:8080/AdminCrudDB/NovoCliente
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/cliente-novo.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		String cpf_cnpj = request.getParameter("cpf_cnpj");
		String telefone = request.getParameter("telefone");
		String id = request.getParameter("id");

	
		List<String> mensagens = new ArrayList<String>();
		
		if(nome.isEmpty()) {
			mensagens.add("Campo nome é obrigatorio");
		}
		if(tipo==null || tipo.isEmpty()) {
			mensagens.add("Campo tipo é obrigatorio");
		}
		if(email.isEmpty()) {
			mensagens.add("Campo email é obrigatorio");
		}
		if(cpf_cnpj.isEmpty()) {
			mensagens.add("Campo CPF/CNPJ é obrigatorio");
		}
		if(telefone.isEmpty()) {
			mensagens.add("Campo Telefone é obrigatorio");
		}
		
		
		
		if(id.isEmpty()) {
			id="0";
			
			System.out.println("Cadastrando novo cliente");
		}
			
			
			
			if(mensagens.size() > 0) {
				request.setAttribute("mensagens", mensagens);
				request.setAttribute("nome", nome);
				request.setAttribute("tipo", tipo);
				request.setAttribute("email", email);
				request.setAttribute("cpf_cnpj", cpf_cnpj);
				request.setAttribute("telefone", telefone);
				request.setAttribute("id", id);
			}else {
				
				try {
					Cliente cliente = new Cliente();
					//cliente.setId(Integer.parseInt(id));
					cliente.setNome(nome);
					cliente.setEmail(email);
					cliente.setCpf_cnpj(cpf_cnpj);
					cliente.setTipo(tipo);
					cliente.setTelefone(telefone);
					cliente.setId(Integer.parseInt(id));
				
					if(id.equals("0")) {
						DAO.Inserir(cliente);
						request.setAttribute("sucesso", "Cliente cadastrado com sucesso");
					}else{
						DAO.Atualizar(cliente);
						request.setAttribute("sucesso", "Cliente atualizado com sucesso");
					}
					
					//request.setAttribute("sucesso", "Cliente cadastrado com sucesso");
		
				} catch (Exception e) {
					e.printStackTrace();
				
					
				}
	

			}
			
		
			doGet(request, response);
			
	
	}
	
	
}
