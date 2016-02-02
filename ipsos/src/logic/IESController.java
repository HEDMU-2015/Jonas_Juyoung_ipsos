package logic;

import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;

public interface IESController {

	
	List<Medarbejder> præsenterMedarbejderKompetenceListe();

	Medarbejder retMedarbejder();
	
	boolean gemRettetMedarbejdersOplysning(Medarbejder rettetMedarbejder);
	
	boolean gemRettetMedarbejdersKompetence (Medarbejder rettetMedarbejder);

	boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder);

	boolean gemRettetMedarbejdersAfdeling(Medarbejder rettetMedarbejder);
	
	Medarbejder vælgMedarbejder(Medarbejder valgtMedarbejder);
	
	List<Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom);
	
	List<Medarbejder> søgMedarbejderMedNavn(String søgeord);
	
	
	List<Kompetence> præsenterKompetenceListe();
	
	List<String> præsenterKategoriListe();

	
	Kompetence vælgKompetence(Kompetence valgtKompetence);
	
	boolean tilføjKompetence(String kompetence_navn, int kategori_id);
	
	boolean tilføjKategori(String kategori);
	
	Kompetence retKompetence ();
	
	boolean gemRettetKompetence (Kompetence rettetKompetence);
	
	boolean sletKompetence();

	boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder);

	
	
	
	
}
