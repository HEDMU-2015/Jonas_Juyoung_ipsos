package logic;

import java.util.List;

import domain.Kompetence;
public interface KompetenceKartotek {

	List <Kompetence> præsenterKompetenceListe();
	
	List <String> præsenterKategoriListe();

	
	Kompetence vælgKompetence (Kompetence valgtKompetence);	

	Kompetence retKompetence();
	
	boolean gemKompetence(String kompetence_navn, int kategori_id);
	
	boolean gemKategori(String kategori);
	
	boolean gemRettetKompetence(Kompetence rettetKompetence);
	
	boolean gemSletning (Kompetence valgtKompetence);

	
}
