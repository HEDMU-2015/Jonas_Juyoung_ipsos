package gui_juyoung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.*;

public class MainApp2 extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private IESController IES_CI = new IESControllerImpl();
	private ObservableList<Medarbejder> personData = FXCollections.observableArrayList();
	private ObservableList<Kompetence> kompetenceData = FXCollections.observableArrayList();
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Ipsos Employee System");
		initRootLayout();
		showPersonOverview();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp2.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			throw new RuntimeException("MainApp initRootLayout : fejl", e);
		}
	}

	public void showPersonOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp2.class.getResource("ShowEmployee.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			ShowEmployeeController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			throw new RuntimeException("MainApp showPersonOverview : fejl", e);
		}
	}

	public void showSkillSearch() {
		try {
			// Load skill search.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp2.class.getResource("SkillSearch.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			SkillSearchController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			throw new RuntimeException("MainApp showSkillSearch : fejl", e);
		}
	}

	public MainApp2() {
		List<Medarbejder> medarbejdere = new ArrayList<>();
		List<Kompetence> kompetencer = new ArrayList<>();



		try {
			medarbejdere = IES_CI.præsenterMedarbejderKompetenceListe();
			for (Medarbejder m : medarbejdere) {
				personData.add(m);
			}

		} catch (Exception e) {
			throw new RuntimeException("MainApp constructor : fejl", e);
		}

		try {
			kompetencer = IES_CI.præsenterKompetenceListe();

			for (Kompetence k : kompetencer) {
				kompetenceData.add(k);
			}

		} catch (Exception e) {
			throw new RuntimeException("MainApp constructor : fejl", e);
		}

	}

	public ObservableList<Medarbejder> getPersonData() {
		return personData;
	}

	public ObservableList<Kompetence> getKompetenceData() {
		return kompetenceData;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void refresh() {
		List<Medarbejder> medarbejdere = new ArrayList<>();

		try {
			personData.clear();
			medarbejdere = IES_CI.præsenterMedarbejderKompetenceListe();
			for (Medarbejder M : medarbejdere) {
				personData.add(M);
			}
		} catch (Exception e) {
			throw new RuntimeException("MainApp constructor : fejl", e);
		}

	}
	
	public void refreshFromSkillSearch(List<Medarbejder> medarbejdere) {		

		try {
			personData.clear();
			
			for (Medarbejder M : medarbejdere) {
				personData.add(M);
			}
		} catch (Exception e) {
			throw new RuntimeException("MainApp constructor : fejl", e);
		}

	}

	
	public boolean showKompetenceDialog (ObservableList<Kompetence> observableList){
		
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp2.class.getResource("kompetenceDetail.fxml"));
		
		AnchorPane page = (AnchorPane) loader.load();
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Skills");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene (page);
		dialogStage.setScene(scene);
		
		KompetenceDetailsController controller = loader.getController();
		controller.setDialogStage(dialogStage);
		controller.setMainApp(this);
		
		dialogStage.showAndWait();
		
		return controller.isOkClicked();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
				
	}
	
}
