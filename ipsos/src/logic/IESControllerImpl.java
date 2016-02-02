package logic;

import java.util.ArrayList;
import java.util.List;

import domain.Kompetence;
import domain.KompetenceImpl;
import domain.Medarbejder;
import domain.MedarbejderImpl;

public class IESControllerImpl implements IESController {

	private MedarbejderKartotek medarbejderKartotek = new MedarbejderKartotekImpl();
	private Medarbejder valgtMedarbejder = new MedarbejderImpl();
	public String søgeord;
	public List<Kompetence> kompetenceListeKom = new ArrayList<>();

	private KompetenceKartotek kompetenceKartotek = new KompetenceKartotekImpl();
	private Kompetence valgtKompetence = new KompetenceImpl();


	@Override
	public List<Medarbejder> præsenterMedarbejderKompetenceListe() {
		return medarbejderKartotek.præsenterMedarbejderListe();	
	}


	@Override
	public Medarbejder retMedarbejder() {

		Medarbejder rettetMedarbejder = new MedarbejderImpl(valgtMedarbejder);

		return rettetMedarbejder;
	}

	
	@Override
	public boolean gemRettetMedarbejdersOplysning(Medarbejder rettetMedarbejder) {
		return medarbejderKartotek.gemRettetMedarbejdersOplysning(rettetMedarbejder);	
	}
	
	@Override
	public boolean gemRettetMedarbejdersKompetence(Medarbejder rettetMedarbejder) {
		return medarbejderKartotek.gemRettetMedarbejdersKompetence(rettetMedarbejder);
	}
	
	@Override
	public boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder){
		return medarbejderKartotek.sletMedarbejdersKompetence(valgtMedarbejder);
	}
	

	@Override
	public boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder) {

		return medarbejderKartotek.gemMedarbejdersNyKompetence(valgtMedarbejder);
	}
	
	@Override
	public boolean gemRettetMedarbejdersAfdeling(Medarbejder rettetMedarbejder) {


		return medarbejderKartotek.gemRettetMedarbejdersAfdeling(rettetMedarbejder);
	}


	@Override
	public Medarbejder vælgMedarbejder(Medarbejder valgtMedarbejder) {

		this.valgtMedarbejder = medarbejderKartotek.vælgMedarbejder(valgtMedarbejder);

		return this.valgtMedarbejder;
	}

	@Override
	public List<Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom) {

		return medarbejderKartotek.søgMedarbejderMedKompetence(kompetenceListeKom);

	}

	@Override
	public List<Medarbejder> søgMedarbejderMedNavn(String søgeord) {

		return medarbejderKartotek.søgMedarbejderMedNavn(søgeord);
	}

	//////// Kompetence part

	@Override
	public List<Kompetence> præsenterKompetenceListe() {
		return kompetenceKartotek.præsenterKompetenceListe();
	}


	@Override
	public List<String> præsenterKategoriListe() {
		return kompetenceKartotek.præsenterKategoriListe(); 
	}


	@Override
	public Kompetence vælgKompetence(Kompetence valgtKompetence) {
		this.valgtKompetence = kompetenceKartotek.vælgKompetence(valgtKompetence);

		return this.valgtKompetence;
	}

	@Override
	public boolean tilføjKompetence(String kompetence_navn, int kategori_id) {

		return kompetenceKartotek.gemKompetence(kompetence_navn, kategori_id);
	}

	@Override
	public boolean tilføjKategori(String kategori) {
		return kompetenceKartotek.gemKategori(kategori);	
	}

	@Override
	public Kompetence retKompetence() {

		Kompetence rettetKompetence = new KompetenceImpl(valgtKompetence);

		return rettetKompetence;	

	}

	@Override
	public boolean gemRettetKompetence(Kompetence rettetKompetence) {

		return kompetenceKartotek.gemRettetKompetence(rettetKompetence);

	}

	@Override
	public boolean sletKompetence() {
		return kompetenceKartotek.gemSletning(valgtKompetence);

	}





}
