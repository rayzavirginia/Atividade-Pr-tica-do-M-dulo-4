package com.agenciaViagens;

import java.sql.SQLException;

import com.agenciaViagens.dao.DestinoDAO;
import com.agenciaViagens.model.Destino;

public class MainDestino {

public static void main (String[] args) throws SQLException {
		
		DestinoDAO dDAO = new DestinoDAO();
		
		Destino destino = new Destino();
		
		destino.setNomeDestino("Paris");
		destino.setEstadoDestino("----");
		destino.setPaisDestino("França");
		destino.setDataDestino("09/11/23 a 12/11/23");
		destino.setPrecoDestino("R$ 3.000,00");
		
		
		dDAO.createDestino(destino);
		
		
		//destino.setIdDestino(1);
		//destino.setNomeDestino("");
		//destino.setEstadoDestino("");
		//destino.setPaisDestino("");
		//destino.setPrecoDestino("");
		
		//dDAO.updateDestino(destino);
		
		
		
		//Destino destino = dDAO.findDestino(1);
		
		//System.out.println("ID: " + destino.getIdDestino() + "\nNome: " + destino.getNomeDestino());
		
		
		//dDAO.deleteDestino(1);
		
	}
	
}
