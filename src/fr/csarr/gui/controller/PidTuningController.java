package fr.csarr.gui.controller;

import java.util.List;

import fr.csarr.gui.DataManager;
import fr.csarr.gui.Main;
import fr.csarr.gui.model.PidData;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PidTuningController {

	/** reference to the main app */
	private Main mainApp;
	
	@FXML
	private XYChart<Number, Number> lineChart;

	@FXML
	private NumberAxis xAxis;
	
	@FXML
	private NumberAxis yAxis;
	
	private ObservableList<XYChart.Data<Number, Number>> series1Data;
	private DataManager dataManager;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PidTuningController() {
    	dataManager = DataManager.getDataManager();
    }
	
	@FXML
	private void initialize() {
		
		lineChart.setTitle("Test value");
		
	    xAxis.setLabel("time");
	    yAxis.setLabel("value");
	    xAxis.setMinorTickVisible(false);
	    xAxis.setAutoRanging(true);
	    yAxis.setAutoRanging(true);
	    
		series1Data = FXCollections.observableArrayList();
		setPIDData(dataManager.getPidData());

	    ObservableList<XYChart.Series<Number, Number>> series = FXCollections.observableArrayList();
	  	series.add(new XYChart.Series<>("PIDdata", series1Data));
	  	
	  	dataManager.addListerOnPidDataHistory(new ListChangeListener<PidData>() {
			
			@Override
			public void onChanged(Change<? extends PidData> c) {
				while (c.next()) {
                    if (c.wasAdded()) {
                    	updatePIDData(c.getAddedSubList());
                    }
				}
			}
		});

	    lineChart.setAnimated(true);     
		lineChart.setData(series);
	}
	
	public void setPIDData(List<PidData> pidData) {
		series1Data.clear();
		for (PidData p : pidData) {
			series1Data.add(new XYChart.Data<Number, Number>(p.getTimeStamp().get(),p.getValue().get()));
		}
    }
	
	public void updatePIDData(List<? extends PidData> list) {
		for (PidData p : list) {
			series1Data.add(new XYChart.Data<Number, Number>(p.getTimeStamp().get(),p.getValue().get()));
		}
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
