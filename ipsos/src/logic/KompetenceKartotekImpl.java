package logic;

import java.util.List;

import data.DataAccess;
import data.DataAccessImpl;
import data.KompetenceMapper;
import data.KompetenceMapperImpl;
import domain.Kompetence;
import domain.KompetenceImpl;

public class KompetenceKartotekImpl implements KompetenceKartotek {

	private KompetenceMapper km = new KompetenceMapperImpl();
	public Kompetence valgtKompetence = new KompetenceImpl();
	private boolean bekræftelse = false;



	@Override
	public List<Kompetence> præsenterKompetenceListe() {
		DataAccess dataAccess = new DataAccessImpl();

		try{

			List<Kompetence> kompetenceListe = km.præsenterKompetence(dataAccess);		
			return kompetenceListe;
		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("præsenterKompetenceListe- KompetenceKartotekImpl error", e);
		}finally{
			dataAccess.close();
		}
	}





	@Override
	public Kompetence vælgKompetence(Kompetence valgtKompetence) {
		DataAccess dataAccess = new DataAccessImpl();

		try{		

			Kompetence kompetence = km.vælgKompetence(valgtKompetence, dataAccess);

			return kompetence;

		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("vælgKompetence- KompetenceKartotekImpl error", e);
		}finally{
			dataAccess.close();
		}


	}


	@Override
	public boolean gemKompetence(String kompetence_navn, int kategori_id) {

		DataAccess dataAccess = new DataAccessImpl();
		Kompetence kompetence = new KompetenceImpl();

		try{ 
			kompetence.setKompetence_navn(kompetence_navn);
			kompetence.setKategori_id(kategori_id);

			if(km.gemKompetence(kompetence, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Gem Kompetence - KompetenceKartotek error", e);
		}finally{
			dataAccess.close();
		}


	}

	@Override
	public boolean gemKategori(String kategori) {
		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(km.gemKategori(kategori, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Gem Kategori - KompetenceKartotek error", e);
		}finally{
			dataAccess.close();
		}

	}


	@Override
	public Kompetence retKompetence(){
		Kompetence rettetKompetence = new KompetenceImpl(valgtKompetence);
		return rettetKompetence;
	}


	@Override
	public boolean gemRettetKompetence(Kompetence rettetKompetence) {
		DataAccess dataAccess = new DataAccessImpl();

		try{ 
			if(km.gemRettetKompetence(rettetKompetence, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();
				rettetKompetence = null;

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Ret Kompetence - KompetenceKartotek error", e);
		}finally{
			dataAccess.close();
		}
	}

	@Override
	public boolean gemSletning(Kompetence valgtKompetence) {
		DataAccess dataAccess = new DataAccessImpl();
		try{ 
			if(km.gemSletning(valgtKompetence, dataAccess)){

				bekræftelse = true;
				dataAccess.commit();

				return bekræftelse;

			}else{	
				return false;
			}
		} catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("Slet Kompetence - KompetenceKartotek error", e);
		}finally{
			dataAccess.close();
		}

	}


	@Override
	public List<String> præsenterKategoriListe() {
		DataAccess dataAccess = new DataAccessImpl();

		try{

			List<String> kategoriListe = km.præsenterKategoriListe(dataAccess);	

			return kategoriListe;
		}catch (Exception e) {
			dataAccess.rollback();
			throw new RuntimeException ("præsenterKategoriListe- KompetenceKartotekImpl error", e);
		}finally{
			dataAccess.close();
		}	
	}
}
