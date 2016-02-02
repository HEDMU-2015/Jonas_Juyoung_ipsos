
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Kompetence;
import domain.KompetenceImpl;

public class KompetenceMapperImpl implements KompetenceMapper {
	private static PreparedStatement statement;
	private static ResultSet resultset;
	private String kategori;
	private int kategori_id;
	private String kompetence_navn;
	private int kompetence_id;
	private Kompetence vk; 
	private boolean bekræftelse = false;
	private List<Kompetence> kompetenceListe = new ArrayList<>();

	@Override
	public List<Kompetence> præsenterKompetence(DataAccess dataAccess) {

		try {
			statement = dataAccess.getConnection().prepareStatement(
					"SELECT kategori.id, kategori.kategori, id, kompetence FROM Kompetence INNER JOIN kategori ON kompetence.kategori=kategori.id");

			resultset = statement.executeQuery();

			while (resultset.next()) {
				kategori = resultset.getString("kategori.kategori");
				kompetence_navn = resultset.getString("kompetence.kompetence");
				kategori_id = resultset.getInt("kategori.id");
				kompetence_id = resultset.getInt("kompetence.id");

				Kompetence k = new KompetenceImpl();
				k.setKategori(kategori);
				k.setKompetence_navn(kompetence_navn);
				k.setKompetence_id(kompetence_id);
				k.setKategori_id(kategori_id);
				kompetenceListe.add(k);
			}
		} catch (SQLException e) {
			throw new RuntimeException("præsenterKompetence i KompetenceMapperImpl: SQLException caught", e);
		}

		return kompetenceListe;
	}


	@Override
	public List<String> præsenterKategoriListe(DataAccess dataAccess) {
		List<String> kategoriListe = new ArrayList<>();
		try {
			statement = dataAccess.getConnection().prepareStatement(
					"SELECT kategori FROM kategori");

			resultset = statement.executeQuery();

			while (resultset.next()) {
				kategori = resultset.getString("kategori");

				kategoriListe.add(kategori);
			}
		} catch (SQLException e) {
			throw new RuntimeException("præsenterKategoriListe i KompetenceMapperImpl: SQLException caught", e);
		}

		return kategoriListe;

	}


	@Override
	public Kompetence vælgKompetence(Kompetence valgtKompetence, DataAccess dataAccess) {

		try {

			statement = dataAccess.getConnection().prepareStatement(
					"SELECT kategori.id, kategori.kategori, id, kompetence FROM kompetence "
							+ "INNER JOIN kategori ON kompetence.kategori=kategori.id "
							+ "WHERE id = ?");
			statement.setInt(1, valgtKompetence.getKompetence_id());

			resultset = statement.executeQuery();

			while (resultset.next()) {
				kategori_id = resultset.getInt("kategori.id");
				kategori = resultset.getString("kategori.kategori");
				kompetence_id = resultset.getInt("kompetence.id");
				kompetence_navn = resultset.getString("kompetence.kompetence");

				Kompetence k = new KompetenceImpl();

				k.setKategori(kategori);
				k.setKategori_id(kategori_id);
				k.setKompetence_navn(kompetence_navn);				
				k.setKompetence_id(kompetence_id);

				vk = k;
			}

			return vk;


		} catch (SQLException e) {
			throw new RuntimeException("vælgKompetence in KompetenceMapper : SQLException caught", e);
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
	public boolean gemKompetence(Kompetence kompetence, DataAccess dataAccess) {

		try {
			statement = dataAccess.getConnection()
					.prepareStatement("INSERT INTO PUBLIC.KOMPETENCE( KOMPETENCE, KATEGORI) VALUES ( ?, ?)");

			statement.setString(1, kompetence.getKompetence_navn());
			statement.setInt(2, kompetence.getKategori_id());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;

		} catch (SQLException e) {
			throw new RuntimeException("gemKompetence : SQLException caught", e);
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
	public boolean gemKategori(String kategori, DataAccess dataAccess) {

		try {
			statement = dataAccess.getConnection()
					.prepareStatement("INSERT INTO PUBLIC.KATEGORI( KATEGORI ) VALUES (?);");
			statement.setString(1, kategori);
			statement.executeUpdate();
			bekræftelse = true;
			return bekræftelse;



		} catch (SQLException e) {
			throw new RuntimeException("gemKategori : SQLException caught", e);
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
	public boolean gemRettetKompetence(Kompetence valgtKompetence, DataAccess dataAccess) {

		try {
			statement = dataAccess.getConnection()
					.prepareStatement("UPDATE Kompetence SET kompetence = ?, kategori = ? WHERE id = ? ");
			statement.setString(1, valgtKompetence.getKompetence_navn());
			statement.setInt(2, valgtKompetence.getKategori_id());
			statement.setInt(3, valgtKompetence.getKompetence_id());
			statement.executeUpdate();

			bekræftelse = true;
			return bekræftelse;



		} catch (SQLException e) {
			throw new RuntimeException("gemRettetKompetence : SQLException caught", e);
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
	public boolean gemSletning(Kompetence valgtKompetence, DataAccess dataAccess) {
		try {
			statement = dataAccess.getConnection()
					.prepareStatement("DELETE FROM KOMPETENCE WHERE KOMPETENCE = ? "); 
			statement.setString(1, valgtKompetence.getKompetence_navn());
			statement.executeUpdate();
			bekræftelse = true;
			return bekræftelse;


		} catch (SQLException e) {
			throw new RuntimeException("SletKompetence : SQLException caught", e);
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
