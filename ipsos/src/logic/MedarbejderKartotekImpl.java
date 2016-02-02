package logic;

import java.util.List;

import data.DataAccess;
import data.DataAccessImpl;
import data.MedarbejderMapper;
import data.MedarbejderMapperImpl;
import data.MedarbejderMedKompetenceListe;
import data.MedarbejderMedKompetenceListeImpl;
import data.MedarbejderSearch;
import data.MedarbejderSearchImpl;
import domain.Kompetence;
import domain.Medarbejder;

public class MedarbejderKartotekImpl implements MedarbejderKartotek {

	private MedarbejderMapper mm = new MedarbejderMapperImpl();
	private MedarbejderMedKompetenceListe mmk = new MedarbejderMedKompetenceListeImpl();
	private MedarbejderSearch ms = new MedarbejderSearchImpl();

	private boolean bekræftelse = false;


	@Override
	public List<Medarbejder> præsenterMedarbejderListe() {
		DataAccess dataAccess = new DataAccessImpl();

		try{

			return mmk.makeMedarbejderKompetenceListe(dataAccess);

		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("præsenterMedarbejderListe- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}

	}

	@Override
	public Medarbejder vælgMedarbejder(Medarbejder valgtMedarbejder) {
		DataAccess dataAccess = new DataAccessImpl();


		try{		

			return mmk.makeValgtMedarbejderKompeteceListe(dataAccess, valgtMedarbejder);

		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("vælgMedarbejder- medarbejderKartotekImpl error", e);
		}finally{
			dataAccess.close();
		}


	}


	@Override
	public boolean gemRettetMedarbejdersOplysning(Medarbejder rettetMedarbejder) {

		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(mm.gemRettetMedarbejdersOplysning(rettetMedarbejder, dataAccess)){
				bekræftelse = true;
				dataAccess.commit();
				rettetMedarbejder = null;

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Ret Medarbejders oplysning- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}
	}

	@Override
	public boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder) {
		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(mm.sletMedarbejdersKompetence(valgtMedarbejder, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();
				valgtMedarbejder = null;

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Slet Medarbejders Kompetence- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}
	}

	@Override
	public List<Medarbejder> søgMedarbejderMedKompetence(List<Kompetence> kompetenceListeKom) {
		DataAccess dataAccess = new DataAccessImpl();

		try{

			return ms.søgMedarbejderMedKompetence(kompetenceListeKom, dataAccess);

		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("søg Medarbejder med Kompetence- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}

	}



	@Override
	public List<Medarbejder> søgMedarbejderMedNavn(String søgeord) {

		List <Medarbejder> medarbejder = mmk.angivNavn(søgeord);

		return medarbejder;	

	}

	@Override
	public boolean gemRettetMedarbejdersKompetence(Medarbejder rettetMedarbejder) {
		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(mm.gemRettetMedarbejdersKompetence(rettetMedarbejder, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();
				rettetMedarbejder = null;

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Ret Medarbejders Kompetence- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}
	}

	@Override
	public boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder) {
		DataAccess dataAccess = new DataAccessImpl();
		try{
			bekræftelse = mm.gemMedarbejdersNyKompetence(valgtMedarbejder, dataAccess);
			dataAccess.commit();
			return bekræftelse;


		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("gem Medarbejders Ny Kompetence- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}

	}

	@Override
	public boolean gemRettetMedarbejdersAfdeling(Medarbejder valgtMedarbejder) {
		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(mm.gemRettetMedarbejdersAfdeling(valgtMedarbejder, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();
				valgtMedarbejder = null;

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Ret Medarbejders Kompetence- medarbejderKartotek error", e);
		}finally{
			dataAccess.close();
		}
	}

}
