package rareDiseasesIfaces;
import java.util.List;
import rareDiseasesPojos.*;

public interface DBManager {
		 
			// Connects with the database and, if needed, performs necessary setup
			public void connect() ;
			// Closes the connection with the database
			// To be called when the application ends
			public void disconnect();
			//To get a particular disease
			public List<Disease> generateDiseaseList();
		
			
		}
