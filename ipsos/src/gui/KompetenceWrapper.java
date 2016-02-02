package gui;

import domain.Kompetence;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class KompetenceWrapper {

	private final StringProperty kategori;
	private final StringProperty kompetence_navn;	
	private Kompetence kompetence;


	public KompetenceWrapper(){
		this(null,null,false);
	}
	
	public KompetenceWrapper(String kategori, String kompetence_navn, boolean checked){
		this.kategori = new SimpleStringProperty(kompetence.getKategori());
		this.kompetence_navn = new SimpleStringProperty(kompetence.getKompetence_navn());
	}

	public StringProperty getKategori() {
		return kategori;
	}

	public StringProperty getKompetence_navn() {
		return kompetence_navn;
	}
		
}
