package it.polito.tdp.libretto.model;

import java.util.*;

public class Model {		
	private List<Esame> esami;
	
	public Model(){
		this.esami=new ArrayList<Esame>();
	}
	/**
	 * Aggiunge un nuovo esame agli esami presenti
	 * @param e
	 */
	public boolean addEsame(Esame e){
		if(!esami.contains(e))	{	//Gestire in modo silenzioso i failure (silent failure)
			esami.add(e);
			return true;				// (failure soft) inserisco un boolean
		} else
			return false; 			// Attraverso un'eccezione, informando l'utente								 
	}
	/**
	 * Ricerca se esiste un esame con il codice specificato. 
	 * Se esiste lo restituice, altrimenti restituisce null.
	 * 
	 * @param codice: codice dell'esame da ricercare
	 * @return: l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice){
		int pos = esami.indexOf(new Esame(codice, null, null)); 		//metodo di altro livello
		if(pos==-1)
			return null;
		else
			return esami.get(pos);
	}
}
