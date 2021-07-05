package rareDiseasesFx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rareDiseasesIfaces.DBManager;
import rareDiseasesPojos.Disease;
import rareDiseasesPojos.Resources;

public class JDBCManager implements DBManager {

	private Connection c;
	
	/*public JDBCManager() {
		this.connect();
	}*/

	@Override
	public void connect() {
		try {

			// Open database connection
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection("jdbc:sqlite:./db/rareDiseases.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
		}

		catch (SQLException sqlE) {
			System.out.println("There was a database exception.");
			sqlE.printStackTrace();
		} catch (Exception e) {
			System.out.println("There was a general exception.");
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			// Close database connection
			c.close();
		} catch (SQLException e) {
			System.out.println("There was a problem while closing the database connection.");
			e.printStackTrace();
		}
	}

	public Disease getDisease(String diseaseName) {
		try {
			String sql = "SELECT * FROM Diseases WHERE diseaseName = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, diseaseName);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				int idDisease = rs.getInt("idDisease");
				String name = rs.getString("diseaseName");
				String prevalence = rs.getString("prevalence");
				String affectedSystem = rs.getString("affectedSystem");
				String treatment = rs.getString("treatment");
				String diagnosis = rs.getString("diagnosis");
				String description = rs.getString("description");
				return new Disease(idDisease, name, prevalence, affectedSystem, treatment, diagnosis, description);
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Disease> createDiseaseList() {
		List<Disease> diseases = new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM Diseases";
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer idDisease = rs.getInt("idDisease");
				String diseaseName = rs.getString("diseaseName");
				String prevalence = rs.getString("prevalence");
				String affectedSystem = rs.getString("affectedSystem");
				String treatment = rs.getString("treatment");
				String diagnosis = rs.getString("diagnosis");
				String description = rs.getString("description");
				Disease d = new Disease(idDisease, diseaseName, prevalence, affectedSystem, treatment, diagnosis,
						description);
				diseases.add(d);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diseases;
	}

	public List<Disease> searchDiseaseByName(String name) {
		List<Disease> diseases = new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM Diseases WHERE diseaseName LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int idDisease = rs.getInt("idDisease");
				String diseaseName = rs.getString("diseaseName");
				String prevalence = rs.getString("prevalence");
				String affectedSystem = rs.getString("affectedSystem");
				String treatment = rs.getString("treatment");
				String diagnosis = rs.getString("diagnosis");
				String description = rs.getString("description");
				Disease d = new Disease(idDisease, diseaseName, prevalence, affectedSystem, treatment, diagnosis,
						description);
				diseases.add(d);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diseases;
	}

	public List<Resources> searchResourcesByDisease(String diseaseName) {
		List<Resources> resources = new ArrayList<Resources>();
		try {
			String sql = "SELECT * FROM Resources AS r JOIN Resources_Diseases AS rd JOIN Diseases as d "
					+ "ON r.idResources= rd.idResource AND rd.idDisease= d.idDisease WHERE d.diseaseName LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + diseaseName + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int idResources = rs.getInt("idResources");
				String name = rs.getString("name");
				String finality = rs.getString("finality");
				String price = rs.getString("price");
				String access = rs.getString("access");
				Resources r = new Resources(idResources, name, finality, price, access);
				resources.add(r);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resources;
	}
	
	

}
