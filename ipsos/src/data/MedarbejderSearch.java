package data;

import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;

public interface MedarbejderSearch {



	List<Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom, DataAccess dataAccess);


	List <Medarbejder> søgMedarbejderMedNavn(String søgeord);


	
}
