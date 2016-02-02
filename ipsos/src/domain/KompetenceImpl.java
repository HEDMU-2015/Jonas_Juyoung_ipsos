package domain;

public class KompetenceImpl implements Kompetence {

	String kategori;
	int kategori_id;
	int kompetence_id;
	String kompetence_navn;
	int medarbejderkompetece_id;

	Kompetence kompetence;
	boolean checked;


	
	public KompetenceImpl(Kompetence valgtKompetence) {
		this.medarbejderkompetece_id = valgtKompetence.getMedarbejderKompetece_id();
		this.kategori = valgtKompetence.getKategori();
		this.kategori_id = valgtKompetence.getKompetence_id();
		this.kompetence_navn = valgtKompetence.getKompetence_navn();
		this.kompetence_id = valgtKompetence.getKompetence_id();
	}
	
	@Override
	public void gemRettetKompetence(Kompetence rettetKompetence) {
		this.medarbejderkompetece_id = rettetKompetence.getMedarbejderKompetece_id();
		this.kategori = rettetKompetence.getKategori();
		this.kategori_id = rettetKompetence.getKompetence_id();
		this.kompetence_navn = rettetKompetence.getKompetence_navn();
		this.kompetence_id = rettetKompetence.getKompetence_id();
	}

	public KompetenceImpl() {
	}

	@Override
	public int getKompetence_id() {
		return kompetence_id;
	}

	@Override
	public void setKompetence_id(int kompetence_id) {
		this.kompetence_id = kompetence_id;
	}

	@Override
	public String getKategori() {
		return kategori;
	}

	@Override
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	@Override
	public int getKategori_id() {
		return kategori_id;
	}

	@Override
	public void setKategori_id(int kategori_id) {
		this.kategori_id = kategori_id;
	}

	@Override
	public String getKompetence_navn() {
		return kompetence_navn;
	}

	@Override
	public void setKompetence_navn(String kompetence_navn) {
		this.kompetence_navn = kompetence_navn;
	}

	@Override
	public Kompetence getKompetence() {
		return kompetence;
	}

	
	@Override
	public int getMedarbejderKompetece_id() {

	return medarbejderkompetece_id;
	}

	@Override
	public void setMedarbejderKompetece_id(int medarbejderKompetece_id) {
		this.medarbejderkompetece_id= medarbejderKompetece_id;		
	}

	
	
	@Override
	public boolean isChecked() {
		return checked;
	}

	@Override
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "KompetenceImpl [kategori_id=" + kategori_id + ", kategori=" + kategori + ", kompetence_id="
				+ kompetence_id +  ", kompetence_navn=" + kompetence_navn
				+ ", medarbejderKompetece_id=" + medarbejderkompetece_id + "]";
	}

	
	
		
	

}
