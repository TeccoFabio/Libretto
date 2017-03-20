package it.polito.tdp.libretto.model;
import java.time.LocalDate;

public class TestEsame {			//In una classe separata per non chiamare i metodi privati, che gli utenti non potrebbero fare

	public static void main(String[] args) {
		Esame tdp = new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami = new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno");
		System.out.println(ami);
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30,  LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18,  LocalDate.now());
		System.out.println(tdp);	
	}

}
