package rareDiseasesMenu;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class MainApp extends Application {
	// private ObservableList<Disease> diseaseInfo =
	// FXCollections.observableArrayList();

	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);

		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("CSS/newCascadeStyleSheet.css");
		stage.setScene(scene);
		stage.show();
	}

	/*
	 * public ObservableList<Disease> getDiseaseData() { return diseaseInfo; }
	 */

	public static void main(String[] args) {
		Application.launch(args);
	}
}
