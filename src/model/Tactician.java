package model;

import model.units.IUnit;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class represent a Player
 *
 * @author Tabita Catalán Muñoz
 * @since 2.0
 */

public class Tactician{
    private String name;
    private IUnit selectedUnit;
    private PropertyChangeSupport support;

    /** Creates a new Tactician
     * @param nameTactician: came of the new Tactician
     * */
    public Tactician(String nameTactician){
        name = nameTactician;
        support = new PropertyChangeSupport(this);
    }

    /**
     * @return name of the Tactician
     * */
    public String getName() {
        return name;
    }

    /**
     * @return the actual selected unit
     * */
    public IUnit getSelectedUnit() {
        return selectedUnit;
    }

    /**
     * Sets the actual selected unit to <i>unit</>.
     * @param  unit
     * */
    public void setSelectedUnit(IUnit unit) {
        selectedUnit = unit;
    }

    /** Adds a new observer
     * @param pcl a new observer
     * */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /*
    public void setNews(String value) {
        support.firePropertyChange("news", this.news, value);
        this.news = value;
    }*/

    /**Removes all the tactician's units from map
     * */
    public void removeAllUnits() {
    }

    /** Removes an unit from map
     * @param unit th unit to be removed
     * */
    public void removeUnit(IUnit unit){

    }


}
