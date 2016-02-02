package data;

import java.util.List;

import domain.Medarbejder;

public interface MedarbejderMapper {
	
	List<Medarbejder> præsenterMedarbejderListe(DataAccess dataAccess);
	
	boolean gemRettetMedarbejdersOplysning(Medarbejder valgtMedarbejder, DataAccess dataAccess);
	
	boolean gemRettetMedarbejdersAfdeling(Medarbejder valgtMedarbejder, DataAccess dataAccess);

	
	boolean gemRettetMedarbejdersKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess);

	boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess);

	
	List<Medarbejder> vælgMedarbejder (Medarbejder valgtMedarbejder, DataAccess dataAccess);
	
	//List<Medarbejder> angivNavn (String søgeord, DataAccess dataAccess) ;

	List<Medarbejder> søgMedarbejderMedNavn(String navn, DataAccess dataAccess);
	
	//List<Medarbejder> søgMedKompetenceListe(List<Kompetence> kompetenceListe, DataAccess dataAccess);

	//String getSøgeord();

	//void setNavn(String søgeord);

	List<Medarbejder> angivNavn(String søgeord);

	boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess);

	
	
}
