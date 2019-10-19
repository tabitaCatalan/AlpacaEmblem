package model.factories.units;

import model.map.Location;
import model.units.Sorcerer;

import java.util.HashMap;
import java.util.Map;

public class SorcererFactory extends AbstractUnitFactory {
    private Map<String, Integer> unitsDict;

    @Override
    protected void setUpDictionary(){
        unitsDict =  new HashMap<>();
        getItemsDictionary().put(HP_KEY, 50);
        getItemsDictionary().put(MOV_KEY, 1);
    }

    @Override
    protected Map<String, Integer> getItemsDictionary() {
        return unitsDict;
    }

    @Override
    public Sorcerer createUnit(Location location) {
        return new Sorcerer(getHitPoints(), getMovement(), location);
    }
}
