package fr.csarr.gui.controller;

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
    
    public MainController(){
    }
    
    @FXML
	private void initialize() {
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

