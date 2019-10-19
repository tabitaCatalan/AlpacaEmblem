package model;

import model.units.IUnit;

/**
 * This class represent a Player
 *
 * @author Tabita Catalán Muñoz
 * @since 2.0
 */

public class Tactician {
    private String name;
    private IUnit selectedUnit;

    /** Creates a new Tactician
     * @param nameTactician: came of the new Tactician
     * */
    public Tactician(String nameTactician){
        name = nameTactician;
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
}
