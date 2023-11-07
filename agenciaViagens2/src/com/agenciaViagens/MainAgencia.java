package com.agenciaViagens;

import java.sql.SQLException;

import com.agenciaViagens.dao.AgenciaDAO;
import com.agenciaViagens.model.Agencia;

public class MainAgencia {

public static void main (String[] args) throws SQLException {
		
		AgenciaDAO aDAO = new AgenciaDAO();
		
		Agencia agencia = new Agencia();
		
		agencia.setNomeAgencia("Ferias.com");
		agencia.setCnpjAgencia("099.344.088/00001-25");
		agencia.setSiteAgencia("www.ferias.com");
		agencia.setEnderecoAgencia("Rua 4");
		
		
		aDAO.createAgencia(agencia);
		
		
		//agencia.setIdAgencia(1);
		//agencia.setNomeAgencia("");
		//agencia.setCnpjAgencia("");
		//agencia.setSiteAgencia("");
		//agencia.setEnderecoAgencia("");
		
		//aDAO.updateAgencia(agencia);
		
		
		
		//Agencia agencia = aDAO.findAgencia(1);
		
		//System.out.println("ID: " + agencia.getIdAgencia() + "\nNome: " + agencia.getNomeAgencia());
		
		
		//aDAO.deleteAgencia(1);
	}
}
