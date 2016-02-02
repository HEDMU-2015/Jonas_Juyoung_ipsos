package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Kompetence;
import domain.KompetenceImpl;
import domain.Medarbejder;
import domain.MedarbejderImpl;

public class MedarbejderMedKompetenceListeImpl implements MedarbejderMedKompetenceListe {
	private List <Medarbejder> medarbejderListe = new ArrayList<>();


	MedarbejderMapper mm = new MedarbejderMapperImpl();
	
	
	@Override
	public List<Medarbejder> makeMedarbejderKompetenceListe(DataAccess dataAccess) {
		
		
		medarbejderListe = mm.præsenterMedarbejderListe(dataAccess);

		List<Medarbejder> navnListe = new ArrayList<>();

		List<Medarbejder> medarbejdereMedKompetenceListe = new ArrayList<>();


		Map<Integer, Medarbejder> map = new HashMap<Integer, Medarbejder>();


		for(Medarbejder m : medarbejderListe){	

			if(!map.containsValue(m.getId())){ 
				map.put(m.getId(), m);
			}

		}

		navnListe.addAll(map.values());	



		for(Medarbejder m : navnListe){


			List <Kompetence> kompetenceListe = getKompetenceListe(m);
			
			m.setKompetenceListe(kompetenceListe);

			medarbejdereMedKompetenceListe.add(m);

		}		

		return medarbejdereMedKompetenceListe;

	}
		
	
	@Override
	public Medarbejder makeValgtMedarbejderKompeteceListe(DataAccess dataAccess, Medarbejder valgtMedarbejder) {

		List<Medarbejder> navnListe = new ArrayList<>();

		List<Medarbejder> navnResult = new ArrayList<>();

		medarbejderListe = mm.vælgMedarbejder(valgtMedarbejder, dataAccess);

		Map<Integer, Medarbejder> map = new HashMap<Integer, Medarbejder>();


		Medarbejder medarbejder = new MedarbejderImpl();

		for(Medarbejder m : medarbejderListe){	

			if(!map.containsValue(m.getId())){ 
				map.put(m.getId(), m);
			}

		}

		navnListe.addAll(map.values());	



		for(Medarbejder m : navnListe){

			List <Kompetence> kompetenceListe = getKompetenceListe(m);
			
			m.setKompetenceListe(kompetenceListe);
						
			navnResult.add(m);

		}		


		for(Medarbejder m : navnResult){
			medarbejder = m;
		}


		return medarbejder;
	}
	
	
	public List<Medarbejder> angivNavn(String søgeord) {
		List <Medarbejder> medarbejderMatchetMedNavn = new ArrayList<>();
		DataAccess dataAccess = new DataAccessImpl();
		medarbejderListe = makeMedarbejderKompetenceListe(dataAccess);
		
		for (Medarbejder m : medarbejderListe) {
			if (m.matcher(søgeord)) {
				medarbejderMatchetMedNavn.add(m);
			}
		}

		return medarbejderMatchetMedNavn;
	}


	private List<Kompetence> getKompetenceListe(Medarbejder m){
		
		List <Kompetence> kompetenceListe = new ArrayList<>();

		for(Medarbejder m2 : medarbejderListe){


			if(m2.getId()==m.getId()){
				Kompetence kompetence = new KompetenceImpl();

				kompetence.setKompetence_id(m2.getKompetence_id());
				kompetence.setKategori_id(m2.getKategori_id());

				kompetence.setKategori(m2.getKategori());
				kompetence.setKompetence_navn(m2.getKompetenceNavn());
				kompetence.setKompetence_id(m2.getKompetence_id());
				kompetence.setMedarbejderKompetece_id(m2.getMedarbejderkompetence_id());

				m2.setKompetence(kompetence);

				kompetenceListe.add(m2.getKompetence());


			}			

		}	
		
		return kompetenceListe;
	}

}
