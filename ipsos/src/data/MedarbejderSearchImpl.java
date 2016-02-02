package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;

public class MedarbejderSearchImpl implements MedarbejderSearch {

	MedarbejderMedKompetenceListe mmk = new MedarbejderMedKompetenceListeImpl();

	@Override
	public List<Medarbejder> søgMedarbejderMedNavn(String søgeord) {

		return mmk.angivNavn(søgeord);
	}

	@Override
	public List<Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom, DataAccess dataAccess) {

		List<Medarbejder> medarbejderFinal = mmk.makeMedarbejderKompetenceListe(dataAccess);

		List<Medarbejder> matchetMedarbejder = new ArrayList<>();


		int i = 1;

		for(Medarbejder m : medarbejderFinal){ // checking each person


			for(Kompetence km : m.getKompetenceListe()){ // checking the person's kompetenceListe

				for(Kompetence k : kompetenceListeKom){	//comparing the person's kompetence to the list

					if(km.getKompetence_id()==k.getKompetence_id()){ 
						m.setNumberOfmatch(i);
						i++;
					}
				}
			}	
			i=1; //move to next person
		}


		for(Medarbejder m : medarbejderFinal){

			if(m.getNumberOfmatch()!=0){ // add when there is at least one match
				matchetMedarbejder.add(m);
			}

		}

		Collections.sort(matchetMedarbejder, new Comparator <Medarbejder>(){

			@Override
			public int compare(Medarbejder o1, Medarbejder o2) {
				return Integer.toString(o1.getNumberOfmatch()).compareTo(Integer.toString(o2.getNumberOfmatch()));
			}				
		});

		Collections.reverse(matchetMedarbejder);


		return matchetMedarbejder;


	}

}
