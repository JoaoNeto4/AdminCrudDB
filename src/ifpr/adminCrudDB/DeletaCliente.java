package ifpr.adminCrudDB;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeletaCliente")
public class DeletaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cli = new Cliente();
		String id = request.getParameter("id");
		cli.setId(Integer.parseInt(id));
		
		//Cliente cli = request.getParameter("id");
		

		DAO dao = new DAO();
		
		try {
			dao.Deletar(cli);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(Integer.parseInt(id));
	}

}
