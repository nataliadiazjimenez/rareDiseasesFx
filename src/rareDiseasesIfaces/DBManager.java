package rareDiseasesIfaces;
import java.util.List;
import rareDiseasesPojos.*;

public interface DBManager {
		 
			// Connects with the database and, if needed, performs necessary setup
			public void connect();
			// Closes the connection with the database
			// To be called when the application ends
			public void disconnect();
			//To get a particular disease
			public Disease getDisease(String diseaseName);
			//search for a disease by name
			public List<Disease> searchDiseaseByName(String name);
			//search for a resource by the name of a disease
			public List<Resources> searchResourcesByDisease(String diseaseName);
		
			
		}

