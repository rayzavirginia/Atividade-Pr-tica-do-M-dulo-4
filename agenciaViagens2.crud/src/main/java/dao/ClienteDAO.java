package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.DatabaseConnection;
import model.Cliente;

public class ClienteDAO {

	private Connection connection;
	private String sql;
	
	public ClienteDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}
	
	public void closeConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO Cliente (nomeCliente,cpfCliente,enderecoCliente,telefoneCliente) VALUES (?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());			
			stmt.setString(4, cliente.getTelefoneCliente());
			
			stmt.executeUpdate();
			
			System.out.println("Cliente criado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Cliente findCliente(int idCliente) {
		
		Cliente cliente = null;
		sql = "SELECT * FROM Cliente WHERE idCliente=?";
		
try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, idCliente);
			ResultSet r = stmt.executeQuery();
			
			if(r.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefoneCliente(r.getString("telefoneCliente"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
		public void updateCliente(Cliente cliente) {
			sql = "UPDATE Cliente SET idCliente = ?, nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefoneCliente = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, cliente.getIdCliente());	
			stmt.setString(2, cliente.getNomeCliente());
			stmt.setString(3, cliente.getCpfCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setString(5, cliente.getTelefoneCliente());
			
				
			stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();			
			}
			
		}
	
		
		public void deleteCliente(int idCliente) {
			sql="DELETE FROM cliente WHERE idCliente = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setInt(1, idCliente);
				stmt.executeUpdate();
				
				System.out.println("Cliente deletado com sucesso!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public List<Cliente> findClientes() {
			// TODO Auto-generated method stub
			return null;
		}
	
}
