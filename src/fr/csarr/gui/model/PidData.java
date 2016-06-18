package fr.csarr.gui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PidData {

	private final IntegerProperty timeStamp;
	private final IntegerProperty value;
    
    /**
     * Default constructor.
     */
    public PidData() {
        this(0, 0);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public PidData(int timeStamp, int value) {
        this.value = new SimpleIntegerProperty(value);
        this.timeStamp = new SimpleIntegerProperty(timeStamp);
    }
    
    public IntegerProperty getTimeStamp() {
		return timeStamp;
	}

	public IntegerProperty getValue() {
		return value;
	}
    
    

}
