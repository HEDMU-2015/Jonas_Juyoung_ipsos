package gui_juyoung;

import domain.Medarbejder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedarbejderWrapper {

	private final StringProperty navn;
	private final StringProperty email;
	private final StringProperty land;
	private final StringProperty afdeling;
	private final StringProperty kategori; 
	private final StringProperty kompetence_navn;
	private final StringProperty numberOfMatch;

	private Medarbejder medarbejder;

	public MedarbejderWrapper(){
		this(null, null,null, null);
	}

	public MedarbejderWrapper(String afdeling, String navn, String land, String numberOfMatch) {
		
		this.afdeling = new SimpleStringProperty(medarbejder.getAfdeling());
		this.navn = new SimpleStringProperty(medarbejder.getNavn());
		this.land = new SimpleStringProperty(medarbejder.getLand());
		this.email = new SimpleStringProperty(medarbejder.getEmail());
		this.kategori = new SimpleStringProperty(medarbejder.getKategori());
		this.kompetence_navn = new SimpleStringProperty(medarbejder.getKompetenceNavn());
		this.numberOfMatch = new SimpleStringProperty(Integer.toString(medarbejder.getNumberOfmatch()));
	}

	public StringProperty getNumberOfMatch() {
		return numberOfMatch;
	}

	public Medarbejder getMedarbejder() {
		return medarbejder;
	}

	public void setMedarbejder(Medarbejder medarbejder) {
		this.medarbejder = medarbejder;
	}

	public StringProperty getNavn() {
		return navn;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getLand() {
		return land;
	}

	public StringProperty getAfdeling() {
		return afdeling;
	}

	public StringProperty getKategori() {
		return kategori;
	}

	public StringProperty getKompetence_navn() {
		return kompetence_navn;
	}

}
