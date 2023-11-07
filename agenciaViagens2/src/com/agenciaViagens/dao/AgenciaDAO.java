package com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenciaViagens.database.DatabaseConnection;
import com.agenciaViagens.model.Agencia;


public class AgenciaDAO {

	private Connection connection;
	private String sql;
	
	public AgenciaDAO() throws SQLException {
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
	
	public void createAgencia(Agencia agencia) {
		sql = "INSERT INTO Agencia_de_viagens (nomeAgencia,cnpjAgencia,siteAgencia,enderecoAgencia) VALUES (?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setString(1, agencia.getNomeAgencia());
			stmt.setString(2, agencia.getCnpjAgencia());
			stmt.setString(3, agencia.getSiteAgencia());			
			stmt.setString(4, agencia.getEnderecoAgencia());
			
			stmt.executeUpdate();
			
			System.out.println("Agência criada com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Agencia findAgencia(int idAgencia) {
		
		Agencia agencia = null;
		sql = "SELECT * FROM Agencia_de_viagens WHERE idAgencia=?";
		
try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, idAgencia);
			ResultSet r = stmt.executeQuery();
			
			if(r.next()) {
				agencia = new Agencia();
				agencia.setIdAgencia(r.getInt("idAgencia"));
				agencia.setNomeAgencia(r.getString("nomeAgencia"));
				agencia.setCnpjAgencia(r.getString("cnpjAgencia"));
				agencia.setSiteAgencia(r.getString("siteAgencia"));
				agencia.setEnderecoAgencia(r.getString("enderecoAgencia"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return agencia;
	}
	
		public void updateAgencia(Agencia agencia) {
			sql = "UPDATE Agencia_de_viagens SET idAgencia = ?, nomeAgencia = ?, cnpjAgencia = ?, siteAgencia = ?, enderecoAgencia = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, agencia.getIdAgencia());	
			stmt.setString(2, agencia.getNomeAgencia());
			stmt.setString(3, agencia.getCnpjAgencia());
			stmt.setString(4, agencia.getSiteAgencia());
			stmt.setString(5, agencia.getEnderecoAgencia());
			
				
			stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();			
			}
			
		}
	
		
		public void deleteAgencia(int idAgencia) {
			sql="DELETE FROM Agencia_de_viagens WHERE idAgencia = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setInt(1, idAgencia);
				stmt.executeUpdate();
				
				System.out.println("Agência deletada com sucesso!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
