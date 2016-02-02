package data;

import java.util.List;

import domain.Medarbejder;

public interface MedarbejderMedKompetenceListe {

	List<Medarbejder> makeMedarbejderKompetenceListe(DataAccess dataAccess);

	Medarbejder makeValgtMedarbejderKompeteceListe(DataAccess dataAccess, Medarbejder valgtMedarbejder);

	List<Medarbejder> angivNavn(String søgeord);

}