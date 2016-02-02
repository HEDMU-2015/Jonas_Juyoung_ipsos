package data;

import java.util.List;

import domain.Kompetence;

public interface KompetenceMapper {
	
	List<Kompetence> præsenterKompetence(DataAccess dataAccess);
	
	List<String>præsenterKategoriListe (DataAccess dataAccess);

	Kompetence vælgKompetence(Kompetence valgtKompetence, DataAccess dataAccess);
	
	boolean gemKompetence(Kompetence kompetence, DataAccess dataAccess);
	
	boolean gemKategori(String kategori, DataAccess dataAccess);
	
	boolean gemRettetKompetence(Kompetence valgtKompetence, DataAccess dataAccess);
	
	boolean gemSletning(Kompetence valgtKompetence, DataAccess dataAccess);
	
}
