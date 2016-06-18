package fr.csarr.gui;
	
import java.io.IOException;

import fr.csarr.gui.controller.PidTuningController;
import fr.csarr.gui.model.PidData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CSARR GUI");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/csarr_logo_title.png")));

        initMainLayout();
        showPidTuning();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/**
     * Initializes the main stage layout.
     */
    public void initMainLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showPidTuning() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PidTuningView.fxml"));
            
            AnchorPane PidTuningView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(PidTuningView);
            
            // Give the controller access to the main app.
            PidTuningController controller = loader.getController();
                        controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
