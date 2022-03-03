package ifpr.adminCrudDB;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditaCliente")
public class EditaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("codigo");
		System.out.println("id::: "+id);
		DAO dao = new DAO();
		
		
		Cliente cli = new Cliente();
		
		try {
			cli=dao.Buscar(Integer.parseInt(id));

		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("codigo", cli.getId());
		request.setAttribute("nome", cli.getNome());
		request.setAttribute("email", cli.getEmail());
		request.setAttribute("cpf_cnpj", cli.getCpf_cnpj());
		request.setAttribute("telefone", cli.getTelefone());
		request.setAttribute("tipo", cli.getTipo());
		
		RequestDispatcher rd = request.getRequestDispatcher("/cliente-novo.jsp");
		rd.forward(request, response);
		
	}

}
