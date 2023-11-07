package com.agenciaViagens;

import java.sql.SQLException;

import com.agenciaViagens.dao.ClienteDAO;
import com.agenciaViagens.model.Cliente;

public class MainCliente {

public static void main (String[] args) throws SQLException {
		
		ClienteDAO cDAO = new ClienteDAO();
		
		//Cliente cliente = new Cliente();
		
		//cliente.setNomeCliente("Maria das Dores");
		//cliente.setCpfCliente("099.344.088-25");
		//cliente.setEnderecoCliente("rua 3");
		//cliente.setTelefoneCliente("9999-8888");
		
		
		//cDAO.createCliente(cliente);
		
		
		//cliente.setIdCliente(1);
		//cliente.setNomeCliente("Lucas");
		//cliente.setCpfCliente("777.998.42-13");
		//cliente.setEnderecoCliente("rua 2");
		//cliente.setTelefoneCliente("8888-8888");
		
		//cDAO.updateCliente(cliente);
		
		
		
		Cliente cliente = cDAO.findCliente(1);
		
		System.out.println("ID: " + cliente.getIdCliente() + "\nNome: " + cliente.getNomeCliente());
		
		
		//cDAO.deleteCliente(1);
		
	}

	
}
