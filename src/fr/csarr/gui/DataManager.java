package fr.csarr.gui;

import fr.csarr.gui.model.PidData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataManager {

	static DataManager instance;
    private static ObservableList<PidData> pidDataHistory = FXCollections.observableArrayList();
	
	private DataManager(){
        pidDataHistory.add(new PidData(0, 10));
        pidDataHistory.add(new PidData(1, 11));
        pidDataHistory.add(new PidData(2, 12));
        pidDataHistory.add(new PidData(3, 13));
        pidDataHistory.add(new PidData(4, 14));
        pidDataHistory.add(new PidData(5, 16));
        pidDataHistory.add(new PidData(6, 18));
        pidDataHistory.add(new PidData(7, 21));
        pidDataHistory.add(new PidData(8, 24));
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
}
