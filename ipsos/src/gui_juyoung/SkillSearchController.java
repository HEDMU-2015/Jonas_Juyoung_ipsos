package gui_juyoung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.*;
import gui.MainApp;
import java.util.ArrayList;
import java.util.List;
import domain.*;

public class SkillSearchController {

	@FXML
	private TableView<Medarbejder> outputfelt = new TableView<>();
	@FXML
	private TableView<Kompetence> outputfelt2 = new TableView<>();
	@FXML
	private TableColumn<MedarbejderWrapper, String> nameColumn, skillsColumn, numberOfMatchColumn;
	@FXML
	private TableColumn<KompetenceWrapper, String> skillColumn, categoryColumn;
	@FXML
	private Label skillsL, matchesL;

	@FXML
	private TextField text;


	private MainApp2 mainApp;
	private IESController IES_CI = new IESControllerImpl();
	private List<Kompetence> kompetencelistKom = new ArrayList<>(); //jy
	private List<Medarbejder> medarbejdere = new ArrayList<>();


	public SkillSearchController() {
	}

	@FXML
	private void initialize() throws Exception {
		outputfelt2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		skillColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kompetence_navn"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kategori"));
		skillsColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("afdeling"));
		numberOfMatchColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("numberOfmatch"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("navn"));
		skillsL.setText("No skills selected");

		outputfelt2.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showKompetenceDetails((Kompetence) newValue));



	}

	public void setMainApp(MainApp2 mainApp) {
		this.mainApp = mainApp;
		outputfelt.setItems(mainApp.getPersonData());
		outputfelt2.setItems(mainApp.getKompetenceData());

	}



	private void showKompetenceDetails(Kompetence kompetence) {
		text.clear();
		List<Kompetence> kompetencelist = new ArrayList<>(); //jy

		if (kompetence != null) {
			kompetencelist.add(kompetence);

			List<Medarbejder> medarbejderListe = IES_CI.søgMedarbejderMedKompetence(kompetencelist);

			System.out.println(kompetencelist);

			skillsL.setText(kompetence.getKompetence_navn());
			ObservableList<Medarbejder> medarbejdere = FXCollections.observableArrayList(medarbejderListe);
			outputfelt.setItems(medarbejdere);

		} else {
			// Kompetence is null, remove all the text.
			skillsL.setText("No skills selected");
			matchesL.setText("");
		}


	}



	@FXML
	private void handleCsøg(ActionEvent event) throws Exception {

		outputfelt.getItems().clear();
		outputfelt.setItems(mainApp.getPersonData());
		text.clear();
		outputfelt2.getSelectionModel().clearSelection();
		outputfelt2.setItems(mainApp.getKompetenceData());

	}

	@FXML
	private void handleSøgKontakt(ActionEvent event) throws Exception {
		mainApp.refresh();
		mainApp.showPersonOverview();
		medarbejdere = outputfelt.getItems();
		System.out.println(medarbejdere);
		mainApp.refreshFromSkillSearch(medarbejdere);
	}

	@FXML
	private void handleSøgKompetence(ActionEvent event) throws Exception {
		text.clear();
		skillsL.setText("");
		kompetencelistKom.clear();
		kompetencelistKom.addAll(outputfelt2.getSelectionModel().getSelectedItems());
		for(Kompetence k : kompetencelistKom){
			text.appendText(k.getKompetence_navn() + "  ");
		}

		System.out.println("\n list to compare" +kompetencelistKom);
		medarbejdere = IES_CI.søgMedarbejderMedKompetence(kompetencelistKom);
		System.out.println(medarbejdere);
		outputfelt.getItems().clear();
		ObservableList<Medarbejder> søgmatch = FXCollections.observableArrayList(medarbejdere);
		outputfelt.setItems(søgmatch);

		medarbejdere.clear();

	}
}
