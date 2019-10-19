package model.factories.units;

import model.map.Location;
import model.units.SwordMaster;

import java.util.HashMap;
import java.util.Map;

public class SwordMasterFactory extends AbstractUnitFactory{

    private Map<String, Integer> unitsDict;

    @Override
    protected void setUpDictionary(){
        unitsDict =  new HashMap<>();
        getItemsDictionary().put(HP_KEY, 70);
        getItemsDictionary().put(MOV_KEY, 2);
    }

    @Override
    protected Map<String, Integer> getItemsDictionary() {
        return unitsDict;
    }

    @Override
    public SwordMaster createUnit(Location location) {
        return new SwordMaster(getHitPoints(), getMovement(), location);
    }
}
