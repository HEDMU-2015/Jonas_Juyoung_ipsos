package domain;

import java.util.List;


public class MedarbejderImpl implements Medarbejder {

	private int id;
	private String navn;
	private String email;
	private String land;
	private String afdeling;
	private int afdeling_id;
	private String kategori; 
	private int kategori_id;
	private Kompetence kompetence;
	private String kompetence_navn;
	private int kompetence_id;
	private List<Kompetence> kompetenceListe;
	private int numberOfmatch;
	private boolean matcher = false;
	private String søgeord;
	private int medarbejderkompetence_id;



	public MedarbejderImpl(Medarbejder valgtMedarbejder) {
		this.id = valgtMedarbejder.getId();
		this.navn = valgtMedarbejder.getNavn();
		this.email = valgtMedarbejder.getEmail();
		this.land = valgtMedarbejder.getLand();
		this.afdeling = valgtMedarbejder.getAfdeling();
		this.afdeling_id = valgtMedarbejder.getAfdeling_id();
		this.kategori = valgtMedarbejder.getKategori();
		this.kategori_id = valgtMedarbejder.getKompetence_id();
		this.kompetence = valgtMedarbejder.getKompetence();
		this.kompetence_id = valgtMedarbejder.getKompetence_id();
		this.medarbejderkompetence_id = valgtMedarbejder.getMedarbejderkompetence_id();

		this.kompetenceListe = valgtMedarbejder.getKompetenceListe();
		this.numberOfmatch = valgtMedarbejder.getNumberOfmatch();
	}
	
	@Override
	public void gemRettetMedarbejder(Medarbejder rettetMedarbejder) {
		this.navn = rettetMedarbejder.getNavn();
		this.email = rettetMedarbejder.getEmail();
		this.land = rettetMedarbejder.getLand();
	}

	@Override
	public int getMedarbejderkompetence_id() {
		return medarbejderkompetence_id;
	}
	@Override
	public void setMedarbejderkompetence_id(int medarbejderkompetence_id) {
		this.medarbejderkompetence_id = medarbejderkompetence_id;
	}

	public MedarbejderImpl() {
		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getNavn() {
		return navn;
	}

	@Override
	public void setNavn(String navn) {
		this.navn = navn;
	}

	
	@Override
	public String getLand() {
		return land;
	}

	@Override
	public void setLand(String land) {
		this.land= land;
	}

	
	@Override
	public String getAfdeling() {
		return afdeling;	
	}

	@Override
	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	@Override
	public int getAfdeling_id() {
		return afdeling_id;
	}

	@Override
	public void setAfdeling_id(int afdeling_id) {
		this.afdeling_id=afdeling_id;
	}

	@Override
	public String getKategori() {
		return kategori;
	}

	@Override
	public void setKategori(String kategori) {
		this.kategori=kategori;
	}

	
	@Override
	public int getKategori_id() {
		return kategori_id;
	}

	@Override
	public void setKategori_id(int kategori_id) {
		this.kategori_id=kategori_id;
	}
	
	@Override
	public int getKompetence_id() {
		return kompetence_id;
	}

	@Override
	public void setKompetence_id(int kompetence_id) {
		this.kompetence_id=kompetence_id;
	}

	@Override
	public Kompetence getKompetence() {
		return kompetence;
	}

	@Override
	public void setKompetence(Kompetence kompetence) {
		this.kompetence=kompetence;
	}
	
	@Override
	public String getKompetenceNavn() {
		return kompetence_navn;
	}

	@Override
	public void setKompetenceNavn(String kompetence_navn) {
		this.kompetence_navn=kompetence_navn;
	}


	@Override
	public List<Kompetence> getKompetenceListe() {
		return kompetenceListe;
	}

	@Override
	public void setKompetenceListe(List<Kompetence> kompetenceListe) {
		this.kompetenceListe = kompetenceListe;
	}

	@Override
	public int getNumberOfmatch() {
		return numberOfmatch;
	}

	@Override
	public void setNumberOfmatch(int numberOfmatch) {
		this.numberOfmatch = numberOfmatch;
	}

	
	@Override
	public boolean matcher(String søgeord) {		
		this.setSøgeord(søgeord);
		if (matcher(navn, søgeord) || matcher(email, søgeord) ){			
			matcher = true;
			return matcher;
		}		
		return matcher;
	}

	private boolean matcher(String attribut, String søgeord){		
		return attribut.toLowerCase().contains(søgeord.toLowerCase());		
	}
	
	
	@Override
	public String getSøgeord() {
		return søgeord;
	}
	@Override
	public void setSøgeord(String søgeord) {
		this.søgeord = søgeord;
	}

	@Override
	public String toString() {
		return "MedarbejderImpl [id=" + id + ", navn=" + navn + ", email=" + email +", land=" + land + ", afdeling=" + afdeling
				+ ", afdeling_id=" + afdeling_id + ", kategori=" + kategori + ", kategori_id=" + kategori_id
				+ ", kompetence=" + kompetence + ", kompetence_navn=" + kompetence_navn + ", kompetence_id="
				+ kompetence_id +", medarbejderkompetence_id="+ medarbejderkompetence_id + ", \n kompetenceListe=" + kompetenceListe + ", numberOfmatch=" + numberOfmatch + "]\n\n";
	}

	
		

}
