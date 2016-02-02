package domain;

public interface Kompetence {
	


	public String getKategori();

	public void setKategori(String kategori);
	
	public int getKategori_id();
	
	public void setKategori_id(int kategori_id);

	public Kompetence getKompetence();
	
	public String getKompetence_navn();

	public void setKompetence_navn(String kompetence_navn);

	int getKompetence_id();

	void setKompetence_id(int medarbejderKompetence_id);
	
	int getMedarbejderKompetece_id();

	void setMedarbejderKompetece_id(int medarbejderKompetece_id);

	void gemRettetKompetence(Kompetence rettetKompetence);

	boolean isChecked();

	void setChecked(boolean checked);
	

	
	
}
