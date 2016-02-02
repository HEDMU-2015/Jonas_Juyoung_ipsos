package logic;

import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;

public interface MedarbejderKartotek {

	List<Medarbejder> præsenterMedarbejderListe();

	Medarbejder vælgMedarbejder (Medarbejder valgtMedarbejder);

	List <Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom);

	List <Medarbejder> søgMedarbejderMedNavn (String søgeord);

	boolean gemRettetMedarbejdersOplysning(Medarbejder rettetMedarbejder);
	
	boolean gemRettetMedarbejdersKompetence (Medarbejder rettetMedarbejder);

	boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder);

	boolean gemRettetMedarbejdersAfdeling(Medarbejder valgtMedarbejder);

	boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder);

	
}
