	/**
	 * Sample Skeleton for 'Libretto.fxml' Controller Class
	 */

	package it.polito.tdp.libretto;
	//Il Controller si puo' debaggare solo attraverso l'interfaccia finale

	import java.net.URL;
	import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class LibrettoController {
//NON HA SENSO PERCHE POSSONO ESSERCI TANTI CONTROLLORI MENTRE IL MOELLO E UNICO		
//		Model model = new Model();		
		Model model;
		

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtCodice"
	    private TextField txtCodice; // Value injected by FXMLLoader

	    @FXML // fx:id="txtTitolo"
	    private TextField txtTitolo; // Value injected by FXMLLoader

	    @FXML // fx:id="txtDocente"
	    private TextField txtDocente; // Value injected by FXMLLoader

	    @FXML // fx:id="txtResult"
	    private TextArea txtResult; // Value injected by FXMLLoader

	    @FXML
	    void doCerca(ActionEvent event) {
	    	String codice = txtCodice.getText();
	    	if(codice.length()<5){
	    		txtResult.appendText("Codice corso non valido\n");
	    		return;
	    	}
	    	Esame e = model.trovaEsame(codice);
	    	if(e==null)
	    		txtResult.appendText("Codice corso non trovato\n");
	    	else{
	    		txtResult.appendText("Codice corso trovato\n");
	    		txtCodice.setText(e.getCodice());
	    		txtTitolo.setText(e.getTitolo());
	    		txtDocente.setText(e.getDocente());
	    	}
	    }

	    @FXML
	    void doInserisci(ActionEvent event) {
	    	//Recupera i dati dalla vista
	    	String codice = txtCodice.getText();
	    	String titolo = txtTitolo.getText();
	    	String docente = txtDocente.getText();
	    	
	    	//Verifica la validita' dei dati
	    	// NON CONTROLLARE ==NULL
	    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
	    		txtResult.appendText("Dati esame insufficiente\n");
	    		return ;
	    	}
	    	//Chiede al model di effettuare l'operazione (inserimento)
	    	Esame e = new Esame(codice, titolo, docente);
	    	boolean result = model.addEsame(e); 		//Puo andare a buon fine come  no
	    	
	    	
	    	//Aggiorna la vista col risultato dell'operazione
	    	if(result)
	    		txtResult.appendText("Esame aggiunto correttamente\n");
	    	else
	    		txtResult.appendText("Esame NON AGGIUNTO\n");
	    				// Si potrebbe suddividere a seconda dello stato del programma
	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
	        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
	        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Libretto.fxml'.";
	    }

		/**
		 * @param model the model to set
		 */
		public void setModel(Model model) {
			this.model = model;
		}
	    
	    
	    
	}