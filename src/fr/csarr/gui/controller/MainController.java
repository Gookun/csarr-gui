package fr.csarr.gui.controller;

import fr.csarr.gui.DataManager;
import fr.csarr.gui.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MainController {
	
	Main mainApp;
	
    @FXML
    private MenuItem closeMenuItem;
    
    @FXML
    private MenuItem connectMenuItem;
    
    @FXML
    private MenuItem disconnectMenuItem;
    
    public MainController(){
    }
    
    @FXML
	private void initialize() {
    	connectMenuItem.setOnAction(ActionEvent -> DataManager.getDataManager().createDataFromString("8;4"));
    	disconnectMenuItem.setOnAction(ActionEvent -> DataManager.getDataManager().createDataFromString("9;5"));
    	closeMenuItem.setOnAction(ActionEvent -> Platform.exit());
	}
    
	 /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
        public void setMainApp(Main mainApp) {
            this.mainApp = mainApp;
        }
}

