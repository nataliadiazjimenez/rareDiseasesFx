package rareDiseasesMenu;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import rareDiseasesPojos.Disease;


public class FXMLDocumentController implements Initializable {
	
	private Connection c;
	@FXML
	private Label label;
	@FXML
	private TextField filterField;
	@FXML
	private TableView<Disease> tableview;
	@FXML
	private TableColumn<Disease, String> diseaseName;
	@FXML
	private TableColumn<Disease, String> prevalence;
	@FXML
	private TableColumn<Disease, String> affectedSystem;
	@FXML
	private TableColumn<Disease, String> treatment;
	@FXML
	private TableColumn<Disease, String> diagnosis;
	@FXML
	private TableColumn<Disease, String> description;

	// observable list to store data
	//private final ObservableList<Disease> dataList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//idDisease.setCellValueFactory(new PropertyValueFactory<>("idDisease"));
		diseaseName.setCellValueFactory(new PropertyValueFactory<>("diseaseName"));
		prevalence.setCellValueFactory(new PropertyValueFactory<>("prevalence"));
		affectedSystem.setCellValueFactory(new PropertyValueFactory<>("affectedSystem"));
		treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
		diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		
//		List<Disease> listAll = this.createDiseaseList();
//
//		//List<Disease> listAll = new ArrayList<Disease>(createDiseaseList());
//		
//		//dataList.addAll(listAll);
//		FilteredList<Disease> filteredData = new FilteredList<>(dataList, b->true);
//		//String newValue, oldValue, observable;
//		
////		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
////			Iterator it= listAll.iterator();
////			while(it.hasNext()) {			
////			    filteredData.setPredicate(disease -> {
////			    	if(newValue == null || newValue.isEmpty()) { return true;}
////			    	
////				    String lowerCaseFilter= newValue.toLowerCase();
////				    if(((Disease) it).getDiseaseName().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
////				    	return true; //filter matches name
////				    }
////					return false;
////			    });
////			    
////				SortedList<Disease> sortedData=new SortedList<> (filteredData);
////				sortedData.comparatorProperty().bind(tableview.comparatorProperty());
////				tableview.setItems(sortedData);
////		    }
////		});
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
  

}


		
	
