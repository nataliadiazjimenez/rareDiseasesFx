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

public class JDBCManager implements DBManager {

	private Connection c;
	
	public void connect() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/rareDiseases.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
		} catch (SQLException sqlE) {
			System.out.println("There was a database exception.");
			sqlE.printStackTrace();
		} catch (Exception e) {
			System.out.println("There was a general exception.");
			e.printStackTrace();
		}
	}

	
	public List<Disease> generateDiseaseList(){
		
		
		List<Disease> d = new ArrayList<Disease>();
		
		try {
			
			connect();
			String sql = "SELECT diseaseName, Prevalence, AffectedSystem, Treatment, Diagnosis,Description FROM Diseases";			
			PreparedStatement prep = c.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				//Integer idDisease = rs.getInt("idDisease");
				String diseaseName = rs.getString("diseaseName");
				String prevalence = rs.getString("prevalence");
				String affectedSystem = rs.getString("affectedSystem");
				String treatment = rs.getString("treatment");
				String diagnosis = rs.getString("diagnosis");
				String description = rs.getString("description");
				Disease disease = new Disease(diseaseName, prevalence, affectedSystem, treatment, diagnosis,
						description);
				d.add(disease);
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
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

}

