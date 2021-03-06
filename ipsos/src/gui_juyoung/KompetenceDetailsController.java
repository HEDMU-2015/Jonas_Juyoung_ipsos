package gui_juyoung;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.Kompetence;
import domain.KompetenceImpl;
import gui.KompetenceWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.IESController;
import logic.IESControllerImpl;

public class KompetenceDetailsController {

	public MainApp2 mainApp;

	@FXML
	private TableView <Kompetence> kompetenceView = new TableView<>();

	@FXML
	private TableColumn<KompetenceWrapper, String> categoryColumn;
	@FXML
	private TableColumn<KompetenceWrapper, String> skillColumn;
	
		
	

	private Stage dialogStage;
	private boolean okClicked;
	private IESController IES_CI = new IESControllerImpl();
	private Alert alert = new Alert(null);
	private String errorMessage = "";

	@FXML
	private TreeView <String> kompetenceTreeView = new TreeView <String>();


	public KompetenceDetailsController(){

	}


	@FXML
	private void initialize() {
		
		//kompetenceTreeView.getSelectionModel().getSelectedItem();

		kompetenceView.getSelectionModel().getSelectedItem();

		skillColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kompetence_navn"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<KompetenceWrapper, String>("kategori"));

		getTreeView(IES_CI.præsenterKompetenceListe());
		
		kompetenceTreeView.getSelectionModel().getSelectedItem();
		

	}


	public void setMainApp(MainApp2 mainApp) {
		this.mainApp = mainApp;
		kompetenceView.setItems(mainApp.getKompetenceData());


	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;

	}

	@FXML
	private void handleEditKompetence(){
		List<Kompetence> kompetenceList = new ArrayList<>();

		kompetenceList.add(kompetenceView.getSelectionModel().getSelectedItem());
		Kompetence valgtKompetence = new KompetenceImpl();

		for(Kompetence k : kompetenceList){
			valgtKompetence.setKompetence_id(k.getKompetence_id());
			valgtKompetence.setKategori_id(k.getKategori_id());
			valgtKompetence.setKompetence_navn(k.getKompetence_navn());
		}
		
		
		TextInputDialog dialog = new TextInputDialog(valgtKompetence.getKompetence_navn());
		dialog.setTitle("Edit Skill Name");
		dialog.setHeaderText("Change the name of Skill");
		dialog.setContentText("Please enter skill name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		if (result.isPresent()){
		    System.out.println("Your name: " + result.get());
		    valgtKompetence.setKompetence_navn(result.get());
		    System.out.println(valgtKompetence);
		    if(IES_CI.gemRettetKompetence(valgtKompetence)){
				errorMessage = "Gemt!";
				alert = new Alert(AlertType.INFORMATION);
				alert.initOwner(dialogStage);
				alert.setTitle("Ret Kontakt");
				alert.setHeaderText("Ændringerne blev gemt.");
				alert.setContentText(errorMessage);
				alert.showAndWait();
			}
			okClicked = true;
			
			mainApp.refresh(); //works
			mainApp.refreshDialog(); //not working yet
			kompetenceView.refresh();

			//mainApp.getKompetenceData();
		
		}
		
				

		// The Java 8 way to get the response value (with lambda expression).
		//result.ifPresent(name -> System.out.println("Your name: " + name));

		
		
		
	}

			
		
	private void getTreeView (List<Kompetence> kompetenceList){
		TreeItem<String> rootItem = new TreeItem<>("Skill");
		rootItem.setExpanded(true);
		
		for (Kompetence k : kompetenceList){
			TreeItem<String> kompetence = new TreeItem<String>(k.getKompetence_navn());
			boolean found = false;
			
			for(TreeItem<String> kategori : rootItem.getChildren()){
				if(kategori.getValue().contentEquals(k.getKategori())){
					kategori.getChildren().add(kompetence);
					found = true;
					break;
					}
				}
			
			if(!found){
				TreeItem<String> kategori = new TreeItem<String>(
						k.getKategori()
						);
				rootItem.getChildren().add(kategori);
				kategori.getChildren().add(kompetence);
			}
	
			kompetenceTreeView.setRoot(rootItem);

		}			
		
	}	

	
	
	
}



