package gui_juyoung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.*;
import gui.MainApp;
import java.util.ArrayList;
import java.util.List;
import domain.*;

public class ShowEmployeeController {

	@FXML
	private TableView<Medarbejder> outputfelt = new TableView<>();
	@FXML
	private TableView<Kompetence> outputfelt2 = new TableView<>();
	@FXML
	private TableColumn<MedarbejderWrapper, String> nameColumn, countryColumn, departmentColumn;
	@FXML
	private TableColumn<KompetenceWrapper, String> categoryColumn, skillColumn;
	@FXML
	private Label navnL, emailL;
	@FXML
	private TextField søgfelt;
	private MainApp2 mainApp;
	private String søgeord;
	private IESController IES_CI = new IESControllerImpl();

	public ShowEmployeeController() {
	}

	@FXML
	private void initialize() throws Exception {
		// Initialize the person table with the two columns.
		nameColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("navn"));
		countryColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("land"));
		departmentColumn.setCellValueFactory(new PropertyValueFactory<MedarbejderWrapper, String>("afdeling"));

		categoryColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kategori"));
		skillColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kompetence_navn"));

		outputfelt.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

		outputfelt2.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails((Medarbejder) newValue));
	}

	public void setMainApp(MainApp2 mainApp) {
		this.mainApp = mainApp;
		outputfelt.setItems(mainApp.getPersonData());
	}

	private void showPersonDetails(Medarbejder medarbejder) {
		List<Kompetence> kompetenceListe = new ArrayList<>();

		if (medarbejder != null) {
			navnL.setText(medarbejder.getNavn());
			emailL.setText(medarbejder.getEmail());
			medarbejder.getKompetenceListe();
			kompetenceListe = medarbejder.getKompetenceListe();
			ObservableList<Kompetence> kompetencer = FXCollections.observableArrayList(kompetenceListe);
			outputfelt2.setItems(kompetencer);

		} else {
			// Person is null, remove all the text.
			navnL.setText("Choose an employee");
			emailL.setText("");

		}
	}

	private void updateUPF() {
		outputfelt.getItems().clear();
		outputfelt2.getItems().clear(); // jy
		mainApp.refresh();
		outputfelt.setItems(mainApp.getPersonData());
	}

	@FXML
	private void handleCsøg(ActionEvent event) throws Exception {
		søgfelt.clear();
		updateUPF();
	}

	@FXML
	private void handleSøgKontakt(ActionEvent event) throws Exception {
		søgeord = søgfelt.getText();
		List<Medarbejder> medarbejdere = IES_CI.søgMedarbejderMedNavn(søgeord);
		ObservableList<Medarbejder> søgmatch = FXCollections.observableArrayList(medarbejdere);
		outputfelt.getItems().clear();
		outputfelt2.getItems().clear();
		outputfelt.setItems(søgmatch);
		medarbejdere.clear();
	}

	@FXML
	private void handleSøgKompetence(ActionEvent event) throws Exception {
		mainApp.refresh();

		mainApp.showSkillSearch();
	}

	}
