package com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenciaViagens.database.DatabaseConnection;
import com.agenciaViagens.model.Destino;


public class DestinoDAO {

	private Connection connection;
	private String sql;
	
	public DestinoDAO() throws SQLException {
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
	
	public void createDestino(Destino destino) {
		sql = "INSERT INTO destinos (nomeDestino,estadoDestino,paisDestino,dataDestino,precoDestino) VALUES (?,?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setString(1, destino.getNomeDestino());
			stmt.setString(2, destino.getEstadoDestino());
			stmt.setString(3, destino.getPaisDestino());			
			stmt.setString(4, destino.getDataDestino());
			stmt.setString(5, destino.getPrecoDestino());
			
			stmt.executeUpdate();
			
			System.out.println("Destino criado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Destino findDestino(int idDestino) {
		
		Destino destino = null;
		sql = "SELECT * FROM destino WHERE idDestino=?";
		
try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, idDestino);
			ResultSet r = stmt.executeQuery();
			
			if(r.next()) {
				destino = new Destino();
				destino.setIdDestino(r.getInt("idDestino"));
				destino.setNomeDestino(r.getString("nomeDestino"));
				destino.setEstadoDestino(r.getString("estadoDestino"));
				destino.setPaisDestino(r.getString("paisDestino"));
				destino.setDataDestino(r.getString("dataDestino"));
				destino.setPrecoDestino(r.getString("precoDestino"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return destino;
	}
	
		public void updateDestino(Destino destino) {
			sql = "UPDATE destinos SET idDestino = ?, nomeDestino = ?, estadoDestino = ?, paisDestino = ?, dataDestino = ?, precoDestino = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, destino.getIdDestino());	
			stmt.setString(2, destino.getNomeDestino());
			stmt.setString(3, destino.getEstadoDestino());
			stmt.setString(4, destino.getPaisDestino());
			stmt.setString(5, destino.getDataDestino());
			stmt.setString(6, destino.getPrecoDestino());
			
				
			stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();			
			}
			
		}
	
		
		public void deleteDestino(int idDestino) {
			sql="DELETE FROM destinos WHERE idDestino = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setInt(1, idDestino);
				stmt.executeUpdate();
				
				System.out.println("Destino deletado com sucesso!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
