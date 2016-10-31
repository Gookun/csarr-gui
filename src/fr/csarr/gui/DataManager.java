package fr.csarr.gui;

import fr.csarr.gui.model.PidData;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class DataManager {

	static DataManager instance;
    public static ObservableList<PidData> pidDataHistory = FXCollections.observableArrayList();
	
	private DataManager(){
        pidDataHistory.add(new PidData(0, 10));
        pidDataHistory.add(new PidData(1, 11));
        pidDataHistory.add(new PidData(2, 12));
        pidDataHistory.add(new PidData(3, 13));
        pidDataHistory.add(new PidData(4, 14));
        pidDataHistory.add(new PidData(5, 16));
        pidDataHistory.add(new PidData(6, 18));
        pidDataHistory.add(new PidData(7, 21));
	}
	
	public static DataManager getDataManager(){
		if (instance == null){
			instance = new DataManager();
		}
		return instance;
	}

    public ObservableList<PidData> getPidData() {
        return pidDataHistory;
    }
    
    public void addListerOnPidDataHistory(ListChangeListener<PidData> listener){
    	pidDataHistory.addListener(listener);
    }
    
    public void createDataFromString(String dataString){
    	String[] stringParts = dataString.split(";");
		try {
	    	PidData data = new PidData(
	    			(int) Float.parseFloat(stringParts[0]),
	    			(int) Float.parseFloat(stringParts[1])
	    			);
			
			DataManager.pidDataHistory.add(data);
		} catch (NumberFormatException e) {
			
		}
		
		
    }
}
