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
import java.util.function.Predicate;
import javafx.scene.input.KeyEvent;
import javafx.collections.transformation.SortedList;
import rareDiseasesFx.*;

public class FXMLDocumentController implements Initializable {
	
	//private Connection c;
	@FXML
	private Label label;
	@FXML
	private TextField filterField;
	@FXML
	private TableView<Disease> tableview = null;
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
	
	ObservableList<Disease> list = FXCollections.observableArrayList();
	FilteredList<Disease> filteredData = new FilteredList<>(list, e->true);

	// observable list to store data
	//private final ObservableList<Disease> dataList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//idDisease.setCellValueFactory(new PropertyValueFactory<>("idDisease"));
		diseaseName.setCellValueFactory(new PropertyValueFactory<Disease, String>("diseaseName"));
		prevalence.setCellValueFactory(new PropertyValueFactory<Disease, String>("prevalence"));
		affectedSystem.setCellValueFactory(new PropertyValueFactory<Disease, String>("affectedSystem"));
		treatment.setCellValueFactory(new PropertyValueFactory<Disease, String>("treatment"));
		diagnosis.setCellValueFactory(new PropertyValueFactory<Disease, String>("diagnosis"));
		description.setCellValueFactory(new PropertyValueFactory<Disease, String>("description"));
		
		List<Disease> listAll = this.generateDiseaseList();
		
		list.addAll(listAll);
		this.tableview.setItems(list);
	}
	
	public void search(KeyEvent event) {

		filterField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate((Predicate<? super Disease>) (Disease mp) -> {

				if (newValue.isEmpty() || newValue == null) {
					return true;
				} else if (mp.getDiseaseName().contains(newValue)) {
					return true;
				}

				return false;
			});

			SortedList<Disease> sort = new SortedList(this.filteredData);
			sort.comparatorProperty().bind(tableview.comparatorProperty());
			tableview.setItems(sort);

		});
	}

	public List<Disease> generateDiseaseList(){
				
		List<Disease> d = new ArrayList<Disease>();
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
				Disease disease = new Disease(idDisease, diseaseName, prevalence, affectedSystem, treatment, diagnosis,
						description);
				d.add(disease);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}

	/*public List<Disease> createDiseaseList() {
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
	}*/
  

}


		
	
