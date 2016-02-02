package domain;

import java.util.List;


public interface Medarbejder {
	
	public int getId();

	public void setId(int id);
	
	public String getEmail();

	public void setEmail(String email);

	public String getNavn();

	public void setNavn(String navn);

	public String getAfdeling();

	public void setAfdeling(String afdeling);
	
	public int getAfdeling_id();
	
	public void setAfdeling_id(int afdeling_id);

	public String getKategori();
	
	public void setKategori(String kategori);
	
	public int getKompetence_id();

	public void setKompetence_id(int kompetence_id);

	public Kompetence getKompetence();

	public void setKompetence(Kompetence kompetence);
	
	public List<Kompetence> getKompetenceListe();
	
	public void setKompetenceListe(List<Kompetence> kompetenceListe);

	public int getNumberOfmatch();

	public void setNumberOfmatch(int numberOfmatch);

	int getKategori_id();

	void setKategori_id(int kategori_id);

	String getKompetenceNavn();

	void setKompetenceNavn(String kompetence_navn);
	
	public boolean matcher(String søgeord);

	String getSøgeord();

	void setSøgeord(String søgeord);

	String getLand();

	void setLand(String land);
	
	void gemRettetMedarbejder(Medarbejder rettetMedarbejder);

	int getMedarbejderkompetence_id();

	void setMedarbejderkompetence_id(int medarbejderkompetence_id);

	
}
