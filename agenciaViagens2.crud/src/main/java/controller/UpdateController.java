package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		
		try {
			ClienteDAO cDAO = new ClienteDAO();
			Cliente cliente = cDAO.findCliente(idCliente);
			
			req.setAttribute("cliente", cliente);
			
			RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
			rd.forward(req, res);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));
			cliente.setNomeCliente(req.getParameter("nomeCliente"));
			cliente.setCpfCliente(req.getParameter("cpfCliente"));
			cliente.setEnderecoCliente(req.getParameter("enderecoCliente"));
			cliente.setTelefoneCliente(req.getParameter("telefoneCliente"));
			
			
			
			ClienteDAO cDAO = new ClienteDAO();
			cDAO.updateCliente(cliente);
			
			res.sendRedirect("ReadController");
		} catch (Exception e) {
			
		}
		
		
		
		
	}

}

