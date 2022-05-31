package it.prova.gestionebiglietti.service;

import it.prova.gestionebiglietti.dao.BigliettoDAO;
import it.prova.gestionebiglietti.dao.BigliettoDAOImpl;

public class MyServiceFactory {
	private static BigliettoService bigliettoServiceInstance=null;
	private static BigliettoDAO bigliettoDAOInstance=null;
	
	public static BigliettoService getBigliettoServiceInstance() {
		if(bigliettoServiceInstance==null)
			bigliettoServiceInstance= new BigliettoServiceImpl();
		
		if(bigliettoDAOInstance==null)
			bigliettoDAOInstance= new BigliettoDAOImpl();
		
		bigliettoServiceInstance.setBigliettoDao(bigliettoDAOInstance);
		
		return bigliettoServiceInstance;
	}
}
