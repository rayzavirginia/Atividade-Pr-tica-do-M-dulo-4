package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setNomeCliente(req.getParameter("nomeCliente"));
		cliente.setCpfCliente(req.getParameter("cpfCliente"));
		cliente.setEnderecoCliente(req.getParameter("enderecoCliente"));
		cliente.setTelefoneCliente(req.getParameter("telefoneCliente"));
		
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.createCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
