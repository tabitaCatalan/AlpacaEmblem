package model.factories.units;

import model.map.Location;
import model.units.IUnit;

import java.util.Map;

public abstract class AbstractUnitFactory implements IUnitFactory{

    protected String HP_KEY = "hitPoints";
    protected String MOV_KEY = "movement";

    public AbstractUnitFactory(){
        setUpDictionary();
    }

    /**
     * Sets up the dictionary that will be use in the unit construction
     * */
    protected abstract void setUpDictionary();

    /**
     * @return the Map used as dictionary to store the unit parameters
     * */
    protected abstract Map<String, Integer > getItemsDictionary();

    @Override
    public int getHitPoints() {
        return getItemsDictionary().get(HP_KEY);
    }

    @Override
    public int getMovement() {
        return getItemsDictionary().get(MOV_KEY);
    }

    @Override
    public abstract IUnit createUnit(Location location);
}
