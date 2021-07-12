package rareDiseasesMenu;

import java.net.URL;
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
import rareDiseasesIfaces.DBManager;
import rareDiseasesFx.JDBCManager;
import java.util.function.Predicate;
import javafx.scene.input.KeyEvent;
import javafx.collections.transformation.SortedList;

public class FXMLDocumentController implements Initializable {
	public static DBManager dbman = new JDBCManager();

	
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
	
	private final ObservableList<Disease> dataList = FXCollections.observableArrayList();
	FilteredList<Disease> filteredData = new FilteredList<>(dataList, e->true);
//	FilteredList<Disease> filteredData = new FilteredList<>(dataList, e->true);

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
		
		//List<Disease> listAll = this.generateDiseaseList();
		//List<Disease> listAll = dbman.generateDiseaseList();

		//list.addAll(listAll);
		tableview.setItems(loadItems());
	}
	
	public ObservableList<Disease>loadItems(){

		List<Disease> list = null;
		list = dbman.generateDiseaseList();
		dataList.addAll(list);

			return dataList;

		}

	
	/*public void initialize(URL url, ResourceBundle rb) {

		//idDisease.setCellValueFactory(new PropertyValueFactory<>("idDisease"));
		diseaseName.setCellValueFactory(new PropertyValueFactory<Disease, String>("diseaseName"));
		prevalence.setCellValueFactory(new PropertyValueFactory<Disease, String>("prevalence"));
		affectedSystem.setCellValueFactory(new PropertyValueFactory<Disease, String>("affectedSystem"));
		treatment.setCellValueFactory(new PropertyValueFactory<Disease, String>("treatment"));
		diagnosis.setCellValueFactory(new PropertyValueFactory<Disease, String>("diagnosis"));
		description.setCellValueFactory(new PropertyValueFactory<Disease, String>("description"));
		
		
		List<Disease> listAll = dbman.generateDiseaseList();

		list.addAll(listAll);
		this.tableview.setItems(list);
	}
	*/
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

	//List<Disease> d = dbman.generateDiseaseList();
	
}


		
	
