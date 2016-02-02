package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.DataAccess;
import data.DataAccessImpl;
import data.KompetenceMapper;
import data.KompetenceMapperImpl;
import data.MedarbejderMapper;
import data.MedarbejderMapperImpl;
import data.MedarbejderMedKompetenceListeImpl;
import data.MedarbejderSearch;
import data.MedarbejderSearchImpl;
import domain.Medarbejder;
import domain.MedarbejderImpl;
import domain.Kompetence;
import domain.KompetenceImpl;
import logic.IESController;
import logic.IESControllerImpl;
import logic.MedarbejderKartotek;
import logic.MedarbejderKartotekImpl;

public class MainTest {
	private static List <Kompetence> kompetenceListeKom = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		
		
		
		//DataAccess dataAccess = new DataAccessImpl();
		IESController ies = new IESControllerImpl();
		
		System.out.println("GITHUB TRY"+ies.præsenterKategoriListe());

		
		//MedarbejderMedKompetenceListeImpl mck = new MedarbejderMedKompetenceListeImpl();
		Medarbejder m = new MedarbejderImpl();
		m.setId(0);
		
		System.out.println(ies.præsenterMedarbejderKompetenceListe());
		System.out.println(ies.vælgMedarbejder(m));
		System.out.println(ies.søgMedarbejderMedNavn("kl"));
		MainTest main = new MainTest();
		main.makeKompetenceKom();

		
		System.out.println(ies.søgMedarbejderMedKompetence(kompetenceListeKom));

		

		
		/*System.out.println(mck.makeValgtMedarbejderKompeteceListe(dataAccess, m));
		System.out.println(mck.makeValgtMedarbejderKompeteceListe(dataAccess, m));

		
		System.out.println("angiv" + mck.angivNavn("kl"));
		
		MedarbejderSearchImpl mse = new MedarbejderSearchImpl();
		System.out.println(mse.søgMedarbejderMedNavn("mar"));
		

		
		MainTest main = new MainTest();
		main.makeKompetenceKom();
		System.out.println(mse.søgMedarbejderMedKompetence(kompetenceListeKom));
		
		System.out.println(mse.søgMedarbejderMedKompetence(kompetenceListeKom));

		*/
		//System.out.println(mck.makeMedarbejderKompetenceListe());
		//System.out.println(mck.makeMedarbejderKompetenceListe());
		//System.out.println(mck.makeMedarbejderKompetenceListe());

		//List <Medarbejder> medarbejderListe = new ArrayList<>();
		//List <Medarbejder> medarbejderListe2 = new ArrayList<>();
		//List <Medarbejder> medarbejderListe3 = new ArrayList<>();
		//List <Medarbejder> medarbejderListe4 = new ArrayList<>();

		//List <Medarbejder> medarbejderMedKompetenceListe = new ArrayList<>();
		//Medarbejder m = new MedarbejderImpl();
		//MainTest main = new MainTest();

		//List<Kompetence> kompetenceListe = new ArrayList<>();
		
		//IESController ies = new IESControllerImpl();
		//main.makeKompetenceKom();
	//System.out.println(	"first" +ies.søgMedarbejderMedKompetence(kompetenceListeKom));

	
	//System.out.println("second"+	ies.søgMedarbejderMedKompetence(kompetenceListeKom));

	
	//System.out.println("\nlist1" + ies.præsenterMedarbejderKompetenceListe());

	//System.out.println("\nlist2" + ies.præsenterMedarbejderKompetenceListe());
	
	//m.setId(0);
	


	//System.out.println("\n 2121 " + ies.vælgMedarbejder(m));
	//System.out.println("\n 22221 " + ies.vælgMedarbejder(m));

	
	//
		
		//System.out.println("\n first "+ies.søgMedarbejderMedNavn("sø"));
		//System.out.println("\n second "+ies.søgMedarbejderMedNavn("kla"));
		
		/*MedarbejderMapper mm  = new MedarbejderMapperImpl();
		System.out.println("\n mm 1 : " +mm.præsenterMedarbejderListe(dataAccess));
		
		System.out.println("\n mm 2 : " +mm.præsenterMedarbejderListe(dataAccess));
*/
		//System.out.println(ies.søgMedarbejderMedNavn("pie"));
		
		//Medarbejder valgtMedarbejder = new MedarbejderImpl();
		
		//medarbejderListe = ies.præsenterMedarbejderKompetenceListe();
		
		
		/*for(Medarbejder m1 : medarbejderListe){

			System.out.println(m1.getNavn() + " : " + m1.getKompetenceListe());
		}
		*/
		
		/*
		valgtMedarbejder.setId(1);
	
		m = ies.vælgMedarbejder(valgtMedarbejder);
		System.out.println("navn : " + m.getNavn() + ", Kompetence: " + m.getKompetenceListe());
		
		kompetenceListe = m.getKompetenceListe();
		
		for(Kompetence k : kompetenceListe){
			System.out.println(k.getKategori() + " : " + k.getKompetence_navn());
		*/}
		
		//System.out.println(kompetenceListe);
		
		/*valgtMedarbejder.setId(1);
		m = ies.vælgMedarbejder(valgtMedarbejder);
		System.out.println(m);
		//valgtMedarbejder.getEmail();
		m.setAfdeling_id(3);
		
		
		ies.gemRettetMedarbejdersAfdeling(m);
		
		System.out.println(ies.vælgMedarbejder(m));
		
*/		//System.out.println("after" +ies.vælgMedarbejder(valgtMedarbejder));

		
		//m.setEmail("klaus.mikkelsen@ipsos.com");
		//m.setKompetence_id(2);
		

		//System.out.println(ies.gemMedarbejdersNyKompetence(m));
		
		//System.out.println(ies.præsenterMedarbejderKompeteceListe()); //works
		
		//System.out.println(ies.søgMedarbejderMedNavn("pie")); //works
		//main.makeKompetenceKom();
		//System.out.println(ies.søgMedarbejderMedKompetence(kompetenceListeKom));
		
		
		//Kompetence valgtKompetence = new KompetenceImpl();
		//valgtKompetence.setKompetence_navn("Java");
		

		//ies.vælgKompetence(valgtKompetence);
		//System.out.println(ies.sletKompetence()); //works
		
		
		//System.out.println(ies.sletKompetence());
		
		/*Kompetence rettetKompetence = new KompetenceImpl();
		rettetKompetence.setKompetence_id(21);
		rettetKompetence.setKategori_id(0);				
		rettetKompetence.setKompetence_navn("Python");
		ies.gemRettetKompetence(rettetKompetence); */ //works
		
		//System.out.println(ies.tilføjKompetence("Python", 0)); //works
		
		//System.out.println(ies.tilføjKategori("Special")); //works
		
		//System.out.println(ies.tilføjKompetence("Ruby", 0)); // fejl : already exists. - works
		
		//System.out.println(ies.præsenterKategoriListe()); //works
		
		//m.setId(2);
		
		//System.out.println(ies.vælgMedarbejder(m));
		
		//kompetenceListe = ies.præsenterKompetenceListe(); // works
	
		
		
		/*Kompetence valgtKompetence = new KompetenceImpl();
		valgtKompetence.setKategori_id(0);
		valgtKompetence.setKompetence_id(21);
		
		
		
		ies.vælgKompetence(valgtKompetence);
		
		System.out.println("test vælgKompetence" +ies.vælgKompetence(valgtKompetence)); //works
	
		
*/		//main.makeKompetenceKom();
		 //ies.søgMedarbejderMedKompetence(kompetenceListeKom); // works
		
		
		//medarbejderListe = ies.søgMedarbejderMedNavn("kla"); //works
		
		//Medarbejder valgtMedarbejder = new MedarbejderImpl(); 
		
		//valgtMedarbejder.setEmail("klaus.mikkelsen@ipsos.com");

		//valgtMedarbejder.setAfdeling_id(1);;
		
		//ies.gemRettetMedarbejdersAfdeling(valgtMedarbejder); //works
		
		
		
		
		 //System.out.println(medarbejderListe);

		
		/*MedarbejderMapper mm = new MedarbejderMapperImpl();
		
		MedarbejderKartotek mk = new MedarbejderKartotekImpl();
		
		
		MedarbejderSearch ms = new MedarbejderSearchImpl();
		
		main.makeKompeteceKom();
		
		medarbejderListe = ms.søgMedarbejderMedKompetence(kompetenceListeKom);
		System.out.println("\n searche : "+medarbejderListe);
		
		MedarbejderKompetence medarbejderK = new MedarbejderKompetenceImpl();
		System.out.println(medarbejderK.makeMedarbejderKompeteceListe());
		
		
		Medarbejder valgtMedarbejder = new MedarbejderImpl();
		valgtMedarbejder.setId(2);
		
		System.out.println("vælg medarbejder :"+mk.vælgMedarbejder(valgtMedarbejder));
		

		
		System.out.println("\n valgtMedarbejder : " + medarbejderK.makeValgtMedarbejderKompeteceListe(valgtMedarbejder));
		
		
		Medarbejder rettetMedarbejder = new MedarbejderImpl();

*/	/*	for(Medarbejder m2 : medarbejderK.makeValgtMedarbejderKompeteceListe(valgtMedarbejder)){
			rettetMedarbejder.setId(m2.getId());
			rettetMedarbejder.setNavn(m2.getNavn());
			rettetMedarbejder.setEmail(m2.getEmail());
			rettetMedarbejder.setLand(m2.getLand());
			rettetMedarbejder.setMedarbejderkompetence_id(m2.getMedarbejderkompetence_id());
		}		
		
		System.out.println("id : " + rettetMedarbejder.getId());
		System.out.println("competenceid +:" +rettetMedarbejder.getMedarbejderkompetence_id());
		rettetMedarbejder.setLand("Danmark");

		System.out.println(rettetMedarbejder);

		
		rettetMedarbejder.setKompetence_id(2);
		mk.gemMedarbejdersNyKompetence(rettetMedarbejder);
		
		MedarbejderSearch ms = new MedarbejderSearchImpl();
		

		medarbejderListe = ms.søgMedarbejderMedNavn("k");
		System.out.println(medarbejderListe);
		
		*/
	//medarbejderListe = mk.præsenterMedarbejderListe();
	/*main.makeKompeteceKom();	
	medarbejderListe = ms.søgMedarbejderMedKompetence(kompetenceListeKom);
	//System.out.println(kompetenceListeKom);
	
	System.out.println(medarbejderListe);*/
	
		
		/*Medarbejder valgtMedarbejder = new MedarbejderImpl();
		valgtMedarbejder.setId(0);

		//m = mk.vælgMedarbejder2(valgtMedarbejder);
		medarbejderListe2 = mk.vælgMedarbejder(valgtMedarbejder);

		
		System.out.println("\n1 :" + medarbejderListe);
		System.out.println("\n2 :" + medarbejderListe2);
		System.out.println("\n3 :" + medarbejderListe3);
		System.out.println("\n4 :" + medarbejderListe4);

		
				
		m = mk.vælgMedarbejder2(valgtMedarbejder);
		System.out.println(m);

		
*/		
		/*m = mk.vælgMedarbejder(valgtMedarbejder); //works
		System.out.println(m);
*/		
		/*String søgeord = "pie";
		medarbejderListe = mk.søgMedarbejderMedNavn(søgeord);
		System.out.println(medarbejderListe); // gives the matched person with kompetenceList
		*/
		//søge med kompetenceliste
		/*main.makeKompeteceKom();
		medarbejderListe = mk.søgMedarbejderMedKompetence(kompetenceListeKom); //works
		
		*/
		//get each person with kompetenceliste
		/*medarbejderListe = mk.getMedarbejderMedKompetenceListe(); //works
		*/
	//System.out.println(medarbejderListe);		
		
		//check præsenterMedarbejder
		/*medarbejderListe = mm.præsenterMedarbejder(dataAccess); //works
		
		
*/		
		//check valgMedarbejder
		/*Medarbejder valgtMedarbejder = new MedarbejderImpl();
		valgtMedarbejder.setId(0);
		
		medarbejderListe = mm.vælgMedarbejder(valgtMedarbejder, dataAccess);
		System.out.println(medarbejderListe);*/
		
		//Søge med Navn
				/*String søgeord = "s";
				medarbejderListe = ms.søgMedarbejderMedNavn(søgeord);
				System.out.println(medarbejderListe);
				
*/			

		
		
		

	
	public void makeKompetenceKom(){

		Kompetence k1 = new KompetenceImpl ();
		k1.setKompetence_id(8);
		k1.setKategori("Kvantitativ");
		k1.setKompetence_navn("Rapport-skrivning");
		kompetenceListeKom.add(k1);


		Kompetence k2 = new KompetenceImpl ();
		k2.setKompetence_id(1);
		k2.setKategori("Operations");
		k2.setKompetence_navn("C#");
		kompetenceListeKom.add(k2);


		Kompetence k3 = new KompetenceImpl ();
		k3.setKompetence_id(7);
		k3.setKategori("Kvantitativ");
		k3.setKompetence_navn("Statistik");
		kompetenceListeKom.add(k3);


		Collections.sort(kompetenceListeKom, new Comparator <Kompetence>(){

			@Override
			public int compare(Kompetence o1, Kompetence o2) {
				return o1.getKompetence_navn().compareToIgnoreCase(o2.getKompetence_navn()); 
				//just compareTo makes Upper letter comes first
			}				
		});

		//System.out.println("skills to find : " + kompetenceListeKom.toString() + "\n");

	}


}
