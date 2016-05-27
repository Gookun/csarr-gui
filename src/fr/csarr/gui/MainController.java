package fr.csarr.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MainController {
    @FXML
    private MenuItem closeMenu;
    
    public MainController(){
    }
    
    @FXML
	private void initialize() {
		closeMenu.setOnAction(ActionEvent -> Platform.exit());
	}
}

