package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Medarbejder;
import domain.MedarbejderImpl;



public class MedarbejderMapperImpl implements MedarbejderMapper {
	private static PreparedStatement statement;
	private static ResultSet resultset;

	private int id;
	private String navn;
	private String email;
	private String land;
	private String afdeling;
	private int afdeling_id;
	private String kategori; 
	private int kategori_id;
	private String kompetence_navn; 
	private int kompetence_id;
	private int medarbejderkompetence_id;
	private boolean bekræftelse = false;	

	@Override
	public List<Medarbejder> præsenterMedarbejderListe(DataAccess dataAccess) {
		
		List <Medarbejder> medarbejderListe = new ArrayList<>();

		try {

			statement = dataAccess.getConnection().prepareStatement("SELECT id, medarbejder, email, land, afdeling.id, afdeling.afdeling, "
					+ "medarbejderkompetence.id, kategori.id, kategori.kategori, kompetence.id, kompetence.kompetence "
					+ "FROM MEDARBEJDER INNER JOIN MEDARBEJDERSAFDELING ON MEDARBEJDER.EMAIL = MEDARBEJDERSAFDELING.EMAIL "
					+ "inner join afdeling on medarbejdersafdeling.afdeling = afdeling.id "
					+ "inner join medarbejderkompetence on medarbejderkompetence.email= medarbejder.email "
					+ "inner join kompetence on medarbejderkompetence.kompetence = kompetence.id "
					+ "inner join kategori on kategori.id = kompetence.kategori "
					+ "ORDER BY medarbejder;");
			resultset = statement.executeQuery();

			while (resultset.next()) {

				id = resultset.getInt("id"); 
				navn = resultset.getString("medarbejder");
				email = resultset.getString("email");
				land = resultset.getString("land");
				afdeling = resultset.getString("afdeling.afdeling");
				afdeling_id = resultset.getInt("afdeling.id");

				medarbejderkompetence_id = resultset.getInt("medarbejderkompetence.id");

				kategori = resultset.getString("kategori"); 
				kategori_id = resultset.getInt("kategori.id");
				kompetence_navn = resultset.getString("kompetence.kompetence");
				kompetence_id = resultset.getInt("kompetence.id");


				Medarbejder m = new MedarbejderImpl();
				m.setId(id);
				m.setNavn(navn);
				m.setEmail(email);
				m.setLand(land);
				m.setAfdeling(afdeling);
				m.setAfdeling_id(afdeling_id);
				m.setKategori(kategori);
				m.setKategori_id(kategori_id);
				m.setKompetenceNavn(kompetence_navn);
				m.setKompetence_id(kompetence_id);
				m.setMedarbejderkompetence_id(medarbejderkompetence_id);


				medarbejderListe.add(m);


			}

			return medarbejderListe;
			
		

		} catch (SQLException e) {
			throw new RuntimeException("præsenterKontaktListe : SQLException caught", e);

		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}		

	}


	@Override
	public boolean gemRettetMedarbejdersKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess) {
		try{
			statement = dataAccess.getConnection().prepareStatement("UPDATE MEDARBEJDERKOMPETENCE SET kompetence=? where id = ?");
			statement.setInt(1, valgtMedarbejder.getKompetence_id());
			statement.setInt(2, valgtMedarbejder.getMedarbejderkompetence_id());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;

		} catch (SQLException e) {
			bekræftelse = false;
			return bekræftelse;
			//throw new RuntimeException("gemRettetMedarbejdersKompetence i mm : SQLException caught", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

	}


	@Override
	public boolean sletMedarbejdersKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess) {
		try{
			statement = dataAccess.getConnection().prepareStatement("DELETE MEDARBEJDERKOMPETENCE where id = ?");
			statement.setInt(1, valgtMedarbejder.getMedarbejderkompetence_id());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;



		} catch (SQLException e) {
			bekræftelse = false;
			return bekræftelse;
			//throw new RuntimeException("Slet MedarbejdersKompetence i mm : SQLException caught", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

	}


	@Override
	public boolean gemRettetMedarbejdersOplysning(Medarbejder valgtMedarbejder, DataAccess dataAccess) {

		try{
			statement = dataAccess.getConnection().prepareStatement(
					"UPDATE MEDARBEJDER SET medarbejder = ?, email = ?, land = ? WHERE id = ? ");
			statement.setString(1, valgtMedarbejder.getNavn());
			statement.setString(2, valgtMedarbejder.getEmail());
			statement.setString(3, valgtMedarbejder.getLand());
			statement.setInt(4, valgtMedarbejder.getId());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;



		} catch (SQLException e) {
			bekræftelse = false;
			return bekræftelse;
			//throw new RuntimeException("gemRettetKontakt : SQLException caught", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public List<Medarbejder> vælgMedarbejder(Medarbejder valgtMedarbejder, DataAccess dataAccess) {
		List <Medarbejder> valgtMedarbejderListe = new ArrayList<>();


		try {

			statement = dataAccess.getConnection().prepareStatement("SELECT id, medarbejder, email, land, afdeling.id, afdeling.afdeling,"
					+ "medarbejderkompetence.id, kategori.id, kategori.kategori, kompetence.id, kompetence.kompetence "
					+ "FROM MEDARBEJDER INNER JOIN MEDARBEJDERSAFDELING ON MEDARBEJDER.EMAIL = MEDARBEJDERSAFDELING.EMAIL "
					+ "inner join afdeling on medarbejdersafdeling.afdeling = afdeling.id "
					+ "inner join medarbejderkompetence on medarbejderkompetence.email= medarbejder.email "
					+ "inner join kompetence on medarbejderkompetence.kompetence = kompetence.id "
					+ "inner join kategori on kategori.id = kompetence.kategori "
					+ "where id = ?;");

			statement.setInt(1, valgtMedarbejder.getId());


			resultset = statement.executeQuery();



			while (resultset.next()) {

				id = resultset.getInt("id"); 
				navn = resultset.getString("medarbejder");
				email = resultset.getString("email");
				land = resultset.getString("land");
				afdeling = resultset.getString("afdeling.afdeling");
				afdeling_id = resultset.getInt("afdeling.id");
				kategori = resultset.getString("kategori"); 
				kategori_id = resultset.getInt("kategori.id");
				kompetence_navn = resultset.getString("kompetence.kompetence");
				kompetence_id = resultset.getInt("kompetence.id");
				medarbejderkompetence_id = resultset.getInt("medarbejderkompetence.id");


				Medarbejder m = new MedarbejderImpl();

				m.setId(id);
				m.setNavn(navn);
				m.setEmail(email);
				m.setLand(land);
				m.setAfdeling(afdeling);
				m.setAfdeling_id(afdeling_id);
				m.setKategori(kategori);
				m.setKategori_id(kategori_id);
				m.setKompetenceNavn(kompetence_navn);
				m.setKompetence_id(kompetence_id);
				m.setMedarbejderkompetence_id(medarbejderkompetence_id);


				valgtMedarbejderListe.add(m);


			}

			return valgtMedarbejderListe;

		} catch (SQLException e) {
			throw new RuntimeException("vælgMedarbejder in medarbejdermapper : SQLException caught", e);

		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}		
	}


	@Override
	public List<Medarbejder> søgMedarbejderMedNavn(String søgeord, DataAccess dataAccess) {
		
		List <Medarbejder> medarbejderListe = new ArrayList<>();

		try {

			statement = dataAccess.getConnection().prepareStatement("SELECT id, medarbejder, email, land, afdeling.id, afdeling.afdeling,"
					+ "kategori.id, kategori.kategori, kompetence.id, kompetence.kompetence "
					+ "FROM MEDARBEJDER INNER JOIN MEDARBEJDERSAFDELING ON MEDARBEJDER.EMAIL = MEDARBEJDERSAFDELING.EMAIL "
					+ "inner join afdeling on medarbejdersafdeling.afdeling = afdeling.id "
					+ "inner join medarbejderkompetence on medarbejderkompetence.email= medarbejder.email "
					+ "inner join kompetence on medarbejderkompetence.kompetence = kompetence.id "
					+ "inner join kategori on kategori.id = kompetence.kategori "
					+ "where medarbejder = ?;");


			statement.setString(1, søgeord);
			resultset = statement.executeQuery();



			while (resultset.next()) {

				id = resultset.getInt("id"); 
				navn = resultset.getString("medarbejder");
				email = resultset.getString("email");
				afdeling = resultset.getString("afdeling.afdeling");
				afdeling_id = resultset.getInt("afdeling.id");
				kategori = resultset.getString("kategori"); 
				kategori_id = resultset.getInt("kategori.id");
				kompetence_navn = resultset.getString("kompetence.kompetence");
				kompetence_id = resultset.getInt("kompetence.id");

				Medarbejder m = new MedarbejderImpl();
				m.setId(id);
				m.setNavn(navn);
				m.setEmail(email);
				m.setAfdeling(afdeling);
				m.setAfdeling_id(afdeling_id);
				m.setKategori(kategori);
				m.setKategori_id(kategori_id);
				m.setKompetenceNavn(kompetence_navn);
				m.setKompetence_id(kompetence_id);

				medarbejderListe.add(m);


			}

			return medarbejderListe;

		} catch (SQLException e) {
			throw new RuntimeException("præsenterKontaktListe : SQLException caught", e);

		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}			}


	@Override
	public boolean gemMedarbejdersNyKompetence(Medarbejder valgtMedarbejder, DataAccess dataAccess) {
		try{
			statement = dataAccess.getConnection().prepareStatement
					("INSERT INTO MEDARBEJDERKOMPETENCE (email, kompetence) values(?,?)");
			statement.setString(1, valgtMedarbejder.getEmail());
			statement.setInt(2, valgtMedarbejder.getKompetence_id());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;


		} catch (SQLException e) {
			bekræftelse = false;
			return bekræftelse;
			//throw new RuntimeException("gemRettetMedarbejdersKompetence i mm : SQLException caught", e);

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

	}


	@Override
	public List<Medarbejder> angivNavn(String søgeord) {
		List <Medarbejder> matchetMedarbejderMedNavn = new ArrayList<>();

		DataAccess dataAccess = new DataAccessImpl();
		List <Medarbejder> medarbejderListe = præsenterMedarbejderListe(dataAccess);

		for (Medarbejder m : medarbejderListe) {
			if (m.matcher(søgeord)) {
				matchetMedarbejderMedNavn.add(m);
			}
		}

		return matchetMedarbejderMedNavn;
	}


	@Override
	public boolean gemRettetMedarbejdersAfdeling(Medarbejder valgtMedarbejder, DataAccess dataAccess) {
		try{
			statement = dataAccess.getConnection().prepareStatement("UPDATE MEDARBEJDERSAFDELING SET afdeling=? where email = ?");
			statement.setInt(1, valgtMedarbejder.getAfdeling_id());
			statement.setString(2, valgtMedarbejder.getEmail());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;


		} catch (SQLException e) {
			bekræftelse = false;
			return bekræftelse;
			//throw new RuntimeException("gemRettetMedarbejdersKompetence i mm : SQLException caught", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
