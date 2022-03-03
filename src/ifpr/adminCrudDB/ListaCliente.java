package ifpr.adminCrudDB;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet("/ListaCliente")
public class ListaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//http://localhost:8080/AdminCrudDB/ListaCliente
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			List<Cliente> lista = DAO.Lista();
			request.setAttribute("clientes", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("/cliente-lista.jsp");
		rd.forward(request, response);
		
	
	}

}
