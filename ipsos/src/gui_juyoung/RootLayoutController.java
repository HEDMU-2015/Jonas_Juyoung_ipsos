package gui_juyoung;

import javafx.fxml.FXML;

public class RootLayoutController {
	
	private MainApp2 mainApp = new MainApp2();
	
	public void setMainApp(MainApp2 mainApp){
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleEditKompetence(){
		mainApp.showKompetenceDialog(mainApp.getKompetenceData());
	}
	
	@FXML
	private void handleEditButton(){
		
		
	}
	
}
